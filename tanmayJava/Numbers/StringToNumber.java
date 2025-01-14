
import java.util.*;

public class StringToNumber{
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String str = sc.nextLine();

            String[] terms = str.split(" ");

            int total = 0;
            int num = 0;

            for (String term : terms){
                switch (term.toLowerCase()) {
                    case "one" -> num += 1;
                    case "two" -> num += 2;
                    case "three" -> num += 3;
                    case "four" -> num += 4;
                    case "five" -> num += 5;
                    case "six" -> num += 6;
                    case "seven" -> num += 7;
                    case "eight" -> num += 8;
                    case "nine" -> num += 9;
                    case "ten" -> num += 10;
                    case "eleven" -> num += 11;
                    case "twelve" -> num += 12;
                    case "thirteen" -> num += 13;
                    case "fourteen" -> num += 14;
                    case "fifteen" -> num += 15;
                    case "sixteen" -> num += 16;
                    case "seventeen" -> num += 17;
                    case "eighteen" -> num += 18;
                    case "nineteen" -> num += 19;
                    case "twenty" -> {total += num; num = 0; num += 20;}
                    case "thirty" -> {total += num; num = 0; num += 30;}
                    case "forty" -> {total += num; num = 0; num += 40;}
                    case "fifty" -> {total += num; num = 0; num += 50;}
                    case "sixty" -> {total += num; num = 0; num += 60;}
                    case "seventy" -> {total += num; num = 0; num += 70;}
                    case "eighty" -> {total += num; num = 0; num += 80;}
                    case "ninety" -> {total += num; num = 0; num += 90;}
                    case "hundred" -> {
                        if (num == 0) num+= 100;
                        else num *= 100;
                    }
                    case "thousand" -> {
                        if (num == 0) num+= 1000;
                        else num *= 1000;
                    }
                    case "lakh" -> {
                        if (num == 0) num+= 100000;
                        else num *= 100000;
                    }
                    case "crore" -> {
                        if (num == 0) num+= 10000000;
                        else num *= 10000000;
                    }
                    case "hundreds" -> num *= 100;
                    case "thousands" -> num *= 1000;
                    case "lakhs" -> num *= 100000;
                    case "crores" -> num *= 10000000;
                    default -> {
                        continue;
                    }
                }
            }

            total += num;

            System.out.println(total);
        }
    }
}