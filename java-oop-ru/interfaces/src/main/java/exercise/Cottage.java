package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int fllorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.fllorCount = floorCount;
    }

    public double getArea() {
        return area;
    }

    public int getFloorCount() {
        return fllorCount;
    }

    @Override
    public String toString() {
        return getFloorCount() + " этажный коттедж площадью " + getArea() + " метров";
    }
}
// END
