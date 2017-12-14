class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        int i = 0;//idea if to throw any non-zero nums to the front
        //in this case the for loop index is the right boundary

        for (;j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, i++, j);
            }
        }

    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
