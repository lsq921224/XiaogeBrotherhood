// 给定一个字符串集合tag_list，一个字符串数组all_tags，请寻找最小的all_tags子数组包含tag_list中的所有字符串，输出这个子数组的长度。如果不存在返回-1。
// Given tag_list = ["made","in","china"], all_tags = ["made", "a","b","c","in", "china","made","b","c","d"], return 3.
import java.util.*;
public class MinimumStringArrayCoverage {
    /**
     * @param tagList: The tag list.
     * @param allTags: All the tags.
     * @return: Return the answer
     */
    public int getMinimumStringArray(String[] tagList, String[] allTags) {
        // Write your code here
        Map<String, Integer> mp1 = new HashMap<String, Integer>();
        Map<String, Integer> mp2 = new HashMap<String, Integer>();
        for(int i = 0; i < tagList.length; i++) {
            mp1.put(tagList[i], 1);
        }
        int ans = allTags.length + 1;
        int l = 0;
        for(int r = 0; r < allTags.length; r++) {
            if(mp1.containsKey(allTags[r])) {
                if(!mp2.containsKey(allTags[r])) {
                    mp2.put(allTags[r], 1);
                } else {
                    mp2.put(allTags[r], mp2.get(allTags[r]) + 1);
                }
                while(l <= r && mp2.size() == tagList.length) {
                    if(r - l + 1 < ans) {
                        ans = r - l + 1;
                    }
                    if(mp1.containsKey(allTags[l])) {
                        if(mp2.get(allTags[l]) == 1) {
                            mp2.remove(allTags[l]);
                        } else {
                            mp2.put(allTags[l], mp2.get(allTags[l]) - 1);
                        }
                    }
                    l++;
                }
            }
        }
        if(ans == allTags.length + 1) {
            return -1;
        }
        return ans;
    }


    // 不是面经题，一道sliding window题目
    // 只不过是宿儒变成（string， target string），找最短substring
    public String minWindow(String s, String t) {
        Map<Character, Integer> A = new HashMap<>();
        Map<Character, Integer> B = new HashMap<>();
        int m = s.length();
        int n = t.length();

        for (int i = 0; i < n; i++) {
            A.put(t.charAt(i), A.getOrDefault(t.charAt(i), 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0, j = 0; i < m; i++) {
            char c = s.charAt(i);
            while(A.size() != B.size() && j < m) {
                char cj = s.charAt(j);
                if (A.containsKey(cj)) {
                    B.put(cj, B.getOrDefault(cj, 0) + 1);
                }
                j++;
            }
            if(A.size() == B.size()) {
                if (min > j - i) {
                    min = j - i;
                    res = s.substring(i, j);
                }
            }
            if (B.containsKey(c)){
                if (B.get(c) == 1) {
                    B.remove(c);
                } else {
                    B.put(c, B.get(c) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        MinimumStringArrayCoverage t = new MinimumStringArrayCoverage();
        System.out.println(t.minWindow("abccdbbadbcbc", "abcdd"));
    }
}
