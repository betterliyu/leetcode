//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 3336 👎 0


package leetcode.editor.cn;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author DY
 * @date 2022-06-21 09:37:27
 */
public class P20_ValidParentheses {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P20_ValidParentheses().new Solution();
        System.out.println(solution.isValid("]"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> checkStack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                char prev;
                switch (s.charAt(i)) {
                    case '(':
                    case '{':
                    case '[':
                        checkStack.push(s.charAt(i));
                        break;
                    case ')':
                        if (checkStack.isEmpty()) return false;
                        prev = checkStack.pop();
                        if (prev != '(') return false;
                        break;
                    case '}':
                        if (checkStack.isEmpty()) return false;
                        prev = checkStack.pop();
                        if (prev != '{') return false;
                        break;
                    case ']':
                        if (checkStack.isEmpty()) return false;
                        prev = checkStack.pop();
                        if (prev != '[') return false;
                        break;
                }
            }

            return checkStack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}