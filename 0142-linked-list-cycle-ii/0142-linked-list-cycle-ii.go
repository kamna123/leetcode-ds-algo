/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func detectCycle(head *ListNode) *ListNode {
    slow := head
    fast := head
    loopExist := false
    for(fast != nil && fast.Next != nil) {
        slow = slow.Next
        fast = fast.Next.Next
        if (slow == fast) {
            loopExist = true
            break
        }
    }
    if loopExist {
     //   fmt.Println(loopExist)
        slow = head

        for slow != fast {
		//	fmt.Printf("slow - %d, fast - %d\n", slow.Val, fast.Val)
            slow = slow.Next
            fast = fast.Next
  
        }
        
        return slow
    }
    return nil
}