// import java.util.*;

// public class NumberLines {
//     private int[][] graph;
//     private boolean[] visited;

//     public NumberLines(int[][] graph) {
//         this.graph = graph;
//         visited = new boolean[graph.length];
//     }

//     public void dfs(int start, int end) {
//         Stack<Integer> stack = new Stack();
//         stack.push(start);

//         while (!stack.empty()) {
//             int current = stack.pop();

//             if (current == end) {
//                 System.out.print(current + " ");
//                 return;
//             }

//             visited[current] = true;
//             System.out.print(current + " ");

//             for (int i = 0; i < graph[current].length; i++) {
//                 if (graph[current][i] == 1 && !visited[i]) {
//                     stack.push(i);
//                 }
//             }
//         }
//     }

//     public void bfs(int start, int end) {
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(start);

//         while (!queue.isEmpty()) {
//             int current = queue.poll();

//             if (current == end) {
//                 System.out.print(current + " ");
//                 return;
//             }

//             visited[current] = true;
//             System.out.print(current + " ");

//             for (int i = 0; i < graph[current].length; i++) {
//                 if (graph[current][i] == 1 && !visited[i]) {
//                     queue.offer(i);
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int[][] graph = {
//             {0,1,0,1,0,0,0,0},
//             {1,0,1,1,0,0,1,0},
//             {0,1,0,0,0,0,0,0},
//             {1,1,0,0,1,0,0,0},
//             {0,0,0,1,0,1,0,0},
//             {0,0,0,0,1,0,0,0},
//             {0,1,0,0,0,0,0,1},
//             {0,0,0,0,0,0,1,0}
//         };

//         NumberLines graphTraversal = new NumberLines(graph);

//         System.out.print("Path from 0 to 7: ");
//         graphTraversal.dfs(0, 7);

//         System.out.print("\nPath from 5 to 7: ");
//         graphTraversal.bfs(5, 7);
//     }
// }
