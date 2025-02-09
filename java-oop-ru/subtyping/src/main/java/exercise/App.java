package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> originalData = storage.toMap();
        storage.toMap().keySet().forEach(storage::unset);

        for (Map.Entry<String, String> entry : originalData.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
