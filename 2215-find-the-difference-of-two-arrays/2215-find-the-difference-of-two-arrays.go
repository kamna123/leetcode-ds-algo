func findDifference(nums1 []int, nums2 []int) [][]int {
	mapNums1 := make(map[int]bool)
	mapNums2 := make(map[int]bool)
	res := make([][]int, 2)
	for _, val := range nums1 {
		mapNums1[val] = true
	}

	for _, val := range nums2 {
		mapNums2[val] = true
	}

	for key, _ := range mapNums1 {
		if _, ok := mapNums2[key]; !ok {
			res[0] = append(res[0], key)
		}
	}

	for key, _ := range mapNums2 {
		if _, ok := mapNums1[key]; !ok {
			res[1] = append(res[1], key)
		}
	}

	return res
}