/*
Find all primes between 0 to n using efficient algorithm of Sieve of Eratosthenes
*/

public static void main(String[] args) {
		int n = 50;
		int[] primes = new int[n+1];
		for(int i=2;i<primes.length;i++) {
			if(primes[i] != -1) {
				int p = i;
				int k = 2;
				for(int j = k*p;j<primes.length;j = (++k)*p) {
					primes[j] = -1;
				}
			}
		}
		for(int i=2;i<primes.length;i++) {
			if(primes[i] != -1) {
				System.out.print(i + " ");
			}
		}
	}
