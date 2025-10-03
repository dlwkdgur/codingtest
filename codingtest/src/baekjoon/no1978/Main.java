package baekjoon.no1978;//소수 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int count = 0;
		int n = Integer.parseInt(br.readLine());
		boolean[] prime = prime(1001);//총 크기가 작기때문에 전체의 소수를 미리 판변해놓음 (false : 소수)
		
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(stk.nextToken());
			if (!prime[num]) count++;
		}
		
		System.out.println(count);
	}
	
	private static boolean[] prime(int end) {
		boolean[] prime = new boolean[end+1];//default : false
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i *i <= end; i++) {
			for (int j = i*i; j <= end; j += i) {
				prime[j] = true;
			}	
		}
		return prime;
	}
}
