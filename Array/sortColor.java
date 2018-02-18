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
