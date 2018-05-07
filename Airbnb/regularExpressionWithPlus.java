public class regularExpressionWithPlus{
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true; // this is important

        for(int i = s.length(); i >= 0; i --) { // starts from the length, to match to the end of string
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    dp[i][j] = firstMatch && dp[i+1][j] || dp[i][j + 2];
                }else if (j < p.length() - 1 && p.charAt(j + 1) == '+') {
                    // for the '+' case you need to make sure i + 1 is within range
                    dp[i][j] = firstMatch && dp[i+1][j] || (i < s.length() - 1 && dp[i + 1][j + 2]);
                } else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String args[]) {
        regularExpressionWithPlus test = new regularExpressionWithPlus();
        System.out.println(test.isMatch("abbc", "ab+c"));
        System.out.println(test.isMatch("abc", "ab+c"));
        System.out.println(test.isMatch("ac", "ab+c"));
        System.out.println(test.isMatch("abc", "ab+"));
        System.out.println(test.isMatch("ac", "ab+"));
        System.out.println(test.isMatch("abbbbbbbbbab", "ab+"));
    }

}
