class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        
        for (int i = 1; i <= n; i++) {
            boolean divisibleBy3 = (i % 3 == 0);
            boolean divisibleBy5 = (i % 5 == 0);
            String ans = "";
            if (divisibleBy3) {
                ans += "Fizz";
            }
            if (divisibleBy5) {
                ans += "Buzz";
            }
            if (ans.equals("")) {
                ans = Integer.toString(i);
            }
            res.add(ans);
        }
        return res;
    }
}