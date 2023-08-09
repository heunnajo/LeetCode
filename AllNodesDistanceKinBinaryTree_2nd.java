/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//오답..디버깅 후 정답 제출 필요!
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //0.child-parent relation : HashMap<Integer,Integer>, K:child,V:parent
        HashMap<Integer,Integer> map = new HashMap<>();
        if(root.left != null){
            map.put(root.left.val,root.val);
        }
        
        if(root.right != null){
            map.put(root.right.val,root.val);
        }
        
        //1.BFS : K times
        Queue<TreeNode> q = new LinkedList<>();
        boolean[] visited = new boolean[500];
        q.offer(target);
        visited[target.val] = true;
        
        while(k>0 && !q.isEmpty()){
            
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                
                if(root.left != null && !visited[root.left.val]){
                    q.offer(root.left);
                    visited[root.left.val]
                }

                if(root.right != null && !visited[root.right.val]){
                    q.offer(root.right);
                    visited[root.right.val] = true;
                }
                
                if(map.containsKey(cur) && !visited[map.get(cur.val).val]){
                    q.offer(map.get(cur.val));
                    visited[map.get(cur.val).val] = true;
                }
            }
            
            k--;
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.offer(q.poll().val);
        }
        return ans;
    }
}