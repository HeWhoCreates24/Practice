import java.util.*;
public class FindSubsets{
    public static void findSubsets(String str, int i, StringBuilder newStr){
        if (i == str.length()){
            if (newStr.length() == 0){
                System.out.println("null");
            }
            else{
            System.out.print(newStr + " ");
            }

            return;
        }
        findSubsets(str, i + 1, newStr.append(str.charAt(i)));
        newStr.deleteCharAt(newStr.length()-1);
        findSubsets(str, i + 1, newStr);
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String str = sc.next();
            StringBuilder newStr = new StringBuilder("");
            findSubsets(str, 0, newStr);
        }
    }
}