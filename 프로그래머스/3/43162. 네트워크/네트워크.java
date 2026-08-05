import java.util.*;

class Solution {
    static int n;
    static int[][] computers;
    static boolean[] area;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        this.n = n;
        
        this.computers = new int[n][n];
        this.area = new boolean[n];
        
        this.computers = computers;
        
        
        for(int i=0;i<n;i++){
            if(area[i]==false){
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        area[x] = true;
        
        while(!q.isEmpty()){
            x = q.poll();
            
            for(int i=0;i<n;i++){
                if(x==i){
                    continue;
                }
                if(computers[x][i]==1 && area[i]==false){
                    q.add(i);
                    area[i]=true;
                }
            }
        }
        
    }
}