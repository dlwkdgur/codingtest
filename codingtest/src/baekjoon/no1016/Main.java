package baekjoon.no1016;//제곱 ㄴㄴ 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(stk.nextToken()), max = Long.parseLong(stk.nextToken());
		int gap = (int)(max - min) + 1;	
		int count = 0;
		boolean[] check = new boolean[gap];//dafault : false
		
		for (long i = 2; i <= (long)Math.sqrt(max) + 1; i++) {
			long square = i * i;
			
			if (min <= square && square <= max) {//제곱수가 범위 내에 있을 때
				if (check[(int)(square-min)]) {//이미 지워진 수(제곱수임)
					continue;
				}
			}
			long start =min/square, end = max/square;
			for (long j = start; j <= end; j++) {
				long num = j*square;
				
				if (min <= num && num <= max) {//범위 내에
					check[(int)(num - min)] = true;//제곱수임
				}
			}
		}
		for (int i = 0; i < gap; i++) {
			if (!check[i]) {//제곱ㄴㄴ수이면 count++;
				count++;
			}
		}
		
		System.out.println(count);
	}
}
