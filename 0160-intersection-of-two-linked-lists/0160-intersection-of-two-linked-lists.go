/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getLength(head *ListNode) int {
	len := 0
	for head != nil {
		len++
        head = head.Next
	}
	return len
}
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	len1, len2 := getLength(headA), getLength(headB)
	if len1 > len2 {
		for ; len1 > len2; len1-- {
			headA = headA.Next
		}
	} else {
		for ; len2 > len1; len2-- {
			headB = headB.Next
		}
	}
	for headA != headB {
		headA = headA.Next
		headB = headB.Next
	}
	return headA
}
