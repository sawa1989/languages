import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_2178_Maze {

	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str1 = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str1.charAt(j) == '1') {
					map[i][j] = 1;
					visited[i][j] = false;
				} else {
					map[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}

		if(N==1 && M==1) {
			System.out.println("1");
			return;
		}

		LinkedList<int[]> list = new LinkedList<int[]>();
		list.push(new int[] { 0, 0, 1 });
		visited[0][0] = true;

		int Answer = Integer.MAX_VALUE;

		while (!list.isEmpty()) {
			int[] temp = list.poll();
			int tempX = temp[0];
			int tempY = temp[1];
			int dis = temp[2];

			for (int d = 0; d < 4; d++) {
				int newX = tempX + dx[d];
				int newY = tempY + dy[d];
				// System.out.println(newX + " " +newY);

				if (newX < 0 || newY < 0 || newX >= M || newY >= N) {
					continue;
				}

				if (visited[newY][newX] == true) {
					continue;
				}

				if (map[newY][newX] == 0) {
					
					continue;
				}

				int newDis = dis + 1;
				if (newY == N - 1 && newX == M - 1) {
					if (Answer > newDis) {
						Answer = newDis;
					}
					break;
				}
				
				visited[newY][newX] = true;
				list.add(new int[] { newX, newY, newDis });
			}
			
		}
		System.out.println(Answer);

	}

}
