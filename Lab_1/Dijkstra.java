package algorithms.dijkstra;

import java.util.Scanner;

public class Dijkstra {
    private static void algo(int[][] adjacencyMatrix){
        int v = adjacencyMatrix.length;
        boolean visited[] = new boolean[v];
        int distance[] = new int[v];
        distance[0] = 0;
        for (int i=1; i<v; i++)
            distance[i] = Integer.MAX_VALUE;
        for (int i=0; i<v-1; i++){
            //find vertex with min distance
            int minVertex = findMinVertex(distance,visited);
            visited[minVertex] = true;
            //explore neighbors
            for (int j=0; j<v; j++){
                if (adjacencyMatrix[minVertex][j] !=0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE){
                    int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if (newDist < distance[j])
                        distance[j] = newDist;
                }
            }
        }
        //print
        System.out.println("Vertex | MinimumDistance");
        for (int i=0; i<v; i++)
            System.out.println("  "+i+"    |    "+distance[i]);
    }
    private static int findMinVertex(int[] distance, boolean visited[]){
        int minVertex = -1;
        for (int i=0; i<distance.length; i++){
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex] ))
                minVertex = i;

        }
        return minVertex;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of vertices and edges(e.g; 5 7): ");
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        System.out.println("Enter values of vertices and edges between them"+
                "\nvertices: 0,1 distance is 5 enter like--> 0 1 5:");
        int adjacencyMatrix[][] = new int[v][v];
        for (int i = 0; i<e; i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int weight = scanner.nextInt();
            adjacencyMatrix[v1][v2] = weight;
            adjacencyMatrix[v2][v1] = weight;
        }
        algo(adjacencyMatrix);
    }
}