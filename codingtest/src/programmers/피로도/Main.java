package programmers.피로도;//코파일럿에 도움 받음

public class Main {
	public static void main(String[] args) {
		int k = 80;//현재 피로도, 1~5_000
		/*세로(행) 길이(즉, 던전의 개수)는 1~8임
		 * 가로(열) 길이는 2임
		 * 최소 피로도 >= 소모 피로도
		 * 최소 피로도, 소모 피로도 : 1~1_000
		 * 서로 다른 던전의 [최소 피로도, 소모 피로도]가 같을 수 있음	*/
		int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};//최소 피로도, 소모 피로도
		
		//하루에 한 번씩 탐험 --> 하루에 최대한 많이 탐험하려함 --> 탐험 할 수 있는 최대 탐험 수
		int answer = solution(k, dungeons);
		
		System.out.println(answer);
	}
	
	private static int solution(int k, int[][] dungeons) {
		boolean[] visited = new boolean[dungeons.length];//default : false (방문하지 않음)
		
		return dfs(k, dungeons, visited);
		
	}
	
	private static int dfs(int k, int[][] dungeons, boolean[] visited) {
		int answer = 0;
		
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && k >= dungeons[i][0]) {//방문하지 않음 and 최소 피로도보다 현재 피로도가 높음
				visited[i] = true;
				answer = Math.max(answer, 1 + dfs((k-dungeons[i][1]), dungeons, visited));//던전돌때마다 하나씩 추가함
				visited[i] = false;//백트레킹
			}
		}
		
		return answer;
	}
}
