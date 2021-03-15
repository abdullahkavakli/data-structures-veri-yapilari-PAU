

//import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LabGraph2<T> extends AbstractGraph2<T> {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        LabGraph2<T> cloned= new LabGraph2<T>();

        //cloned.vertices=  new ArrayList<Vertex<T>>(vertices);
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
        LabGraph2<T> cloned = new LabGraph2<T>();
        try {
            cloned = (LabGraph2<T>) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        /*while(cloned.verticesMap.size()!=0) {
            T goer=null;
            for (Map.Entry<T, Vertex<T>> mapElement : cloned.verticesMap.entrySet()) {

                if (inDegree(mapElement.getKey()) == 0) {
                    donecek.add(mapElement.getKey());
                    goer=mapElement.getKey();
                    removeVertex(mapElement.getKey());
                    break;
                }
                break;
            }

            removeVertex(goer);

        }*/


        Iterator<Map.Entry<T, Vertex<T>>> mapper = verticesMap.entrySet().iterator();

        while (cloned.verticesMap.size() != 0) {

            //T goer = null;
            //Iterator<Map.Entry<T, Vertex<T>>> mapper = verticesMap.entrySet().iterator();
                if (!(mapper.hasNext()))
                    mapper = cloned.verticesMap.entrySet().iterator();

            while (mapper.hasNext()) {
                Map.Entry<T, Vertex<T>> assistant = mapper.next();

                if (cloned.inDegree(assistant.getKey()) == 0) {
                    donecek.add(assistant.getKey());
                    System.out.println(donecek);
                    cloned.removeVertex(assistant.getKey());
                    mapper = cloned.verticesMap.entrySet().iterator();
                    break;
                }

            //break;
            }



        }
        return donecek;
    }
}
