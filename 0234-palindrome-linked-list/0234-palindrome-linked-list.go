/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverse(head *ListNode) *ListNode {
	prev, curr := &ListNode{}, head
	for curr != nil {
		temp := curr.Next
		curr.Next = prev
		prev = curr
		curr = temp
	}
	return prev
}
func findMid(head *ListNode) (*ListNode, *ListNode) {
	if head == nil || head.Next == nil {
		return head, nil
	}
	slow := head
	fast := head.Next
	for fast != nil && fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow, fast
}
func isPalindrome(head *ListNode) bool {
	slow, fast := findMid(head)
	if fast == nil {
		return true
	}
	listL := head
	listR := head
	if fast.Next == nil { // even
		listR = slow.Next
		slow.Next = nil
	} else { // odd
		listR = slow.Next.Next
		slow.Next = nil
	}
	listR = reverse(listR)
	for listL != nil && listR != nil {
		if listL.Val != listR.Val {
			return false
		}
		listL = listL.Next
		listR = listR.Next
	}
	return true
}
