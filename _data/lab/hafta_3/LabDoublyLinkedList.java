/**
 * @author abdullahkavakli
 */

public class LabDoublyLinkedList<T> extends DoublyLinkedList<T> {
    
    
    @Override
    public void insertAt(int index, T value) {//beforeAdd gibi çalışıyor
        
        if(getHead()==null||index==0){
            addFirst(value);
        } else if(index==size()){
            addLast(value);
            
        } else {
        Node<T> Brought= getNode(index);
        Node<T> NewNode=new Node<>(value, Brought.next, Brought);
        Brought.next.previous=NewNode;
        Brought.next=NewNode;
        setSize(size()+1);
        }            
                        
    }
    
    
    public Node<T> getNode(int index){       
        
        if(index>size())
            throw new IndexOutOfBoundsException();
        
        Node<T> p;              
            
        p= getHead();

        for(int i=1; i<index; i++){
            p=p.next;             
        }
        
        return p;
        
    }


    @Override
    public T removeAt(int index) {        
       
        if(index==0){
            removeFirst();
        } else if(index==size()-1){
            removeLast();
        } else {
            Node<T> Brought= getNode(index+1);

            Brought.previous.next=Brought.next;
            Brought.next.previous=Brought.previous;
            setSize(size()-1);
            return Brought.value;
            
        }    
        
        return null;
    }
}
