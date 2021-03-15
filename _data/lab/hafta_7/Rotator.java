/**
 * @author abdullahkavakli
 */

public class Rotator {
    public static <T> BTNode<T> solaDondur(BTNode<T> k1){
        
        BTNode<T> y=null;
        BTNode<T> k2=k1.right;
        
        if(k1.right.left!=null)
            y= k1.right.left;
        
        k1.right.left=k1;
        
        if(y!=null)
            k1.right=y;
        else
            k1.right=null;        
        
        return k2;
    }
    public static <T> BTNode<T> sagaDondur(BTNode<T> k2){
        
        BTNode<T> y=null;
        BTNode<T> k1=k2.left;
        
        if(k2.left.right!=null)
            y= k2.left.right;
        
        k2.left.right=k2;
        
        if(y!=null)
            k2.left=y;
        else
            k2.left=null;
        
        
        return k1;
    }
    
    
    
    public static <T> BTNode<T> solaSagaDondur(BTNode<T> k3){
        
        k3.left=solaDondur(k3.left);
        return sagaDondur(k3);
    }
    public static <T> BTNode<T> sagaSolaDondur(BTNode<T> k1){
        
        k1.right=sagaDondur(k1.right);
        return solaDondur(k1);
    }
}
