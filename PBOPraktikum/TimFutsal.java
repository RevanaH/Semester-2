// import java.util.*;

// class Player {
//     int height;
//     int weight;

//     public Player(int height, int weight) {
//         this.height = height;
//         this.weight = weight;
//     }
// }

// class Soal1 {

//     static void sameHeight(LinkedHashMap<Integer, Player> teamA, LinkedHashMap<Integer, Player> teamB) {

//         System.out.println("================================================================");
//         System.out.println();
//         System.out.println("a. Yang mempunyai Tinggi badan sama");
//         System.out.println();
//         List<Player> playerA = new ArrayList<>(teamA.values());
//         List<Player> playerB = new ArrayList<>(teamB.values());
//         System.out.printf("%2s %12s %23s %12s\n", "Pemain", "Team A", "Pemain", "Team B");
//         System.out.printf("%2s %18s %17s %18s\n", "Ke-", "Tinggi Badan", "Ke-", "Tinggi Badan");
//         System.out.printf("%18s %36s\n", "(cm)", "(cm)");
//         System.out.println("----------------------------------------------------------------");
//         int a, b;
//         a = 1;
//         for (Player A : playerA) {
//             b = 1;
//             for (Player B : playerB) {
//                 if (A.height == B.height) {
//                     System.out.printf("%2d %14d %11s %10d %14d\n", a, A.height, "|", b, B.height);
//                 }
//                 b++;
//             }
//             a++;
//         }
//         System.out.println("----------------------------------------------------------------");
//         System.out.println();
//     }

//     static void sameWeight(LinkedHashMap<Integer, Player> teamA, LinkedHashMap<Integer, Player> teamB) {

//         System.out.println("================================================================");
//         System.out.println();
//         System.out.println("b. Yang mempunyai Berat badan sama");
//         System.out.println();
//         List<Player> playerA = new ArrayList<>(teamA.values());
//         List<Player> playerB = new ArrayList<>(teamB.values());
//         System.out.printf("%2s %12s %23s %12s\n", "Pemain", "Team A", "Pemain", "Team B");
//         System.out.printf("%2s %18s %17s %18s\n", "Ke-", "Berat Badan", "Ke-", "Berat Badan");
//         System.out.printf("%18s %36s\n", "(kg)", "(kg)");
//         System.out.println("----------------------------------------------------------------");
//         int a, b;
//         a = 1;
//         for (Player A : playerA) {
//             b = 1;
//             for (Player B : playerB) {
//                 if (A.weight == B.weight) {
//                     System.out.printf("%2d %14d %11s %10d %14d\n", a, A.weight, "|", b, B.weight);
//                 }
//                 b++;
//             }
//             a++;
//         }
//         System.out.println("----------------------------------------------------------------");
//         System.out.println();
//     }

//     static void heightDiff(LinkedHashMap<Integer, Player> teamA, LinkedHashMap<Integer, Player> teamB) {

//         System.out.println("================================================================");
//         System.out.println();
//         System.out.println("c. Rentang nilai dari tinggi badan kedua tim");
//         System.out.println();
//         List<Player> playerA = new ArrayList<>(teamA.values());
//         List<Player> playerB = new ArrayList<>(teamB.values());
//         int tallA = 0;
//         int shortA = 0;
//         int tallB = 0;
//         int shortB = 0;

//         for (Player A : playerA) {
//             if (shortA == 0) {
//                 shortA = A.height;
//             }
//             if (A.height < shortA) {
//                 shortA = A.height;
//             }
//             if (tallA == 0) {
//                 tallA = A.height;
//             }
//             if (A.height > tallA) {
//                 tallA = A.height;
//             }
//         }
//         for (Player B : playerB) {
//             if (shortB == 0) {
//                 shortB = B.height;
//             }
//             if (B.height < shortB) {
//                 shortB = B.height;
//             }
//             if (tallB == 0) {
//                 tallB = B.height;
//             }
//             if (B.height > tallB) {
//                 tallB = B.height;
//             }
//         }
//         int diffA = tallA - shortA;
//         int diffB = tallB - shortB;

