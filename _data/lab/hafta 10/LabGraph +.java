


import java.util.List;
import java.util.Map;

public class LabGraph<T> extends AbstractGraph<T> {

    @Override
    public int outDegree(T deger) {
        for (Vertex<T> vertex : vertices) {
            if (vertex.value == (deger))
                return vertex.edges.size();
        }
        return -1;
    }

    @Override
    public int inDegree(T deger) {

        
        int degree=0;//indegrre that we count

        for (Map.Entry<T, List<Edge<T>>> mapElement : edges.entrySet()) {
            
            for (int i = 0; i < (mapElement.getValue().size()); i++) {
                if (mapElement.getValue().get(i).to.value==deger){
                    degree++;

                }
            }


        }

        
        if (degree>0)
            return degree;
        else {
            int indicator=0;
            for (Vertex<T> vertex : vertices) {
                if (vertex.value == (deger))
                    indicator=1;
            }
            if (indicator==0){
                return -1;
            }
            return 0;
            
        }
        
        
        
        
    }
}




