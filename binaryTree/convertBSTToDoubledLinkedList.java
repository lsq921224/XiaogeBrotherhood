private static class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode(int val){
        this.val = val;
    }
}
static TreeNode prev;
static TreeNode head;
// In-order
public static void convert(TreeNode root){
    if(root == null) return;
    convert(root.left);
    if(prev == null){
        head = root;
    } else {
        root.left = prev;
        prev.right = root;
    }
    prev = root;
    convert(root.right);
}
