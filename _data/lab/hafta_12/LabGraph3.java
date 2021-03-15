package AbstractGraph2;

import java.util.*;

public class LabGraph3<T extends Comparable<T>> extends AbstractGraph3<T> {
    //T baslangıc=new T

    @Override
    public List<T> dfs(T baslangic) {

        Stack<T> stack = new Stack<>();
        List<T> visited = new ArrayList<>();
        List<T> temporary = new ArrayList<>();
        stack.push(baslangic);
        while (!stack.isEmpty()){

        T current= stack.pop();
        if (visited.contains(current))
            continue;

        visited.add(current);

            for (Vertex<T> vertex : vertices) {
                if ((vertex.value).equals(current))
                    for (Edge<T> edge: vertex.edges ) {
                        //stack.push(edge.to.value);
                        temporary.add(edge.to.value);
                    }

            }

            //System.out.println(temporary+"b4temp");
            //java.util.Collections.sort(temporary);
            temporary.sort(Comparator.naturalOrder());
            //System.out.println(temporary+"temp");
            Collections.reverse(temporary);

            for (int i = 0; i < temporary.size(); i++) {
                stack.push(temporary.get(i));
            }
            temporary.clear();

        }





        return visited;
    }

    @Override
    public List<T> bfs(T baslangic) {

        Queue<T> queue = new LinkedList<T>();
        List<T> visited = new ArrayList<>();
        List<T> temporary = new ArrayList<>();
        queue.add(baslangic);
        while (!queue.isEmpty()){

            T current= queue.remove();
            if (visited.contains(current))
                continue;

            visited.add(current);

            for (Vertex<T> vertex : vertices) {
                if ((vertex.value).equals(current))
                    for (Edge<T> edge: vertex.edges ) {
                        //queue.add(edge.to.value);
                        temporary.add(edge.to.value);
                    }

            }


            //java.util.Collections.sort(temporary);
            temporary.sort(Comparator.naturalOrder());

            for (int i = 0; i < temporary.size(); i++) {
                queue.add(temporary.get(i));
            }


            //temporary.clear();

        }








        return visited;

    }
}
