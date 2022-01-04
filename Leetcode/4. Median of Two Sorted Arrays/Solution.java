/* https://leetcode.com/problems/median-of-two-sorted-arrays/

There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).
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

import java.util.*;
class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
        
        if(totalLength % 2 == 0) return ((double)both[totalLength/2 - 1] + (double)both[totalLength/2]) / 2;
        else return both[totalLength / 2];
    }
    public static void main(String[] args) {
        double ex1 = findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        double ex2 = findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        double ex3 = findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0});
        double ex4 = findMedianSortedArrays(new int[]{2}, new int[]{});

        System.out.println(ex1);
        System.out.println(ex2);
        System.out.println(ex3);
        System.out.println(ex4);
    }
}

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int totalLength = nums1.length + nums2.length;
//         int[] both = new int[totalLength];
//         int idx = 0;
        
//         for(int i = 0 ; i < nums1.length ; i++) {
//             both[idx++] = nums1[i];
//         }
        
//         for(int j = 0 ; j < nums2.length ; j++) {
//             both[idx++] = nums2[j];
//         }
        
//         Arrays.sort(both);
        
//         if(totalLength % 2 == 0) {
//             return ((double)both[totalLength/2 - 1] + (double)both[totalLength/2]) / 2;
//         }
//         else
//             return both[totalLength / 2];
//     }
// }
