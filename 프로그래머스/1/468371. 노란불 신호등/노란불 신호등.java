import java.util.*;

class Solution {
    static int n;
    
    public int solution(int[][] signals) {
        
        n = signals.length;
        List<Integer>[] arr = new List[n];
        
        // [2, 1, 2] -> [0, 0, 1, 2, 2] 로 만들기 
        for(int i=0;i<signals.length;i++){
            arr[i] = new ArrayList<Integer>();
            for(int j=0;j<3;j++){   // G:0, Y:1, R:2
                int times = signals[i][j];
                for(int k=0;k<times;k++){
                    arr[i].add(j);
                }
            }
        }
        
        // 배열에 넣었기 때문에 0초부터 시작
        // 0초 ~ 10^8초까지 돌면서 모든 신호등이 Y(1)인지 체크
        for(int i=0;i<100000000;i++){
            boolean isYellow = true;
            for(int j=0;j<arr.length;j++){
                List<Integer> list = arr[j];
                if(list.get(i%list.size())!=1){
                    isYellow = false;
                    break;
                }
            }
            if(isYellow){
                return i+1;
            }
        }
        
        return -1;
    }
}