import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static ArrayList<Integer>[] info;
	static int[] cnt;
	static int result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		if(result==n) {
			System.out.println(sb);
		}
		else {
			System.out.println(0);
		}
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
			sb.append((num+1)+"\n");
			result++;
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
			int cntTemp = Integer.parseInt(st.nextToken());
			int before = Integer.parseInt(st.nextToken())-1;
			int end=-1;
			for(int j=0;j<cntTemp-1;j++) {
				end = Integer.parseInt(st.nextToken())-1;
				info[before].add(end);
				cnt[end]++;
				before = end;
			}
		}
		result = 0;
	}
}
