import java.util.*;

public class Stroken {
    public static void main(String[] args) {
        String sentence = "Saya belajar bahasa Java. Bahasa Java mempunyai kelas berupa String. Belajar String Java itu mudah. String Java juga sering diimplementasikan";

        StringTokenizer token = new StringTokenizer(sentence, " .");
        LinkedHashMap<String, Integer> tokenFreq = new LinkedHashMap<>();
        while(token.hasMoreTokens()){
            String Stroken = token.nextToken().toLowerCase();
            if(!tokenFreq.containsKey(Stroken)){
                tokenFreq.put(Stroken, 1);
            }else{
                int freq = tokenFreq.get(Stroken);
                tokenFreq.put(Stroken, ++freq);
            }
        }
        System.out.println("+-------------------+-------------------+");
        System.out.printf("%-8s%-12s%-6s%-14s%s\n", "|","Token","|", "Frekuensi", "|");
        System.out.println("+-------------------+-------------------+");
        for (Map.Entry<String, Integer> entries : tokenFreq.entrySet()) {
            String tokenized = entries.getKey();
            int freq = entries.getValue(); 
            System.out.printf("%-2s%-18s%-10s%-10d%s\n","|", tokenized,"|", freq, "|");
        }
        System.out.println("+-------------------+-------------------+");
    }
}