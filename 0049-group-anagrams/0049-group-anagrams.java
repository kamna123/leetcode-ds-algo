class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> mapping = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);

            if (mapping.containsKey(sortedStr)) {
                List<String> val = mapping.get(sortedStr);
                val.add(str);
                mapping.put(sortedStr, val);
            } else {
                List<String> newList = new ArrayList<>(); // Create a new ArrayList
                newList.add(str);
                mapping.put(sortedStr, newList);
            }
        }
        for (Map.Entry<String, List<String>> entry : mapping.entrySet()) {
            List<String> val = entry.getValue();
            res.add(val);
        }
        return res;
    }
}