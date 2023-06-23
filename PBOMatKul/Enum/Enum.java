package Enum;

enum Size {
    SMALL(20),
    MEDIUM(30),
    LARGE(40);
    public final int price;
    Size( int price) { this.price = price; }    
    public int getPrice() { return price; }
}