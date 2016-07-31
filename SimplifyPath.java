public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        Set<String> skip = new HashSet<String>();
        skip.add("..");
        skip.add(".");
        skip.add("");
        String[] dirArr = path.split("/");
        for (String dir : dirArr) {
            if (dir.equals("..") && !stack.isEmpty()) 
                stack.pop();
            else if (!skip.contains(dir)) 
                stack.push(dir);
        }
        String res = "";
        while (!stack.isEmpty()) {
            String dir = stack.pop();
            if (!res.equals(""))
                res = dir + "/" + res;
            else 
                res = dir;
        }
        res = "/" + res;
        return res.isEmpty() ? "/" : res;
    }
}