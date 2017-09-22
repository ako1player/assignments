package countNumbers;
import java.util.*;
public class countNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner keyboard = new Scanner (System.in);
	        System.out.println("enter numbers you want to count.");
	        Map<Integer, Integer> list = new HashMap<>();
	        int n;
	        while((n=keyboard.nextInt()) !=0){
	            if(!list.containsKey(n)) {
	                list.put(n, 1);
	            }
	            else{
	                int value = list.get(n);
	                value++;
	                list.put(n, value);
	            }
	        }
	        int max = Collections.max(list.values());
	        System.out.println("The numbers with most occurances: ");
	        for(Map.Entry<Integer,Integer> entry : list.entrySet()){
	        	if(entry.getValue()==max)
	                System.out.println(entry.getValue()+ "\t" + entry.getKey());
	        }
	    }
	}


