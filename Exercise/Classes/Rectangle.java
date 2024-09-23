package Exercise;
public class Rectangle {

    public double length;
    public double width;
    
    // Constructor to initialize length and width
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    //Method to calculate area
    public double area() {
        return length * width;
    }
    
}
