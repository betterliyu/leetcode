//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 2297 👎 0


package leetcode.editor.cn;

/**
 * 最长公共前缀
 *
 * @author DY
 * @date 2022-06-20 18:21:16
 */
public class P14_LongestCommonPrefix {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P14_LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"abb", "ab", "a"}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            String lmp = "";
            for (int i = 0; i < strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length() < i + 1 || strs[j].charAt(i) != strs[0].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
                lmp = strs[0].substring(0, i + 1);
            }

            return lmp;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}