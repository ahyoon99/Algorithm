import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[][] matrix;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		
	}
	
	static void solution() {
		int componentCnt=0;
		int[] component = new int[n];
		Arrays.fill(component, -1);
		
		for(int i=0;i<n;i++) {
			if(component[i]==-1) {
				bfs(component, componentCnt, i);
				componentCnt++;
			}
		}
		System.out.println(componentCnt);
	}
	
	static void bfs(int[] component, int componentCnt, int num) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(num);
		component[num]=componentCnt;
		
		while(!q.isEmpty()) {
			num = q.poll();
			
			for(int i=0;i<n;i++) {
				if(matrix[num][i]==1 && component[i]==-1) {
					q.add(i);
					component[i]=componentCnt;
				}
			}
		}
		
		
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][n];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			matrix[start][end]=1;
			matrix[end][start]=1;
		}
	}

}
