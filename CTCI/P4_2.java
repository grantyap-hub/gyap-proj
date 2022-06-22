package CTCI;

public class P4_2 {

    public static TreeNode sortedArrayToBST(int[] nums){
        return sortedBST(nums, 0, nums.length-1);
    }

    public static TreeNode sortedBST(int[] nums, int start, int end){
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = sortedBST(nums, start, mid - 1);
        n.right = sortedBST(nums, mid + 1, end);
        return n;
    }

    public static String toStringInorder(TreeNode root){
        String s = "";
        if(root == null) return "";

        s += root.val + " ";
        s += toStringInorder(root.left);
        s += toStringInorder(root.right);
        return s;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode t = sortedArrayToBST(nums);
        System.out.println(toStringInorder(t));

    }


}
