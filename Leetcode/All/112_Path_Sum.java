public class Solution {
    // DFS Recursion:
    // O(1) space OR O(logn) space if consider recursion stack
    // O(n) time
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)    return false;
        return hasPathSumRec(root, sum);
    }
    
    private boolean hasPathSumRec(TreeNode root, int sum){
        if(root.left == null && root.right == null && sum == root.val)
            return true;
        if(root.left != null && hasPathSumRec(root.left, sum - root.val))
            return true;
        if(root.right != null && hasPathSumRec(root.right, sum - root.val))
            return true;
        return false;
    }

    // BFS Iteration:
    // O(n) space, n is the maximum TreeNode number from all level
    // O(n) time
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null)    return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> cnts = new LinkedList<Integer>();
        queue.add(root);
        cnts.add(root.val);
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int cnt = cnts.poll();
            if(cur.left == null && cur.right == null && cnt == sum)
                return true;
            if(cur.left != null){
                queue.add(cur.left);
                cnts.add(cur.left.val + cnt);
            }
            if(cur.right != null){
                queue.add(cur.right);
                cnts.add(cur.right.val + cnt);
            }
        }
        return false;
    }
}