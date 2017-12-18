public class binarySearch {
    public int search(int[] A, int target) {
        int l = 0, r = A.length-1, ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target <= A[mid]) {
                ans = mid;//不着急返回，不停地给ans赋值, find left bound.
                r = mid - 1;
            }  else
                l = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        binarySearch bs = new binarySearch();
        int[] arr = new int[]{1,2,2,2,2,3};
        System.out.println(bs.search(arr, 2));
    }
}
