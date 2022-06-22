package CTCI;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
public class P4_3 {

    public static void compute(List<List<Integer>> ans, TreeNode root, int level){
        if(root == null) return;
        if(ans.size() == level){
            ans.add(new LinkedList<Integer>());
        }
        ans.get(level).add(root.val);
        compute(ans, root.left, level + 1);
        compute(ans, root.right, level + 1);
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        compute(ans, root, 0);
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans;
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        TreeNode temp = root;
        temp = temp.right;
        temp.left = new TreeNode(15);
        temp.right = new TreeNode(7);
        ans = levelOrder(root);
        for(List<Integer> list : ans){
            System.out.println(list);
        }

    }
}
