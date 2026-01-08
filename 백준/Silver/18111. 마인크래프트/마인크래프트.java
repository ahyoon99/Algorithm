import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int B;
	static int[][] grounds;
	static int minTime;
	static int maxHeight;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		System.out.println(minTime+" "+maxHeight);
	}
	
	static void solution() {
		for(int height=0;height<=256;height++) {
			int time = 0;
			int inventory = B;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(grounds[i][j]<height) {
						time+=(height-grounds[i][j]);
						inventory-=(height-grounds[i][j]);
					} else if(grounds[i][j]>height) {
						time+=(grounds[i][j]-height)*2;
						inventory+=(grounds[i][j]-height);
					}
				}
			}
			if(inventory<0) {
				continue;
			}
			if(minTime>=time) {
				minTime = time;
				maxHeight = height;
			}
		}
	}

	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		grounds = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				grounds[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minTime = Integer.MAX_VALUE;
		maxHeight = Integer.MIN_VALUE;
	}
}
