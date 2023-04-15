package BinarySearch;

class Solution {
    public int search1(int[] nums, int target) {
        return search1(nums, 0, nums.length - 1, target);
    }

    private int search1(int[] data, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (data[mid] == target) {
            return mid;
        }

        if (data[mid] < target) {
            return search1(data, mid + 1, r, target);
        }

        return search1(data, l, mid - 1, target);

    }

    public int search(int[] data, int target) {
        int l = 0, r = data.length;

        //在data[l...r]的范围里寻找target
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid] == target) {
                return mid;
            }

            if (data[mid] < target) {
                l = mid + 1; //target在data[mid+1,r]中
            } else {
                r = mid; //target在data[l,mid]中
            }
        }

        return -1;
    }
}