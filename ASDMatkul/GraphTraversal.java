import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

    private static int[][] graf = {
            {0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 0}
    };

    public static void main(String[] args) {
        System.out.println("Mencari rute dari titik 0 ke titik 7:");
        findRoute(0, 7);
        System.out.println("\nMencari rute dari titik 5 ke titik 7:");
        findRoute(5, 7);
    }

    private static void findRoute(int start, int finish) {
        boolean[] visited = new boolean[graf.length];
        int[] parent = new int[graf.length];
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        stack.push(start);
        visited[start] = true;
        parent[start] = -1;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (current == finish) {
                printRoute(parent, current);
                return;
            }
            for (int i = 0; i < graf.length; i++) {
                if (graf[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    stack.push(i);
                }
            }
        }
        queue.add(start);
        visited[start] = true;
        parent[start] = -1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == finish) {
                printRoute(parent, current);
                return;
            }
            for (int i = 0; i < graf.length; i++) {
                if (graf[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    queue.add(i);
                }
            }
        }
        System.out.println("Tidak ada rute dari titik " + start + " ke titik " + finish);
    }

    private static void printRoute(int[] parent, int current) {
        if (parent[current] != -1) {
            printRoute(parent, parent[current]);
        }
        System.out.print(current + " ");
    }
}
