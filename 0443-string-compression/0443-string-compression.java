class Solution {
    public int compress(char[] chars) {
        int wIndex = 0;
        int rIndex = 0;
        while (rIndex < chars.length) {
            char currChar = chars[rIndex++];
            chars[wIndex++] = currChar;
            int currCount = 1;
            while (rIndex < chars.length && chars[rIndex] == currChar) {
                rIndex++;
                currCount++;
            }
            if (currCount != 1) {
                for (char digit : Integer.toString(currCount).toCharArray()) {
                    chars[wIndex++] = digit;
                }
            }
        }
        return wIndex;
    }
}