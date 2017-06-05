package searchInRotatedSortedArrayII;

public class Solution {
	public boolean search(int[] nums, int target) {
		if (nums != null && nums.length > 0) {
            int minIndex = findMinIndex(nums);

            if (minIndex == 0) return binarySearch(nums, 0, nums.length - 1, target);
            else {
                if (nums[nums.length - 1] == target) return true;
                else if (nums[nums.length - 1] > target) return binarySearch(nums, minIndex, nums.length - 1, target);
                else return binarySearch(nums, 0, minIndex - 1, target);
            }
        }

        return false;
    }
	
	private boolean binarySearch(int[] nums, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);

            if (nums[mid] == target) return true;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return false;
    }
	
	private int findMinIndex(int[] nums) {
        if (nums == null || nums.length < 1) throw new IllegalArgumentException();

        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while (nums[lo] >= nums[hi]) {
            if (hi - lo == 1) {
                mid = hi;
                break;
            }

            mid = lo + ((hi - lo) >> 1);

            if (nums[mid] == nums[lo] && nums[mid] == nums[hi]) return sequenceSearchMinIndex(nums, lo, hi);

            if (nums[mid] >= nums[lo]) lo = mid;
            else if (nums[mid] <= nums[hi]) hi = mid;
        }

        return mid;
    }
	
	private int sequenceSearchMinIndex(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) return i + 1;
        }
        
        return start;
    }
}
