import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QS {

    public static void sort(List<Integer> list) {
        sort(list, 0, list.size() - 1);
    }

    public static void sort(List<Integer> list, int from, int to) {
        if (from < to) {
            int pivot = from;
            int left = from + 1;
            int right = to;
            int pivotValue = list.get(pivot);
            while (left <= right) {
                // left <= to -> limit protection
                while (left <= to && pivotValue >= list.get(left)) {
                    left++;
                }
                // right > from -> limit protection
                while (right > from && pivotValue < list.get(right)) {
                    right--;
                }
                if (left < right) {
                    Collections.swap(list, left, right);
                }
            }
            Collections.swap(list, pivot, left - 1);
            sort(list, from, right - 1); // <-- pivot was wrong!
            sort(list, right + 1, to);   // <-- pivot was wrong!
        }
    }
        public static void main(String[] args)
        {
            Random rnd = new Random();

            ArrayList<Integer> lista = new ArrayList<>();
            ArrayList<Integer> listaAntiga = new ArrayList<>();

//        for (int i=0;i<=4;i++){
//            lista.add(i);
//        }

            for (int i = 0; i < 10; i++) {
                lista.add(rnd.nextInt(100));


            }
            sort(lista, 0, lista.size() - 1);
            listaAntiga.addAll(lista);

            System.out.println(lista);
            System.out.println("entrando no quicksort \n");

            //bubbleSort(lista);
           // quickSort(lista,0,lista.size()-1);


            System.out.println("lista antiga:    " + listaAntiga);
            System.out.println("lista ordenada: " + lista);
        }


}
