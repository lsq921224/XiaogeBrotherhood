class Solution {
  public void printText(List<Map<String, String>> input) {
    for (Map<String, String> m : input) {
      String s = m.get("text");
      int width = Integer.parseInt(m.get("width"));
      if (s.length() < width) {
        System.out.println(s);

      } else {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int len = 0;
        int i = 0;
        // Have to use while loop don't do for loop
        while (i < arr.length) {
            //Have to add up len first
          len += arr[i].length();
          if (len > width) {
            System.out.println(sb.toString());
            len = 0;
            sb.setLength(0);
          } else {
              // Append after checking the len
            sb.append(arr[i]);
            sb.append(" ");
            len++;
            // only plus one on here
            i++;
          }
        }
        // last line, don't forget
        if (sb.length() != 0) System.out.println(sb.toString());
      }
    }
  }
  public static void main(String[] args) {
    List<Map<String, String>> list = new ArrayList<>();
    Map<String, String> m = new HashMap<>();
    m.put("text", "This is a bad sentence");
    m.put("width", "10");
    list.add(m);
    Map<String, String> m1 = new HashMap<>();
    m1.put("text", "What ever met you again thanks for joining this interview");
    m1.put("width", "17");
    list.add(m1);
    Solution s = new Solution();
    s.printText(list);
  }
}
