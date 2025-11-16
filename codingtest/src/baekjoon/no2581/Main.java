package baekjoon.no2581;//소수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());
		//min, max의 최댓값이 10,000임 --> 미리 구하는 것이 편할듯
		boolean[] notPrime = sieve(end);
		
		int min = 0, sum = 0;
		
		start = Math.max(start, 2);
		for (int i = start; i <= end; i++) {
			if (!notPrime[i]) {//소수이면
				if (min == 0) min = i;
				sum += i;
			}
		}
		
		if (sum == 0) {
			sb.append(-1);
		} else {
			sb.append(sum).append("\n").append(min);
		}
		
		System.out.print(sb);
	}
	
	static boolean[] sieve(int n) {
		boolean[] notPrime = new boolean[n+1];
		//default =false --> 소수 --> true : 소수 아님
		
		notPrime[0] = true;
		notPrime[1] = true;
		
		for (int i = 2; i*i <= n; i++) {
			if (notPrime[i]) continue;//이미 소수가 아니라고 판별남 그 배수는 당연히 이미 제거됨
			for (int j = i*i; j <= n; j += i) {
				notPrime[j] = true;
			}
		}
		return notPrime;
	}
}
