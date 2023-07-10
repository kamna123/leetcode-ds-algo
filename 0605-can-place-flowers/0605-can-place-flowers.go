func canPlaceFlowers(flowerbed []int, n int) bool {
    //prev := flowerbed[0]
    prev := -1
    next := -1
    for i:= 0; i < len(flowerbed); i++ {
            prev = -1
            next = -1
        if (flowerbed[i] == 0) {
            if i == 0 || flowerbed[i - 1] == 0 {
                prev = 0
            } 
            if i == len(flowerbed) - 1 || flowerbed[i + 1] == 0 {
                next = 0
            }
            if prev == 0 && next == 0 {
                flowerbed[i] = 1
                n--
            
            }
        }
    }
    
    return n <= 0
}