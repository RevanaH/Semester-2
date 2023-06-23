public class Identity
{
	public static void main(String[] args) {
		Student anna = new Student();
        anna.setName("Anna");
        anna.setAddress("Malang");
        anna.setAge(20);
        anna.setMath(100);
        anna.setScience(89);
        anna.setEnglish(80);
        anna.displayMessage();
        
     //menggunakan constructor lain
        System.out.println("===================");
        Student chris = new Student("Chris", "Kediri", 21);
        chris.setMath(70);
        chris.setScience(60);
        chris.setEnglish(90);
        chris.displayMessage();
         //siswa dengan nama anna dirubah informasi alamat dan umurnya melalui constructor
        System.out.println("===================");
        Student anna1 = new Student(70,80,90);
        anna1 = new Student("anna", "Batu", 18);
        anna1.setScore(70,80,90);
        anna1.displayMessage();
        anna1.displayScore();
        
        
        //siswa denagan nama chris dirubah informasi alamat dan umurnya melalui method
        System.out.println("===================");
        chris.setAddress("Surabaya");
        chris.setAge(22);
        chris.displayMessage();
	}
}
class Student {
    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;
    private double average;
    
    public Student(){
        this.name = "";
        this.address = "";
        this.age = 0;
    }
    public Student(int math, int english, int science){
        this.mathGrade = math;
        this.englishGrade = english;
        this.scienceGrade = science;
    }
    public Student(String n, String a, int ag){
        this.name = n;
        this.address = a;
        this.age = ag;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setAddress(String a){
       this.address = a;
    }
    public void setAge(int ag){
        this.age = ag;
    }
    public void setMath(int math){
        mathGrade = math;
    }
    public void setEnglish(int english){
        englishGrade = english;
    }
    public void setScience(int science){
        scienceGrade = science;
    }
    public void setScore(int math, int english, int science){
        mathGrade = math;
        englishGrade = english;
        scienceGrade = science;

    }
    
    public void displayScore(){
        System.out.println("math "+this.mathGrade);
        System.out.println("english "+this.englishGrade);
        System.out.println("science "+this.scienceGrade);
    }
    public double getAverage(){
        double result = 0;
        result = (mathGrade+scienceGrade+englishGrade)/3;
        return result;
    }
    public void displayMessage(){
        System.out.println("Siswa dengan nama "+this.name);
        System.out.println("beramalat di "+this.address);
        System.out.println("berumur "+this.age);
        System.out.println("mempunyai nilai rata rata "+getAverage());
        if(statusAkhir() == true){
            System.out.println("Status: lulus");

        }
        else{
            System.out.println("Status: remedi");
        }

       
    }

    private boolean statusAkhir(){
        double rata = getAverage();
        return (rata >= 61) ? true : false;

    }
    
}