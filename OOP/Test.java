public class Test {
    public static void main(String[] args){
        Car car1 = new Car("Emas",101);
        //car1.setColor("Merah");
        //car1.setPower(1000);
        //car1.setSpeed(150);
        car1.drive();
        System.out.println("Warna: " + car1.getColor());
        System.out.println("Power: " + car1.getPower());
        System.out.println("Speed: " + car1.getSpeed() + "\n");
        
        Car car2 = new Car("Hitam", 1293, 293);
        //car2.setColor("Hitam");
        //car2.setPower(1563);
        //car2.setSpeed(420);
        car2.drive();
        System.out.println("Warna: " + car2.getColor());
        System.out.println("Power: " + car2.getPower());
        System.out.println("Speed: " + car2.getSpeed() + "\n");
        

        Car car3 = new Car("Pink");// dari public Car(){}
        //car3.setColor("Biru");
        //car3.setPower(1243);   // dari public void dll
        //car3.setSpeed(317);
        car3.drive();
        System.out.println("Warna: " + car3.getColor());
        System.out.println("Power: " + car3.getPower());
        System.out.println("Speed: " + car3.getSpeed());
        

    }
    
}
