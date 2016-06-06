public class Solution {
    public String reverseWords(String s) {
        String result = "";
        s = s.trim();
        ArrayList<String> list = new ArrayList<String>();
        String[] array = s.split(" ");
        for (String a : array)
            if (!a.trim().equals(""))
                list.add(a.trim());
        for (int i = 0; i < list.size(); i++)
            result += list.get(list.size() - 1 - i) + " ";
        result = result.trim();
        return result;
    }
}