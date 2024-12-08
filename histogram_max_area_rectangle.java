/*
 * Neetcode Link: https://neetcode.io/problems/largest-rectangle-in-histogram
 * Leetcode Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 *  
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer, Integer>> heightStack = new Stack<>();
        int maxArea = 0;
        int currentArea, min_idx;
        for (int i=0; i< heights.length; i++) {
            min_idx = i;
            while (heightStack.size() > 0 && heightStack.peek().getKey() > heights[i]) {
                Pair<Integer,Integer> poppedPair = heightStack.pop();
                min_idx = poppedPair.getValue();
                currentArea = poppedPair.getKey() * (i - poppedPair.getValue());
                if (currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }

            if (heightStack.size() == 0 || heightStack.peek().getKey() < heights[i]) {
                heightStack.push(new Pair<Integer,Integer>(heights[i], min_idx));
            }
        }

        while (heightStack.size() > 0) {
            Pair<Integer,Integer> poppedPair = heightStack.pop();
            currentArea = poppedPair.getKey() * (heights.length - poppedPair.getValue());
            if (currentArea > maxArea) {
                maxArea = currentArea;
            }
        }
        return maxArea;
    }
}
