
import java.util.Arrays;

/**
 * Minimum heap sınıfı
 * @param <T> Generic sınıf
 */
public class BinaryHeap<T extends Comparable<T>> {
    public T[]  dizi;//Yığını tutacak dizi(değiştirmeyin)
    public int es;//Eleman sayısı(değiştirmeyin)

    public BinaryHeap() {//değiştirmeyin
        dizi=(T[]) new Comparable[100];
    }
    public BinaryHeap(int boyut){//değiştirmeyin
        dizi=(T[])new Comparable[boyut];
    }
    public int ebeveyn(int konum){ return konum/2;}//değiştirmeyin, kullanın
    public int solCocuk(int konum){ return 2*konum;}//değiştirmeyin, kullanın
    public int sagCocuk(int konum){return 2*konum+1;}//değiştirmeyin, kullanın
    public int elemanSayisi(){return es;}

    public void ekle(T eleman){
        es++;
        
        dizi[es]=eleman;
        
        int değistirilecekyer=es;
        while(değistirilecekyer>1 && eleman.compareTo(dizi[ebeveyn(değistirilecekyer)])<0){
            T ebeveyn = dizi[ebeveyn(değistirilecekyer)];
            dizi[ebeveyn(değistirilecekyer)]=eleman;
            //eleman=ebeveyn;
            dizi[değistirilecekyer]=ebeveyn;
            değistirilecekyer/=2;
            
        }
        
        
        
        
    }

    public T sil(){
        
        if(es>0){
            
            T donecek=dizi[1];  
            dizi[1]=dizi[es];
            dizi[es--]=null;
            int degisecek=1;
            
            while(es>degisecek){
                
                if(es>=degisecek*2+1){
                    switch(dizi[solCocuk(degisecek)].compareTo(dizi[sagCocuk(degisecek)])){
                        case -1:
                            T soldaki= dizi[solCocuk(degisecek)];
                            dizi[solCocuk(degisecek)]=dizi[degisecek];
                            dizi[degisecek]=soldaki;
                            degisecek=degisecek*2;
                            break;
                        default:
                            T sagdaki= dizi[sagCocuk(degisecek)];
                            dizi[sagCocuk(degisecek)]=dizi[degisecek];
                            dizi[degisecek]=sagdaki;
                            degisecek=degisecek*2+1;
                    }
                        
                }else if(es>=degisecek*2){
                    T soldaki= dizi[solCocuk(degisecek)];
                    dizi[solCocuk(degisecek)]=dizi[degisecek];
                    dizi[degisecek]=soldaki;
                    degisecek=degisecek*2;
                    
                }else
                    break;
                
                
                
            }
            
            
            
            return donecek;
        }else
            return null;
    }
}
