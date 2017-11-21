public class Solution {
public static double findMedianSortedArrays(int A[], int B[]) {
    int total = A.length + B.length;
    if(total%2 == 0){
        return (findKth(A,0,B,0,total/2) + findKth(A,0,B,0,total/2+1))/2.0;
    }else{
        return findKth(A,0,B,0,total/2 + 1);
    }
}
