import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int v;;
    static ArrayList<Integer>[] matrix;
    //static int[][] matrix;
    

    static public void main(String args[]) throws IOException{
        //System.setIn(new FileInputStream("res/input.txt"));
        input();

        // for(int i=0;i<n+1;i++){

        // System.out.println(matrix[i].toString());
        // }

        dfs(v);
        System.out.println();
        bfs(v);
    }

    static void dfs(int v){
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited = new boolean[n+1];

        st.add(v);
        visited[v]=true;
        boolean flag;
        System.out.print(v+" ");

        while(!st.isEmpty()){
            int num = st.peek();
            flag = false;
            ArrayList<Integer> temp = matrix[num];
            for(int i=0;i<temp.size();i++){
                if(!visited[temp.get(i)]){
                    st.push(temp.get(i));
                    visited[temp.get(i)]=true;
                    System.out.print(temp.get(i)+" ");
                    flag=true;
                    break;
                }
            }

            if(!flag){
                st.pop();
            }
        }
    }

    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        q.add(v);
        visited[v]=true;

        while(!q.isEmpty()){
            int num = q.poll();
            System.out.print(num+" ");
            ArrayList<Integer> temp = matrix[num];
            for(int i=0;i<temp.size();i++){
                int next = temp.get(i);
                if(!visited[next]){
                    q.add(next);
                    visited[next]=true;
                }
            }
        }
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
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

        for (int i=0; i<n+1; i++) {
			Collections.sort(matrix[i]);
		}
    }
}
