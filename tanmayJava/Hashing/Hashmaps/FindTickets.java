import java.util.*;

public class FindTickets{
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("chennai", "bengaluru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");

        String start = "";

        for (String key : tickets.keySet()){
            if (!tickets.values().contains(key)){
                System.out.print(key);
                start = key;
            }
        }

        while (tickets.containsKey(start)){
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
    }
}