class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String s1 = s.substring(0, 2);
            map.putIfAbsent(s1, new HashSet<>());
            map.get(s1).add(s.charAt(2));
        }
        return bfs(bottom,"", map, 1);
    }

    boolean bfs(String row, String nextRow, Map<String, Set<Character>> allowed, int start) {
        if (row.length() == 1) return true;
        if (nextRow.length() + 1 == row.length())
            return bfs(nextRow, "", allowed, 1);
        for (int i = start; i < row.length(); i++)
            //allowed可能找不到string注意返回空的set
            for (Character c : allowed.getOrDefault(row.substring(i - 1, i + 1), new HashSet<>()))
                //注意这个是i+1不是idx+1，最好命名为start比较好
                if (bfs(row, nextRow + c, allowed, i + 1))
                    return true;
        return false;
    }
}
