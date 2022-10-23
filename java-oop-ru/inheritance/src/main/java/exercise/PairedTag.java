package exercise;

import java.util.Map;
import java.util.List;

public class PairedTag extends Tag {

    private final String body;
    private final List<Tag> child;

    public PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> child) {
        this.child = child;
        this.attributes = attributes;
        this.tagName = tagName;
        this.body = body;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<").append(tagName);

        attributes.forEach((key, value) -> stringBuilder.append(" ").
                append(key).append("=").append("\"").append(value).
                append("\""));
        stringBuilder.append(">");

        child.forEach(element -> stringBuilder.
                append(element.toString()));
        return stringBuilder.append(body).append("</").append(tagName).append(">").toString();
    }
}