import java.text.DecimalFormat;

interface Payable {
    public int getPayableAmount();  

}

class Invoice implements Payable {
    String productName;
    int quantity;
    int pricePerItem;


    public String getProductName() {
        return productName;
    }
 
    public int getQuantity() {
        return quantity;
    }
    public int getPricePerItem() {
        return pricePerItem;
    }
    public Invoice(String productName, int quantity, int pricePerItem) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public int getPayableAmount(){
        return quantity*pricePerItem;
    }

   

}

class Employee implements Payable {
    String registerNumber;
    String name;
    int salaryPerMonth;
    Invoice[] invoices = new Invoice[20];
    int i = 0;
    int totalBayar;
    DecimalFormat rupiah = new DecimalFormat("Rp ###,###.00");


    public Employee(String registerNumber, String name, int salaryPerMonth) {
        this.registerNumber = registerNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        
    }

    public int getPayableAmount(){
        return totalBayar;

    }

    void buyItem(String productName, int quantity, int pricePerItem){
        Invoice crap = new Invoice(productName, quantity, pricePerItem);
        invoices[i] = crap;
        i++;
        totalBayar = crap.getPayableAmount();

    }



    void emProfile(){
        System.out.println();
        System.out.println("==============================================================");
        System.out.printf("%-25s %s\n","","Data Karyawan");
        System.out.println("==============================================================");
        System.out.printf("%-25s: %s\n","Nama", this.name);
        System.out.printf("%-25s: %s\n","Nomor Registrasi", this.registerNumber);
        System.out.printf("%-25s: %s\n", "Gaji", rupiah.format(this.salaryPerMonth));
        System.out.println();
        System.out.println("==============================================================");
        System.out.printf("%-20s", "Nama Barang");
        System.out.printf("%-25s", "Jumlah Barang");
        System.out.printf("%-20s\n", "Harga per Barang");
        System.out.println("=============================================================");
        for (int i = 0; i < invoices.length; i++) {
            if(invoices[i] != null){
                System.out.printf("%-25s", invoices[i].productName);
                System.out.printf("%-20s", invoices[i].quantity);
                System.out.printf("%s", rupiah.format(invoices[i].pricePerItem));
                System.out.println();
            }                 
        }
        System.out.println("=============================================================");
        System.out.printf("%-30s: %s\n", "Banyaknya Invoice", rupiah.format(getPayableAmount()));
        System.out.printf("%-30s: %s", "Total Gaji Bersih", rupiah.format(salaryPerMonth - getPayableAmount()));
    }

    }


public class NVMeneer {
    public static void main(String[] args) {
        Employee emp = new Employee("225150201111020", "Ervan Halimsurya", 20000000);
        emp.buyItem("Soda", 2, 13000);
        emp.buyItem("Hand Bag", 1, 3000000);
        emp.buyItem("Sturgeon", 3, 230000);
        emp.emProfile();
    }
   

}
