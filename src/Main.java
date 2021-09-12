



import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rnd = new Random();

        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaQS = new ArrayList<>();
        ArrayList<Integer> listaBB = new ArrayList<>();
        ArrayList<Integer> listaIS = new ArrayList<>();
        ArrayList<Integer> listaSS = new ArrayList<>();

//        for (int i=0;i<=4;i++){
//            lista.add(i);
//        }

        for (int i = 0; i < 10; i++) {
            lista.add(rnd.nextInt(100));


        }

        listaBB.addAll(lista);
        listaQS.addAll(lista);
        listaIS.addAll(lista);
        listaSS.addAll(lista);

        System.out.println("lista: " + lista);

        //sort
        System.out.println("Sorting Quicksort...");
        long tempoInicialQS = System.currentTimeMillis();
        quickSort(lista, 0, lista.size()-1);
        long tempoFinalQS = System.currentTimeMillis();
        System.out.println(lista);
        System.out.printf("quickSort: %.3f ms%n", (tempoFinalQS - tempoInicialQS) / 1000d);
        System.out.println( listaQS);

        System.out.println("Sorting BubbleSort...");
        long tempoInicialBB = System.currentTimeMillis();
        bubbleSort(listaBB);
        long tempoFinalBB = System.currentTimeMillis();
        System.out.printf("BubbleSort: %.3f ms%n", (tempoFinalBB - tempoInicialBB) / 1000d);
        System.out.println(listaBB);

        System.out.println("Sorting InsertionSort...");
        long tempoInicialIS = System.currentTimeMillis();
        insertionSort(listaIS);
        long tempoFinalIS = System.currentTimeMillis();
        System.out.printf("InsertionSort: %.3f ms%n", (tempoFinalIS - tempoInicialIS) / 1000d);
        System.out.println(listaIS);

        long tempoInicialSS = System.currentTimeMillis();
        selectionSort(listaSS);
        long tempoFinalSS = System.currentTimeMillis();
        System.out.printf("Selection sort: %.3f ms%n", (tempoFinalSS - tempoInicialSS) / 1000d);
        System.out.println(listaSS);
    }


    private static void quickSort(List<Integer> lista, int esquerda, int direita) {
        if (esquerda < direita) {

            int medio = esquerda;
            int left = esquerda + 1;
            int right = direita;
            int pivo = lista.get(medio);
            System.out.println("lista "+ lista +" pivo "+ pivo + " esquerda "+ lista.get(esquerda) + " direita " + lista.get(direita));

            while (left <= right) {
                while (left <= direita && pivo >= lista.get(left)) {

                    left++;
                }
                while (right > esquerda && pivo < lista.get(right)) {

                    right--;
                }

                if (left < right) {

              //      System.out.println("pivo "+ pivo +" left "+ lista.get(left) + "right" + lista.get(right));
                    Collections.swap(lista, left, right);

                }

            }

            Collections.swap(lista, medio, left - 1);
            quickSort(lista, esquerda, right - 1);
            quickSort(lista, right + 1, direita);


        }

    }

    public static void swap(ArrayList<Integer> lista, int a, int b) {
        int temp = lista.get(a);
        lista.set(a, lista.get(b));
        lista.set(b, temp);
    }

    public static void bubbleSort(ArrayList<Integer> lista) {


        for (int i = 0; i < lista.size() - 1; i++) {

            for (int j = 0; j < lista.size() - i - 1; j++) {

                if ((lista.get(j)) > lista.get(j + 1)) {
                    System.out.println("i: "+ i + " j " + j + " (j+1) " +(j+1));
                    Collections.swap(lista, j, j + 1);
//                        int aux=lista.get(j);
//                        lista.set(j, lista.get(j+1));
//                        lista.set(j+1,aux);

                    //   System.out.println("get(p) = " + lista.get(j) + " get (q) = "+ lista.get(j+1) + " lista ordenando: " + lista);

                }

            }

        }

    }

    public static void insertionSort(ArrayList<Integer> lista) {

        for (int i = 1; i < lista.size(); i++) {
            int pick = lista.get(i);
            int j = i;
            while ((j > 0) && (lista.get(j - 1) > pick)) {

                Collections.swap(lista, j, j - 1);
                j = j - 1;
                System.out.println(lista.get(j));
                System.out.println(lista.get(j + 1));
                System.out.println(lista);
            }
            if (j != i - 1) {
                lista.set(j, pick);
            }


        }
    }

    public static void selectionSort(ArrayList<Integer> lista) {

        for (int i = 0; i < lista.size()-1; i++) {
            int pick =i;

            for (int inext=i+1;inext<lista.size();inext++) {

                if (lista.get(inext) < lista.get(pick)) {
                    System.out.println("pick " + lista.get(pick) + " inext "+ lista.get(inext));

                    pick = inext;


                }
            }
            Collections.swap(lista,i,pick);


        }


    }
}




