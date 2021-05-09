
public class SquareDiff {
	static int sumOfSquares(int n) {
		int sum = 0;
		for(int i = 1 ; i <= n ; i++) {
			sum += i*i;
		}
		return sum;
	}
	
	static int squareSum(int n) {
		int sum = 0;
		for(int i = 1 ; i <= n ; i++) {
			sum += i;
		}
		return sum*sum;
	}
	
	public static void main(String[] args) {
		int sumOfSquares = sumOfSquares(100);
		int squareSum = squareSum(100);
		
		System.out.println(squareSum - sumOfSquares);
	}

}
