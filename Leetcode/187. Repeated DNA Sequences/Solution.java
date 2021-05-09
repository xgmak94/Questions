/* https://leetcode.com/problems/repeated-dna-sequences/

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) return new ArrayList<>();
        Set<String> list = new HashSet<>(); //convert to list later, make sure no dupes
        Set<String> set = new HashSet<>(); //hold sequences we have seen
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, 10));
        set.add(s.substring(0, 10));
        
        for(int i = 10 ; i < s.length() ; i++) {
            sb.append(s.charAt(i));
            sb.deleteCharAt(0);
            if(!set.add(sb.toString())) { //if we cannot add it to set it is a dup
                list.add(sb.toString());
            }
        }
        return new ArrayList<>(list);
    }
}