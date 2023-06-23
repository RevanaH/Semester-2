import java.util.*;

public class BarangStock {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            int itemTypes = s.nextInt();
            int[] stock = new int[itemTypes];
            for (int i = 0; i < stock.length; i++) {
                stock[i] = s.nextInt();
            }
            int client = s.nextInt();
            int[][] orders = new int[client][itemTypes];
            // input the orders
            for (int i = 0; i < client; i++) {
                for (int j = 0; j < itemTypes; j++) {
                    orders[i][j] = s.nextInt();
                }
            }
            // process the orders
            int[][] delivered = new int[client][itemTypes];
            for (int i = 0; i < client; i++) {
                for (int j = 0; j < itemTypes; j++) {
                    if (orders[i][j] <= stock[j]) {
                        delivered[i][j] = orders[i][j];
                        stock[j] = stock[j] - delivered[i][j];

                    } else if (orders[i][j] > stock[j]) {
                        delivered[i][j] = stock[j];
                        stock[j] = 0;
                        
                    }
                    System.out.print(delivered[i][j] + "   ");
                }
                System.out.println();
            }
            
        }
    }
}