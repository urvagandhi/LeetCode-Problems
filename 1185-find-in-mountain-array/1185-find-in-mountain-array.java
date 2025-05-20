/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int divide = peakIndexInMountainArray(mountainArr);

        int start = 0;
        int end = mountainArr.length() - 1;
        int mid = divide;

        if(mountainArr.get(mid) == target) return mid;
        int incIndex = orderAgnosticBS(mountainArr,target, start, mid, true);
        int descIndex = orderAgnosticBS(mountainArr,target, mid, end, false);
        
        if (incIndex != -1) return incIndex;
        else if(descIndex != -1) return descIndex;
        else return -1;
    }

    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            int midNextVal = mountainArr.get(mid + 1);

            if (midVal < midNextVal) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    int orderAgnosticBS(MountainArray mountainArr, int target, int start, int end, boolean isAsc) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target)
                return mid;

            if (isAsc) {
                if (target < midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

}