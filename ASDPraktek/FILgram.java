import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    private String[] usernames;
    private boolean[][] connections;

    public Graph(int num) {
        usernames = new String[num];
        connections = new boolean[num][num];
    }

    public Graph(String[] usernames, boolean[][] connections) {
        this.usernames = usernames;
        this.connections = connections;
    }

    public void addUser(String username, int index) {
        usernames[index] = username;
    }

    public void addFollows(int user1Index, int user2Index) {
        connections[user1Index][user2Index] = true;
    }

    public String[] getFollowing(int userIndex) {
        int count = 0;
        for (int i = 0; i < usernames.length; i++) {
            if (connections[userIndex][i]) {
                count++;
            }
        }

        String[] following = new String[count];
        int index = 0;
        for (int i = 0; i < usernames.length; i++) {
            if (connections[userIndex][i]) {
                following[index++] = usernames[i];
            }
        }
        return following;
    }

    public String[] getFollowers(int userIndex) {
        int count = 0;
        for (int i = 0; i < usernames.length; i++) {
            if (connections[i][userIndex]) {
                count++;
            }
        }

        String[] followers = new String[count];
        int index = 0;
        for (int i = 0; i < usernames.length; i++) {
            if (connections[i][userIndex]) {
                followers[index++] = usernames[i];
            }
        }
        return followers;
    }

    public String[] getAllUsers() {
        return usernames;
    }

    public int Index(String username) {
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public void printFollows(String username) {
        int userIndex = Index(username);
        if (userIndex == -1) {
            return;
        }

        String[] following = getFollowing(userIndex);
        String[] followers = getFollowers(userIndex);

        System.out.println(username + "'s followings :");
        if (following.length == 0) {
            System.out.print("");
        } else {
            for (String followings : following) {
                System.out.println(" " + followings);
            }
        }

        System.out.println(username + "'s followers :");
        if (followers.length == 0) {
            System.out.print("");
        } else {
            for (String follower : followers) {
                System.out.println(" " + follower);
            }
        }
    }
}

public class FILgram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int account = s.nextInt();
        s.nextLine();

        Graph graph = new Graph(account);

        for (int i = 0; i < account; i++) {
            String username = s.nextLine();
            graph.addUser(username, i);
        }

        int req = s.nextInt();
        s.nextLine();
        String command = "";
        String[] splitted = new String[2];
        for (int i = 0; i < req; i++) {
            command = s.nextLine();
            splitted = command.split(" ");

            if (splitted[1].equals("follow")) {
                String user1 = splitted[0];
                String user2 = splitted[2];
                int user1Index = graph.Index(user1);
                int user2Index = graph.Index(user2);
                if (user1Index != -1 && user2Index != -1 && !user1.equals(user2)) {
                    graph.addFollows(user1Index, user2Index);
                }
            } else if (splitted[1].equals("connections")) {
                if (splitted[0].equals("all")) {
                    String[] users = graph.getAllUsers();
                    for (String user : users) {
                        graph.printFollows(user);
                        System.out.println();
                    }
                } else {
                    String username = splitted[0];
                    graph.printFollows(username);
                }
            }
        }
        s.close();
    }
}
