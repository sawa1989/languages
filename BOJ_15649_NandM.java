import java.util.*;
import java.io.*;

public class Main {

  private static boolean[] visited;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");

    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    visited = new boolean[N];
    arr = new int[M];

    dfs(0, N, M);

  }

  private static void dfs(int step, int N, int M) {
    if (step == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println("");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (visited[i] == false) {
        visited[i] = true;

        arr[step] = i + 1;
        dfs(step + 1, N, M);

        visited[i] = false;
      }
    }

    return;
  }
}