package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {
        StringBuilder attrs = new StringBuilder();
        if (getAttributes() != null && !getAttributes().isEmpty()) {
            for (Map.Entry<String, String> entry : getAttributes().entrySet()) {
                attrs.append(String.format(" %s=\"%s\"", entry.getKey(), entry.getValue()));
            }
        }
        return String.format("<%s%s>", getTagName(), attrs);
    }
}
// END
