/* https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

Example 1:
Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").

Example 2:
Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 
Constraints:
1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] are English lowercase letters.
*/

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] smallestFreq = new int[words.length];      
        for(int i = 0 ; i < words.length ; i++) {
            String word = words[i];
            smallestFreq[i] = calculateSmallestCharFreq(word);
        }
        Arrays.sort(smallestFreq);

        int[] ret = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++) {
            String query = queries[i];
            int freq = calculateSmallestCharFreq(query);

            int l = 0;
            int r = smallestFreq.length;
            while(l <= r) {
            	int middle = l + (r-l)/2;
            	if(smallestFreq[middle] <= freq) {
            		l = middle+1;
            	}
            	else {
            		r = middle-1;
            	}
            }
            ret[i] = r;
        }
        return ret;
    }
    
    public int calculateSmallestCharFreq(String word) {
        char[] sorted = word.toCharArray();
        Arrays.sort(sorted);
        
        char c = sorted[0];
        int count = 1;
        for(int i = 1 ; i < sorted.length ; i++) {
            if(sorted[i] == c) {
                count++;
            }
        }
        return count;
    }
}
