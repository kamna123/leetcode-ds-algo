class Solution {
    public String longestPalindrome(String s) {
            
      int maxLenght = 1;
      int leftIndex = 0;
      int rightIndex = 0;
      for (int mid = 0; mid < s.length(); mid++) {
        int left = mid - 1;
        int right = mid + 1;
        // for odd length
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (maxLenght < right - left + 1) {
                    maxLenght = right - left + 1;
                    leftIndex = left;
                    rightIndex = right;
                }
                left--;
                right++;
                
            } else {
                break;
            }
        }
         // for even length
        left = mid;
        right = mid + 1;
         while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (maxLenght < right - left + 1) {
                    maxLenght = right - left + 1;
                    leftIndex = left;
                    rightIndex = right;
                }
                left--;
                right++;
                
            } else {
                break;
            }
        }
       
      }
      return s.substring(leftIndex, rightIndex + 1); 
    }
}