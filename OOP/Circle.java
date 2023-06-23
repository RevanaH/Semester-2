public class Circle {
    double radius;
    double phi = 3.14;


    public Circle(double radius, double phi){
        this.radius = radius;
        this.phi = phi;
    }
    
    public double getArea(){
        return this.radius*this.phi*this.radius;
    }
    public double getCircumference(){
    return 2*(this.radius*this.phi);
}
}
