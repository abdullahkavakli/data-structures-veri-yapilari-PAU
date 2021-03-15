public class Araba implements Comparable<Araba>{//türkçe karakter ışçöüğİ
    public int modelYili;
    public double motorHacmi;
    public String marka;
    public String plaka;

    public Araba(String marka, int modelYili, double motorHacmi, String plaka) {
        this.modelYili = modelYili;
        this.motorHacmi = motorHacmi;
        this.marka = marka;
        this.plaka = plaka;
    }


    @Override
    public int compareTo(Araba d) {
        return this.modelYili - d.modelYili;
    }
}