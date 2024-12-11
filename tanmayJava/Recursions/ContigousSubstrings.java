import java.util.*;
public class ContigousSubstrings{
    public static int cSubs (String str, int i, int j){
        if (i == str.length()) return 0;
        boolean cont = false;
        if (str.charAt(i) == str.charAt(j)) cont = true;
        int rest;
        if (j != str.length()-1){
            rest = cSubs(str, i, j+1);
        }
        else{
            rest = cSubs(str, i+1, i+1);
        }
        if (cont){
            return ++rest;
        }
        else{
            return rest;
        }
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter a string :");
            String str = sc.nextLine();
            int nOfCSubs = cSubs(str, 0, 0);
            System.out.println(nOfCSubs);
        }
    }
}