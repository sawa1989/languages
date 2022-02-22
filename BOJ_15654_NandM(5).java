import java.util.*;
import java.io.*;

class Main {

  private static int[] pool;
  private static int[] arr;
  private static StringBuilder sb;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");

    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    arr = new int[M];
    pool = new int[N];
    sb = new StringBuilder();
    visited = new boolean[N];

    String[] str1 = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      pool[i] = Integer.parseInt(str1[i]);
    }

    Arrays.sort(pool);

    dfs(0, N, M);
    System.out.println(sb.toString());
  }

  private static void dfs(int step, int N, int M) {
    if (step == M) {
      for (int i = 0; i < M; i++) {
        sb.append(pool[arr[i]] + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i] == false) {
        visited[i] = true;

        arr[step] = i;
        dfs(step + 1, N, M);

        visited[i] = false;
      }
    }
  }

}