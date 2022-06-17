//Given an unsorted array of integers nums, return the length of the longest con
//secutive elements sequence. 
//
// You must write an algorithm that runs in O(n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 1290 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * Longest Consecutive Sequence
 *
 * @author DY
 * @date 2022-06-17 09:39:27
 */
public class P128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P128_LongestConsecutiveSequence().new Solution();
        int[] data = new int[]{-1, -2, -1, -4, -1, 0};
        System.out.println(solution.longestConsecutive(data));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length <= 0) {
                return 0;
            }

            HashMap<Integer, Integer> maps = new HashMap();
            WeightedQuickUnionUF uf = new WeightedQuickUnionUF(nums.length);

            for (int i = 0; i < nums.length; i++) {
                if (!maps.containsKey(nums[i])) {
                    maps.put(nums[i], i);
                    if (maps.containsKey(nums[i] - 1)) {
                        uf.union(i, maps.get(nums[i] - 1));
                    }
                    if (maps.containsKey(nums[i] + 1)) {
                        uf.union(i, maps.get(nums[i] + 1));
                    }
                }
            }
            return uf.getMax();
        }
    }

    class WeightedQuickUnionUF {

        int[] nums;
        int[] sizes;

        int max = 1;

        public WeightedQuickUnionUF(int num) {
            nums = new int[num];
            sizes = new int[num];
            for (int i = 0; i < num; i++) {
                nums[i] = i;
                sizes[i] = 1;
            }
        }

        public int find(int n) {
            while (nums[n] != n) {
                nums[n] = nums[nums[n]];
                n = nums[n];
            }
            return nums[n];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rootP > rootQ) {
                nums[rootQ] = rootP;
                sizes[rootP] += sizes[rootQ];
                max = Math.max(max, sizes[rootP]);
            } else {
                nums[rootP] = rootQ;
                sizes[rootQ] += sizes[rootP];
                max = Math.max(max, sizes[rootQ]);
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int getMax() {
            return max;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}