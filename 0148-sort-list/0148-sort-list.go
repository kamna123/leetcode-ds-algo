/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func merge(listA *ListNode, listB *ListNode) *ListNode {
	if listA == nil {
		return listB
	}

	if listB == nil {
		return listA
	}
	if listA.Val < listB.Val {
		listA.Next = merge(listA.Next, listB)
		return listA
	}
	listB.Next = merge(listA, listB.Next)
	return listB
}
func middle(h *ListNode) *ListNode {
    s := h
    h = h.Next
    for ;h != nil && h.Next != nil; h = h.Next {
        s, h = s.Next, h.Next
    }
    return s
}
func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

 mid := middle(head)
    next := mid.Next
    mid.Next = nil
    left := sortList(head)
    right := sortList(next)
    return merge(left, right)

}

