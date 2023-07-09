/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeZeroSumSublists(head *ListNode) *ListNode {
	dummy := &ListNode{
		Next: head,
	}
	curr := dummy
	prefixSum := make(map[int]*ListNode)
	sum := 0

	for curr != nil {
		sum += curr.Val

		if prev, ok := prefixSum[sum]; ok {
			// Remove nodes between prev and current
			node := prev.Next
			subSum := sum
			for node != curr {
				subSum += node.Val
				delete(prefixSum, subSum)
				node = node.Next
			}
			prev.Next = curr.Next
		} else {
			prefixSum[sum] = curr
		}
		curr = curr.Next
	}
	return dummy.Next
}
