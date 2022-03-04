/* https://leetcode.com/problems/occurrences-after-bigram/

Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

For each such occurrence, add "third" to the answer, and return the answer.

Example 1:
Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]

Example 2:
Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]
*/

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();        
        String[] arr = text.split(" ");
        
        for(int i = 2 ; i < arr.length ; i++) {
            if(arr[i-2].equals(first) && 
                arr[i-1].equals(second)) {
                list.add(arr[i]);
            }
        }
        return list.stream().toArray(String[]::new);
    }
}
