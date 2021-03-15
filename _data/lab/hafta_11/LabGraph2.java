/**
 * @author abdullahkavakli
 */

import java.util.*;

public class LabGraph2<T extends Comparable<? super T>> extends AbstractGraph2<T> {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LabGraph2<T> cloned= new LabGraph2<T>();
        
        cloned.vertices.addAll(vertices);
        
        cloned.verticesMap.putAll(verticesMap);

        return cloned;
    }

    @Override
    public void removeVertex(T deger) {

        Iterator<Vertex<T>> iter = vertices.iterator();

        while (iter.hasNext()) {
            Vertex<T> vert = iter.next();

            if (vert.value == deger) {
                iter.remove();
                break;
            }
        }


        verticesMap.remove(deger);

        for (Map.Entry<T, Vertex<T>> mapElement : verticesMap.entrySet()) {




            for (int i = 0; i < (mapElement.getValue().edges.size()); i++) {
                if (mapElement.getValue().edges.get(i).to.value==deger){
                    mapElement.getValue().edges.remove(i);
                }
            }
        }
    }

    @Override
    public List<T> topologicalSort() {


        List<T> donecek = new ArrayList<>();
        List<T> temporary = new ArrayList<>();
        LabGraph2<T> cloned = new LabGraph2<T>();
        try {
            cloned = (LabGraph2<T>) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        Iterator<Map.Entry<T, Vertex<T>>> mapper = verticesMap.entrySet().iterator();

        while (cloned.verticesMap.size() != 0) {


            while (mapper.hasNext()) {
                Map.Entry<T, Vertex<T>> assistant = mapper.next();

                if (cloned.inDegree(assistant.getKey()) == 0) {
                    temporary.add(assistant.getKey());
                }


            }

            temporary.sort(Comparator.<T>naturalOrder());

            donecek.add(temporary.get(0));
            cloned.removeVertex(temporary.get(0));
            temporary.clear();
            mapper = cloned.verticesMap.entrySet().iterator();




        }
        return donecek;
    }
}
