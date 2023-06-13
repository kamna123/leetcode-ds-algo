func plusOne(digits []int) []int {
	carry := 1

	for i := len(digits) - 1; i >= 0; i-- {
		num := digits[i] + carry
		// if num is less than 10 after addition, simply return the array after updating the value at index
		if num <= 9 {
			digits[i] = num
			return digits
		} else { // num is more than 10, so there is carry. 
			carry = 1
			digits[i] = 0
		}
	}
	// for cases where carry was left, so append it at the front. case like 9,9,9
	return append([]int{1}, digits...)
}