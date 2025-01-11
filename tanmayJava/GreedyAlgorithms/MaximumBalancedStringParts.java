public class MaximumBalancedStringParts{

    public static void main(String[] args) {
        
        String str = "LRRRRLLRLLRL";

        int i = 0;
        int l = 0;
        int r = 0;
        int subs = 0;

        while (i < str.length()){

            if (str.charAt(i) == 'L'){
                l++;
            }
            else{
                r++;
            }

            if (l == r){
                subs++;
                l = 0;
                r = 0;
            }

            i++;

        }

        System.out.println("max balanced substrings : " + subs);

    }

}