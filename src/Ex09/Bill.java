package Ex09;

public class Bill {
    private double oldPoint;
    private double newPoint;


    public Bill(double oldPoint, double newPoint) {
        this.oldPoint = oldPoint;
        this.newPoint = newPoint;
    }


    public double getOldPoint() {
        return oldPoint;
    }

    public void setOldPoint(double oldPoint) {
        this.oldPoint = oldPoint;
    }

    public double getNewPoint() {
        return newPoint;
    }

    public void setNewPoint(double newPoint) {
        this.newPoint = newPoint;
    }


}
