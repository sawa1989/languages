class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int final_attack = attacks.length;
        int max_time = attacks[final_attack-1][0];

        
        int[] attack =new int[max_time+1];
        for(int i=0;i<attacks.length;i++){
            attack[attacks[i][0]]=attacks[i][1];
        }
        
        int casting_time = bandage[0];
        int healing = bandage[1];
        int plus_bandage = bandage[2];
        
        int now_health = health;
        int max_health = health;
        
        int success_flag=0;
        for( int time=1; time<= max_time; time++){ //공격시간은 1000이하, 시간 만족
            if(attack[time]!=0){ // 공격이 있다면
                if( now_health - attack[time] <= 0 ){ // die
                    answer = -1;
                    now_health-=attack[time];
                    System.out.printf("%d ", now_health);
                    return answer;
                }else {
                    now_health-=attack[time];
                    success_flag=0;
                }
            }else { //공격이 없다면 
                success_flag++;
                
                now_health+=healing;
                
                if(success_flag ==casting_time){ //추가 회복
                    now_health+=plus_bandage;
                    success_flag=0; // 이거때문에 한참걸렸네..^^;;
                }
                
                if(now_health >= max_health){ //max 체력 조정
                    now_health=max_health;
                }
                
            }
            System.out.printf("%d ", now_health);
        }
        System.out.printf("%d ", now_health);
        answer=now_health;
        return answer;
    }
}
