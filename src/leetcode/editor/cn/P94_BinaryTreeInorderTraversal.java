//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1470 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的中序遍历
 *
 * @author DY
 * @date 2022-06-27 17:07:30
 */
public class P94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        //测试代码

        Solution solution = new P94_BinaryTreeInorderTraversal().new Solution();
        TreeNode n1 = new P94_BinaryTreeInorderTraversal().new TreeNode(1);
        TreeNode n2 = new P94_BinaryTreeInorderTraversal().new TreeNode(2);
        TreeNode n3 = new P94_BinaryTreeInorderTraversal().new TreeNode(3);
        TreeNode n4 = new P94_BinaryTreeInorderTraversal().new TreeNode(4);
        TreeNode n5 = new P94_BinaryTreeInorderTraversal().new TreeNode(5);
        TreeNode n6 = new P94_BinaryTreeInorderTraversal().new TreeNode(6);
        TreeNode n7 = new P94_BinaryTreeInorderTraversal().new TreeNode(7);
        TreeNode n8 = new P94_BinaryTreeInorderTraversal().new TreeNode(8);
        TreeNode n9 = new P94_BinaryTreeInorderTraversal().new TreeNode(9);
        TreeNode n10 = new P94_BinaryTreeInorderTraversal().new TreeNode(10);
        TreeNode n11 = new P94_BinaryTreeInorderTraversal().new TreeNode(11);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n8;
        n4.right = n9;
        n5.left = n10;
        n5.right = n11;
        n1.right = n3;
        n3.left = n6;
        n3.right = n7;

        solution.inorderTraversal(n1);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            // morris 遍历
            return inorderTraversalMorris(root);
        }

//        public List<Integer> inorderTraversalRecursion(TreeNode root) {
//            List<Integer> list = new ArrayList<>();
//
//            if (root == null) {
//                return list;
//            }
//114
//            if (root.left != null) {
//                list.addAll(inorderTraversal(root.left));
//            }
//            list.add(root.val);
//            if (root.right != null) {
//                list.addAll(inorderTraversal(root.right));
//            }
//            return list;
//        }
//
//        public List<Integer> inorderTraversalLoop(TreeNode root) {
//            Stack<TreeNode> temp = new Stack<>();
//            List<Integer> list = new ArrayList<>();
//            // 1
//            while (root != null || !temp.isEmpty()) {
//                while (root != null) {
//                    temp.push(root);
//                    root = root.left;
//                }
//                TreeNode cur = temp.pop();
//                list.add(cur.val);
//                root = cur.right;
//            }
//
//
//            // 2
//            /* while(root != null || !temp.isEmpty()) {
//                if(root != null) {
//                    temp.push(root);
//                    root = root.left;
//                } else {
//                    root = temp.pop();
//                    list.add(root.val);
//                    root = root.right;
//                }
//            }
//            */
//
//            return list;
//        }

        public List<Integer> inorderTraversalMorris(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            TreeNode current = root;
            TreeNode mostRight;
            while (current != null) {
                if (current.left != null) {
                    mostRight = current.left;
                    while (mostRight.right != null && mostRight.right != current) {
                        mostRight = mostRight.right;
                    }
                    if (mostRight.right == null) {
                        mostRight.right = current;
                        current = current.left;
                        continue;
                    } else {
                        mostRight.right = null;
                        list.add(current.val);
                    }
                } else {
                    list.add(current.val);
                }
                current = current.right;
            }

            return list;
        }

//        // 后序遍历方法
//        private List<Integer> printEdge(TreeNode root) {
//            TreeNode cur = reverseNode(root);
//            TreeNode prev = null;
//            List<Integer> list = new ArrayList<>();
//            list.add(cur.val);
//            System.out.println(cur.val);
//            while (cur.right != null) {
//                prev = cur;
//                cur = cur.right;
//                if(cur != null) {
//                    list.add(cur.val);
//                    System.out.println(cur.val);
//                }
//            }
//            if (root.right != null) {
//                reverseNode(prev);
//            }
//
//            return list;
//        }
//
//        private TreeNode reverseNode(TreeNode root) {
//            if (root.right == null) {
//                return root;
//            }
//            TreeNode current = root;
//            TreeNode next = null;
//            TreeNode prev = null;
//            while (current != null) {
//                next = current.right;
//                current.right = prev;
//                prev = current;
//                current = next;
//            }
//            return prev;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}