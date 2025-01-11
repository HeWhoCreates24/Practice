public class SmallestStringSum{

    public static void main(String[] args) {
        
        int n = 5, k = 42;

        if (k < n || k > (n * 26)){
            System.out.println("Invalid K");
            return;
        }

        StringBuilder str = new StringBuilder("");

        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < 26; i++){

            while ((((n - str.length()) - 1) * 26) >= (k - (i + 1))){

                if (str.length() == (n - 1)){

                    str.append(chars[k-1]);
                    k = 0;
                    break;

                }

                str.append(chars[i]);
                k -= (i + 1);

            }

            if (k == 0) break;

        }

        System.out.println(str.toString());

    }

}