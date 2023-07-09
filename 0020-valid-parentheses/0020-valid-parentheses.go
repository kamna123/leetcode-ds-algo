type Stack struct {
	stack []string
}

func initilise() *Stack {
	stack := &Stack{
		stack: make([]string, 0),
	}
	return stack
}

func (st *Stack) len() int {
	return len(st.stack)
}

func (st *Stack) IsEmpty() bool {
	return len(st.stack) == 0
}

func (st *Stack) Push(data string) {
	st.stack = append(st.stack, data)
}

func (st *Stack) Pop() {
	if st.IsEmpty() {
		return
	}
	st.stack = st.stack[:st.len()-1]
}

func (st *Stack) Front() string {
	if st.IsEmpty() {
		panic("stack is empty")
	}
	return st.stack[st.len()-1]
}

func isValid(s string) bool {
	mapping := map[byte]byte{
		'(': ')',
		'{': '}',
		'[': ']',
	}

	stack := initilise()
	for i := 0; i < len(s); i++ {
		if s[i] == '(' || s[i] == '{' || s[i] == '[' {
			stack.Push(string(s[i]))
		} else {
			if stack.IsEmpty() {
				return false
			}
			val := mapping[stack.Front()[0]]
			//	fmt.Println("val ", val)
			if val != s[i] {
				return false
			}
			stack.Pop()

		}
	}
    return stack.IsEmpty()
}