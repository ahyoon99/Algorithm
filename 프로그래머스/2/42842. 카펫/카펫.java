import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[][] dp = new int[2000][2000];
        int[] answer = new int[2];
        
        for(int i=3;i<dp.length;i++){
            for(int j=3;j<dp.length;j++){
                int brownCnt = j*2+(i-2)*2;
                int yellowCnt = i*j-brownCnt;
                if(brownCnt==brown && yellowCnt==yellow){
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }
}