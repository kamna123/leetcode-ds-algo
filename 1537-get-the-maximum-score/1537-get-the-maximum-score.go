func max(i, j int) int {
    if (i > j) {
        return i
    }
    return j
}
func maxSum(nums1 []int, nums2 []int) int {
 
    sum1 := 0
    sum2 := 0
    i := 0
    j := 0
    res := 0
    for (i < len(nums1) && j < len(nums2)) {
        if (nums1[i] < nums2[j]) {
            sum1 += nums1[i]
            i++
        } else if (nums1[i] > nums2[j]) {
            sum2 += nums2[j]
            j++
        } else {
            res += max(sum1, sum2) + nums1[i]
            i++
            j++
            sum1 = 0
            sum2 = 0
        
        }
    }
    for (i < len(nums1)) {
        sum1 += nums1[i]
        i++
    }
    for (j < len(nums2)) {
        sum2 += nums2[j]
        j++
    }
    res += max(sum1, sum2)
    return res % 1000000007;
}