func removeStars(s string) string {
	stack := make([]byte, 0)

	//	input := []rune(s)

	for _, val := range s {
		if val == '*' {
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, byte(val))
		}
	}
	return string(stack)
}
