class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        //this initial condition is important
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        // 2 3 1 4
        //4 2 2 1 1

        //if iterate from 0 to n would have so many corner cases because of 0;
        // if 0 exist in i, and you have to pre check, doing backwards would get rid of this case
        for (int i = n - 2; i >= 0; i--)
            //if doing forward you cannot continue here, etc 30
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }

    //convert to O(1) space
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int pre = 27, digit, answer = 0, first = 1, second = 1;
        for(int i = s.length()-1; i >= 0; i--){
            digit = s.charAt(i) - '0';
            if(digit == 0) answer = 0;
            else answer = first + (digit*10 + pre < 27 ? second : 0);
            second = first; first = answer; pre = digit;
        }
        return answer;
    }

    //from start to end
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigits = Integer.valueOf(s.substring(i-2, i)) ;
            if(oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            if(twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }         
    //get all decode path
 public Set<String> decode(String code) {
    Set<String> result = new HashSet<String>();
    helper("", code, result);
    return result;
}


public void helper(String prefix, String code, Set<String> result) {

    int len = code.length();
    if (len == 0) {
        result.add(prefix);
        return;
    }
    if (code.charAt(0) == '0')
        return;

    helper(prefix + (char)(code.charAt(0) - '1' + 'a'), code.substring(1), result);

    if (len >= 2) {
        int value = Integer.parseInt(code.substring(0, 2));
        if (value <= 26)
            helper(prefix + (char)(value - 1 +'a'), code.substring(2), result);
    }
}
                 
 
}
