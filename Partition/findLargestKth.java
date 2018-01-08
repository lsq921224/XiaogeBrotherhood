public class Solution {
    //O(NlogK) not the best solution
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue(k);
        for(int num:nums){
            if(heap.size()<k)
                heap.add(num);
            else if(num>heap.peek()){
                heap.remove();
                heap.add(num);
            }
        }
        return heap.peek();
    }
    //O(N) Best Solution with quick selection
    public int findKthLargest(int[] nums, int k){
           return helper(nums,nums.length-k,0,nums.length-1);
    }
    public int helper(int[] nums,int k,int i, int j){
        int pivot=partition(nums,i,j);
        if(k==pivot){
            return nums[pivot];
        }
        else if(k>pivot){
            return helper(nums,k,pivot+1,j);
        }
        else{
            return helper(nums,k,i,pivot-1);
        }
    }
    public int partition(int[] nums,int start, int end){
        int pivot=nums[end];
        int i=start;
        int j=end;
        while(true){
            while(i<j && nums[i]<pivot){
                i++;
            }
            while(i<j && nums[j]>=pivot){// has to be equal because pivot is on end
                j--;
            }
            if(i==j) break;
            swap(nums,i,j);
        }
        swap(nums,i,end);
        return i;
    }

    public void swap(int[] nums,int i, int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}


public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
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

        if (k <= right) { // the equal is neccessary because the `start>=end return nums[end]`
            return quickSelect(nums, start, right, k);

        // reduce branch to save time
        // } else if (k > right && k <= left) {
        //     return quickSelect(nums, right + 1, left, k);

        } else {
            return quickSelect(nums, right + 1, end, k);
        }
    }
}
