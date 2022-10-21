package exercise;

class Cottage implements Home {

    public double area;
    public int floorCount;

    public Cottage(double area1, int floorCount1) {
        this.area = area1;
        this.floorCount = floorCount1;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public double compareTo(Home home) {
        return this.getArea() - home.getArea();
    }

    @Override
    public String toString() {
        return this.floorCount + " этажный коттедж площадью " + this.getArea() + " метров";
    }
}
