import java.util.*;

class Solution {
    public static ArrayList<String> answer = new ArrayList<String>();
    public static boolean[] visited;
    public static String route="";
    
    //이거 하면서 진짜 많이 배운 것같다. 이런 생각을 맨처음에 못했거든...
    //첫번째 시도, Set을 이용해 공항을 뽑아내서 연결시키면 되지않을까?
    //두번째 시도, 엣지를 전부 정렬한 다음 ICN을 찾아서 가면되지않을까? (엣지가 몇개 까지 들어올줄알고..? 티켓을 다쓰는것은 어떻게 생각하려고..?)
    // 결국 구글링...
    public String[] solution(String[][] tickets) {
        for(int i=0;i<tickets.length;i++){
            String start = tickets[i][0];
            String next = tickets[i][1];
            visited= new boolean[tickets.length];
            
            //정렬없이 먼저 ICN으로만 시작하는 것
            if(start.equals("ICN")==true){
                visited[i]=true;
                route= start+","; //경로를 string 저장
                dfs(next, tickets, 1);
            }
        }
        
        //많은 경로중에서 하나만 뽑아내는 것
        Collections.sort(answer);
        
        return answer.get(0).split(","); //split쓰면 자동으로 배열이됨...!!! 
    }
    public static void dfs(String next, String[][] tickets, int visitedCount){
        route+=(next+",");
        
        if(tickets.length==visitedCount){ //티켓 다쓴지 확인, 공항 개수로 확인하는 것이 아니였음 
            answer.add(route);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(next.equals(tickets[i][0])==true && visited[i]!=true){
                visited[i]=true;
                dfs(tickets[i][1], tickets,visitedCount+1);
                visited[i]=false;
                // false가 된경우 맨뒤에서 공항이름 , (총4자리를 빼야함)
                route=route.substring(0, route.length()-4);
            }
        }
    }
    
}
