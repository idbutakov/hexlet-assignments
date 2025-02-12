package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path path, Car car) throws IOException {
        car.serialize(path);
    }

    public static Car extract(Path path) throws IOException {
        return Car.deserialize(path);
    }
}
// END
