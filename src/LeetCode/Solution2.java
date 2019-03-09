package LeetCode;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev= dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
                prev = prev.next.next;
            }
            else  prev = prev.next;
        }
        return dummyHead.next;   //不要返回dummyHead。因为用户不需要知道有虚拟头节点的存在
    }
}
