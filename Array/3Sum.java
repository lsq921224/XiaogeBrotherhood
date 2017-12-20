public class Solution {
    	public List<List<Integer>> threeSum(int[] num) {

        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(num.length==0) return res;
        int len=num.length;
        Arrays.sort(num);
        for(int i=0;i<len-2;i++){
        	if(i!=0 && num[i]==num[i-1]) continue;//i-1 compare with i is better
        	int j=i+1;
        	int k=len-1;
        	while(k>j){
        		if(num[i]+num[k]+num[j]==0){
    				ArrayList<Integer> temp=new ArrayList<Integer>();
    				temp.add(num[i]);
    				temp.add(num[j]);
    				temp.add(num[k]);
                    res.add(temp);
    				j++;
                    k--;
        			while(j<k && num[j]==num[j-1]) j++;
        			while(j<k && num[k]==num[k+1]) k--;
        		}
        		else if(num[i]+num[k]+num[j]<0){
        			j++;
        		}
        		else {
        			k--;
        		}
        	}
        }
        return res;

    }
}
