package exercise;

import java.util.Map;

class FileKV implements KeyValueStorage {

    private String filepath;

    public FileKV(String filepath, Map<String, String> initial) {
        this.filepath = filepath;
        initial.entrySet().stream().forEach(entry -> set(entry.getKey(), entry.getValue()));
    }

    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(filepath);
        Map<String, String> data = Utils.unserialize(content);
        data.put(key, value);
        Utils.writeFile(filepath, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(filepath);
        Map<String, String> data = Utils.unserialize(content);
        data.remove(key);
        Utils.writeFile(filepath, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(filepath);
        Map<String, String> data = Utils.unserialize(content);
        return data.containsKey(key) ? data.get(key) : defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(filepath);
        Map<String, String> data = Utils.unserialize(content);
        return data;
    }
}
