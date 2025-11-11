package baekjoon.no28278;//스택2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] stack = new int[n];
		int top = -1;
		
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			switch(stk.nextToken()) {
			case "1":
				stack[++top] = Integer.parseInt(stk.nextToken());
				break;
			case "2":
				int value = (top == -1) ? -1 : stack[top--];
				sb.append(value).append("\n");
				break;
			case "3":
				sb.append(top+1).append("\n");
				break;
			case "4":
				int check = (top == -1) ? 1 : 0;
				sb.append(check).append("\n");
				break;
			case "5":
				value = (top == -1) ? -1 : stack[top];
				sb.append(value).append("\n");
				break;
			}
		}
		System.out.print(sb.toString());
		
	}
}