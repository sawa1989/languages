import java.util.*;

class Solution {
    
    static private ArrayList<Integer> answer_list = new ArrayList<Integer>();
    static private int[] check = new int[10];
    
    public int solution(String numbers) {
        
        int answer = 0; 
        String tmp ="";
        
        
        for(int i=0;i<numbers.length();i++){
            dfs("", numbers, i+1);
        }
        
        /*
        for(int i : answer_list){
            System.out.println(i);
        }*/
        
        for(int i=0;i<answer_list.size();i++){
            if(check(answer_list.get(i))==true){
                answer++;
            }else{
                
            }
        }
        
        return answer;
    }
    
    private void dfs(String now, String numbers,int size){
        if(now.length()==size){
            int temp_num = Integer.parseInt(now);
            if(answer_list.contains(temp_num)==false){
                answer_list.add(temp_num);
            }
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            if(check[i]==0){
                check[i]=1;
                now+=numbers.charAt(i);
                
                dfs(now, numbers, size);
                
                check[i]=0;
                now= now.substring(0, now.length()-1);
            }
        }
        
        
    }
    
    private boolean check(int num){
        if(num==0) return false;
        if(num==1) return false;
        
        for(int i=2;i<num;i++){
            if(num % i ==0){
                return false;
            }
        }
        
        return true;
       
    }
}
