import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer>[] matrix;
    static int answer;
    static public void main(String args[]) throws IOException{
        //System.setIn(new FileInputStream("res/input.txt"));

        input();

        bfs();

        System.out.println(answer);
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        q.add(1);
        visited[1]=true;

        while(!q.isEmpty()){
            int num = q.poll();
            ArrayList<Integer> temp = matrix[num];
            for(int i=0;i<temp.size();i++){
                int next = temp.get(i);
                if(!visited[next]){
                    q.add(next);
                    visited[next]=true;
                    answer++;
                }
            }
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());

        matrix = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            matrix[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            matrix[start].add(end);
            matrix[end].add(start);
        }

        answer = 0;
    }
}
