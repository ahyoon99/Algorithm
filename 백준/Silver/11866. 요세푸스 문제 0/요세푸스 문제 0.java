import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int K;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		System.out.println(sb.toString());
	}
	
	static void solution() {
		sb.append("<");
		
		while(q.size()!=1) {
			for(int i=0;i<K-1;i++) {
				q.add(q.poll());
			}
			sb.append(q.poll()+", ");
		}
		sb.append(q.poll()).append(">");
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
	}

}
