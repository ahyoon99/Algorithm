import java.util.*;
import java.io.*;

public class Main {
	static int h;
	static int w;
	static int[] height;
	static int[][] world;
	
	static int answer;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		System.out.println(answer);
	}
	
	static void solution() {
		
		for(int i=0;i<w;i++) {
			for(int j=0;j<height[i];j++) {
				world[j][i]=1;
			}
		}
		
		for(int i=0;i<h;i++) {
			int cnt = 0;
			boolean flag = false;
			for(int j=0;j<w;j++) {
				if(world[i][j]==1) {
					flag=true;
					answer+=cnt;
					cnt=0;
				}
				else if(world[i][j]==0 && flag==true) {
					cnt++;
				}
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		height = new int[w];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<w;i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		world = new int[h][w];
		answer = 0;
		
	}

}
