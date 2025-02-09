package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String label;
    private TagInterface inputTag;

    public LabelTag(String label, TagInterface inputTag) {
        this.label = label;
        this.inputTag = inputTag;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", label, inputTag.render());
    }
}
// END
