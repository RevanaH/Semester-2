package Bangundatar;

class Lingkaran extends BangunDatar{
    double radius;

    public Lingkaran(double radius){
        this.radius = radius;
    }
    
    public double luas(){
        return radius*radius*Math.PI;
    }
    public double keliling(){
    return 2*(radius*Math.PI);
}
}