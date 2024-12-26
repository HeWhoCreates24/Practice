import java.util.*;
public class MostFrequentTarget{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            
            // input array
            ArrayList <Integer> arr = new ArrayList <>();
            System.out.println("Enter array elements ( end with '.')");
            while (sc.hasNextInt()){
                arr.add(sc.nextInt());
            }
            sc.next();

            //  input key
            System.out.println("Enter the key ( should be present in array )");
            int key = sc.nextInt();

            // moore's voting kinda approach
            int maxTarget = Integer.MIN_VALUE;
            int vote = 0;
            for (int i = 0; i < arr.size()-1; i++){
                if (arr.get(i) == key){
                    if (vote == 0){
                        maxTarget = arr.get(i+1);
                        vote++;
                    }
                    else{
                        if (arr.get(i+1) == maxTarget){
                            vote++;
                        }
                        else{
                            vote--;
                        }
                    }
                }
            }

            // display max target
            if (maxTarget != Integer.MIN_VALUE){
                System.out.println("Most frequent target : " + maxTarget);
            }
            else{
                System.out.println("No target found for the given key");
            }
        }
    }
}