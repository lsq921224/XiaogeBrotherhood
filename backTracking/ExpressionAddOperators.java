class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num.length() == 0)  return list;
        helper(num, target, list, "", 0, 0, 0);
        return list;
    }

    private void helper(String num, int target, List<String> res, String path, int idx, long val, long carry) {
        if (idx == num.length()) {
            if (val == target) res.add(path);
            return;
        }
        for (int i = idx; i < num.length(); i++) {
            if (i != idx && num.charAt(idx) == '0') break;
            long current_val = Long.parseLong(num.substring(idx, i + 1));
            if (idx == 0) {
                helper(num, target, res, path + current_val, i + 1, current_val, current_val);
            } else {
                helper(num, target, res, path + '+' + current_val, i + 1, val + current_val, current_val);
                helper(num, target, res, path + '-' + current_val, i + 1, val - current_val, -current_val);
                helper(num, target, res, path + '*' + current_val, i + 1, val - carry + carry * current_val, current_val * carry);
            }
        }
    }
}
