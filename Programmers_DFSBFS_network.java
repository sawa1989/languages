import java.util.*;

class Solution {
    
    static int[] visited;
    static int networks = 0;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new int[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                bfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void bfs(int node, int n, int[][] computers){
        Queue<Integer> q = new LinkedList<Integer>();
        visited[node]=1;
        q.add(node);
        
        while(!q.isEmpty()){
            int now = q.remove();
            
            for(int i=0;i<n;i++){
                //같은거
                if(now==i){
                    continue;
                }
                //이미 간거
                if(visited[i]==1){
                    continue;
                }
                //이제 갈수있는거
                if(computers[now][i]==1 ){
                    q.add(i);
                    visited[i]=1;
                }
            }
        }  
    }
}
