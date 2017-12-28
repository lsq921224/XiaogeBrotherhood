public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
      Stack<TreeNode> stack=new Stack<TreeNode>();
      List<Integer> res=new ArrayList<Integer>();
      if(root==null) return res;
      stack.push(root);
      while(!stack.isEmpty()){
          TreeNode cur=stack.pop();
          res.add(cur.val);//addFirst for postOrder
          if(cur.right!=null)
          stack.push(cur.right);
          if(cur.left!=null)
          stack.push(cur.left);
      }
      return res;
  }
}
