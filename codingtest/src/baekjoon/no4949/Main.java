package baekjoon.no4949;//균형잡힌 세상

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String input = br.readLine();
			if (input == null) break;//EOF 안정 처리 --> 필수는 아니고 권장임
			if (input.equals(".")) break;//종료 조건
			
			int size = input.length();
			
			char[] stack = new char[size];
			int top = -1;
			boolean check = true;
			for (int i = 0; i < size; i++) {
				char value = input.charAt(i);
				if (value == '(' || value == '[') {//열린괄호 --> 스택에 넣음
					stack[++top] = value;
				} else if(value == ')' || value == ']') {
					//닫힌 괄호 --> 스택이 비어있으면 균형이 안 잡힘
					if (top == -1) {
						check = false;
						break;
					} else {
						//세트가 맞으면 top--, 아니면 균형 X
						if ((value == ')' && stack[top] == '(') || (stack[top] == '[' && value == ']')) top--;
						else {
							check = false;
							break;
						}
					}
				}
			}
			//반복문이 끝난 후 스택이 비어있으면 균형이 잡힘, 비어있지 않으면 균형이 안 잡힘
			sb.append((check && top == -1) ? "yes" : "no").append("\n");
		}
		
		System.out.print(sb);
	}
}
