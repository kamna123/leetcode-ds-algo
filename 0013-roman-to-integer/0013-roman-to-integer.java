class Solution {
    static Map<Character, Integer> values = new HashMap<>();

    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }
    public int romanToInt(String s) {
        int res = 0;
        int len = 0;
        while (len < s.length()) {
            int firstChar = values.get(s.charAt(len));
            int secondChar = 0;
            if (len + 1 < s.length()) {
                secondChar = values.get(s.charAt(len + 1));
            }
            if (secondChar > firstChar) {
                res = res + (secondChar - firstChar);
                len = len + 2;
            } else {
                res = res + firstChar;
                len = len + 1;
            }
        }
        return res;
    }
}