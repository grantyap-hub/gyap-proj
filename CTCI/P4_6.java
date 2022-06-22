package CTCI;

public class P4_6 {
    public static TreeNode inOrderSucc(TreeNode n){
        if(n == null) return null;

        if(n.right != null){
            return leftMostChild(n.right);
        } else{
            TreeNode q = n, x = q.parent;
            while(x != null && x.left != q){
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    public static TreeNode leftMostChild(TreeNode n){
        if(n == null) return null;

        while(n.left != null){
            n = n.left;
        }
        return n;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(6));
        TreeNode temp = root, temp1 = root;
        temp = temp.right;
        temp.parent = root;
        temp1 = temp1.left;
        temp1.parent = root;
        temp1.left = new TreeNode(1);
        temp1.right = new TreeNode(3);
        temp.left = new TreeNode(5);
        temp.right = new TreeNode(7);
        TreeNode secondRootL = temp1, secondRootR = temp1, thirdRootL = temp, thirdRootR = temp;
        secondRootL = secondRootL.left;
        secondRootL.parent = temp1;
        secondRootR = secondRootR.right;
        secondRootR.parent = temp1;
        thirdRootL = thirdRootL.left;
        thirdRootL.parent = temp;
        thirdRootR = thirdRootR.right;
        thirdRootR.parent = temp;
        System.out.println(inOrderSucc(secondRootR).val);

    }
}
