package CTCI;
import java.util.*;

public class Graph<T> {

    private Map<T, List<T>> map = new HashMap<>();

    public void addNewVertex(T s){
        map.put(s, new LinkedList<T>());
    }

    public void addNewEdge(T source, T destination, boolean bidirectional) {
        if (!map.containsKey(source))
            addNewVertex(source);
        if (!map.containsKey(destination))
            addNewVertex(destination);
        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }

    public void countVertices(){
        System.out.println("Total number of vertices: " + map.keySet().size());
    }

    public void countEdges(boolean bidirection){
        int count = 0;
        for(T v: map.keySet()){
            count = count + map.get(v).size();
        }
        if(bidirection == true){
            count /= 2;
        }
        System.out.println("Total number of edges: " + count);
    }

    public void containsVertex(T s){
        if(map.containsKey(s)){
            System.out.println("The graph contains " + s + " as a vertex.");
        } else{
            System.out.println("The graph does not contains " + s + " as a vertex");
        }
    }

    public void containsEdge(T s, T d){
        if(map.get(s).contains(d)){
            System.out.println("The graph has an edge between " + s + " and " + d + ".");
        } else{
            System.out.println("There is no edge between " + s + " and " + d + ".");
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();

        for(T v: map.keySet()){
            builder.append(v.toString() + ": ");
            for(T w : map.get(v)){
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
