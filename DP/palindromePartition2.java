//Min Cut problem
// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];
        boolean[][] pl = new boolean[len][len];
        for (int i = len - 1;i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (j - i < 2 && s.charAt(i) == s.charAt(j)) pl[i][j] = true;
                else pl[i][j] = s.charAt(i) == s.charAt(j) && pl[i + 1][j - 1];
                if (pl[i][j]) {
                    if (j == len - 1) dp[i] = 0;
                    else dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }
}


//dfs solution
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        if(n <= 1) return 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) &&( i - j <= 2 ||
                dp[i - 1][j + 1])){
                    dp[i][j] = dp[j][i] = true;
                }
            }
        }
        return getMinPieces(s, dp, 0, n - 1) - 1;
    }
    private int getMinPieces(String s, boolean[][] isPalindrome,
    int start, int end){
        if(start == end) return 1;
        if(isPalindrome[start][end]) return 1;
        int min = s.length();
        for(int i = start; i < end; i++){
            // 回头再看，这段其实就是未优化版的 dp 逻辑。
            // 把 left 替换成 dp[]，right 替换成 isPalindrome 就是 dp 了。
            // 再仔细思考下的话，每一对 index 的区间 [i , j]
            // 其实在递归中重复出现了许多次，并且又满足 optimal substructure.
            int left = getMinPieces(s, isPalindrome, start, i);
            int right = getMinPieces(s, isPalindrome, i + 1, end);
            min = Math.min(min, left + right);
        }
        return min;
    }
}
