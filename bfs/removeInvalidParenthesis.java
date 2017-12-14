//BFS is definitely better than dfs because it only cares about the max result.

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<String>();
        ArrayList<String> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<String>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValid(str.toCharArray())) {
                    res.add(str);
                    found = true;// this is important, once you have found this level of result, you don't care about the lower level
                }

                if (!found) {
                    for (int j = 0; j < str.length(); j++) {
                        if (str.charAt(j) != '(' && str.charAt(j) != ')') continue;
                        String newStr = str.substring(0, j) + str.substring(j + 1);
                        if (!visited.contains(newStr)) {
                            queue.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(char[] arr) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.empty()) return false;
                if (Math.abs(stack.pop() - c) > 2) return false;
            }
        }
        return stack.empty();
    }
}
