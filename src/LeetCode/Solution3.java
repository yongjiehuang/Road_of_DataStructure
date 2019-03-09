package LeetCode;

public class Solution3 {
    public ListNode removeElements(ListNode head, int val, int depth){
        String depthString = generateDepthString(depth);
        System.out.println(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if(head == null)
            return null;
        head.next = removeElements(head.next,val,depth + 1);
        return head.val == val ? head.next : head;
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }
}
