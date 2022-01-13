import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_7569_tomato {

	static int M;
	static int N;
	static int H;
	static int result = 0;

	// 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	static int[][][] tomato;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		H = Integer.parseInt(str[2]);

		tomato = new int[H][N][M];
		visited = new boolean[H][N][M];

		LinkedList<int[]> list = new LinkedList<>();

		for (int x = 0; x < H; x++) {
			for (int y = 0; y < N; y++) {
				String[] str1 = br.readLine().split(" ");
				for (int z = 0; z < M; z++) {
					tomato[x][y][z] = Integer.parseInt(str1[z]);
					if (tomato[x][y][z] == 1) {
						list.push(new int[] { z, y, x});
						visited[x][y][z] = true;
					}
				}
			}
		}
		
//		for (int x = 0; x < H; x++) {
//			for (int y = 0; y < N; y++) {
//				for (int z = 0; z < M; z++) {
//						System.out.print(tomato[x][y][z]+" ");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
//		}

		while (!list.isEmpty()) {
			int[] temp = list.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			int temp_h = temp[2];

			for (int d = 0; d < 6; d++) {
				int newX = temp_x + dx[d];
				int newY = temp_y + dy[d];
				int newH = temp_h + dh[d];

				// 범위밖
				if (newX < 0 || newY < 0 || newX >= M || newY >= N || newH < 0 || newH >= H) {
					continue;
				}
				if (visited[newH][newY][newX] == true) {
					continue;
				}

				if (tomato[newH][newY][newX] == -1) {
					continue;
				}

				visited[newH][newY][newX] = true;
				tomato[newH][newY][newX] = tomato[temp_h][temp_y][temp_x] + 1;
				list.add(new int[] { newX, newY, newH });
			}

		}

		for (int i = 0; i < H; i++) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (tomato[i][y][x] == 0) {
						System.out.println("-1");
						return;
					}
					result = Math.max(result, tomato[i][y][x]);
				}
			}
		}
		System.out.println(result - 1);

	}

}
