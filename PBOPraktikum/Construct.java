public class Construct {
    public static void main(String[] args) {
        Lingkaran ling = new Lingkaran();
        Lingkaran ling2 = new Lingkaran(2);
        Lingkaran ling3 = new Lingkaran(3.4);

    }

    
}

class Lingkaran{
    int jari;
    double diameter;

    Lingkaran(int jari){
        this.jari = jari;

    }
    Lingkaran(){}

    Lingkaran(double diameter){
        this.diameter = diameter;

    }

    double getKeliling(int jari){
        return  (2*jari*Math.PI);
    }

    double getKeliling(double diameter){
        return diameter*Math.PI;
    }
}
