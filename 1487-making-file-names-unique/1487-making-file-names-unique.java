class Solution {
    public String[] getFolderNames(String[] names) {
                String[] res = new String[names.length];
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String name : names) {
            if (!map.containsKey(name)) {
                res[index++] = name;
                map.put(name, 1);
            } else {
                Integer count = map.get(name);
                while (map.containsKey(name + "(" + count +")")) {
                    count++;
                }
                res[index++] = name + "(" + count +")";
                map.put(name, count);
                map.put(res[index - 1], 1);
            }
        }
        return res;
    }
}