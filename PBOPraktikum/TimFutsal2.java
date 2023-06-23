import java.util.*;

class Player {
    int height;
    int weight;

    public Player(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}

class HeightComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return p1.height - p2.height;
    }
}

class WeightComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return p1.weight - p2.weight;
    }
}

class TimFutsal2 {
    public static void main(String[] args) {
        ArrayList<Player> teamA = new ArrayList<>();
        ArrayList<Player> teamB = new ArrayList<>();
        ArrayList<Player> teamC = new ArrayList<>();

        teamA.add(new Player(168, 50));
        teamA.add(new Player(170, 60));
        teamA.add(new Player(165, 56));
        teamA.add(new Player(168, 55));
        teamA.add(new Player(172, 60));
        teamA.add(new Player(170, 70));
        teamA.add(new Player(169, 66));
        teamA.add(new Player(165, 56));
        teamA.add(new Player(171, 72));
        teamA.add(new Player(166, 56));

        teamB.add(new Player(170, 66));
        teamB.add(new Player(167, 60));
        teamB.add(new Player(165, 59));
        teamB.add(new Player(166, 58));
        teamB.add(new Player(168, 58));
        teamB.add(new Player(175, 71));
        teamB.add(new Player(172, 68));
        teamB.add(new Player(171, 68));
        teamB.add(new Player(168, 65));
        teamB.add(new Player(169, 60));

        
        System.out.println();

        System.out.println("Soal 1. Urutkan data pemain diantara kedua tim tersebut:");
        System.out.println("A. Berdasarkan Tinggi Badannya secara Ascending/menaik dan Descending/menurun");
        System.out.println();

        // Height Team A
        Collections.sort(teamA, new HeightComparator());
        System.out.println("Sort Tinggi Badan Tim A Secara Menaik (Ascending):");
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : teamA) {
            System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
        }
        System.out.println("+-------------+------------+");
        System.out.println();

