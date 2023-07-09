/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNodeHeap []*ListNode

func (h ListNodeHeap) Len() int {
	return len(h)
}
func (h ListNodeHeap) Less(i, j int) bool {
	return h[i].Val < h[j].Val
}
func (h ListNodeHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}
func (h *ListNodeHeap) Push(x interface{}) {
	*h = append(*h, x.(*ListNode))
}
func (h *ListNodeHeap) Pop() interface{} {
	old := *h
	n := len(old)
	elem := old[n-1]
	*h = old[:n-1]
	return elem
}

func mergeKLists(lists []*ListNode) *ListNode {

	// Create a dummy node as the head of the merged list
	dummy := new(ListNode)
	curr := dummy

	// Create an empty min-heap
	h := &ListNodeHeap{}

	// Initialize the heap with the heads of the linked lists
	for _, node := range lists {
		if node != nil {
			heap.Push(h, node)
		}
	}
	for h.Len() > 0 {
		minNode := heap.Pop(h).(*ListNode)
		curr.Next = minNode
		curr = curr.Next
		if minNode.Next != nil {
			heap.Push(h, minNode.Next)
		}
	}
	return dummy.Next
}