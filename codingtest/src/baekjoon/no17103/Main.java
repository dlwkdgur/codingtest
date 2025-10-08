package baekjoon.no17103;//골드바흐 파티션

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int max = 1_000_000;
		int start = 3;
		boolean[] prime = prime(max);
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());//num은 2 초과이고 짝수이기 때문에 소수일 가능성 없음
			if (num == 4) {//4일 경우에만 유일하게 2가 쓰이고 나머지 경우에는 2가 쓸모가 없음
				sb.append(1).append("\n");
				continue;
			}
			int count = 0;
			for (int j = num-1; j >= start; j--) {//num이 소수가 아니기 때문에 -1로 시작함
				// 큰 수 부터 하는 것이 간격이 더 커서 더 빠를것이라 생각함 --> 대칭 조건에 빠르게 도달함
				if (!prime[j]) {//소수인 경우에만 생각함
					int check = num - j;
					if (check > j) {//이렇게 하면은 반복되는 경우가 생기기 떄문에 그냥 브레이크함, 대칭조건임
						break;
					} else if(!prime[check]) {//다른 수가 소수이면
						count++;
					}
					
				}
			}
			sb.append(count).append("\n");
		}
		
		System.out.print(sb);
		
		
	}
	private static boolean[] prime(int max) {
		boolean[] check = new boolean[max + 1];
		//전체가 백만으로 한번에 미리 구해놓는 것이 좋아보임
		//default : false --> 소수이면 false임
		check[0] = true;
		check[1] = true;
		for (int i = 2; i*i <= max; i++) {
			for (int j = i * i; j <= max; j += i) {
				check[j] = true;
			}
		}
		
		return check;
	}
}
/* 6 , 6보다 작은 소수 : 2, 3, 5
 * 6 = 3 + 3
 */
//현재 문제를 맨 처음에 소수만 따로 모아서 판별해야지 라는 생각으로 리스트를 사용해서 시간초과가 나옴
//contains가 리스트에서 O(N)이라 입력이 많아지면 느려짐 --> 시간초과 발생