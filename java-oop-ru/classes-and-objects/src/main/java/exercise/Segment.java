package exercise;

class Segment {

    private Point start;
    private Point end;

    public Segment(Point start1, Point end1) {
        if (start1 == null || end1 == null) {
            return;
        }

        this.start = start1;
        this.end = end1;
    }

    Point getBeginPoint() {
        return start;
    }

    Point getEndPoint() {
        return end;
    }

    Point getMidPoint() {
        return new Point((start.getX() + end.getY() / 2),
                (start.getY() + end.getY()) / 2);
    }
}