//         System.out.printf("%s %15s %15s %20s\n", "Team", "Tertinggi", "Terpendek", "Perbedaan Tinggi");
//         System.out.printf("%18s %15s %17s\n", "(cm)", "(cm)", "(cm)");
//         System.out.println("----------------------------------------------------------------");
//         System.out.printf("%2s %15s %15d %16d\n", "A", tallA, shortA, diffA);
//         System.out.printf("%2s %15d %15d %16d\n", "B", tallB, shortB, diffB);
//         System.out.println("----------------------------------------------------------------");

//         System.out.println();

//     }

//     static void weightDiff(LinkedHashMap<Integer, Player> teamA, LinkedHashMap<Integer, Player> teamB) {

//         System.out.println("================================================================");
//         System.out.println();
//         System.out.println("d. Rentang nilai dari berat badan kedua tim");
//         System.out.println();
//         List<Player> playerA = new ArrayList<>(teamA.values());
//         List<Player> playerB = new ArrayList<>(teamB.values());
//         int heavyA = 0;
//         int lightA = 0;
//         int heavyB = 0;
//         int lightB = 0;

//         for (Player A : playerA) {
//             if (lightA == 0) {
//                 lightA = A.weight;
//             }
//             if (A.weight < lightA) {
//                 lightA = A.weight;
//             }
//             if (heavyA == 0) {
//                 heavyA = A.weight;
//             }
//             if (A.weight > heavyA) {
//                 heavyA = A.weight;
//             }
//         }
//         for (Player B : playerB) {
//             if (lightB == 0) {
//                 lightB = B.weight;
//             }
//             if (B.weight < lightB) {
//                 lightB = B.weight;
//             }
//             if (heavyB == 0) {
//                 heavyB = B.weight;
//             }
//             if (B.weight > heavyB) {
//                 heavyB = B.weight;
//             }
//         }
//         int diffA = heavyA - lightA;
//         int diffB = heavyB - lightB;

//         System.out.printf("%s %15s %15s %20s\n", "Team", "Terberat", "Teringan", "Perbedaan Berat");
//         System.out.printf("%18s %15s %17s\n", "(kg)", "(kg)", "(kg)");
//         System.out.println("----------------------------------------------------------------");
//         System.out.printf("%2s %14s %15d %17d\n", "A", heavyA, lightA, diffA);
//         System.out.printf("%2s %14d %15d %17d\n", "B", heavyB, lightB, diffB);
//         System.out.println("----------------------------------------------------------------");
//         System.out.println();
//     }

//     static void diffHeight(LinkedHashMap<Integer, Player> teamA, LinkedHashMap<Integer, Player> teamB) {

//         System.out.println("================================================================");
//         System.out.println();
//         System.out.println("e. Tinggi badan pada tim A yang tidak ada pada tim B");
//         System.out.println();
//         List<Player> playerA = new ArrayList<>(teamA.values());
//         List<Player> playerB = new ArrayList<>(teamB.values());
//         List<Integer> diffH = new ArrayList<>();
//         List<Integer> heightB = new ArrayList<>();
//         for (Player B : playerB) {
//             heightB.add(B.height);
//         }
//         for (Player A : playerA) {
//             if (!(heightB.contains(A.height)) && (!(diffH.contains(A.height)))) {
//                 diffH.add(A.height);
//             }
//         }
//         if (diffH.size() == 0) {
//             System.out.println(" Semua Tinggi Badan pada tim A yang ada pada tim B");
//         } else {
//             for (int i = 0; i < diffH.size(); i++) {

//                 System.out.println(i + 1 + ". " + diffH.get(i) + " cm");
//             }
//             System.out.println();
//         }

//         System.out.println();
//     }

//     static void diffWeight(LinkedHashMap<Integer, Player> teamA, LinkedHashMap<Integer, Player> teamB) {

