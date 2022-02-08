import java.util.*;
import java.math.*;

class Solution {
    
    static boolean flag=false;
    static int answer=50;
    static int[] visited = new int[50]; 
    public int solution(String begin, String target, String[] words) {
               
        dfs(begin, target, words, 0);
        
        if(answer==50){
            return 0;
        }else{
            return answer;
        }
    }
    
    static private void dfs(String begin, String target, String[] words, int number){
        //빠른 것중에서 느린것은 찾을 필요 없음
        if(answer<=number){
            return;
        }
        
        // 문자열 비교는 equals함수를 사용해야 한다.. 
        // == 을 사용할경우 주소값을 비교하기 때문... 이것때문에 삽질을 얼마나 했는지.. 다 잊어버렸다. 
        if(target.equals(begin)){
            answer=Math.min(answer, number);
            return;
        }
        
        for(int i=0;i<words.length;i++){   
            if(visited[i]==1){
                continue;
            }
            
            if(diff1(begin, words[i])==false){
                continue;
            }
            
            visited[i]=1;
            dfs(words[i], target, words, number+1);
            //풀어주는거 기억하기!!!
            visited[i]=0;
            
        }
        
        return;
    }
    
    static private boolean diff1(String now, String next){
        int temp=0;
        
        for(int i=0;i<now.length();i++){
            if(now.charAt(i) != next.charAt(i)){
                temp++;
            }
            if(temp>=2){
                return false;
            }
        
        }
        //System.out.println(now+" " +next);
        return true;
    }
    
}
