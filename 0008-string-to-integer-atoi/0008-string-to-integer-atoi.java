class Solution {
    public int myAtoi(String s) {
       int sign = 1;
       long res = 0;
       int index = 0;
       int len = s.length();
       
        while(index < len && s.charAt(index) == ' ') {
            index++;
        }
        
        if(index < len && s.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < len && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        
        while (index < len && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            res = res * 10 + digit;
            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && res * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) (sign * res);
    }
}