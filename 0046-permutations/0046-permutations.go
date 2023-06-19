func permute(nums []int) [][]int {
	res := [][]int{}
	util(nums, []int{}, &res, map[int]bool{})
	return res
}
func util(nums []int, curr []int, res *[][]int, set map[int]bool) {
	if len(curr) >= len(nums) {
		temp := make([]int, len(curr))
		copy(temp, curr)
		*res = append(*res, temp)
		return
	}
	for i := 0; i < len(nums); i++ {
		if set[nums[i]] {
			continue
		}
		set[nums[i]] = true
		curr = append(curr, nums[i])
		util(nums, curr, res, set)
		delete(set, nums[i])
		curr = curr[:len(curr)-1]
	}
}