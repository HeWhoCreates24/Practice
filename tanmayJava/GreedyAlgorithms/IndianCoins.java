import java.util.*;

public class IndianCoins{

    public static void pay(int[] coins, int ammount){

        for (int i = coins.length-1; i >= 0; i--){

            if (coins[i] <= ammount){

                System.out.println("give " + coins[i]);
                pay(coins, ammount - coins[i]);
                return;

            }

        }

    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000, 2000, 5000, 20000, 50000, 100000, 200000, 500000, 1000000};
        int ammount = 8888;

        Arrays.sort(coins);

        System.out.println("To pay " + ammount + " ...");
        pay(coins, ammount);
    }

}