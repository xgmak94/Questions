/* https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int count = 0;
        
        for(int n : nums) {
        	Integer get = map.get(n);
            if(get == null) {
                map.put(n, 1);           
                list.add(n);             
                count++;
            }
            else if(get == 1){
                map.put(n, get + 1);      
                list.add(n);                   
                count++;
            }
        }
        
        for(int i = 0 ; i < count ; i++)
            nums[i] = list.get(i);
        
        return count;
    }
}