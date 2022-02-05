import java.io.*;
import java.util.*;


public class BOJ_1325_ProductiveHacking {

	static int N;
	static int M;

	static List<Integer>[] list;

	static int[] answer = new int[10001];
	static int[] visited = new int[10001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		// 1<=N<=10,000 컴퓨터
		// M <=100,000 관계

		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		
		//LinkedList에서 ArrayList로 변경 
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		answer = new int[N + 1];

		// 단방향
		for (int i = 0; i < M; i++) {
			String[] str1 = br.readLine().split(" ");
			int start = Integer.parseInt(str1[0]);
			int end = Integer.parseInt(str1[1]);

			list[start].add(end);
		}

		// 일단 Collections.sort쓰면 틀리는 시간초과 나는 문제임 ( 문제 잘만들었네... 하아)
		for (int i = 1; i <= N; i++) {
			visited = new int[10001];
			bfs(i);
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, answer[i]);
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			if (max == answer[i]) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString());

	}

	private static void bfs(int node) { 

		Queue<Integer> q = new LinkedList<Integer>();

		q.add(node);
		int[] visited = new int[N + 1];
		visited[node] = 1;

		while (!q.isEmpty()) {
			int now = q.remove();

			for (int next : list[now]) {
				if (visited[next] == 0) {
					q.add(next);
					visited[next] = 1;
					answer[next]++;
				}
			}

		}
	}

}
