public class QuadraticProbeHashing<T> {
    public HashEntry<T>[] dizi;
    public int elemanSayisi;

    public QuadraticProbeHashing() {
        dizi=new HashEntry[23];
    }
    public QuadraticProbeHashing(int boyut){
        dizi=new HashEntry[boyut];
    }
    public int hash(T deger) {
        return deger.hashCode()%dizi.length;
    }

    public void ekle(T eleman){
        //Karesel sondalama ekleme işlemini gerçekleştirin
    }

    public boolean sil(T eleman){
        //karesel sondalama silme işlemini gerçekleştirin
        return false;
    }

}
