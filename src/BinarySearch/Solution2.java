package BinarySearch;

import java.util.Arrays;

//leetcode 875题：爱吃香蕉的珂珂
public class Solution2 {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (eatingTime(piles, mid) <= H) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int eatingTime(int[] piles, int k) {
        int res = 0;
        for (int pile : piles) {
            res += pile / k + (pile % k > 0 ? 1 : 0);
        }
        return res;
    }
}
