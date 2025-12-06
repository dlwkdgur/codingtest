package baekjoon.no10773;//제로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		int[] num = new int[k];
		int sum = 0, top = -1;
		
		for (int i = 0; i < k; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (input == 0) {//가장 최근에 쓴 수를 지움
				top--;
			} else {//해당 수를 씀
				num[++top] = input;
			}
		}
		
		for (int i = 0; i <= top; i++) {
			sum += num[i];
		}
		
		System.out.println(sum);
	
	}
}
