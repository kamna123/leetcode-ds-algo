/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	carry := 0
	dummy := &ListNode{}
	curr := dummy
	for l1 != nil && l2 != nil {
		res := (l1.Val + l2.Val + carry) % 10
        carry = (l1.Val + l2.Val + carry) / 10
		dummy.Next = &ListNode{
			Val: res,
		}
		dummy = dummy.Next
		l1 = l1.Next
		l2 = l2.Next
	}
	for l1 != nil {
		res := (l1.Val + carry) % 10
        carry = (l1.Val + carry) / 10
		dummy.Next = &ListNode{
			Val: res,
		}
		dummy = dummy.Next
		l1 = l1.Next
	}
	for l2 != nil {
		res := (l2.Val + carry) % 10
		carry = (l2.Val + carry) / 10
		dummy.Next = &ListNode{
			Val: res,
		}
		dummy = dummy.Next
		l2 = l2.Next
	}
	if carry != 0 {
		dummy.Next = &ListNode{
			Val: carry,
		}

	}
	return curr.Next
}