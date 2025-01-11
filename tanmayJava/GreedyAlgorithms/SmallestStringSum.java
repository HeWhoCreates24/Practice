public class SmallestStringSum{

    public static void main(String[] args) {
        
        int n = 4, k = 42;

        StringBuilder sb = new StringBuilder("");

        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < 26; i++){

            while (((sb.length() - 1) * 26) >= (k - (i + 1))){

                if (sb.length() == (n - 1)){

                    sb.append(chars[k-1]);
                    k = 0;
                    break;

                }

                sb.append(chars[i]);
                k -= (i + 1);

            }

            if (k == 0) break;

        }

        System.out.println(sb);

    }

}