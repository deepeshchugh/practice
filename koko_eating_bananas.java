/*
 * Neetcode Link: https://neetcode.io/problems/eating-bananas
 * Leetcode Link: https://leetcode.com/problems/koko-eating-bananas/description/
 * Problem Code: 875
 */
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long totalBananas = 0;
        int maxBananas = 0;
        for (int i = 0; i < piles.length; i++) {
            totalBananas += piles[i];
            if (piles[i] > maxBananas) {
                maxBananas = piles[i];
            }
        }
        int l = (int) (totalBananas/h);
        if (l == 0) {
            l = 1;
        }
        int r = maxBananas;
        int totalTime = 0, mid;
        while (l <= r) {
            if (l == r) {
                return l;
            }
            mid = (l + r) / 2;
            totalTime = 0;
            for (int i = 0; i < piles.length; i++) {
                totalTime += piles[i] / mid;
                if ((piles[i] % mid) != 0) {
                    totalTime += 1;
                }
            }
            if (totalTime <= h) {
                if (r == mid) {
                    totalTime = 0;
                    for (int i = 0; i < piles.length; i++) {
                        totalTime += piles[i] / l;
                        if (piles[i] % l != 0) {
                            totalTime += 1;
                        }
                    }
                    if (totalTime <= h) {
                        return l;
                    }
                    return r;
                }
                r = mid;
            } else {
                if (l == mid) {
                    return r;
                }
                l = mid;
            }
        }
        return -1;
    }
}
