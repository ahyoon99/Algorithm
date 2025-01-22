import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2)->{return o1[1]-o2[1];});
        
        int position=0;
        for(int i=0;i<targets.length;i++){
            if(position<=targets[i][0]){
                position = targets[i][1];
                answer++;
            }
        }
        
        
        return answer;
    }
}