import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] info;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		for(int i=1;i<=n;i++) {
			boolean[] visited = new boolean[n+1];
			visited[i]=true;
			dfs(i, visited, i);
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
		
	}
	
	static boolean dfs(int n, boolean[] visited, int start) {
		int next = info[n];
		
		if(visited[next]) {
			if(next == start) {
				result.add(n);
				return true;
			}
		}
		else {
			visited[next]=true;
			dfs(next, visited, start);
			visited[next]=false;
		}
		return false;
	}
	
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
	
		info = new int[n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i]=Integer.parseInt(st.nextToken());
		}
		
		result = new ArrayList<>();
		
	}

}
