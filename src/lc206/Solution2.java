package lc206;

//翻转链表的递归实现
public class Solution2 {
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode rev = reverseList((head.next));
        head.next.next = head;
        head.next = null;
        return rev;
    }
}
