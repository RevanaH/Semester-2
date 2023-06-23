import java.util.Scanner;
import java.util.Arrays;

public class DetekString {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        s.nextLine();

        for (int i = 0; i < cases; i++) {
            String name1 = s.nextLine();
            String name2 = s.nextLine();

            sameChar(name1, name2);

        }
        s.close();

    }

    static void sameChar(String name1, String name2) {
        for (int j = 0; j < name2.length(); j++) {
            char same = name2.charAt(j);
            boolean found = false;

            int k = 0;
            while (k < name1.length()) {
                if (name1.charAt(k) == same) {
                    System.out.print(k + " ");
                    found = true;
                }
                k++;
            }

            if (!found) {
                System.out.print("-1 ");
            }
        }
        System.out.println("");
    }
}
