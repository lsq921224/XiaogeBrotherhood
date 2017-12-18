private int quickSelect(int[] nums, int start, int end, int k) {
    // System.out.println(start + " " + end + " " + k);
    if(start >= end) return nums[end];
    int left = start, right = end;
    int pivot = nums[(start + end) / 2];
    while (left <= right) {
        while(left <= right && nums[left] < pivot) left++;
        while(left <= right && nums[right] > pivot) right--;
        if (left <= right) {
            // swap
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            // check boundry for special case, can keep in both quick sort or quick select
            if (left < end) left++;
            if (right > start) right--;
        }
    } 
    // System.out.println(left + " " + right);
    // figure out which range we should keep looking at
    if (k <= right) {
        return quickSelect(nums, start, right, k);
    // reduce branch to save time
    // } else if (k > right && k <= left) {
    //     return quickSelect(nums, right + 1, left, k);
    } else {
        return quickSelect(nums, right + 1, end, k);
    }
}
