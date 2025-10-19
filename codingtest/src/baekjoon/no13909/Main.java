package baekjoon.no13909;//창문 닫기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		//1일 때에 모든 창문을 염 
		//소수인 경우 : 자기 차례 한 번만 문이 건듬 --> 문이 닫혀있음
		//소수가 아닌 경우 : 자신의 약수가 건들고 본인이 건듬  - 예)4 - 1, 2, 4(열고 닫고 염)
		/* 
		 * 1 2 3 4 5 6 7 8 9 10 (-> close : 2, 3, 5, 7(소수는 확실히 닫혀 있음)6, 8, 10open : 1, 4, 9
		 * 100 -> open : 1, 4, 9, 16, 25, 36, 49, 64, 81, 100 -> 제곱근일때 open
		 * --> 약수의 개수가 홀수 일때만 open임 -> 약수의 개수가 홀수인 경우는 제곱수일때 말곤 없음 제곱수는 2n개 있음 여기에 1을 더하면 2n+1로 홀수임
		 */
		int count = (int)Math.sqrt(n);
		System.out.println(count);
	}

}
