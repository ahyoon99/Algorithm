import java.util.*;

class Solution {
    static int n;
    static int[] diffs;
    static int[] times;
    static long limit;
    static int answer;
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        n = diffs.length;
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        
        answer = Integer.MAX_VALUE;
        
        bs(1, 100000);
        
        return answer;
    }
    
    public void bs(int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(calculate(mid)){
                answer = Math.min(answer, mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
    }
    
    
    
    public boolean calculate(int level){
        if(level<1){
            return false;
        }
        
        long totalTime = times[0];
        int prevTime = times[0];
        
        for(int i=1;i<n;i++){
            // 계산 도중, 소요시간이 limit보다 커지면 바로 false 리턴 
            if(totalTime>limit){
                return false;
            }
            int diff = diffs[i];
            int curTime = times[i];
            
            if(diff<=level){
                totalTime += curTime;
            }else if(diff>level){
                int loop = diff-level;
                totalTime+=loop*(prevTime+curTime);
                totalTime+=curTime;
            }
            prevTime = curTime;
        }
        
        if(totalTime>limit){
            return false;
        }
        return true;
    }
}