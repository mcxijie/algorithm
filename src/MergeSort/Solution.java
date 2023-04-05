package MergeSort;

//leetcode 第51题：数组中的逆序对
public class Solution {
    //没有使用归并排序
//    public int reversePairs(int[] nums) {
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    res++;
//                }
//            }
//        }
//
//        return res;
//    }

    //使用归并排序


    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];

        return sort(nums, 0, nums.length - 1, temp);
    }

    private int sort(int[] nums, int l, int r, int[] temp) {
        if (l >= r) {
            return 0;
        }

        int res = 0;
        int mid = l + (r - l) / 2;
        res += sort(nums, l, mid, temp);
        res += sort(nums, mid + 1, r, temp);
        if (nums[mid] > nums[mid + 1]) {
            res += merge(nums, l, mid, r, temp);
        }
        return res;
    }

    private int merge(int[] nums, int l, int mid, int r, int[] temp) {
        System.arraycopy(nums, l, temp, l, r - l + 1);

        int i = l, j = mid + 1, res = 0;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > r) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                res += (mid - i + 1);
                nums[k] = temp[j];
                j++;
            }
        }
        return res;
    }
}
