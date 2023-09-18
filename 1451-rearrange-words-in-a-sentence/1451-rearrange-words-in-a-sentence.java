class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                sb.append(words[i]).append(" ");
                sb.setCharAt(i, Character.toUpperCase(words[i].charAt(i)));
            } else {
                sb.append(words[i].toLowerCase()).append(" ");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}