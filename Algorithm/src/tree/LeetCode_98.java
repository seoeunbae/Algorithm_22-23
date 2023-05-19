package tree;

public class LeetCode_98 {
// * Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE , Long.MAX_VALUE);
    }

    public boolean check(TreeNode root , long min, long max){
        if(root==null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return check(root.left,  min , root.val) && check(root.right, root.val, max);
        // while(!stack.isEmpty()){
        //     TreeNode cur = stack.pop();
        //     int value = cur.val;
        //     TreeNode left = cur.left;
        //     TreeNode right = cur.right;
        //     if(cur==null ){
        //         return true;
        //     }

        //     if(left != null || right != null){
        //          if(left != null){
        //             stack.add(left);
        //         }
        //         if(right != null){
        //             stack.add(right);
        //         }
        //         if(left != null && value <= left.val){
        //             return isValid= false;
        //         }
        //         if(right != null && value >= right.val){
        //             return isValid= false;
        //         }

        //     }
        // }

    }
}