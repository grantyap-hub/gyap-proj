package CTCI;

import java.util.ArrayList;

public class P4_5 {

    public static boolean isBST(TreeNode root){
        ArrayList<Integer> arr = new ArrayList<>();
        inOrderTraverse(root, arr);
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i) < arr.get(i-1))
                return false;
        }
        return true;
    }

    public static void inOrderTraverse(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;
        inOrderTraverse(root.left, arr);
        arr.add(root.val);
        inOrderTraverse(root.right, arr);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(6));
        TreeNode temp = root, temp1 = root;
        temp = temp.right;
        temp1 = temp1.left;
        temp1.left = new TreeNode(1);
        temp1.right = new TreeNode(3);
        temp.left = new TreeNode(5);
        temp.right = new TreeNode(7);
        //temp = temp.right;
        //temp.right = new TreeNode(3);
        System.out.println(isBST(root));
    }

}
