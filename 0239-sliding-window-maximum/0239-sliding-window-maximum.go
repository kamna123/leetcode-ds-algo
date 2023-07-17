func maxSlidingWindow(nums []int, k int) []int {
	queue := make([]int, 0)
	res := make([]int, 0)

	for i := 0; i < len(nums); i++ {
		if len(queue) > 0 {
			for len(queue) > 0 && nums[i] > nums[queue[len(queue)-1]] {
				queue = queue[:len(queue)-1]
			}
		}
		queue = append(queue, i)
		if queue[0] <= i-k {
			queue = queue[1:]
		}
		if i >= k-1 {
			res = append(res, nums[queue[0]])

		}
	}
	return res
}
