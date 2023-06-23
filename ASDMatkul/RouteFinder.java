import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RouteFinder {
    
    private int[][] graph;
    private boolean[] visited;
    private int start, finish;
    
    public RouteFinder(int[][] graph, int start, int finish) {
        this.graph = graph;
        this.start = start;
        this.finish = finish;
        this.visited = new boolean[graph.length];
    }
    
    public void findRoute() {
        int[] parent = new int[graph.length];
        Arrays.fill(parent, -1);
        
        Queue queue = new LinkedList();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = (int) queue.poll();
            if (current == finish) {
                printRoute(parent, current);
                return;
            }
            for (int i = 0; i < graph.length; i++) {
                if (graph[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    parent[i] = current;
                }
            }
        }
        System.out.println("No route found!");
    }
    
    private void printRoute(int[] parent, int current) {
        Stack stack = new Stack();
        while (current != -1) {
            stack.push(current);
            current = parent[current];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
    public static void main(String[] args) {
        int[][] graph = {
                {0,1,0,1,0,0,0,0},
                {1,0,1,1,0,0,1,0},
                {0,1,0,0,0,0,0,0},
                {1,1,0,0,1,0,0,0},
                {0,0,0,1,0,1,0,0},
                {0,0,0,0,1,0,0,0},
                {0,1,0,0,0,0,0,1},
                {0,0,0,0,0,0,1,0}
        };
        
        RouteFinder graphTraversal = new RouteFinder(graph, 5, 7);
        graphTraversal.findRoute(); // Output: 0 1 6 7
    }
}
