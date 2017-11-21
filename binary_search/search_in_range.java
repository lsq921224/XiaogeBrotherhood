// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].
public class Solution {
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        int left = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int right = A.size() - 1;
        if (A.size() == 0) {
            res.add(-1);
            res.add(-1);
            return res;
        }
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            int midval = A.get(mid);
            if (midval < target) { //!!!WITHOUT EQUAL SIGN HERE IS IMPORTANT
                left  = mid;
            }
            else {
                right = mid;
            }
        }
        int rightbound = -1;
        if (A.get(left) == target) {
            rightbound = left;
        }
        else if (A.get(right) == target) {
            rightbound = right;
        }

        left = 0;
        right = A.size() -1;
        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            int midval = A.get(mid);
            if (midval <= target) {
                left  = mid;
            }
            else {
                right = mid;
            }
        }
        int leftbound = -1;
        if (A.get(right) == target) {
            leftbound = right;
        }
        else if (A.get(left) == target) {
            leftbound = left;
        }


        res.add(rightbound);
        res.add(leftbound);
        return res;
    }
}
