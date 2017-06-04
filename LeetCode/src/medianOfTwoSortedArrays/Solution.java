package medianOfTwoSortedArrays;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1 == null) nums1 = new int[0];
        if (nums2 == null) nums2 = new int[0];

        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 < len2) return findMedianSortedArrays(nums2, nums1);
        if (len2 == 0) return (nums1[(len1 - 1) / 2] + nums1[len1 / 2]) / 2.0;

        int lo = 0;
        int hi = len2 * 2;
        int mid1;
        int mid2;
        double l1, l2, r1, r2;

        while (lo <= hi) {
            mid2 = (lo + hi) / 2;
            mid1 = len1 + len2 - mid2;

            l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];

            r1 = (mid1 == len1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            r2 = (mid2 == len2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (l1 > r2) lo = mid2 + 1;
            else if (l2 > r1) hi = mid2 - 1;
            else return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        }

        return -1;
    }
}