        Collections.sort(teamA, Collections.reverseOrder(new HeightComparator()));
        System.out.println("Sort Tinggi Badan Tim A Secara Menurun (Descending):");
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : teamA) {
            System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
        }
        System.out.println("+-------------+------------+");
        System.out.println();

        // Height Team B
        Collections.sort(teamB, new HeightComparator());
        System.out.println("Sort Tinggi Badan Tim B Secara Menaik (Ascending):");
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : teamB) {
            System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
        }
        System.out.println("+-------------+------------+");
        System.out.println();

        Collections.sort(teamB, Collections.reverseOrder(new HeightComparator()));
        System.out.println("Sort Tinggi Badan Tim B Secara Menurun (Descending):");
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : teamB) {
            System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
        }
        System.out.println("+-------------+------------+");
        System.out.println();

        // Weight Team A
        System.out.println("B. Berdasarkan Berat Badannya secara Ascending/menaik dan Descending/menurun ");
        System.out.println();
        Collections.sort(teamA, new WeightComparator());
        System.out.println("Sort Berat Badan Tim A Secara Menaik (Ascending):");
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : teamA) {
            System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
        }
        System.out.println("+-------------+------------+");
        System.out.println();

        Collections.sort(teamA, Collections.reverseOrder(new WeightComparator()));
        System.out.println("Sort Berat Badan Tim A Secara Menurun (Descending):");
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : teamA) {
            System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
        }
        System.out.println("+-------------+------------+");
        System.out.println();

        // Weight Team B
        Collections.sort(teamB, new WeightComparator());
        System.out.println("Sort Berat Badan Tim B Secara Menaik (Ascending):");
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : teamB) {
            System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
        }
        System.out.println("+-------------+------------+");
        System.out.println();

        Collections.sort(teamB, Collections.reverseOrder(new WeightComparator()));
        System.out.println("Sort Berat Badan Tim B Secara Menurun (Descending):");
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : teamB) {
            System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
        }
        System.out.println("+-------------+------------+");
        System.out.println();
        System.out.println();

        System.out.println(
                "C. Cari Nilai maksimum dan minimum Tinggi Badan dan Berat Badan untuk pemain dari masing-masing tim.");

        int maxHeightA = Integer.MIN_VALUE;
        int minHeightA = Integer.MAX_VALUE;

        for (Player player : teamA) {
            if (player.height > maxHeightA) {
                maxHeightA = player.height;
            }
            if (player.height < minHeightA) {
                minHeightA = player.height;
            }
        }

        
        System.out.println();
        System.out.println("Nilai Maksimum dan Minimum untuk Tinggi Badan Tim A:");
        System.out.println("Nilai Maximum Tinggi: " + maxHeightA + " cm");
        System.out.println("Nilai Minimum Tinggi: " + minHeightA + " cm");
        System.out.println();

        // Finding max and min height in teamB
        int maxHeightB = Integer.MIN_VALUE;
        int minHeightB = Integer.MAX_VALUE;

        for (Player player : teamB) {
            if (player.height > maxHeightB) {
                maxHeightB = player.height;
            }
            if (player.height < minHeightB) {
                minHeightB = player.height;
            }
        }
        System.out.println("Nilai Maksimum dan Minimum untuk Tinggi Badan Tim B:");
        System.out.println("Nilai Maximum Tinggi: " + maxHeightB + " cm");
        System.out.println("Nilai Minimum Tinggi: " + minHeightB + " cm");
        System.out.println();

        // Finding max and min weight in teamA
        int maxWeightA = Integer.MIN_VALUE;
        int minWeightA = Integer.MAX_VALUE;

        for (Player player : teamA) {
            if (player.weight > maxWeightA) {
                maxWeightA = player.weight;
            }
            if (player.weight < minWeightA) {
                minWeightA = player.weight;
            }
        }

        System.out.println("Nilai Maksimum dan Minimum untuk Berat Badan Tim A:");
        System.out.println("Nilai Maximum Berat: " + maxWeightA + " kg");
        System.out.println("Nilai Minimum Berat: " + minWeightA + " kg");
        System.out.println();

        // Finding max and min weight in teamB
        int maxWeightB = Integer.MIN_VALUE;
        int minWeightB = Integer.MAX_VALUE;

        for (Player player : teamB) {
            if (player.weight > maxWeightB) {
                maxWeightB = player.weight;
            }
            if (player.weight < minWeightB) {
                minWeightB = player.weight;
            }
        }
        System.out.println("Nilai Maksimum dan Minimum untuk Berat Badan Tim B:");
        System.out.println("Nilai Maximum Berat: " + maxWeightB + " kg");
        System.out.println("Nilai Minimum Berat: " + minWeightB + " kg");
        System.out.println();

        for (Player player : teamB) {
            teamC.add(new Player(player.height, player.weight));
        }

        // Copy Team B to Team C
        System.out.println("D. Copy seluruh anggota Tim B ke Tim C yang baru dibentuk");
        System.out.println();
        System.out.println("Data Anggota Tim C");
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : teamC) {
            System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
        }
        System.out.println("+-------------+------------+");
        System.out.println();


        System.out.println("Soal 2");
        System.out.println("B. Dari data tim B, dicari jumlah pemain yang mempunyai tinggi badan 168 cm dan 160 cm.");

        Collections.sort(teamB, new HeightComparator());

        int height168Count = binarySearchHeight(teamB, 168);
        int height160Count = binarySearchHeight(teamB, 160);
        System.out.println();
        printHeight(teamB, 168);
        System.out.println("Jumlah pemain dengan tinggi  168 cm: " + height168Count);
        System.out.println();
        printHeight(teamB, 160);
        System.out.println("Jumlah pemain dengan tinggi  160 cm: " + height160Count);
        System.out.println();

        Collections.sort(teamA, new WeightComparator());
        System.out.println("C. Dari data tim A, dicari jumlah pemain yang mempunyai berat badan 56 kg dan 53 kg.");
        int weight56Count = binarySearchWeight(teamA, 56);
        int weight53Count = binarySearchWeight(teamA, 53);
        printWeight(teamA, 56);
        System.out.println("Jumlah pemain dengan berat 56 kg: " + weight56Count);
        System.out.println();
        printWeight(teamA, 53);
        System.out.println("Jumlah pemain dengan berat 53 kg: " + weight53Count);
        System.out.println();

        Collections.sort(teamA, new HeightComparator()); // Urutkan Tim A berdasarkan tinggi badan
        Collections.sort(teamB, new HeightComparator()); // Urutkan Tim B berdasarkan tinggi badan
        System.out.println("D. Ingin diketahui apakah pemain di Tim A ada yang mempunyai tinggi badan atau berat badan yang sama dengan pemain di Tim B?");
        System.out.println();
        System.out.println("Kesamaan tinggi badan antara Tim A dan Tim B:");

        for (Player playerA : teamA) {
            if (binarySearchByHeight(teamB, playerA.height)) {
                System.out.println("Tinggi badan " + playerA.height + " ditemukan di kedua tim");
            }
        }
        sameHeight(teamA, teamB);

        Collections.sort(teamA, new WeightComparator()); // Urutkan Tim A berdasarkan berat badan
        Collections.sort(teamB, new WeightComparator()); // Urutkan Tim B berdasarkan berat badan

        System.out.println("Kesamaan berat badan antara Tim A dan Tim B:");

        for (Player playerA : teamA) {
            if (binarySearchByWeight(teamB, playerA.weight)) {
                System.out.println("Berat badan " + playerA.weight + " ditemukan di kedua tim");
            }
        }
        sameWeight(teamA, teamB);
    }

    public static int binarySearchWeight(ArrayList<Player> players, int targetWeight) {
        int left = 0;
        int right = players.size() - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Player player = players.get(mid);

            if (player.weight == targetWeight) {
                count++;

                int index = mid - 1;
                while (index >= 0 && players.get(index).weight == targetWeight) {
                    count++;
                    index--;
                }

                index = mid + 1;
                while (index < players.size() && players.get(index).weight == targetWeight) {
                    count++;
                    index++;
                }

                break;
            } else if (player.weight < targetWeight) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return count;
    }

    public static int binarySearchHeight(ArrayList<Player> players, int targetHeight) {
        int left = 0;
        int right = players.size() - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Player player = players.get(mid);

            if (player.height == targetHeight) {
                count++;

                int index = mid - 1;
                while (index >= 0 && players.get(index).height == targetHeight) {
                    count++;
                    index--;
                }

                index = mid + 1;
                while (index < players.size() && players.get(index).height == targetHeight) {
                    count++;
                    index++;
                }

                break;
            } else if (player.height < targetHeight) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return count;
    }

    static void printHeight(ArrayList<Player> team, int key) {
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : team) {
            if (player.height == key) {
                System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
            }
        }
        System.out.println("+-------------+------------+");
        System.out.println();
    }

    static void printWeight(ArrayList<Player> team, int key) {
        System.out.println("+-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+");
        for (Player player : team) {
            if (player.weight == key) {
                System.out.printf("|%8s %4s| %6s %3s |\n", player.height, "", player.weight, "");
            }
        }
        System.out.println("+-------------+------------+");
        System.out.println();
    }

    static void findWeight(ArrayList<Player> data, int key) {
        WeightComparator ct = new WeightComparator();
        Collections.sort(data, ct);
        int firstIndex = Collections.binarySearch(data, new Player(key, -1), Comparator.comparingInt(p -> p.weight));
        int lastIndex = firstIndex;
        if (firstIndex >= 0) {
            while (firstIndex > 0 && data.get(firstIndex - 1).weight == key) {
                firstIndex--;
            }
            while (lastIndex < data.size() - 1 && data.get(lastIndex + 1).weight == key) {
                lastIndex++;
            }

            int count = lastIndex - firstIndex + 1;
            System.out.println("Jumlah pemain dengan tinggi " + key + " adalah " + count);
        } else {
            System.out.println("Pemain dengan tinggi " + key + " tidak ditemukan");
        }
    }

    private static boolean binarySearchByHeight(ArrayList<Player> team, int target) {
        int left = 0;
        int right = team.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int playerHeight = team.get(mid).height;

            if (playerHeight == target) {
                return true;
            } else if (playerHeight < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    private static boolean binarySearchByWeight(ArrayList<Player> team, int target) {
        int left = 0;
        int right = team.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int playerWeight = team.get(mid).weight;

            if (playerWeight == target) {
                return true;
            } else if (playerWeight < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    static void sameHeight(ArrayList<Player> teamA, ArrayList<Player> teamB) {
        System.out.println();
        System.out.println("Data pemain dari kedua tim yang memiliki Tinggi yang sama");
        System.out.println();
        System.out.println("         Data Tim A                    Data Tim B");
        System.out.println("+-------------+------------+" + " +-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |" + " | Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+" + " +-------------+------------+");
        int a, b;
        a = 1;
        for (Player A : teamA) {
            b = 1;
            for (Player B : teamB) {
                if (A.height == B.height) {
                    System.out.printf("|%8s %4s| %6s %3s | |%8s %4s| %6s %3s |\n", A.height, "", A.weight,"", B.height, "", B.weight, "");
                }
                b++;
            }
            a++;
        }
        System.out.println("+-------------+------------+" + " +-------------+------------+");
        System.out.println();
    }
    static void sameWeight(ArrayList<Player> teamA, ArrayList<Player> teamB) {
        System.out.println();
        System.out.println("Data pemain dari kedua tim yang memiliki Berat yang sama");
        System.out.println();
        System.out.println("         Data Tim A                    Data Tim B");
        System.out.println("+-------------+------------+" + " +-------------+------------+");
        System.out.println("| Tinggi (cm) | Berat (kg) |" + " | Tinggi (cm) | Berat (kg) |");
        System.out.println("+-------------+------------+" + " +-------------+------------+");
        int a, b;
        a = 1;
        for (Player A : teamA) {
            b = 1;
            for (Player B : teamB) {
                if (A.weight == B.weight) {
                    System.out.printf("|%8s %4s| %6s %3s | |%8s %4s| %6s %3s |\n", A.height, "", A.weight,"", B.height, "", B.weight, "");
                }
                b++;
            }
            a++;
        }
        System.out.println("+-------------+------------+" + " +-------------+------------+");
        System.out.println();
    }

}
