import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ_1260_DFSandBFS {

	static int N; // 정점 개수
	static int M; // 간선 개수
	static int V; // 탐색 시작점

	static LinkedList[] line;
	// 정점의 개수 N(1 ≤ N ≤ 1,000)
	static int[] visited = new int[1001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		V = Integer.parseInt(str[2]);

		line = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++) {
			line[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			String[] str1 = br.readLine().split(" ");
			int start = Integer.parseInt(str1[0]);
			int end = Integer.parseInt(str1[1]);
			
			
			line[start].add(end);
			line[end].add(start);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(line[i]);
		}

		// 디버깅용 출력
//		for (int i = 1; i <= N; i++) {
//			for(int j=0;j<line[i].size();j++) {
//				System.out.print(line[i].get(j)+ " ");
//			}
//			System.out.println();
//		}
		
		
		// dfs 수행 결과
		dfs(V);
		
		//초기화 
		for (int i = 0; i < 1001; i++) {
			visited[i] = 0;
		}
		System.out.println();
		// bfs 수행 결과
		bfs(V);

	}

	private static void dfs(int node) {
		visited[node]=1;
		System.out.print(node +" " );
		
		for(int i=0;i<line[node].size();i++) {
			if(visited[(int) line[node].get(i)]==0) {
				dfs((int) line[node].get(i));
			}
			
		}
	}

	private static void bfs(int node) {
		visited[node] = 1;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			int now = queue.remove();
			System.out.print(now +" ");
			
			for(int i=0;i<line[now].size();i++) {
				if(visited[(int) line[now].get(i)]==0) {
					queue.add((int) line[now].get(i));
					visited[(int) line[now].get(i)]=1;
				}
			}
		}
	}
}
