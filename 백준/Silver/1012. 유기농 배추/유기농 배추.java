import java.util.*;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    // 방법 1 : DFS(재귀)
    static boolean dfs(boolean[][] land, boolean[][] check, int x, int y, int n, int m){
        if(check[x][y]==true){
            return false;
        }
        else if(land[x][y]==false){
            return false;
        }else{
            check[x][y]=true;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(0<=nx && nx < n && 0<=ny && ny<m && check[nx][ny]==false && land[nx][ny]==true){
                    dfs(land, check, nx, ny, n, m);
                }
            }
            return true;
        }
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0;tc<t;tc++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int cnt=0;
            boolean[][] land = new boolean[n][m];
            boolean[][] check = new boolean[n][m];  // 방문여부 확인
            for(int i=0;i<k;i++){
                int y = sc.nextInt();
                int x = sc.nextInt();
                land[x][y]=true;
            }

            // for(int i=0;i<n;i++){
            //     System.out.println(Arrays.toString(land[i]));
            // }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(dfs(land, check, i,j,n,m)){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
