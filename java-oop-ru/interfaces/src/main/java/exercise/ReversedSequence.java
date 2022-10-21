package exercise;

class ReversedSequence implements CharSequence {

    private final String reverse;

    public ReversedSequence(String reverse1) {
        this.reverse = reverse1;
    }

    @Override
    public int length() {
        return reverse.length();
    }

    @Override
    public char charAt(int index) {
        return reverse.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        StringBuffer stringBuffer = new StringBuffer(reverse).reverse();
        return stringBuffer.subSequence(start, end);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(reverse).reverse();
        return stringBuffer.toString();
    }
}
