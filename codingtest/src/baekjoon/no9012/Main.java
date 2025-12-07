package baekjoon.no9012;//괄호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			int size = input.length();
			
			//오프셋 방식으로 -1에서 시작하여 '('이면 ++, ')'이면 --임
			int top = -1;
			boolean check = false;
			
			for (int j = 0; j < size; j++) {
				char value = input.charAt(j);
				
				if (value == '(') {//안에 넣음
					top++;
				} else {//뺌
					top--;
					if (top < -1) {//'('보다 ')'이 더 많이 나옴 --> VPS가 아님 (이후 불필요)
						sb.append("NO\n");
						check =true;
						break;
					}
				}
			}
			
			if (check) {
				continue;
			}
			
			if(top == -1) {//VPS임
				sb.append("YES\n");
			} else {//VPS가 아님, '(', ')'의 개수가 각각 다르다면은 일단 VPS가 아님
				sb.append("NO\n");
			}
			
		}
		
		System.out.print(sb);
		
	}
}
