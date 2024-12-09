/*
 * Neetcode Link: https://neetcode.io/problems/search-2d-matrix
 * Leetcode Link: https://leetcode.com/problems/search-a-2d-matrix
 * Problem Code: 74
 * Comment: Made the while loop this time. 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int matrixHeight = matrix.length;
        if (matrixHeight == 0) {
            return false;
        }
        int matrixLength = matrix[0].length;
        if (matrixLength == 0) {
            return false;
        }


        int l = 0, r = matrixHeight - 1;
        int mid;
        int row = -1;
        // Find correct row
        while (l < r) {
            if (matrix[l][0] == target) {
                return true;
            }
            if (matrix[r][0] == target) {
                return true;
            }
            if (matrix[r][0] < target) {
                row = r;
                break;
            }
            mid = (l+r)/2;
            if (mid == l || mid == r) {
                row = l;
                break;
            }
            if (matrix[mid][0] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (row == -1) {
            if (matrix[0][0] > target || matrix[0][matrixLength - 1] < target) {
                return false;
            }
            row = 0;
        }

        l = 0; r = matrixLength - 1;
        while (l < r) {
            if (matrix[row][l] == target || matrix[row][r] == target) {
                return true;
            }
            mid = (l + r) / 2;
            if (mid == l || mid == r) {
                return false;
            }
            if (matrix[row][mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (matrix[0][0] == target) {
            return true;
        }
        return false;
    }
}
