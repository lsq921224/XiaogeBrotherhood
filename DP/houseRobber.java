public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    //---方法一---
    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;
        long []res = new long[n+1];


        res[0] = 0;
        res[1] = A[0];
        for(int i = 2; i <= n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + A[i-1]);
        }
        return res[n];
    }
    //---方法二---
    //滚动数组  三个变量就可以求解
    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;
        long []res = new long[2];


        res[0] = 0;
        res[1] = A[0];
        for(int i = 2; i <= n; i++) {
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2] + A[i-1]);
        }
        return res[n%2];
    }

}
// what if it's a circle
    public class Solution {
    public int houseRobber2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robber1(nums, 0, nums.length - 2), robber1(nums, 1, nums.length - 1));
    }
    public int robber1(int[] nums, int st, int ed) {
        int []res = new int[2];
        if(st == ed)
            return nums[ed];
        if(st+1 == ed)
            return Math.max(nums[st], nums[ed]);
        res[st%2] = nums[st];
        res[(st+1)%2] = Math.max(nums[st], nums[st+1]);

        for(int i = st+2; i <= ed; i++) {
            res[i%2] = Math.max(res[(i-1)%2], res[(i-2)%2] + nums[i]);

        }
        return res[ed%2];
    }
}
