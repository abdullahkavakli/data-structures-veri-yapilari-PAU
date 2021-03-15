//19253037 Abdullah KAVAKLI 

import java.util.Comparator;

/**
 * FrekansKarsilastirici sınıfı Huffman ağaçlarını köklerindeki frekans değerlerine göre
 * karşılaştırır.
 */
class FrekansKarsilastirici implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        int compared=o1.frequency- o2.frequency;
        /*(compared > 0) ? 1 : 0;

        switch (compared) {

            case (((compared > 0) ? 1 : 0)):
                return 1;
            case (0):
                return 0;
            default: return -1;
        }*/

        if (compared>0)
            return 1;
        else if (compared==0)
            return 0;
        else return -1;

        //return 0;
    }
}

/**
 * AlfabetikKarsilastirici sınıfı Huffman ağaçlarını içlerinde bulunan en küçük karakterlere
 * göre karşılaştırır.
 */
class AlfabetikKarsilastirici implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        bestcase =26;
        int harfinsirasi_1= harfinsirasi(o1);
        bestcase =26;
        int harfinsirasi_2= harfinsirasi(o2);

        if (harfinsirasi_1>harfinsirasi_2)
            return 1;
        else if (harfinsirasi_1==harfinsirasi_2)
            return 0;
        else return -1;


    }
    int bestcase =26;

    public int harfinsirasi (HuffmanNode o1) {
        char [] alfabe= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
                'w','x','y','z'};
        if(o1.left!=null)
            harfinsirasi(o1.left);
        if(o1.right!=null)
            harfinsirasi(o1.right);

        if (o1.value!=null)
            for (int i = 0; i <25 ; i++) {
                if (o1.value==alfabe[i]&& bestcase>(i+1) ){
                    bestcase=i+1;
                    break;
                }
            }



        return bestcase;
    }

}


