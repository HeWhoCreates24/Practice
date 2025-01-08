import java.util.Stack;

class DecodeString{
    static String decode(String str) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String temp, result = "";

        for (int i = 0; i < str.length(); i++) {
            int count = 0;

            // If the character is a digit, calculate the complete number
            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + (str.charAt(i) - '0');
                    i++;
                }
                i--; // Adjust for the loop increment
                integerStack.push(count);
            }
            // If the character is ']', decode the string
            else if (str.charAt(i) == ']') {
                temp = "";
                count = 0;

                // Get the number of repetitions
                if (!integerStack.isEmpty()) {
                    count = integerStack.pop();
                }

                // Build the string inside the brackets
                while (!stringStack.isEmpty() && !stringStack.peek().equals("[")) {
                    temp = stringStack.pop() + temp;
                }

                // Remove the '[' from the stack
                if (!stringStack.isEmpty() && stringStack.peek().equals("[")) {
                    stringStack.pop();
                }

                // Repeat the string and push it back to the stack
                String repeatedString = temp.repeat(count);
                stringStack.push(repeatedString);
            }
            // If the character is '[', push it to the stack
            else if (str.charAt(i) == '[') {
                stringStack.push("[");
            }
            // For any other character, push it to the stack
            else {
                stringStack.push(String.valueOf(str.charAt(i)));
            }
        }

        // Build the final result
        while (!stringStack.isEmpty()) {
            result = stringStack.pop() + result;
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "3[b2[ca]]";
        System.out.println(decode(str)); // Output: bcacabcacabcaca
    }
}
