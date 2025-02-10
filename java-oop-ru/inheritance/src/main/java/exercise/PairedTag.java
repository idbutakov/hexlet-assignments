package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String content;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String content, List<Tag> children) {
        super(tagName, attributes);
        this.content = content;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder attrs = new StringBuilder();
        if (getAttributes() != null && !getAttributes().isEmpty()) {
            for (Map.Entry<String, String> entry : getAttributes().entrySet()) {
                attrs.append(String.format(" %s=\"%s\"", entry.getKey(), entry.getValue()));
            }
        }

        StringBuilder childrenContent = new StringBuilder();
        if (children != null && !children.isEmpty()) {
            for (Tag child : children) {
                childrenContent.append(child.toString());
            }
        }

        String innerContent = String.format("%s%s", content, childrenContent);

        return String.format("<%s%s>%s</%s>", getTagName(), attrs, innerContent, getTagName());
    }
}
// END
