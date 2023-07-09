/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
    
    if head == nil || head.Next == nil {
        return head
    }
	dummy := &ListNode{}
	curr := dummy
	if head != nil && head.Next != nil {
		for head != nil && head.Next != nil {
			tmp := head.Next.Next
			dummy.Next = head.Next
			head.Next.Next = head
			head.Next = tmp

			dummy = dummy.Next.Next
			head = head.Next
		}
	}
	return curr.Next
}