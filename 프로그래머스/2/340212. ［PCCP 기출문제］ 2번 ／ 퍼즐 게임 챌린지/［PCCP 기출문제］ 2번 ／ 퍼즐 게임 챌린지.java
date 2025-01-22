import java.util.*;

class Solution {
    static int n;
    static int answer;
    public int solution(int[] diffs, int[] times, long limit) {
        answer = Integer.MAX_VALUE;

        n = diffs.length;

        int start=1;
        int end = 100000;
        while(start<=end){
            int mid = (start+end)/2;
            if(calculate(mid, diffs, times, limit)){
                answer = Math.min(answer, mid);
                end = mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return answer;
    }

    static boolean calculate(int level, int[] diffs, int[] times, long limit){
        long total=0;
        for(int i=0;i<n;i++){
            if(diffs[i]<=level){
                total+=times[i];
            }
            else{
                int loop = diffs[i]-level;
                total+=(times[i]+times[i-1])*loop+times[i];
            }
        }
        if(total<=limit){
            answer = level;
            return true;
        }
        return false;
    }
}