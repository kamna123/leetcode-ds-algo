func middle(h *ListNode) *ListNode {
    s := h
    h = h.Next
    for ;h != nil && h.Next != nil; h = h.Next {
        s, h = s.Next, h.Next
    }
    return s
}

func merge(l, r *ListNode) *ListNode {
    var dummy ListNode
    c := &dummy
    for ; l != nil && r != nil; c = c.Next {
        if l.Val < r.Val {
            c.Next = l
            l = l.Next
            continue
        }
        c.Next = r
        r = r.Next
    }
    c.Next = r
    if l != nil {
        c.Next = l
    }
    return dummy.Next
}

func mergeSort(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    mid := middle(head)
    next := mid.Next
    mid.Next = nil
    left := mergeSort(head)
    right := mergeSort(next)
    return merge(left, right)
}

func sortList(head *ListNode) *ListNode {
    return mergeSort(head)
}