import java.util.*;

class Solution {
    static int n;
    // static int[][] matrix;
    static List<Integer>[] graph;
    static int[] distance;
    static int maxValue;
    
    public int solution(int n, int[][] edge) {
        this.n = n;
        graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<edge.length;i++){
            int start = edge[i][0]-1;
            int end = edge[i][1]-1;
            graph[start].add(end);
            graph[end].add(start);
        }
        distance = new int[n];
        Arrays.fill(distance, -1);
        
        maxValue = Integer.MIN_VALUE;
        bfs(0);
        
        int answer=0;
        for(int i=0;i<n;i++){
            if(distance[i]==maxValue){
                answer++;
            }
        }
        return answer;
    }
    
    static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        distance[num]=1;
        
        while(!q.isEmpty()){
            num = q.poll();
            for(int i=0;i<graph[num].size();i++){
                int next = graph[num].get(i);
                if(distance[next]==-1){
                    q.add(next);
                    distance[next] = distance[num]+1;
                    maxValue = Math.max(distance[next], maxValue);
                }
            }
        }
    }
}