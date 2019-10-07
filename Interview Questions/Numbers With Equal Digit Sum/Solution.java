public class Solution {
    public static int sumDigits(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    
    public static int maxSumDigits(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        
        for(int num : nums) {
            int digitSum = sumDigits(num);
            if(map.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, map.get(digitSum) + num);
                if(num > map.get(digitSum)) {
                    map.put(digitSum, num);
                }
            }
            else {
                map.put(digitSum, num);
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] A = {51,71,17,42};
        int[] B = {42,33,60};
        int[] C = {51,32,43};
        
        int retA = maxSumDigits(A);
        System.out.println(retA);
        
        int retB = maxSumDigits(B);
        System.out.println(retB);
        
        int retC = maxSumDigits(C);
        System.out.println(retC);
    }
}
