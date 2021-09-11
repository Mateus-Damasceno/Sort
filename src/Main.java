



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rnd = new Random();

        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaBB = new ArrayList<>();

//        for (int i=0;i<=4;i++){
//            lista.add(i);
//        }

       for (int i = 0; i < 50000; i++) {
           lista.add(rnd.nextInt(100));


        }

        listaBB.addAll(lista);
        System.out.println("lista: " + lista);
        System.out.println(lista);
        System.out.println("entrando no quicksort \n");

        long tempoInicialQS = System.currentTimeMillis();
        quickSort(lista, 0, lista.size()-1);
        long tempoFinalQS = System.currentTimeMillis();
        System.out.println(lista);
        System.out.printf("quickSort: %.3f ms%n", (tempoFinalQS - tempoInicialQS) / 1000d);
        System.out.println( "fim quickSort inicio Bubble sort");


        long tempoInicial = System.currentTimeMillis();
        bubbleSort(listaBB);
        long tempoFinal = System.currentTimeMillis();
        System.out.printf("BubbleSort: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);




        System.out.println("lista BB: " + listaBB);
        System.out.println("lista QS: " + lista);


    }


    private static void quickSort(List<Integer> lista, int esquerda, int direita) {

        if (esquerda < direita) {

            int medio = esquerda;
            int left = esquerda +1;
            int right = direita;
            int pivo=lista.get(medio);

            while (left <= right) {
                while (left<= direita && pivo >= lista.get(left)) {

                    left++;
                }
                while (right > esquerda && pivo < lista.get(right)) {

                    right--;
                }

                if (left < right) {
                    Collections.swap(lista, left, right);

                }

            }

            Collections.swap(lista,medio,left-1);
            quickSort(lista, esquerda, right - 1);
            quickSort(lista, right + 1, direita);



        }

    }

    public static void swap(ArrayList<Integer> lista, int a, int b) {
        int temp =  lista.get(a);
        lista.set(a, lista.get(b));
        lista.set(b, temp);
    }

    public static void bubbleSort(ArrayList<Integer> lista){


            for (int i=0;i<lista.size()-1;i++){

                for(int j =0; j<lista.size()-i-1;j++){

                    if((lista.get(j))>lista.get(j+1)){
                      //  System.out.println("i: "+ i + " j " + j + " (j+1) " +(j+1));
                        Collections.swap(lista,j,j+1);
//                        int aux=lista.get(j);
//                        lista.set(j, lista.get(j+1));
//                        lista.set(j+1,aux);

                     //   System.out.println("get(p) = " + lista.get(j) + " get (q) = "+ lista.get(j+1) + " lista ordenando: " + lista);

                    }

                }

            }

   }



}




