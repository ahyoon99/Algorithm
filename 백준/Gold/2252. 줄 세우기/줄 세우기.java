import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static ArrayList<Integer>[] info;
	static int[] cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		System.out.println(sb);
	}
	
	static void solution() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i=0;i<n;i++) {
			if(cnt[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int num = q.poll();
			sb.append((num+1)+" ");
			ArrayList<Integer> temp = info[num];
			for(int i=0;i<temp.size();i++) {
				cnt[temp.get(i)]--;
				if(cnt[temp.get(i)]==0) {
					q.add(temp.get(i));
				}
			}
		}
	}
	
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		info = new ArrayList[n];
		for(int i=0;i<n;i++) {
			info[i] = new ArrayList<>();
		}
		cnt = new int[n];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int before = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			info[before].add(end);
			cnt[end]++;
		}
	}

}
