/* https://leetcode.com/problems/map-sum-pairs/description/

Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
*/

class MapSum {
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        char[] chars = key.toCharArray();
        int total = val;
        String prefix = "";
        
        for(char c : chars) {
            prefix += c;
            val += map.getOrDefault(prefix, 0);
        }
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        return map.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */