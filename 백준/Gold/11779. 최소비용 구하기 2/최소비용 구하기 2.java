import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static int START, END;
	static ArrayList<Node>[] info;
	
	static int[] distance;	// 최소 비용 저장할 배열
	static int[] route;	
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		
		Node(int to, int weight){
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException{
		input();
		
		dijkstra(START);
		System.out.println(distance[END]);
		
		int cnt=0;
		Stack<Integer> st = new Stack<>();
		st.push(END);
		while(route[END] != 0) {
			cnt++;
			st.push(route[END]);
			END = route[END];
		}
		System.out.println(cnt+1);
		
		while(!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}

	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		pq.add(new Node(start, 0));
		distance[start]=0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int next = node.to;
			if(distance[next] < node.weight) continue;
			
			ArrayList<Node> temp = info[next];
			for(int i=0;i<temp.size();i++) {
				if(distance[temp.get(i).to] > distance[next] + temp.get(i).weight) {
					distance[temp.get(i).to] = distance[next] + temp.get(i).weight;
					route[temp.get(i).to] = next;
					pq.add(new Node(temp.get(i).to, distance[temp.get(i).to]));
				}
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		
		info = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			info[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			info[start].add(new Node(end, cost));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		START = Integer.parseInt(st.nextToken());
		END = Integer.parseInt(st.nextToken());
		
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		route = new int[N+1];
	}
}
