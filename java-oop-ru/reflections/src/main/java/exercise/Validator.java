package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Object instance) {
        ArrayList<String> notValidFields = new ArrayList<>();

        for (Field field : instance.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    Object value = field.get(instance);
                    if (value == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Не удалось получить доступ к полю: " + field.getName(), e);
                }
            }
        }
        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object instance) {
        HashMap<String, List<String>> notValidFields = new HashMap<>();

        for (Field field : instance.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            ArrayList<String> errors = new ArrayList<>();

            try {
                Object value = field.get(instance);
                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    errors.add("can not be null");
                    notValidFields.put(field.getName(), errors);
                }
                if (field.isAnnotationPresent(MinLength.class) && ((String)value).length() < 4) {
                    errors.add("length less than 4");
                    notValidFields.put(field.getName(), errors);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Не удалось получить доступ к полю: " + field.getName(), e);
            }
        }

        return notValidFields;
    }
}
// END
