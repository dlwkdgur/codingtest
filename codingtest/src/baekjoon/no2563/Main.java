package baekjoon.no2563;//색종이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int n = Integer.parseInt(br.readLine());
		int size = 100;
		int area = 0;
		boolean[][] check = new boolean[size][size];//가로, 세로가 0 ~ 99임
		//default = false --> false인 경우는 붙이지 않음, true인 경우 붙인 경우임
		int addSize = 10;
		
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(stk.nextToken());
			int col = Integer.parseInt(stk.nextToken());
			
			for (int x = row; x < row + addSize; x++) {
				for (int y = col; y < col + addSize; y++) {
					if (!check[x][y]) {//false인 경우 붙어지지 않았는데 붙여야 할 경우
						area++;
						check[x][y] = true;
					}
				}
			}
		}
		
		System.out.println(area);
	}
}
