import java.io.*;
import java.util.*;

public class Main {
	static int r;
	static int c;
	static char[][] matrix;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static boolean[] isAlp;   // 지나온 알파벳을 체크하기 위한 배열
	static int result;
	
	static class Node{
		int x;
		int y;
		
		Node(){}
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		solution();
	}
	
	static void solution() {		
	    go(0,0,1);  // (0,0) 부터 시작, 현재 방문 개수 1번 
		System.out.println(result);
	}
	
	static void go(int x, int y, int count) {
        isAlp[matrix[x][y]-'A'] = true;
        result = Math.max(result, count);

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(isValid(nx, ny)){
                if(isAlp[matrix[nx][ny]-'A'] == false){
                    go(nx, ny, count+1);
                    isAlp[matrix[nx][ny]-'A'] = false;
                }
            }
        }
	}
	
	static boolean isValid(int x, int y) {    // 배열 범위 체크
		if(0<=x && x<r && 0<=y && y<c) {
			return true;
		}
		return false;
	}
	
	static void input(BufferedReader br) throws IOException{
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		matrix = new char[r][c];
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();
			for(int j=0;j<c;j++) {
				matrix[i][j]=com.charAt(j);
			}
		}
		
		isAlp = new boolean[26];
		result = 0;
	}
}