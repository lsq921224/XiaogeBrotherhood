package leetcode;

public class QuickSort {

	public void sort(int[] arr, int left, int right){
		int i=left;
		int j=right;
		int pivot=i+(j-i)/2;
		int mid=arr[pivot];
		//partition
		while(i<=j){

			while(arr[i]<mid){
				i++;
			}
			while(arr[j]>mid){
				j--;
			}
			if(i<=j){
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		}
		if(left<j) sort(arr,left,j);
		if(i<right) sort(arr,i,right);
	}
	public static void main(String args[]){
		QuickSort test=new QuickSort();
		int[] arr=new int[]{3,2,1,5,4,4,4,3,9,8,0};
		test.sort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
