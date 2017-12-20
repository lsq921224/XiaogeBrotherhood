class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'); // . cannot match empty string, so you need the parenthesis
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return firstMatch && isMatch(s.substring(1), p) || // a* if match then take first char
                isMatch(s, p.substring(2));//a* no match then give up the regex
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    //Top Down Version
    enum Result {
        TRUE, FALSE
    }
    Result[][] memo
    public boolean isMatchDP(String s, String p) {
        memo = new Result[s.length()][p.length()];
        return helper(0, 0, s, p, memo);
    }
    public boolean helper(int i, int j, String s, String p) {
        if(memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean res;
        if (p.length() == j) { //check p len here
            res = i == s.length();
        } else {
            //check s len here
            boolean firstMatch = i < s.length && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
            if(j < p.length() - 1 && p.charAt(j + 1) == '*') {
                res = firstMatch && helper(i + 1, j, s, p) || helper(i, j + 2, s, p);
            } else {
                res = firstMatch && helper(i + 1, j + 1, s, p);
            }
        }
        memo[i][j] = res ? Result.TRUE : Result.FALSE;
        return res;
    }

    //Bottom-up
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true; // this is important

        for(int i = s.length(); i >= 0; i --) { // starts from the length
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    dp[i][j] = firstMatch && dp[i+1][j] || dp[i][j + 2];
                } else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
