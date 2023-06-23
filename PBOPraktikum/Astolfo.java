import java.util.*;

class Simulate {
    private long t;
    private long hc;
    private long dc;
    private long hm;
    private long dm;
    private long k;
    private long w;
    private long a;
    private long turnForCharToDie;
    private long turnForMonsterToDie;
    Scanner s = new Scanner(System.in);

    void RegiStats() {
        t = s.nextLong();
        for (long i = 0; i < t; i++) {
            // hc = 0;
            // dc = 0;
            // hm = 0;
            // dm = 0;
            hc = s.nextLong();
            dc = s.nextLong();
            hm = s.nextLong();
            dm = s.nextLong();
            k = s.nextLong();
            w = s.nextLong();
            a = s.nextLong();
            upgrade();
            simulate();
        }
    }

    void upgrade() {
        turnForCharToDie = (hc + dm - 1) / dm;
        turnForMonsterToDie = (hm + dc - 1) / dc;

        if (turnForCharToDie < turnForMonsterToDie) {

            long turnDifference = turnForMonsterToDie - turnForCharToDie;

            long armorNeeded = dm * turnDifference;
            long damageNeeded = ((hm - turnForCharToDie * dc) + turnForCharToDie - 1) / turnForCharToDie;
            if (armorNeeded <= a * k) {

                hc += a * k;
                k = 0;
                return;
            }
            if (damageNeeded <= w * k) {
                dc += w * k;
                k = 0;
                return;
            }
            while (k > 0) {

                double damagePriority = w * 1.0 / damageNeeded;
                double armorPriority = a * 1.0 / armorNeeded;

                if (damagePriority >= armorPriority) {

                    dc += w;
                    k -= 1;

                } else {

                    hc += a;
                    k -= 1;

                }

                turnForCharToDie = (hc + dm - 1) / dm;
                turnForMonsterToDie = (hm + dc - 1) / dc;

                turnDifference = turnForMonsterToDie - turnForCharToDie;

                armorNeeded = dm * turnDifference;
                damageNeeded = ((hm - turnForCharToDie * dc) + turnForCharToDie - 1) / turnForCharToDie;//divided by char to know how to kill in char turn 
            }
        }
    }

    void simulate() {
        turnForCharToDie = (hc + dm - 1) / dm;
        turnForMonsterToDie = (hm + dc - 1) / dc;

        if (turnForCharToDie >= turnForMonsterToDie) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

public class Astolfo {
    public static void main(String[] args) {
        Simulate sim = new Simulate();
        sim.RegiStats();
    }
}
