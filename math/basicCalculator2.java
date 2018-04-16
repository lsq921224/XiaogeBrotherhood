import java.util.*;

class Solution {
    public int calculate(String s) {
      int result = 0;
      int sign = 1;
      int num = 0;
      Stack<Integer> stack = new Stack<>();

      for (char c : s.toCharArray()) {
        if (c == ' ') continue;
        else if (Character.isDigit(c)) num = num*10 + Character.getNumericValue(c);
        else {
          if (!stack.isEmpty()) {
            int a = stack.pop();
            int b = stack.pop();
            num = cal(b, num, a);
          }
          if (c == '+') {
            result = cal(result, num, sign);
            sign = 1;
          } else if (c == '-') {
            result = cal(result, num, sign);
            sign = -1;
          } else if (c == '*') {
            stack.push(num);
            stack.push(2);
          } else if (c == '/') {
            stack.push(num);
            stack.push(3);
          }
          num = 0;
        }
      }
      if (!stack.isEmpty()) {
        int a = stack.pop();
        int b = stack.pop();
        num = cal(b, num, a);
      }

      return cal(result, num, sign);
    }
    private int cal(int a, int b, int op) {
      if (op < 2) {
        return a + op * b;
      } else if (op == 2) {
        return a * b;
      } else {
        return a / b;
      }
    }
}


// Solution 2, store the opartion and do * / first.
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c != ' ' && !Character.isDigit(c) || i + 1 == s.length()) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
