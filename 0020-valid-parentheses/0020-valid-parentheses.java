class Solution {
    HashMap<Character, Character> mapping;

    public Solution() {
        this.mapping = new HashMap<>();
        this.mapping.put('(', ')');
        this.mapping.put('{', '}');
        this.mapping.put('[', ']');

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || this.mapping.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}