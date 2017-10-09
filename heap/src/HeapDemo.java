/*
Test for clone and equals methods
 */
public class HeapDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Integer[] list = {1, 2, 3, 3, 4, 5, -1};
         Heap<Integer> heap1 = new Heap<>(list);
         Heap<Integer> heap2 = (Heap)heap1.clone();
         if(heap1.equals(heap2))
             System.out.println("heap1 equals heap2.");
         else{
             System.out.println("heap1 does not equal heap2");
         }

    }
}
