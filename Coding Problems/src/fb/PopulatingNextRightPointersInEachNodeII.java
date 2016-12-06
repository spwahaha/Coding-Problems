package fb;

public class PopulatingNextRightPointersInEachNodeII {
	//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
    public void connect(TreeLinkNode root) {
        /*
         * cur is current used node, in current level
         * head is the head of next level
         * pre is pre node when connecting the next level
         */

      
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;
        while(cur != null){
            while(cur != null){
                if(cur.left != null){
                    if(pre != null){
                        pre.next = cur.left;
                    }else{
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                
                if(cur.right != null){
                    if(pre != null){
                        pre.next = cur.right;
                    }else{
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }
    }
    
    
	
}
