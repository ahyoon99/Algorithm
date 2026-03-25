import java.util.*;

class Solution {
    static int n;
    static int[][] computers;
    static boolean[] visited;
    static int answer;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        answer = 0;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                bfs(i);
            }            
        }
    
        return answer;
    }
    
    static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num]=true;
        
        while(!q.isEmpty()){
            num = q.poll();
            for(int i=0;i<n;i++){
                if(computers[num][i]==1 && visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }
}