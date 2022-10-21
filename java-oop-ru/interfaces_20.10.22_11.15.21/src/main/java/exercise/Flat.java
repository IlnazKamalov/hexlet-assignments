package exercise;

class Flat implements Home {

    public double area;
    public double balconyArea;
    public int floor;

    public Flat(double area1, double balconyArea1, int floor1) {
        this.balconyArea = balconyArea1;
        this.area = area1;
        this.floor = floor1;
    }

    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    @Override
    public double compareTo(Home home) {
       return this.getArea() - home.getArea();
    }

    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + this.floor + " этаже";
    }
}