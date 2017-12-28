class Solution {
    public String minWindow(String s, String t) {
        int[] A = new int[256];
        int[] B = new int[256];
        int m = s.length();
        int n = t.length();
        init(B, t);
        int min = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0, j = 0; i < s.length(); i++) {
            while(j < m && !isValid(A, B)) {
                A[s.charAt(j++)]++;
            }
            if(isValid(A, B)) {
                if (min > j - i) {
                    min = j - i;
                    res = s.substring(i, j);
                }
            }
            A[s.charAt(i)]--;
        }
        return res;
    }

    public boolean isValid(int[] A, int[] B) {
        for (int i = 0; i < 256; i++) {
            if (A[i] < B[i]) {
                return false;
            }
        }
        return true;
    }

    public void init(int[] A, String s) {
        for (char c : s.toCharArray()) {
            A[c]++;
        }
    }
}
