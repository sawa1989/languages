import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int friends_length = friends.length;
        HashMap<String, Integer> dict = new HashMap<>();
        
        // 점수저장용
        int[] gift_ranking = new int[friends_length];
        // 그래프 저장용
        int[][] gift_graph = new int[friends_length][friends_length];
        
        for(int i=0;i<friends_length;i++){
            dict.put(friends[i], i);
        }
        
        // 점수저장 및 그래프 만들기
        for( String gift : gifts){
            String[] gift_name_temp = gift.split(" ");
            gift_ranking[dict.get(gift_name_temp[0])]++;
            gift_ranking[dict.get(gift_name_temp[1])]--;
            gift_graph[dict.get(gift_name_temp[0])][dict.get(gift_name_temp[1])]++;
        }
        //점수확인
        // for(int i=0;i<friends_length;i++){
        //     System.out.printf(gift_ranking[i]+" ");
        // }
        
       // 그래프 확인
        // for(int i=0;i<friends_length;i++){
        //     for(int j=0;j<friends_length;j++){
        //         System.out.printf("%d ", gift_graph[i][j]);
        //     }
        //     System.out.println("");
        // }
        
        // 돌면서 확인
        for(int i=0;i<friends_length;i++){
            int temp=0;
            
            for(int j=0;j<friends_length;j++){
                if(i==j){
                    continue;
                }
                
                // 더많이주면 받고
                // 같으면 비교비교, 선물지수 내가 더 높으면 다 가져와
                if(gift_graph[i][j] > gift_graph[j][i] || ( gift_graph[i][j] == gift_graph[j][i] && gift_ranking[i]>gift_ranking[j]))
                    temp++;
            }
            
            if(answer< temp){
                answer=temp;
            }
        }
        
        return answer;
    }
}
