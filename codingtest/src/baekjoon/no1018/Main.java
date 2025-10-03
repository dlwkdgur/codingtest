package baekjoon.no1018;//체스판 다시 칠하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int row = Integer.parseInt(stk.nextToken()), col = Integer.parseInt(stk.nextToken());//행, 열
		final int totalCount = 8*8;
		char[] BW = {'B', 'W'};
		int min = totalCount;
		
		int[][] check = new int[row][col];//체스판을 B 이면 true, W이면 false로 설정
		
		for (int i = 0; i < row; i++) {
			String input = br.readLine();
			for (int j = 0; j < col; j++) {
				check[i][j] = (input.charAt(j)  == BW[(i + j)%2]) ? 1 : 0;//bwbwbw / wbwbwb순으로 했을떄 맞으면 1 아니면 0임
			}
		}
		
		check = accumulateSum(check, row, col);//누적합을 구함
		
		for (int i = 7; i < row; i++) {//8*8범위내에서의 틀린 갯수를 구함, 그리고 틀린갯수와 맞은 개수, 이미 최소라고 생각한 갯수 중에서의 최소값을 정함
			for (int j = 7; j < col; j++) {
				int count = 0;
				if (i == 7 && j == 7) {
					count = check[i][j];
				} else if (i == 7) {
					count = check[i][j] - check[i][j-8];
				} else if(j == 7) {
					count = check[i][j] - check[i-8][j];
				} else {
					count = check[i][j] - check[i-8][j] - check[i][j-8] + check[i-8][j-8];
				}
				min = Math.min(min, Math.min(count, totalCount - count));
			}
		}
		
		System.out.println(min);
		
	}
	
	private static int[][] accumulateSum(int[][] check, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0) { //맨처음임
					continue;
				} else if(i == 0) {//맨 첫행임
					check[i][j] += check[i][j-1];
				} else if(j == 0) {//맨 첫열임
					check[i][j] += check[i-1][j];
				} else {
					check[i][j] += check[i-1][j] + check[i][j-1] - check[i-1][j-1];
				}
			}
		}
		
		return check;
	}
}
/*
 * 1 0 1 0		1 1 2 2
 * 0 0 1 0 -->1 1 3 3
 * 0 1 0 1		1 2 4 5
 * 0 0 0 0		1 2 4 5
 * */