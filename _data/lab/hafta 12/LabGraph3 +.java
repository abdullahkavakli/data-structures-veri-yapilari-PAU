
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

public class LabGraph3<T extends Comparable<T>> extends AbstractGraph3<T> {
    @Override
    public List<T> dfs(T baslangic) {

        Stack<T> stack = new Stack<>();
        List<T> visited = new ArrayList<>();
        stack.push(baslangic);
        while (!stack.isEmpty()){

        T current= stack.pop();
        if (visited.contains(current))
            continue;

        visited.add(current);

            for (Vertex<T> vertex : vertices) {
                if (vertex.value == (current))
                    for (Edge<T> edge: vertex.edges ) {
                        stack.push(edge.to.value);
                    }

            }


        }


        return visited;
    }

    @Override
    public List<T> bfs(T baslangic) {

        Queue<T> queue = new LinkedList<T>();
        List<T> visited = new ArrayList<>();
        queue.add(baslangic);
        while (!queue.isEmpty()){

            T current= queue.remove();
            if (visited.contains(current))
                continue;

            visited.add(current);

            for (Vertex<T> vertex : vertices) {
                if (vertex.value == (current))
                    for (Edge<T> edge: vertex.edges ) {
                        queue.add(edge.to.value);
                    }

            }


        }


        return visited;


        //return null;
    }
}
