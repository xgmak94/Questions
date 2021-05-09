
public class main {

	public static void main(String[] args) {
		int sum = 1000;
		for(int i = 1 ; i <= sum / 2 ; i++) {
			for(int j = i + 1 ; j <= sum / 2 ; j++) {
				int k = sum - i - j;
				if(i*i + j*j == k*k) {
					System.out.printf("%d, %d, %d = %d\n", i, j, k, i*j*k);
				}
			}
		}
	}
}
