import (
	"fmt"
	"strings"
)


func generateBinaryStrings(n int, combination []string, set map[string]bool) string {
	if len(combination) == n {
		if _, exists := set[strings.Join(combination, "")]; !exists {
			return strings.Join(combination, "")
		}
		return ""
	}

	combination = append(combination, "0")
	res1 := generateBinaryStrings(n, combination, set)
	if res1 != "" {
		return res1
	}
	combination[len(combination)-1] = "1"
	res2 := generateBinaryStrings(n, combination, set)
	if res2 != "" {
		return res2
	}
	return ""

}


func findDifferentBinaryString(nums []string) string {
	set := make(map[string]bool)
	for _, val := range nums {
		set[val] = true
	}
	n := len(nums[0])
	return generateBinaryStrings(n, []string{}, set)
}