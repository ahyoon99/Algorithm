import java.util.*;
import java.io.*;

public class Main {
    static int m;
    static int n;
    static int h;
    static int[][][] matrix;
    static Queue<Node> q = new ArrayDeque<>();
    static int day = 0;
    static int unripenTomato;
    static boolean[][][] visited;

    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};

    static class Node{
        int x;
        int y;
        int z;

        Node(int x, int y, int z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }

    public static void main(String[] args) throws IOException{
    	input();
    	
        if(unripenTomato==0) {
            System.out.println(0);
            return;
        }

        go();
        
        for(int i=0;i<h;i++) {
            for(int j=0;j<n;j++) {
                for(int k=0;k<m;k++) {
                    if(matrix[j][k][i]==0 || matrix[j][k][i]==1) {
                    	if(!visited[j][k][i]) {
                    		System.out.println(-1);
                    		return;
                    	}
                    }
                }
            }
        }
        
        System.out.println(day-1);
        return;
    }

    static void go() {
        while(!q.isEmpty()) {
            int size= q.size();
            day++;
            
            while(--size>=0) {
                Node node = q.poll();
                int x = node.x;
                int y = node.y;
                int z = node.z;
                for(int i=0;i<6;i++) {
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    int nz = z+dz[i];
                    if(isValid(nx, ny, nz) && matrix[nx][ny][nz]==0 && visited[nx][ny][nz]==false) {
                    	q.add(new Node(nx, ny, nz));
                    	visited[nx][ny][nz]=true;
                    }
                }
            }
        }

    }
    
    static boolean isValid(int x, int y, int z) {
    	if(0<=x && x<n && 0<=y && y<m && 0<=z && z<h) {
    		return true;
    	}
    	return false;
    }
    
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        matrix = new int[n][m][h];
        visited = new boolean[n][m][h];
        for(int i=0;i<h;i++) {
            for(int j=0;j<n;j++) {
            	st = new StringTokenizer(br.readLine(), " ");
                for(int k=0;k<m;k++) {
                    matrix[j][k][i] = Integer.parseInt(st.nextToken());
                    if(matrix[j][k][i]==1) {
                        q.add(new Node(j,k,i));
                        visited[j][k][i]=true;
                    }
                    else if(matrix[j][k][i]==0) {
                    	unripenTomato++;
                    }
                }
            }
        }
    }

}