import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] matrix;
	
	static int whiteCnt;
	static int blackCnt;
	
	public static void main(String[] args) throws IOException{
		input();
		
		partition(0,0,n);
		System.out.println(whiteCnt);
		System.out.println(blackCnt);
	}
	
	static void partition(int x, int y, int size) {
		if(isSameColor(x,y,size)) {
			if(matrix[x][y]==0) {
				whiteCnt++;
			}
			else {
				blackCnt++;
			}
			return;
		}
		
		int newSize = size/2;
		partition(x, y, newSize);	// 2사분면 
		partition(x, y+newSize, newSize);	// 1사분면 
		partition(x+newSize, y, newSize);	// 3사분면 
		partition(x+newSize, y+newSize, newSize);	// 4사분면 
	}
	
	static boolean isSameColor(int x, int y, int size) {
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(matrix[i][j]!=matrix[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		whiteCnt = 0;
		blackCnt = 0;
	}

}
