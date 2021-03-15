import java.util.ArrayList;
import java.util.List;
public class Vertex<T> {
    public T value;//Düğümün adı
    public List<Edge<T>> edges;//Kenar listesi
    public Vertex(T value) {
        this.value = value;
        edges=new ArrayList<>();
    }
}