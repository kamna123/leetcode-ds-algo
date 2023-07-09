/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func oddEvenList(head *ListNode) *ListNode {
	odd := &ListNode{}
	curr := odd
	even := &ListNode{}
	evenHead := even
	i := 1
	for head != nil {
		if i%2 == 0 {
			even.Next = head
			even = even.Next
		} else {
			odd.Next = head
			odd = odd.Next
		}
		head = head.Next
        i++
	}
    even.Next = nil
	odd.Next = evenHead.Next
	return curr.Next
}