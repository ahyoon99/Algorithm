import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static int[] boards;
	static int[] moves;
	static int result;
	
	static public void main(String[] args) throws IOException{
		input();
		bfs();
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int[] cnt = new int[100];
		Arrays.fill(cnt, -1);
		
		q.add(0);
		cnt[0]=0;
		while(!q.isEmpty()) {
			int num = q.poll();
			// 도착한 경우 바로 종료 
			if(num==99) {
				System.out.println(cnt[99]);
				return;
			}
			
			for(int i=1;i<=6;i++) {
				int nextNum = num+i;
				
				if(nextNum>99) {
					continue;
				}
				
				if(moves[nextNum] !=0) {
					nextNum = moves[nextNum];
				}
				
				if(cnt[nextNum]==-1) {
					q.add(nextNum);
					cnt[nextNum] = cnt[num]+1;
				}
			}
		}
	}

	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boards = new int[100];
		moves = new int[100];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			moves[start-1] = end-1;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			moves[start-1] = end-1;
		}
		result = Integer.MAX_VALUE;
	}
}
