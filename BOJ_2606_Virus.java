import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2606_Virus {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		String str = br.readLine();
		int Computers = Integer.parseInt(str);

		str = br.readLine();
		int edge = Integer.parseInt(str);

		List<Integer>[] line = new ArrayList[Computers + 1];

		for (int i = 0; i <= Computers; i++) {
			line[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < edge; i++) {
			String[] str1 = br.readLine().split(" ");

			int start = Integer.parseInt(str1[0]);
			int end = Integer.parseInt(str1[1]);

			line[start].add(end);
			line[end].add(start);
		}

		for (int i = 0; i <= Computers; i++) {
			Collections.sort(line[i]);
		}

		int[] visited = new int[Computers + 1];

		visited[1] = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);

		while (!q.isEmpty()) {
			int now = q.remove();

			for (int next : line[now]) {
				if (visited[next] == 0) {
					q.add(next);
					visited[next] = 1;
				}
			}
		}
		
		int result = 0;
		for (int i = 2; i <= Computers; i++) {
			if (visited[i] == 1) {
				result++;
			}
		}
		System.out.println(result);
	}

}
