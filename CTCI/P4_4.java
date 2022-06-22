package CTCI;

public class P4_4 {

    public static int getHeight(TreeNode root){
        if(root == null) return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static boolean check_balance(TreeNode root){
        if(root == null) return true;

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(right-left) <= 1){
            return true;
        }
        return false;
    }

    public static boolean isBalanced(TreeNode root){
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static int checkHeight(TreeNode root){
        if(root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if(Math.abs(leftHeight-rightHeight) > 1){
            return Integer.MIN_VALUE;
        } else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        TreeNode temp = root;
        temp = temp.right;
        temp.left = new TreeNode(15);
        temp.right = new TreeNode(7);
        temp = temp.right;
        temp.right = new TreeNode(3);
        System.out.println(isBalanced(root));

    }

}
