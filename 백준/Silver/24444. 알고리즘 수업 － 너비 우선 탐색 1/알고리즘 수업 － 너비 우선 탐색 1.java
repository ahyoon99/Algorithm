import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int r;
    static ArrayList<ArrayList<Integer>> matrix;
    static int[] order;
    static int cnt;

    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        matrix = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            matrix.add(new ArrayList<Integer>());
        }

        order = new int[n+1];
        Arrays.fill(order, 0);

        cnt=1;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            matrix.get(num1).add(num2);
            matrix.get(num2).add(num1);
        }

        for(int i=1;i<=n;i++){
            ArrayList<Integer> temp = matrix.get(i);
            Collections.sort(temp);
            matrix.set(i, temp);
        }

        bfs();

        for(int i=1;i<=n;i++){
            System.out.println(order[i]);
        }

    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        order[r]=cnt;
        cnt++;

        while(!q.isEmpty()){
            int num = q.poll();
            ArrayList<Integer> temp = matrix.get(num);
            for(int i=0;i<temp.size();i++){
                if(order[temp.get(i)]==0){
                    q.add(temp.get(i));
                    order[temp.get(i)] = cnt;
                    cnt++;
                }
            }
        }

    }
}
