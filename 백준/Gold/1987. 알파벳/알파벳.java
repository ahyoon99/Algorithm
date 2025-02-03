import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[][] matrix;
    static boolean[] alp;
    static int answer;
    static int max;

    static class Node{
        int x;
        int y;

        Node(){}
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
   
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new char[n][m];
        alp = new boolean[26];
        answer=0;
        max=0;
        
        for(int i=0;i<n;i++){
            String com = sc.next();
            for(int j=0;j<m;j++){
                matrix[i][j] = com.charAt(j);
            }
        }

        alp[matrix[0][0]-'A']=true;
        answer++;

        backTracking(0,0);
        System.out.println(max);
    }

    static void backTracking(int x, int y){
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(0<=nx && nx<n && 0<=ny && ny<m){
                if(!alp[matrix[nx][ny]-'A']){
                    alp[matrix[nx][ny]-'A']=true;
                    answer++;
                    backTracking(nx, ny);
                    alp[matrix[nx][ny]-'A']=false;
                    answer--;
                }
            }
        }
        max = Math.max(max, answer);
    }
}
