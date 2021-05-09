
public class main {
	static int max_limit = 4000000;
	public static void main(String[] args) {
		System.out.println(fibonacci(max_limit));
	}

	static int fibonacci(int limit) {
		int sum = 0;
		int odd = 0, even = 1;
		while(odd < limit && even < limit) {
			odd = odd + even;
			even = even + odd;
			if(odd % 2 == 0) {
				sum += odd;
			}
			if(even % 2 == 0) {
				sum += even;
			}
		}
		return sum;
	}
}
