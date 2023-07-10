func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func maxDepth(s string) int {
    input := []byte(s)
	stack := make([]byte, 0)

	res := 0
	maxLength := 0
	for _, val := range input {
		if val == '(' || val == '{' || val == '[' {
			stack = append(stack, val)
			res++
        } else if val == ')' || val == ']' || val == '}' {
           
			maxLength = max(maxLength, res)
			stack = stack[:len(stack)-1]
             res--
            
		}
	}
	return maxLength
}