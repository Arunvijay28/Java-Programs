/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();

        if(root==null)
            return ans;

        Queue<TreeNode> x=new LinkedList<>();
        x.add(root);

        while(x.size()!=0){
            int i=x.size();
            System.out.println(i);

            List<Integer> temp=new ArrayList<>();

            while(i!=0){
                TreeNode ptr=x.peek();

                if(ptr.left!=null)
                    x.add(ptr.left);
                if(ptr.right!=null)
                    x.add(ptr.right);

                x.remove();
                temp.add(ptr.val);

                i-=1;
            }

            ans.add(temp);
        }

        return ans;
    }
}
