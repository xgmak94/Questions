/* https://leetcode.com/problems/assign-cookies

Assume you are an awesome parent and want to give your children some cookies. 
But, you should give each child at most one cookie. 
Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. 
Your goal is to maximize the number of your content children and output the maximum number.

Note:
You may assume the greed factor is always positive. 
You cannot assign more than one cookie to one child.

Example 1:
Input: [1,2,3], [1,1]
Output: 1

Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.

Example 2:
Input: [1,2], [1,2,3]
Output: 2

Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
*/

//Greedy algorithm
//Sort both arrays, give each children the first cookie that is ATLEAST as big as the greed factor
//# of children we went through is the max # of children that are content

class Solution {
    public int findContentChildren(int[] g, int[] s) { //g = greedfactor, s = cookie size
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = 0;
        int j = 0;
        
        while(i < g.length && j < s.length) {
            if(g[i] <= s[j]) { //current cookie is good for current child
                i++;
                j++;
            }
            else {
                j++; //need a better cookie for current child
            }
        }
        return i; //all children before i are good
    }
}
