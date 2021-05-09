/* https://leetcode.com/discuss/interview-question/365872/

*/

public class Solution {
	public static int maxSum(int[] A) {
		Map<Integer,Integer> map = new HashMap<>(); //digitSum, num
        int max = -1;
        
		for(int i = 0 ; i < A.length ; i++) {
			int num = A[i];
			int sum = digitSum(num);
			if(map.containsKey(sum)) {
               	max = Math.max(map.get(sum) + num, max);

               	map.put(sum, Math.max(map.get(sum), num));
            }
            else {
                map.put(sum, num);
            }
		}
        return max;
	}

	public static int digitSum(int n) {
		int sum = 0;
		while(n > 0) {
			sum = sum + (n% 10);
			n = n / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[][] testCases = {{51,71,17,42,33,60,51,32,43},
								{51,71,17,42},
								{42,33,60,},
								{51,32,43}};

		for(int[] test : testCases) {
			System.out.println(maxSum(test));
		}
	}
}
