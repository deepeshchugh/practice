/*
 * Neetcode Link: https://neetcode.io/problems/binary-search
 * Leetcode Link: https://leetcode.com/problems/binary-search
 * Problem Code: 704
 * Comment: Space complexity currently O(logn) because of recursive stack, can be O(1) if done in loop instead.
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } 
        return searchRecursive(nums, target, 0, nums.length - 1);
    }

    private int searchRecursive(int[] nums, int target, int l, int r) {
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        int mid = (l + r) / 2;
        if (mid > l && mid < r) {
            if (nums[mid] >= target) {
                return searchRecursive(nums, target, l, mid);
            } else {
                return searchRecursive(nums, target, mid, r);
            }
        }
        return -1;
    }
}
