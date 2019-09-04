
public class main {
	static int NUM_MAX = 1000;
	public static void main(String[] args) {
		System.out.println(mult3and5(NUM_MAX));
	}
	
	static int mult3and5(int n) {
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