//         System.out.println("================================================================");
//         System.out.println();
//         System.out.println("f. Berat badan pada tim B yang tidak ada pada tim A");
//         System.out.println();
//         List<Player> playerA = new ArrayList<>(teamA.values());
//         List<Player> playerB = new ArrayList<>(teamB.values());
//         List<Integer> diffW = new ArrayList<>();
//         List<Integer> weightA = new ArrayList<>();
//         for (Player A : playerA) {
//             weightA.add(A.weight);
//         }

//         for (Player B : playerB) {
//             if (!(weightA.contains(B.weight)) && (!(diffW.contains(B.weight)))) {
//                 diffW.add(B.weight);
//             }
//         }
//         if (diffW.size() == 0) {
//             System.out.println(" Semua Tinggi Badan pada tim A yang ada pada tim B");
//         } else {
//             for (int i = 0; i < diffW.size(); i++) {
//                 System.out.println(i + 1 + ". " + diffW.get(i) + " kg");
//             }
//         }
//         System.out.println();
//         System.out.println("================================================================");
//     }
// }

// class Soal2 {

//     static void team(LinkedHashMap<Integer, Player> team) {
//         System.out.println();
//         System.out.printf("%s %12s\n", "Tinggi", "Berat");
//         System.out.printf(" %3s %13s\n", "(cm)", "(kg)");
//         System.out.println("--------------------");
//         for (int i = 1; i < team.size() + 1; i++) {
//             System.out.printf(" %2d %13d\n", team.get(i).height, team.get(i).weight);

//         }
//         System.out.println("====================");

//     }

//     static void fixed(LinkedHashMap<Integer, Player> team, int height, int neweight) {
//         System.out.println("B. Dari data tim B, ternyata ada kesalahan pencatatan berat badan yaitu untuk pemain");
//         System.out.println("yang memiliki tinggi badan 168, berat badannya adalah 66. Update data Map untuk tim B.");
//         for (int i = 1; i < team.size() + 1; i++) {
//             if (team.get(i).height == height) {
//                 team.get(i).weight = neweight;
//             }
//         }
//         System.out.println();
//         System.out.println("Berikut ini adalah versi yang sudah di Update:");
//         System.out.println();
//         System.out.printf("%s %12s\n", "Tinggi", "Berat");
//         System.out.printf(" %3s %13s\n", "(cm)", "(kg)");
//         System.out.println("--------------------");
//         for (int i = 1; i < team.size() + 1; i++) {
//             System.out.printf(" %2d %13d\n", team.get(i).height, team.get(i).weight);

//         }
//         System.out.println("====================");
//     }

//     static LinkedHashMap<Integer, Player> Asort(LinkedHashMap<Integer, Player> teamA,
//             LinkedHashMap<Integer, Player> teamB) {
//         System.out.println();
//         System.out.println("C. Implementasikan Map untuk menyimpan data tinggi badan dan ");
//         System.out.println("berat badan dari tim A yang tinggi badannya sama dengan tim B.");
//         System.out.println();
//         // System.out.println("(Semua Anggota Tim A memiliki Tinggi Badan yang sama");
//         // System.out.println("dengan salah satu Anggota Tim B)");
//         System.out.println();
//         List<Player> playerA = new ArrayList<>(teamA.values());
//         List<Player> playerB = new ArrayList<>(teamB.values());
//         LinkedHashMap<Integer, Player> Asort = new LinkedHashMap<Integer, Player>();
//         int a = 1;
//         int b = 1;
//         int key = 0;

//         for (Player A : playerA) {
//             b = 1;
//             for (Player B : playerB) {
//                 if (A.height == B.height) {
//                     Asort.put(key, new Player(A.height, A.weight));
//                     key++;
//                     break;

//                 }
//                 b++;
//             }
//             a++;
//         }
//         System.out.printf("%s %12s\n", "Tinggi", "Berat");
//         System.out.printf(" %3s %13s\n", "(cm)", "(kg)");
//         System.out.println("--------------------");
//         for (int i = 0; i < Asort.size(); i++) {
//             System.out.printf(" %2d %13d\n", Asort.get(i).height, Asort.get(i).weight);
//         }
//         System.out.println("====================");
//         return Asort;
//     }

