package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
    private FileKV fileKV;

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
        fileKV = new FileKV(filepath.toString(), new HashMap<>());
    }

    // BEGIN
    @Test
    public void testSetAndGet() {
        fileKV.set("key1", "value1");
        assertEquals("value1", fileKV.get("key1", "default"));
        assertEquals("default", fileKV.get("key2", "default"));
    }

    @Test
    public void testUnset() {
        fileKV.set("key1", "value1");
        fileKV.unset("key1");
        assertEquals("default", fileKV.get("key1", "default"));
    }

    @Test
    public void testToMap() {
        fileKV.set("key1", "value1");
        fileKV.set("key2", "value2");
        Map<String, String> expected = new HashMap<>();
        expected.put("key1", "value1");
        expected.put("key2", "value2");
        assertEquals(expected, fileKV.toMap());
    }

    @Test
    public void testInitialData() {
        Map<String, String> initialData = new HashMap<>();
        initialData.put("key1", "value1");
        initialData.put("key2", "value2");
        fileKV = new FileKV(filepath.toString(), initialData);
        assertEquals("value1", fileKV.get("key1", "default"));
        assertEquals("value2", fileKV.get("key2", "default"));
    }
    // END
}
