/**
 * Huffman düğüm sınıfı. Bu sınıfın içeriğini değiştirmemeniz gerekmektedir. Değişiklik yaparsanız test ortamında kodunuz beklendiği gibi çalışmayacaktır.
 */
public class HuffmanNode {
    public Character value; // Karakter
    public int frequency; // Frekansı
    public HuffmanNode left; // sol çocuk
    public HuffmanNode right; // sağ çocuk

    public HuffmanNode(Character value, int frequency, HuffmanNode left, HuffmanNode right) {
        this.value = value;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}
