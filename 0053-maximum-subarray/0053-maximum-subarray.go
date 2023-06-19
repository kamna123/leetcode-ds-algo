
func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}

func maxSubArray(nums []int) int {
    currSum := nums[0]
    maxSum := nums[0]
    for i := 1 ; i < len(nums); i++ {
        currSum = max(currSum + nums[i], nums[i])
        maxSum = max(maxSum, currSum)
    }
    return maxSum
}