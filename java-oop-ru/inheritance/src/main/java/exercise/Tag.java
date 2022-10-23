package exercise;

import java.util.Map;

public class Tag {

    String tagName;
    Map<String, String> attributes;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<").append(tagName);

        attributes.forEach((key, value) -> stringBuilder.append(" ").
                append(key).append("=").append("\"").append(value).
                append("\""));
        return stringBuilder.append(">").toString();
    }
}
