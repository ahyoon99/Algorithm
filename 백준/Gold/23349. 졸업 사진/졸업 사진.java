import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static HashSet<String> students;
	static HashMap<String, int[]> info;
	static ArrayList<Node> result;
	
	static class Node implements Comparable<Node>{
		String place;
		int start;
		int end;
		int cnt;
		
		Node(String place, int start, int end, int cnt){
			this.place = place;
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node next) {
			if(this.cnt == next.cnt) {
				if(this.place.compareTo(next.place) == 0) {
					if(this.start == next.start) {
						return Integer.compare(this.end, next.end);
					}
					return Integer.compare(this.start, next.start);
				}
				return this.place.compareTo(next.place);
			}
			return Integer.compare(this.cnt, next.cnt) * (-1);
		}

		@Override
		public String toString() {
			return place + " " + start + " " + end;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		for(String place : info.keySet()) {
			int maxCount = Integer.MIN_VALUE;
			Node resultNode = new Node(null, -1, -1, -1);
			
			int[] popular = info.get(place);
			boolean isFinish = true;
			for(int i=0;i<50001;i++) {
				// 동일한 장소일 때, 가장 빠른 시간대로 자동 걸러짐 
				if(maxCount<popular[i]) {
					resultNode = new Node(place, i, i+1, popular[i]);
					maxCount = popular[i];
					isFinish = false;
				} else if(maxCount==popular[i] && !isFinish) {
					resultNode.end = i+1;
				} else if(maxCount>popular[i]) {
					isFinish = true;
				}
			}
			
			result.add(resultNode);
		}
		
		
		Collections.sort(result);		
		System.out.println(result.get(0).toString());
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		students = new HashSet<String>();
		info = new HashMap<String, int[]>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String place = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(students.contains(name)) {
				continue;
			}else {
				students.add(name);
				int[] popular;
				if(info.containsKey(place)) {
					popular = info.get(place);
				} else {
					popular = new int[50001];
				}
				for(int j=start;j<end;j++) {
					popular[j]++;
				}
				info.put(place, popular);
			}
		}
		result = new ArrayList<>();
	}
}
