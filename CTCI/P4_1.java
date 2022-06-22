package CTCI;

import java.util.ArrayList;
import java.util.Stack;

public class P4_1 {

    public static boolean validPath(int n, int[][] edges, int start, int end){
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> s = new Stack<Integer>();
        s.push(start);
        while(!s.isEmpty()){
            int current = s.pop();
            visited[current] = true;
            if(current == end) return true;
            for(int neighbor : graph[current]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    s.push(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
        System.out.println(validPath(6, edges, 0, 2));
    }

}
