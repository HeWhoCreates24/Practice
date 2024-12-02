import java.util.*;
public class oddSumEvenSum{
    public static void main(String[] args) {
        int n;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter n : ");
            n = sc.nextInt();
        }
        int oSum=0,eSum=0;
        for(int i=0;i<=n;i++){
            eSum+=(i%2==0)?i:0;
            oSum+=(i%2!=0)?i:0;
        }
        System.out.println("even sum : "+eSum+"\n odd sum : "+oSum);
    }
}