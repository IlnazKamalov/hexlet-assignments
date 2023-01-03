package exercise;

class SafetyList {
    // BEGIN
    private int[] numbers = new int[0];
    private int length = 0;

    public synchronized void add(int value) {

        int[] data = new int[length + 1];
        data[length] = value;
        numbers = data;

        length++;
    }

    public int get(int index) {
        return numbers[index];
    }

    public int getSize() {
        return length;
    }
    // END
}
