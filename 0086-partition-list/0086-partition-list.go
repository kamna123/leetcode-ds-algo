/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func partition(head *ListNode, x int) *ListNode {
	leftList := &ListNode{}
	leftListHead := leftList
	rightList := &ListNode{}
	rightListHead := rightList
	for head != nil {
		if head.Val < x {
			leftList.Next = head
			leftList = leftList.Next
		} else {
			rightList.Next = head
			rightList = rightList.Next
		}
		head = head.Next
	}
	leftList.Next = rightListHead.Next
	rightList.Next = nil
	return leftListHead.Next
}
