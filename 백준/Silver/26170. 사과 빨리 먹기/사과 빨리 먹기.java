import java.util.*;
import java.io.*;

public class Main {
    static int[][] matrix;
    static Node student;

    static int result;
    
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

    static public void main(String args[]) throws IOException{
        // System.setIn(new FileInputStream("res/input.txt"));

        input();
        solution();
    }
    
    static void solution(){
        matrix[student.x][student.y]=-1;
        go(student.x, student.y, 0, 0);

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }

    }

    static void go(int x, int y, int cnt, int distance){
        if(cnt==3){
            result = Math.min(result, distance);
            return;
        }
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isValid(nx, ny) && matrix[nx][ny]!=-1){
                if(matrix[nx][ny]==1){
                    matrix[nx][ny]=-1;
                    go(nx, ny, cnt+1, distance+1);
                    matrix[nx][ny]=1;
                }
                else if(matrix[nx][ny]==0){
                    matrix[nx][ny]=-1;
                    go(nx, ny, cnt, distance+1);
                    matrix[nx][ny]=0;
                }
            }
        }
    }

    static boolean isValid(int x, int y){
        if(0<= x && x<5 && 0<=y && y<5){
            return true;
        }
        return false;
    }

    static void input() throws IOException{

        matrix = new int[5][5];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<5;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        student = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));        
        
        result = Integer.MAX_VALUE;
    }
}

