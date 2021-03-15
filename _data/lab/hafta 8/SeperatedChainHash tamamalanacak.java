import java.util.LinkedList;

public class SeperatedChainHash {
    public LinkedList<Integer>[] dizi;

    public SeperatedChainHash() {
        //içerği değiştirmeyin
        dizi=new LinkedList[23];
    }
    public SeperatedChainHash(int boyut) {
        //içerği değiştirmeyin
        dizi=new LinkedList[boyut];
    }
    public int hash(int deger){
        //içerği değiştirmeyin
        return deger%dizi.length;
    }
    public void ekle(int deger){
        //ekle metodunu yazınız
    }
    public boolean sil(int deger){
        //sil metodunu yazınız
        return false;
    }
    public void yenidenOzetle() {
        //yenidenOzetle metodunu yazınız
    }
}
