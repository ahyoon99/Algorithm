import java.util.*;

class Solution {
    static int n;
    static int m;
    
    static int[][] maps;
    static int[][] distance;
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        this.maps = maps;        
        
        bfs(0, 0);
        answer = distance[n-1][m-1];        
        
        return answer;
    }
    
    public void bfs(int x, int y){
        distance = new int[n][m];
        
        for(int i=0;i<n;i++){
            Arrays.fill(distance[i], -1);
        }
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(x, y));
        distance[x][y]=1;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            x = node.x;
            y = node.y;
            
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(!isValid(nx, ny)){
                    continue;
                }
                if(maps[nx][ny]==1 && distance[nx][ny]==-1){
                    distance[nx][ny]=distance[x][y]+1;
                    q.add(new Node(nx, ny));
                }
            }
        }
    }
    
    boolean isValid(int x, int y){
        if(0<=x && x<n && 0<=y && y<m){
            return true;
        }
        return false;
    }
}