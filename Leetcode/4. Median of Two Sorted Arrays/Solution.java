/* https://leetcode.com/problems/median-of-two-sorted-arrays/

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int idx = 0;
        
        int currA = 0;
        int currB = 0;
        
        for(int i = 0 ; i < totalLength / 2 ; i++) {
            if(nums1[currA] > nums2[currB]) {
                currA++;
            }
            else {
                currB++;
            }
        }
        
        if(totalLength % 2 == 0)
            return ((double)nums1[currA] + (double)nums2[currB]) / 2;
        else
            return Math.min(nums1[currA], nums2[currB]);
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] both = new int[totalLength];
        int idx = 0;
        
        for(int i = 0 ; i < nums1.length ; i++) {
            both[idx++] = nums1[i];
        }
        
        for(int j = 0 ; j < nums2.length ; j++) {
            both[idx++] = nums2[j];
        }
        
        Arrays.sort(both);
        
        if(totalLength % 2 == 0) {
            return ((double)both[totalLength/2 - 1] + (double)both[totalLength/2]) / 2;
        }
        else
            return both[totalLength / 2];
    }
}
