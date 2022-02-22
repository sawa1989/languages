import java.util.*;
import java.io.*;

public class Main {
  private static StringBuilder sb;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");

    int N = Integer.parseInt(str[0]);
    int M = Integer.parseInt(str[1]);

    sb = new StringBuilder();
    arr = new int[M];

    dfs(0, 0, N, M);

    System.out.println(sb.toString());
  }

  private static void dfs(int step, int next, int N, int M) {
    if (step == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = next; i < N; i++) {

      arr[step] = i + 1;
      dfs(step + 1, i, N, M);

    }
  }

}
