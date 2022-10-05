class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int[][] sur_list = new int[4][2];
        // RT
        // CF
        // JM
        // AN
        
        for(int i=0;i<choices.length;i++){
            if(survey[i].charAt(0)=='R'){
                if(choices[i]==1){
                    sur_list[0][0]+=3;
                }else if(choices[i]==2){
                    sur_list[0][0]+=2;
                }else if(choices[i]==3){
                    sur_list[0][0]+=1;
                }else if(choices[i]==5){
                    sur_list[0][1]+=1;
                }else if(choices[i]==6){
                    sur_list[0][1]+=2;
                }else if(choices[i]==7){
                    sur_list[0][1]+=3;
                }
            }else if(survey[i].charAt(0)=='T'){
                if(choices[i]==1){
                    sur_list[0][1]+=3;
                }else if(choices[i]==2){
                    sur_list[0][1]+=2;
                }else if(choices[i]==3){
                    sur_list[0][1]+=1;
                }else if(choices[i]==5){
                    sur_list[0][0]+=1;
                }else if(choices[i]==6){
                    sur_list[0][0]+=2;
                }else if(choices[i]==7){
                    sur_list[0][0]+=3;
                }
            }else if(survey[i].charAt(0)=='C'){
                if(choices[i]==1){
                    sur_list[1][0]+=3;
                }else if(choices[i]==2){
                    sur_list[1][0]+=2;
                }else if(choices[i]==3){
                    sur_list[1][0]+=1;
                }else if(choices[i]==5){
                    sur_list[1][1]+=1;
                }else if(choices[i]==6){
                    sur_list[1][1]+=2;
                }else if(choices[i]==7){
                    sur_list[1][1]+=3;
                }
            }else if(survey[i].charAt(0)=='F'){
                if(choices[i]==1){
                    sur_list[1][1]+=3;
                }else if(choices[i]==2){
                    sur_list[1][1]+=2;
                }else if(choices[i]==3){
                    sur_list[1][1]+=1;
                }else if(choices[i]==5){
                    sur_list[1][0]+=1;
                }else if(choices[i]==6){
                    sur_list[1][0]+=2;
                }else if(choices[i]==7){
                    sur_list[1][0]+=3;
                }
            }else if(survey[i].charAt(0)=='J'){
                if(choices[i]==1){
                    sur_list[2][0]+=3;
                }else if(choices[i]==2){
                    sur_list[2][0]+=2;
                }else if(choices[i]==3){
                    sur_list[2][0]+=1;
                }else if(choices[i]==5){
                    sur_list[2][1]+=1;
                }else if(choices[i]==6){
                    sur_list[2][1]+=2;
                }else if(choices[i]==7){
                    sur_list[2][1]+=3;
                }
            }else if(survey[i].charAt(0)=='M'){
                if(choices[i]==1){
                    sur_list[2][1]+=3;
                }else if(choices[i]==2){
                    sur_list[2][1]+=2;
                }else if(choices[i]==3){
                    sur_list[2][1]+=1;
                }else if(choices[i]==5){
                    sur_list[2][0]+=1;
                }else if(choices[i]==6){
                    sur_list[2][0]+=2;
                }else if(choices[i]==7){
                    sur_list[2][0]+=3;
                }
            }else if(survey[i].charAt(0)=='A'){
                if(choices[i]==1){
                    sur_list[3][0]+=3;
                }else if(choices[i]==2){
                    sur_list[3][0]+=2;
                }else if(choices[i]==3){
                    sur_list[3][0]+=1;
                }else if(choices[i]==5){
                    sur_list[3][1]+=1;
                }else if(choices[i]==6){
                    sur_list[3][1]+=2;
                }else if(choices[i]==7){
                    sur_list[3][1]+=3;
                }
            }else if(survey[i].charAt(0)=='N'){
                if(choices[i]==1){
                    sur_list[3][1]+=3;
                }else if(choices[i]==2){
                    sur_list[3][1]+=2;
                }else if(choices[i]==3){
                    sur_list[3][1]+=1;
                }else if(choices[i]==5){
                    sur_list[3][0]+=1;
                }else if(choices[i]==6){
                    sur_list[3][0]+=2;
                }else if(choices[i]==7){
                    sur_list[3][0]+=3;
                }
            }
        }
        
       if(sur_list[0][0] >= sur_list[0][1]){
           answer+="R";
       }else{
           answer+="T";
       }
        
        if(sur_list[1][0] >= sur_list[1][1]){
           answer+="C";
       }else{
           answer+="F";
       }
        
        if(sur_list[2][0] >= sur_list[2][1]){
           answer+="J";
       }else{
           answer+="M";
       }
        
        if(sur_list[3][0] >= sur_list[3][1]){
           answer+="A";
       }else{
           answer+="N";
       }
        
        return answer;
    }
}
