package baekjoon.no1929;//소수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int start = Integer.parseInt(stk.nextToken()), end = Integer.parseInt(stk.nextToken());
		int gap = end - start + 1;
		boolean[] check = new boolean[gap];//default : false; -> false인 경우 소수라고 함
		
		if (start == 1) {
			check[0] = true;
		}
		for (int i = 2; i * i <= end; i++) {
			if (start <= i && i <= end) {//i가 범위 내이면
				if (check[(int)(i - start)]) {//true 인 경우는 소수가 아니라고 판별남
					continue;
				}
			}
			for (int j = (int)(start/i); j <= end/i + 1; j++) { //Math.sqrt(end)까지 비교
				if (j == 1) continue;
				int num = i * j;
				if (start <= num && num <= end) {
					check[(int)(num - start)] = true;
				}
			}
		}
		
		for (int i = 0; i < gap; i++) {
			if (!check[i]) {
				sb.append(i+start).append("\n");
			}
		}
		
		System.out.print(sb);
	}
}
