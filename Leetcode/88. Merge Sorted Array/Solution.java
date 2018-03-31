/* https://leetcode.com/problems/merge-sorted-array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums2[j--];
            }
        }
        
        while(i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
                k--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        
        while(i >= 0) {
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while(j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int i = 0;
        int j = 0;
        
        while( i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                ans[i + j] = nums1[i];
                i++;
            }
            else {
                ans[i + j] = nums2[j];
                j++;
            }
        }
        while(i < m) {
            ans[i + j] = nums1[i];
            i++;
        }
        while(j < n) {
            ans[i + j] = nums2[j];
            j++;
        }
        
        for(int k = 0 ; k < (m + n) ; k++)
            nums1[k] = ans[k];
    }
}