/* https://leetcode.com/problems/sort-characters-by-frequency/

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input:
"tree"
Output:
"eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input:
"cccaaa"
Output:
"cccaaa"
Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input:
"Aabb"
Output:
"bbAa"
Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        
        q.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Map.Entry e = q.remove();
            for (int i = 0 ; i < (int) e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        List<Character>[] list = new ArrayList[s.length()+1];
        
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char c : map.keySet()) {
            int freq = map.get(c);
            if(list[freq] == null) {
                list[freq] = new ArrayList<>();
            }
            list[freq].add(c);
        }
        for(int i = s.length() ; i >= 0 ; i--) {
            if(list[i] != null) {
                for(char c : list[i]) {
                    for(int n = 0 ; n < i ; n++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
