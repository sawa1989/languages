import java.util.*;
import java.io.*;

class Main {

  private static int[] arr;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    sb = new StringBuilder();

    String[] str = br.readLine().split(" ");

    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    arr = new int[M];

    dfs(0, N, M);

    System.out.println(sb.toString());
  }

  private static void dfs(int step, int N, int M) {
    if (step == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      arr[step] = i + 1;
      dfs(step + 1, N, M);
    }

    return;
  }

}