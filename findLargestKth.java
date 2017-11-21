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
            while(i<j && nums[j]>=pivot){
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
