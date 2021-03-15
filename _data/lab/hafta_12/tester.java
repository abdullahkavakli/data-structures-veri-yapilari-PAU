package AbstractGraph2;

import java.util.Scanner;

public class tester {
    public static void main(String[] args) {


        LabGraph3<String> deneme = new LabGraph3();

/*
        // kenarları ve köşeleri programı çalıştırdığınızda eklemek yerine buradan da ekleyebilirsiniz

        //kenarlar için
        deneme.addVertex("a");
        deneme.addVertex("b");
        deneme.addVertex("l");
        deneme.addVertex("c");
        deneme.addVertex("g");
        deneme.addVertex("f");
        deneme.addVertex("d");
        deneme.addVertex("e");
        deneme.addVertex("h");
        //deneme.addVertex("e");
        //köşeler için
        deneme.addEdge("b","a");
        deneme.addEdge("a","e");
        deneme.addEdge("e","h");
        deneme.addEdge("e","c");
        deneme.addEdge("c","g");
        deneme.addEdge("g","h");
        deneme.addEdge("h","l");
        deneme.addEdge("l","f");
        deneme.addEdge("c","d");
        deneme.addEdge("c","f");*/



        System.out.println("İlk başta kenarları giriniz");
        System.out.println("Her kenarın değerini girdikten sonra Enter tuşuna basınız");
        System.out.println("Tüm kenarlar bitince herhangibir karekter yazmadan sadece enter tuşuna basınız");
        while (true){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
            if(!str.isEmpty()){
                deneme.addVertex(str);
                System.out.println("Yeni kenar oluşturuldu");
            }else{
                System.out.println("Şimdi kenarları giriniz");
                System.out.println("Şimdi kenarları giriniz kenar bitince ise sadece Enter tuşuna basınız");
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


        System.out.println("Şuradan başlanacak:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Breath Fisrt Search");
        System.out.println(deneme.bfs(str));
        System.out.println("Depth First Search");
        System.out.println(deneme.dfs(str));


    }
}
