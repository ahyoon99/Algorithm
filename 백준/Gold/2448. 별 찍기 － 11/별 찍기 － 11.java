import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] result;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		for(int i=0;i<N;i++) {
			Arrays.fill(result[i], ' ');
		}
		go(0, N-1, N);
		
		
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[i].length;j++) {
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void go(int r, int c, int size) {	// (r,c)는 꼭지점 좌표, size는 전체 삼각형의 길이 
		if(size==3) {
			result[r][c] = '*';
			result[r+1][c-1] = '*'; result[r+1][c+1] = '*';
			for(int i=-2;i<=2;i++) {
				result[r+2][c+i] = '*';
			}
			
			return;
		}
		
		int half = size/2;
		go(r, c, half);				// 위쪽 삼각형 
		go(r+half, c-half, half);	// 왼쪽 아래 삼각형 
		go(r+half, c+half, half);	// 오른쪽 아래 삼각형 
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		result = new char[N][2*N -1];
	}
}
