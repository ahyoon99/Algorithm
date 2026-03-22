import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n-lost.length;
        
        boolean[] isReserve = new boolean[n+1];
        
        for(int i=0;i<reserve.length;i++){
            isReserve[reserve[i]]=true;
        }
        
        ArrayList<Integer> lostStudents = new ArrayList<>();
        for(int i=0;i<lost.length;i++){
            if(isReserve[lost[i]]){
                isReserve[lost[i]]=false;
                answer++;
            }else{
                lostStudents.add(lost[i]);
            }
        }
        
        Collections.sort(lostStudents);
        for(int i=0;i<lostStudents.size();i++){
            int student = lostStudents.get(i);
            if(isValid(student-1, n) && isReserve[student-1]){
                isReserve[student-1]=false;
                answer++;
            } else if(isValid(student+1, n) && isReserve[student+1]){
                isReserve[student+1]=false;
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isValid(int num, int n){
        if(0<num && num<=n){
            return true;
        }
        return false;
    }
}