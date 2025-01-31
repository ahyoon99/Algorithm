import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int k;
	static int x;
	static ArrayList<Integer>[] routes;
	static int[] distance;
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input(br);
		solution();
	}
	
	static void solution() {
		bfs();
		
		boolean isExist = false;
		for(int i=1;i<n+1;i++) {
			if(distance[i]==k) {
				isExist = true;
				System.out.println(i);
			}
		}
		if(!isExist) {
			System.out.println(-1);
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		distance[x]=0;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			ArrayList<Integer> nextNums = routes[num];
			for(int i=0;i<nextNums.size();i++) {
				if(distance[nextNums.get(i)]==-1) {
					distance[nextNums.get(i)]=distance[num]+1;
					q.add(nextNums.get(i));
				}
			}
		}
	}
	
	static void input(BufferedReader br) throws IOException{
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		routes = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) {
			routes[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			routes[start].add(end);
		}
		
		distance = new int[n+1];
		Arrays.fill(distance, -1);
	}
}
