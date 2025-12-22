import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static Node[] nodes;
	static int[] result;
	
	static class Node implements Comparable<Node>{
		int num;
		int idx;
		int result;
		
		Node(int num, int idx){
			this.num=num;
			this.idx=idx;
			result=-1;
		}
		
		@Override
		public int compareTo(Node next) {
			return Integer.compare(this.num, next.num);
		}
	}
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		Arrays.sort(nodes);
		
		nodes[0].result = 0;
		for(int i=1;i<n;i++) {
			if(nodes[i-1].num == nodes[i].num) {
				nodes[i].result = nodes[i-1].result;
			}
			else {
				nodes[i].result = nodes[i-1].result+1;
			}
		}
		
		for(int i=0;i<n;i++) {
			int idx = nodes[i].idx;
			int value = nodes[i].result;
			result[idx]=value;
		}
		
		for(int i=0;i<n;i++) {
			sb.append(result[i]+" ");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		nodes = new Node[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			nodes[i] = new Node(Integer.parseInt(st.nextToken()), i);
		}
		
		result = new int[n];
	}

}