//     static LinkedHashMap<Integer, Player> newTeam(LinkedHashMap<Integer, Player> team, int req) {
//         LinkedHashMap<Integer, Player> newTeam = new LinkedHashMap<Integer, Player>();
//         int key = 0;
//         for (int i = 0; i < team.size(); i++) {
//             if (team.get(i).height >= req) {
//                 newTeam.put(key, new Player(team.get(i).height, team.get(i).weight));
//                 key++;
//             }

//         }
//         return newTeam;
//     }

// }

// public class TimFutsal {
//     public static void main(String[] args) {
//         LinkedHashMap<Integer, Player> teamA = new LinkedHashMap<Integer, Player>();
//         LinkedHashMap<Integer, Player> teamB = new LinkedHashMap<Integer, Player>();

//         teamA.put(1, new Player(168, 50));
//         teamA.put(2, new Player(170, 60));
//         teamA.put(3, new Player(165, 56));
//         teamA.put(4, new Player(168, 55));
//         teamA.put(5, new Player(172, 60));
//         teamA.put(6, new Player(170, 70));
//         teamA.put(7, new Player(169, 66));
//         teamA.put(8, new Player(165, 56));
//         teamA.put(9, new Player(171, 72));
//         teamA.put(10, new Player(166, 56));

//         teamB.put(1, new Player(170, 66));
//         teamB.put(2, new Player(167, 60));
//         teamB.put(3, new Player(165, 59));
//         teamB.put(4, new Player(166, 58));
//         teamB.put(5, new Player(168, 58));
//         teamB.put(6, new Player(175, 71));
//         teamB.put(7, new Player(172, 68));
//         teamB.put(8, new Player(171, 68));
//         teamB.put(9, new Player(168, 65));
//         teamB.put(10, new Player(169, 60));

//         System.out.println();
//         System.out.println("Soal 1:");
//         Soal1.sameHeight(teamA, teamB);
//         Soal1.sameWeight(teamA, teamB);
//         Soal1.heightDiff(teamA, teamB);
//         Soal1.weightDiff(teamA, teamB);
//         Soal1.diffHeight(teamA, teamB);
//         Soal1.diffWeight(teamA, teamB);
//         System.out.println();

//         System.out.println();
//         System.out.println("Soal 2:");
//         System.out.println();
//         System.out.println("A. Implementasikan Map untuk menyimpan data tim A dan tim B dalam bentuk Map terpisah.");
//         System.out.println();
//         System.out.println("Tim A");
//         Soal2.team(teamA);
//         System.out.println();
//         System.out.println("Tim B");
//         Soal2.team(teamB);
//         System.out.println();

//         Soal2.fixed(teamB, 168, 66);
//         // System.out.println(Soal2.Asort(teamA, teamB));
//         LinkedHashMap<Integer, Player> TeamC = Soal2.newTeam(Soal2.Asort(teamA, teamB), 168);
//         System.out.println();
//         System.out.println("D. Dari data tim A yang mempunyai tinggi badan sama dengan tim B");
//         System.out.println("tadi, pelatih memutuskan untuk hanya mengambil pemain yang ");
//         System.out.println("memiliki tinggi badan 168 keatas, sehingga pemain dengan tinggi");
//         System.out.println("badan kurang dari 168 dinyatakan dieleminasi dari tim. ");
//         System.out.println("Update data Map tersebut sesuai dengan kondisi terakhir.");
//         System.out.println();
//         System.out.printf("%s %12s\n", "Tinggi", "Berat");
//         System.out.printf(" %3s %13s\n", "(cm)", "(kg)");
//         System.out.println("--------------------");
//         for (int i = 0; i < TeamC.size(); i++) {
//             System.out.printf(" %2d %13d\n", TeamC.get(i).height, TeamC.get(i).weight);
//         }
//         System.out.println("====================");
//     }
// }

