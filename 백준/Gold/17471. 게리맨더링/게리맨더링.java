import java.util.*;
import java.io.*;

public class Main {
	static int n;
	
	static int[] order;
	
	static ArrayList<Integer>[] info;
	static int[] population;
	static int result = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws IOException{
		input();
		subset(0, 0);
		if(result==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(result);
		}
	}
	
	static void subset(int depth, int total) {
		if(depth >= n) {
			boolean isPossible =  false;
			if(total!=0 && total!=n) {
				for(int i=0;i<n;i++) {
					if(order[i]==0) {
						isPossible = bfs(i);
						break;
					}
				}
				
				if(!isPossible) {
					return;
				}
				
				for(int i=0;i<n;i++) {
					if(order[i]==1) {
						isPossible = bfs(i);
						break;
					}
				}
				
				if(!isPossible) {
					return;
				}
				
				int pop1 = 0;
				int pop2 = 0;
				for(int i=0;i<n;i++) {
					if(order[i]==0) {
						pop1+=population[i];
					}
					else if(order[i]==1) {
						pop2+=population[i];
					}
				}
				
				result = Math.min(result, Math.abs(pop1-pop2));
			}
			return;
		}
		order[depth] = 0;
		subset(depth+1, total);
		order[depth]=1;
		subset(depth+1, total+1);
	}
	
	static boolean bfs(int start) {
		// 특정 도시(start)와 연결된 도시 탐색하기 
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n];
		visited[start]=true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			ArrayList<Integer> temp = info[num];
			for(int i=0;i<temp.size();i++) {
				if(visited[temp.get(i)]==false && order[temp.get(i)] == order[num]) {
					q.add(temp.get(i));
					visited[temp.get(i)] = true;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			if(order[i]==order[start] && visited[i]==false) {
				return false;
			}
		}
		return true;
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		population = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		info = new ArrayList[n];
		for(int i=0;i<n;i++) {
			info[i] = new ArrayList<>();
		}
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++) {
				int next = Integer.parseInt(st.nextToken())-1;
				info[i].add(next);
			}
		}
		
		order = new int[n];
	}

}
