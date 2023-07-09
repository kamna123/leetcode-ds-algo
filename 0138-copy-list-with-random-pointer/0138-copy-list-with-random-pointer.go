/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node {
	if head == nil {
		return head
	}
	visited := make(map[*Node]*Node)

	dummy := new(Node)
	curr := dummy
	// add nodes to map
	for node := head; node != nil; node = node.Next {
		copied := &Node{
			Val: node.Val,
		}
		curr.Next = copied
		curr = curr.Next
		visited[node] = copied
	}
	// visit head list again to copy random pointer
	for node := head; node != nil; node = node.Next {
		copied := visited[node]
		if node.Random != nil {
			copied.Random = visited[node.Random]
		}
	}

	return dummy.Next
}