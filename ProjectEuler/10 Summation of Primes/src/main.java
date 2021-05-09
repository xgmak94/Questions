
public class main {
	public static void main(String [] args) {
		long max = 2000000;
		long sum = 0;
		for(int i = 2 ; i < max ; i++) {
			if(isPrime(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	static boolean isPrime(int n)  {
		for(int i = 2 ; i <= Math.sqrt(n) ; i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}
}
