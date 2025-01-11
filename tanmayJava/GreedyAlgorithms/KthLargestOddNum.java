public class KthLargestOddNum{

    public static void main(String[] args) {
        
        int l = -3, r = 3, k = 1;

        if (k > (Math.abs(r - l) / 2) + 1){
            System.out.println("0");
            return;
        }

        int num = (r % 2 == 0 ? r-1 : r);

        while (k-- > 1){

            num -= 2;

        }

        System.out.println(num);

    }

}