type MinStack struct {
	stack    []int
	minStack []int
}

func Constructor() MinStack {
	return MinStack{
		stack:    make([]int, 0),
		minStack: make([]int, 0),
	}
}
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
func (this *MinStack) Push(val int) {
	this.stack = append(this.stack, val)
	if len(this.minStack) == 0 || this.minStack[len(this.minStack)-1] >= val {
		this.minStack = append(this.minStack, val)
	}
}

func (this *MinStack) Pop() {
	stackPeekVal := this.stack[len(this.stack)-1]
	minStackPeekVal := this.minStack[len(this.minStack)-1]
	if minStackPeekVal == stackPeekVal {
		this.minStack = this.minStack[:len(this.minStack)-1]
	}
	this.stack = this.stack[:len(this.stack)-1]
}

func (this *MinStack) Top() int {
	return this.stack[len(this.stack)-1]
}

func (this *MinStack) GetMin() int {
	return this.minStack[len(this.minStack)-1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */