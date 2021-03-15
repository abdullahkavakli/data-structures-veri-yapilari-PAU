package AbstractGraph2;

import java.util.Scanner;

public class tester {
    public static void main(String[] args) {
        LabGraph2<String> deneme= new LabGraph2();

        // kenarları ve köşeleri programı çalıştırdığınızda konsoldan eklemek yerine buradan da ekleyebilirsiniz
/*
        //kenarlar için
        deneme.addVertex("h");
        deneme.addVertex("q");
        deneme.addVertex("c");
        deneme.addVertex("t");
        deneme.addVertex("y");
        deneme.addVertex("g");
        deneme.addVertex("w");
        deneme.addVertex("e");
        deneme.addVertex("s");
        deneme.addVertex("u");
        deneme.addVertex("k");
        deneme.addVertex("b");
        deneme.addVertex("l");

        //köşeler için
        deneme.addEdge("h","q");
        deneme.addEdge("h","c");
        deneme.addEdge("h","y");
        deneme.addEdge("q","k");
        deneme.addEdge("q","e");
        deneme.addEdge("q","y");
        deneme.addEdge("q","t");
        deneme.addEdge("q","c");
        deneme.addEdge("q","b");
        deneme.addEdge("c","u");
        deneme.addEdge("c","b");
        deneme.addEdge("u","k");
        deneme.addEdge("t","s");
        deneme.addEdge("t","l");
        deneme.addEdge("t","e");
        deneme.addEdge("y","e");
        deneme.addEdge("y","l");
        deneme.addEdge("g","l");
        deneme.addEdge("g","e");
        deneme.addEdge("w","k");
        deneme.addEdge("w","e");
        deneme.addEdge("e","k");
        deneme.addEdge("s","b");
*/





        System.out.println("İlk başta kenarları giriniz(Topolojik sıralama için)");
        System.out.println("Her kenarın değerini girdikten sonra Enter tuşuna basınız");
        System.out.println("Tüm kenarlar bitince herhangi bir karekter yazmadan sadece Enter tuşuna basınız");
        while (true){
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if(!str.isEmpty()){
                deneme.addVertex(str);
                System.out.println("Yeni kenar oluşturuldu");
            }else{
                System.out.println("Şimdi köşeleri giriniz, köşeler bitince ise sadece Enter tuşuna basınız");
                break;
            }


        }

        while (true){
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Şuradan");
            String str = sc1.nextLine();
            if(str.isEmpty() ) {

                break;
            }
            System.out.println("Şuraya");
            String str2 = sc2.nextLine();
            if(str.isEmpty() & str2.isEmpty()){

                break;

            }else{
                deneme.addEdge(str,str2);
            }


        }


        System.out.println("Graf(çizge) şu:");
        System.out.println(deneme.toString());
        System.out.println("Topolojik sıralama:");
        System.out.println(deneme.topologicalSort());

    }
}
