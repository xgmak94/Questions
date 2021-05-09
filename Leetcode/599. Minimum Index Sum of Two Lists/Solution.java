/* https://leetcode.com/problems/minimum-index-sum-of-two-lists

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
*/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> ret = new LinkedList<>();
        int sumIndex = Integer.MAX_VALUE;

        if(list1.length < 1 || list2.length < 1) {
            return ret.toArray(new String[ret.size()]); //empty
        }
        
        for(int i = 0 ; i < list1.length ; i++) { //interest, index
            map.put(list1[i], i);
        }
        
        for(int i = 0 ; i < list2.length ; i++) {
            String interest = list2[i];
            if(map.containsKey(interest)) {
                int indexSum = i + map.get(interest);
                if(indexSum == sumIndex) { //add to list if equal to current indexsum
                    ret.add(interest);
                }
                else if(indexSum < sumIndex) { //clear list and add to new list if indexsum is lower
                    ret.clear();
                    ret.add(interest);
                    sumIndex = indexSum;
                }
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
}
