import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int v;
	
	static int[][] matrix;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		input();
		
		boolean[] visited = new boolean[n];
		dfs(v-1, visited);
		
		sb.append("\n");
		
		bfs();
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int num, boolean[] visited) {
		if(visited[num]) {
			return;
		}
		sb.append((num+1)+" ");
		visited[num]=true;
		
		for(int i=0;i<n;i++) {
			if(matrix[num][i]==1 && visited[i]==false) {
				dfs(i, visited);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		
		visited[v-1]=true;
		q.add(v-1);
		sb.append((v)+" ");
		
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i=0;i<n;i++) {
				if(matrix[num][i]==1 && visited[i]==false) {
					q.add(i);
					visited[i]=true;
					sb.append((i+1)+" ");
				}
			}
		}
		
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
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
