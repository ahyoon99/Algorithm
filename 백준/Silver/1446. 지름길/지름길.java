import java.util.*;
import java.io.*;

public class Main {
	static int N, D;
	
	static ArrayList<Node>[] info;
	static int[] distance;
	
	
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
		dijkstra(0);
		System.out.println(distance[D]);
		
	}
	
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		distance[start]=0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			// 이미 더 짧은 경로로 방문했다면 skip 
			if(distance[node.end] < node.distance) continue;
			
			for(int i=0;i<info[node.end].size();i++) {
				Node next = info[node.end].get(i);
				int nextDistance = distance[node.end]+next.distance;
				
				// 현재 계산된 경로가 더 짧다면 갱신 
				if(distance[next.end]>nextDistance) {
					distance[next.end]=nextDistance;
					pq.add(new Node(next.end, distance[next.end]));
				}
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		info = new ArrayList[D+1];
		for(int i=0;i<=D;i++) {
			info[i] = new ArrayList<>();
		}
		
		// 기본 도로 : i -> i+1 (비용1)
		for(int i=0;i<D;i++) {
			info[i].add(new Node(i+1, 1));
		}
		
		// 지름길 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()); 
			int end = Integer.parseInt(st.nextToken()); 
			int time = Integer.parseInt(st.nextToken());
			
			// 도착점이 D보다 크면 의미 없음 
			if(end>D) continue;
			
			// 지름길이 일반 길이보다 짧을 때만 유효 
			if(end-start > time) {
				info[start].add(new Node(end, time));
			}
		}
		distance = new int[D+1];
		Arrays.fill(distance,  Integer.MAX_VALUE);
	}
}
