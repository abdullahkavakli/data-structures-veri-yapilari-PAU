/**
 * @author abdullahkavakli
 */


public class Traversal {
        
    static String traversalString= "";
    
    public static<T> String inOrder(BTNode<T> node) {
        traversalString= "";
        
        inOrderAssist(node);
                
        return traversalString;
    }
    
    protected static<T> String inOrderAssist(BTNode<T> node) {
        
                
        if(node.left!=null)
            inOrderAssist(node.left);
           
        
        if((node.right==null) && (node.left==null))
            return traversalString+=node.value+" ";
        else
            traversalString+=node.value+" ";
        
        
        if(node.right!=null)
            inOrderAssist(node.right);
        
        return null;
    }

    public static<T> String preOrder(BTNode<T> node) {
        
        traversalString= "";
        
        preOrderAssist(node);
                
        return traversalString;
    }
    
     protected static<T> String preOrderAssist(BTNode<T> node) {
        
         if((node.right==null) && (node.left==null))
            return traversalString+=node.value+" ";
        else
            traversalString+=node.value+" "; 
         
         
        if(node.left!=null)
            preOrderAssist(node.left);
        
        if(node.right!=null)
            preOrderAssist(node.right);
        
        return null;
    }

    public static<T> String postOrder(BTNode<T> node) {
        traversalString= "";
        postOrderAssist(node);
        
        
        return traversalString;
    }
    
    
    protected static<T> String postOrderAssist(BTNode<T> node) {
        
        if(node.left!=null)
            postOrderAssist(node.left);
        if(node.right!=null)
            postOrderAssist(node.right);
        
        
        return traversalString+=node.value+" ";
    }
    
    
    
    
}
