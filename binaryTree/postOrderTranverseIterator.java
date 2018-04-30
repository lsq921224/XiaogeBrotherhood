private static class PostOrderIterator implements Iterator<T
reeNode>{
    Stack<TreeNode> stack;
    TreeNode cur;
    TreeNode prev;
    public PostOrderIterator(TreeNode root){
        stack = new Stack<>();
        cur = root;
        prev = null;
        if(cur != null) stack.push(cur);
    }
    public boolean hasNext(){
        return (!stack.isEmpty());
    }
    public TreeNode next(){
        TreeNode rst = null;
        while(!stack.isEmpty()){
            cur = stack.peek();
            // three case 1. going down through left/right nodes,
            if(prev == null || prev.left == cur || prev.right == cur){
                if(cur.left != null){
                    stack.push(cur.left);
                } else if(cur.right != null){
                    stack.push(cur.right);
                }
                //case 2, going back through left nodes
            } else if(cur.left == prev){
                if(cur.right != null) stack.push(cur.right);
                //case 3, jump from left node to right node when parent has both left and right node, curr is on right node
            } else {
                rst = cur;
                stack.pop();
            }
            prev = cur;
            if(rst != null) break;
        }
        return rst;
    }
}
