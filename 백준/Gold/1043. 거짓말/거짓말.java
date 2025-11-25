import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int l;
	
	static int[] initKnown;
	static boolean[] known;
	
	static int[][] matrix;
	
	static ArrayList<Integer>[] arr;
	
	static int result;
	
	public static void main(String[] args) throws IOException{
		input();
		for(int i=0;i<initKnown.length;i++) {
			bfs(initKnown[i]);
		}
		
		for(int i=0;i<arr.length;i++) {
			ArrayList<Integer> temp = arr[i];
			boolean possible = true;
			for(int j=0;j<temp.size();j++) {
				if(known[temp.get(j)]) {
					possible=false;
					break;
				}
			}
			if(possible) {
				result++;
			}
		}
		
		System.out.println(result);
	}

	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		
		visited[start]=true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i=1;i<n+1;i++) {
				if(matrix[num][i]==1 && visited[i]==false) {
					q.add(i);
					visited[i]=true;
					known[i]=true;
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
		
		matrix = new int[n+1][n+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		
		initKnown = new int[l];
		known = new boolean[n+1];
		for(int i=0;i<l;i++) {
			int idx = Integer.parseInt(st.nextToken());
			initKnown[i]=idx;
			known[idx]=true;
		}
		
		arr = new ArrayList[m];
		for(int i=0;i<m;i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			arr[i] = new ArrayList<>();
			int start  = Integer.parseInt(st.nextToken());
			arr[i].add(start);
			if(cnt>1) {
				for(int j=1;j<cnt;j++) {
					int end = Integer.parseInt(st.nextToken());
					matrix[start][end]=1;
					matrix[end][start]=1;
					arr[i].add(end);
				}
			}
		}
		
		result = 0;
	}

}
