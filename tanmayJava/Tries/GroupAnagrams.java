import java.util.*;
public class GroupAnagrams{
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        HashMap<String, ArrayList<String>> groups = new HashMap<>();

        for (String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);

            String id = new String(temp);

            if (groups.containsKey(id)){
                groups.get(id).add(str);
            }else{
                ArrayList<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                groups.put(id, newGroup);
            }
        }

        System.out.println(groups.values());
    }
}