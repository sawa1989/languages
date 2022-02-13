import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        int[] answer1 = new int[answers.length];
        int[] answer2 = new int[answers.length];
        int[] answer3 = new int[answers.length];
        
        int temp1=1;
        int temp2=1;
        int temp3=1;
        for(int i=0;i<answers.length;i++){
            //1번
            if(temp1==6){
                temp1=1;
            }
            answer1[i] = temp1;
            temp1++;
            
            //2번
            if(i%2==0){
                answer2[i]=2;
            }else{
                if(temp2==6){
                    temp2=1;
                }else if(temp2==2){
                    temp2=3;
                }
                answer2[i]=temp2;
                temp2++;      
            }
            //3번
            if(temp3==11){
                temp3=1;
            }
            if(temp3==1 || temp3==2){
                answer3[i]=3;
            }else if(temp3==3 || temp3==4){
                answer3[i]=1;
            }else if(temp3==5 || temp3==6){
                answer3[i]=2;
            }else if(temp3==7||temp3==8){
                answer3[i]=4;
            }else if(temp3==9 || temp3==10){
                answer3[i]=5;
            }
            temp3++;
            
            //결과내기
            if(answers[i]==answer1[i]){
                answer[0]++;
            }
            if(answers[i]==answer2[i]){
                answer[1]++;
            }
            if(answers[i]==answer3[i]){
                answer[2]++;
            }
        }
        LinkedList<int[]> list = new LinkedList<int[]>();
        list.add(new int[]{1, answer[0]});
        list.add(new int[]{2, answer[1]});
        list.add(new int[]{3, answer[2]});
        Collections.sort(list, new Comparator<int[]>(){
                        @Override
                        public int compare(int[] s1, int[] s2 ){
                            if(s1[1] > s2[1]){
                                return -1;
                            }else if(s1[1]==s2[1]){
                                if(s1[0] < s2[0]){
                                    return -1;
                                }else{
                                    return 1;
                                }
                            }else{
                                return 1;
                            }
                        }    
            });
        
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)[0]+" " +list.get(i)[1]);
        }
        
        int max = list.get(0)[1];
        int size =1;
        for(int i=1;i<3;i++){
            if(max == list.get(i)[1]){
                size++;
               //System.out.println(size+" " +list.get(i)[1]);
            }
        }
        int[] realanswer = new int[size];
        for(int i=0;i<size;i++){
            realanswer[i]=list.get(i)[0];
        }
        return realanswer;
    }
}
