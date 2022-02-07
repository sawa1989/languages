class Solution {
    static int result=0;
    static int answer=0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, numbers[0]);
        dfs(numbers, target, 0, numbers[0]*-1);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int turn, int temp){
        if(numbers.length == turn+1){
            if(target==temp){
                answer++;
            }
            return;   
        }
        
        for(int i=0;i<2;i++){
            if(i==0)
                dfs(numbers, target, turn+1, temp+numbers[turn+1]);
            else
                dfs(numbers, target, turn+1, temp-numbers[turn+1]);
        }
        
    }
    
}
