package BST;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5,3,6,8,4,2};
        for(int i = 0; i < nums.length;i++){
            bst.add(nums[i]);
        }
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();
        bst.levelOrder();
        /*for(int num : nums)
            bst.add(num);
        bst.preOrder();
        System.out.println();
        System.out.println(bst);
        bst.inOrder();
        System.out.println();
        bst.postOrder();*/
    }
}
