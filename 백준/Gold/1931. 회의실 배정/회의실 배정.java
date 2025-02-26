import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int result;
	
	static ArrayList<Node> timeline;
	static class Node implements Comparable<Node>{
		int startTime;
		int endTime;
		
		Node(int startTime, int endTime){
			this.startTime=startTime;
			this.endTime = endTime;
		}
		
		@Override
		public int compareTo(Node node) {
			if(this.endTime==node.endTime) {
				return Integer.compare(this.startTime, node.startTime);
			}
			return Integer.compare(this.endTime, node.endTime);
		}
	}
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		Collections.sort(timeline);
		
		Node time = timeline.get(0);
		for(int i=1;i<n;i++) {
			if(time.endTime<=timeline.get(i).startTime) {
				result++;
				time = timeline.get(i);
			}
		}
		System.out.println(result);
	}

	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		timeline = new ArrayList<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			timeline.add(new Node(start, end));
		}
		result = 1;
	}
}
