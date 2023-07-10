func getMax(arr []int) int {
    res := 0
    for _, val := range arr {
        if val >= res {
            res = val
        }
    }
    return res
}
func kidsWithCandies(candies []int, extraCandies int) []bool {
    
    res := make([]bool, len(candies))
    maxCandies := getMax(candies)
    for i, val := range candies {
        if val + extraCandies >= maxCandies {
            res[i] = true
        }
    }
    return res
}