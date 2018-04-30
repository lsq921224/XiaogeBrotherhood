public class Solution {
    public void sortColors(int[] A) {
        int red,white,blue;
        red=0;white=0;blue=0;
        for(int i=0;i<A.length;i++){
            int current=A[i];
            if (current<=2)
                A[blue++]=2;
            if (current<=1)
                A[white++]=1;
            if (current<=0)
                A[red++]=0;
        }
    }

    public void sortColors2(int[] a) {
        if(a == null || a.length <= 1)
            return;

        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        while(i <= pr){
            if(a[i] == 0){
                swap(a, pl, i);
                pl++;
                i++;
            }else if(a[i] == 1){
                i++;
            }else{
                swap(a, pr, i);
                pr--;
            }
        }
    }

    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
//K - partition
class Solution {
    /**
    * @param colors: A list of integer
    * @param k: An integer
    * @return: nothing
    */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int left = 0;
        int right = colors.length - 1;
        int cur;
        int lowColor = 1;
        int highColor = k;
        while(lowColor < highColor){
            cur = left;
            while(cur <= right){
                if(colors[cur] == lowColor){
                    swap(colors, cur ++, left ++);
                } else if(colors[cur] == highColor){
                    swap(colors, cur, right --);
                } else {
                    cur ++;
                }
            }
            lowColor ++;
            highColor --;
        }
    }
    private void swap(int[] colors, int a, int b){
        int temp = colors[a];
        colors[a] = colors[b];
        colors[b] = temp;
    }
}
