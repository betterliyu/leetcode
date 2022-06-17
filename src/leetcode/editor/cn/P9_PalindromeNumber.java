//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 2051 👎 0


package leetcode.editor.cn;

/**
 * Palindrome Number
 *
 * @author DY
 * @date 2022-06-17 14:30:29
 */
public class P9_PalindromeNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P9_PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(1001));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x == 0) return true;
            if (x < 0 || x % 10 == 0) return false;

            // 1. 字符串反转
//            char[] sequence = Integer.toString(x).toCharArray();
//
//            for (int i = 0, j = sequence.length - 1; i < j; i++, j--) {
//                if (sequence[i] != sequence[j]) {
//                    return false;
//                }
//            }

            // 2. 全部数字反转
            int left = x;
            int reversal = 0;
            while (left != 0) {
                int high = left / 10;
                int unitDigit = high == 0 ? left : left % (high < 10 ? 10 : high);
                reversal = reversal * 10 + unitDigit;
                left = high;
            }
            return reversal == x;

            // TODO: 3. 后半段反转、

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}