public class LabBinarySearchTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    public LabBinarySearchTree(){
        //Bu metodu değiştirmeyin
    }
    public LabBinarySearchTree(BTNode<T> root) {
        //Bu metodu değiştirmeyin
        super(root);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public BTNode<T> successor(T value) {
        return null;
    }

    @Override
    public BTNode<T> predecessor(T value) {
        return null;
    }

    @Override
    public BTNode<T> findParent(BTNode<T> node) {
        return null;
    }


}
