import java.util.*;

class Solution {
    
    private static ArrayList<int[]> answer_list = new ArrayList<int[]>();
    
    public int[] solution(int brown, int yellow) {
        
        int area = brown + yellow;
        
        //가능한 모든 방법 
        for(int i=3;i<=area;i++){
            if(area%i ==0){
                answer_list.add(new int[]{area/i, i});
            }
        }
        
        int answer=0;
        //검증
        // 가로 세로
        for(int i=0;i< answer_list.size();i++){
            int[] temp = answer_list.get(i);
            //System.out.println(temp[0] + " " +temp[1]);
            if(temp[0]<temp[1]){
                continue;
            }
            
            int temp_brown = temp[0]*2 + temp[1] * 2 -4;
            int temp_yellow = (temp[0]-2)*(temp[1]-2);
            
            //System.out.println(temp[0]+" " +temp[1]+" " +temp_brown+" " +temp_yellow);
            
            if(temp_brown==brown && temp_yellow==yellow)
                answer=i;
        }
        
        return answer_list.get(answer);
    }
}
