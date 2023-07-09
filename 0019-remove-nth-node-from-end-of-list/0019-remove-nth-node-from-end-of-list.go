/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    dummy := &ListNode{
		Val:  0,
		Next: nil,
	}
    dummy.Next = head
	first := dummy
	second := dummy
	for i := 0; i <= n; i++ {
		first = first.Next
	}
  //  fmt.Println(first.Val)
	for first != nil {
		second = second.Next
		first = first.Next
      //   fmt.Println("inside loop -",first.Val)
	}
  //  fmt.Println(second.Val)
    
	second.Next = second.Next.Next
	return dummy.Next
}