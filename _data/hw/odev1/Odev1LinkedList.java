/**
 * @author abdullahkavakli
 */

public class Odev1LinkedList<T extends Comparable<T>> extends AbstractLinkedList<T> {
    /*
     küçükten büyüğe sıralı olacak
     */
    @Override
    public void insertInOrder(T value) {

        if((getHead()==null) || (0<=(getHead().value).compareTo(value)) ){//tekrar incele
            addFirst(value);
        }else if(findNode(value)==null){
               addLast(value);
        }else {
            Node<T> Brought=findNode(value);
            Node<T> NewNode= new Node<>(value,Brought.next);      
            Brought.next=NewNode;
        }       
        
        
    }

    public Node<T> findNode(T value){
        
        Node<T> p=getHead();
        
        while(p.next!=null && (0<((value).compareTo(p.next.value)))){
            p=p.next;//iterator kullanamak zorunda kalabilirsin
            
        }
        if(p.next==null){
            return null;
            
        }
        
        return p;        
    }
    
    
    
    /**
     * Mevcut listeyi değiştirmeden, elemanların sırası ters çevrilmiş halde geri döndürür.
     * @return Ters çevrilmiş liste
     */
    @Override
    public AbstractLinkedList<T> reverse() {//boyutun 0 lduuğu durumu da düşün
        
        Odev1LinkedList<T> hll = new Odev1LinkedList<>();
        int size=toplamEleman();
        int samesize=size;
        for (int i = 0; i <= samesize; i++) {
            T degisken=elemanikapgel(size).value;
            hll.addLast(degisken);
            size--;
        }                                                   
        
        return hll;
    }

    
    
    
    
    
    public Node<T> elemanikapgel(int size){
        
        Node<T> p=getHead();                              
        
        for (int i = 0; i < size; i++) {
            p=p.next;
            
        }        
        
        return p;        
    }
    
    
    
    public int toplamEleman(){
        
        int size=0;
        Node<T> p=getHead(); 
        while(p.next!=null){
            p=p.next;
            size++;
        }
     return size;
    }        
        
    
    /**
     * Mevcut liste ile parametre olarak gelen listeyi birleştirip geriye döndürür.
     * Mevcut listede değişiklik yapılmaz.
     * @param list Mevcut listenin sonuna eklenecek liste
     * @return Birleşmiş liste
     */
    @Override    
    public AbstractLinkedList<T> concatenate(AbstractLinkedList<T> list) {
        
        Odev1LinkedList<T> oll = new Odev1LinkedList<>();  
        int b = toplamEleman();
        
        for (int sayac = 0; sayac <=b ; sayac++) {
            oll.addLast(elemanikapgel(sayac).value);
            
        }
        
        int listsayaci=((Odev1LinkedList)list).toplamEleman();
        for (int i = 0; i <= listsayaci; i++){
            
            oll.addLast(((Node<T>)(((Odev1LinkedList)list).elemanikapgel(i))).value);        
            
        }               
                
        return oll;
    }   
            

}
