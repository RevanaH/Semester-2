public class Car {
    // attribute declrataion
    private String color;
    private int speed;
    public int power;

    // method declaration

    public void drive(){
      int power = 10000;
       System.out.println("drive");
       System.out.println("drive power: " + power); //yang terpanggis di dalam method karena prioritas lokal
       //System.out.println("drive power: " + this.power); // yang terpanggil adalah this karena dispesifikasikan menggunkana this 
    }
    public void turnRight(){
       System.out.println("turnRight");
    }
    public void turnLeft(){
       System.out.println("turnLeft"); 
    }
    public void stop(){
       System.out.println("stop");
    }
    // set untuk menyatakan value variabel
    public void setColor(String color){
      this.color = color;
    }
   // untuk memanggil value variabel
   public String getColor(){
      return  color;
   }
   
   public void setSpeed(int speed){
      this.speed = speed;
    }

   public int getSpeed(){
      return  speed;
   }
   
   public void setPower(int power){
      this.power = power;
    }

   public int getPower(){
      return  power;
   }

   public Car( String color, int speed, int power){ // untuk menyiapkan variable agar tidak perlu dipanggil lagi saat memasukan variable di file sebelah
      this.color = color;
      this.speed = speed;
      this.power = power;

   } 
   public Car( String color, int power){ // untuk overload jadi kalau hanya dimasukan 2 saja tetap dapat dijalankan
      this.color = color;
      //this.speed = speed;
      this.power = power;
   }
      public Car(String color){
         this.color = color;
         //this.speed = speed;
         //this.power = power;
      }
   }
