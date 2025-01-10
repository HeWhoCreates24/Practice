import java.util.*;

public class GenerateBinaryNumbersTillN{

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

            System.out.println("Enter n : ");
            int n = sc.nextInt();

            // FIRST APPROACH
            System.out.println("------------First Approach------------");

            for (int i = 1; i <= n; i++){

                System.out.println(Integer.toBinaryString(i));

            }

            // QUEUE APPROACH
            System.out.println("------------Queue Approach------------");

            Queue <String> q = new LinkedList<>();

            q.add("1");

            while (n-- > 0){

                System.out.println(q.peek());

                q.add(q.peek() + "0");
                q.add(q.remove() + "1");

            }

        }
    }

}