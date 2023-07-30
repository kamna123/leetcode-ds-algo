class Solution {
    public boolean isValidParenthesis(String input) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
    public void generateParenthesisHelper(int n, String curr, List<String> res) {
        if (curr.length() == 2 * n) {
            if (isValidParenthesis(curr))
                res.add(curr);
            return;
        }
        generateParenthesisHelper(n, curr + "(", res);
        generateParenthesisHelper(n, curr + ")", res);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisHelper(n, "", res);
        return res;
    }
}