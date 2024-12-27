import java.util.*;
public class BeautifulArray{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            // input n
            System.out.println("Enter n :");
            int n = sc.nextInt();

            // create beautiful array
            ArrayList <Integer> arr = new ArrayList<>();

            // initialize array with natural nums till n
            for (int i = 0; i < n; i++){
                arr.add(i+1);
            }

            // make array beautiful
            for (int i = 2; i < n; i++){

                // if not beautiful, swap
                if (i > 1 && i < n){
                    if (arr.get(i-1) * 2 == arr.get(i-2) + arr.get(i)){

                        //swap
                        int temp = arr.get(i-1);
                        arr.set(i-1, arr.get(i));
                        arr.set(i, temp);

                        //restart checking
                        i -= 2;
                    }
                }
            }

            // display beautiful array
            for (int i = 0; i < n; i++){
                System.out.print(arr.get(i) + " ");
            }
        }
    }
}