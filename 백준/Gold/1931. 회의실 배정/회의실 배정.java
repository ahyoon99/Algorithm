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
		
		// 빨리 끝나는 순서로 정렬하기, 단 같은 시간에 끝나는 회의인 경우 시작 시간이 빠른 순으로 정렬하기
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
		
		// 첫번째 단체가 회의실 사용하기
		Node time = timeline.get(0);
		result++;
		
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
		result = 0;
	}
}
