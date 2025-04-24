import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int X;
	static int M;
	
	static ArrayList<Node>[] info;
	
	static int result;
	
	static class Node implements Comparable<Node>{
		int end;
		int distance;
		
		Node(int end, int distance){
			this.end=end;
			this.distance=distance;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.distance, o.distance);
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		
		for(int i=0;i<N;i++) {
			int total = 0;
			total+= dijkstra(i, X);
			total+= dijkstra(X, i);
			result = Math.max(result, total);
		}
		System.out.println(result);
	}
	
	
	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean visited[] = new boolean[N];
		int distance[] = new int[N]; 
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		pq.add(new Node(start, 0));
		distance[start]=0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(visited[node.end]) continue;
			
			visited[node.end]=true;
			ArrayList<Node> temp = info[node.end];
			
			for(int i=0;i<temp.size();i++) {
				int nextDistance = distance[node.end]+temp.get(i).distance;
				if(distance[temp.get(i).end]>nextDistance) {
					distance[temp.get(i).end]=nextDistance;
					pq.add(new Node(temp.get(i).end, distance[temp.get(i).end]));
				}
			}
		}
		return distance[end];
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		
		info = new ArrayList[N];
		for(int i=0;i<N;i++) {
			info[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken())-1; 
			int end = Integer.parseInt(st.nextToken())-1; 
			int time = Integer.parseInt(st.nextToken());
			
			info[start].add(new Node(end, time));
		}
		
		result = Integer.MIN_VALUE;
	}
}
