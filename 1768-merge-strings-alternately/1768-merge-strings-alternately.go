func mergeAlternately(word1 string, word2 string) string {
    
    res := make([]string, 0)
	for i := 0; i < len(word1) || i < len(word2); i++ {
		if i < len(word1) {
			res = append(res, string(word1[i]))
		}
		if i < len(word2) {
			res = append(res, string(word2[i]))
		}
	}
	return strings.Join(res, "")
}