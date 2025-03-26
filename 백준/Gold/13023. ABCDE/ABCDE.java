import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static ArrayList<Integer>[] info;
	static boolean[] visited;
	static boolean isSuccess;	// 친구 관계 존재 여부를 저장하는 변수 
	
	public static void main(String[] args) throws IOException{
		input();
		
		for(int i=0;i<n;i++) {
			Arrays.fill(visited, false);	// 방문 초기화하기 
			visited[i]=true;
			go(i, 1);

			if(isSuccess) {	// isSuccess가 true이면 1 출력하고 종료하기
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);	// 1 출력하지 않았다면 0 출력하기 

	}
	
	static void go(int start, int depth) {
		if(depth==5) {	// 깊이가 4인 친구 관계가 존재한다면 
			isSuccess = true;	// isSuccess를 true로 바꾸
			return;				// 리턴하기 
		}
		
		ArrayList<Integer> temp = info[start];
		for(int i=0;i<temp.size();i++) {
			if(!visited[temp.get(i)]) {
				visited[temp.get(i)]=true;
				go(temp.get(i), depth+1);
				visited[temp.get(i)]=false;
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
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			info[a].add(b);
			info[b].add(a);
		}
		
		visited = new boolean[n];
	}

}
