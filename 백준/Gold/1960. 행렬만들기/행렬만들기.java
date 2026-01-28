import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] R;
	static int[] C;
	static int[][] result;
	
	static class Node implements Comparable<Node>{
		int idx;	// 행/열의 인덱스 
		int cnt;	// idx에서 필요한 1의 개수 
		
		Node(int idx, int cnt){
			this.idx = idx;
			this.cnt = cnt;
		}
		
		// cnt(필요한 1의 개수)를 기준으로 내림차순 정렬 
		@Override
		public int compareTo(Node next) {
			return Integer.compare(this.cnt, next.cnt) * (-1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		System.out.println(sb.toString());
	}
	
	
	static void solution() {
		// 1. 행 Node를 담는 PriorityQueue 생성  
		PriorityQueue<Node> rows = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			rows.add(new Node(i, R[i]));
		}
		
		while(!rows.isEmpty()) {
			// 2. 1이 가장 많이 필요한 행 Node 뽑기  
			Node row = rows.poll();	
			
			// 3. 열 Node를 담는 PriorityQueue 생성  
			PriorityQueue<Node> cols = new PriorityQueue<>();
			for(int i=0;i<N;i++) {
				if(C[i]>0) {	// 1이 필요한 열 Node만 PQ에 추가  
					cols.add(new Node(i, C[i]));
				}
			}
			
			// 4. 행이 필요한 1의 개수(row.cnt)보다 1을 넣을 수 있는 열의 개수(cols.size())가 더 작으면 -> 답 존재 X
			if(row.cnt>cols.size()) {
				sb.append("-1");
				return;
			}
			
			// 5. 뽑은 행에 1 채우기 (1이 많이 필요한 열부터)
			for(int i=0;i<row.cnt;i++) {
				Node col = cols.poll();
				result[row.idx][col.idx]=1;
				C[col.idx]--;
			}
		}
		
		// 6. 아직 열에 사용해야하는 1이 남아 있는 경우 -> -1 출력 
		boolean isPossible = true;
		for(int i=0;i<N;i++) {
			if(C[i]!=0) {
				isPossible = false;
				break;
			}
		}
		if(!isPossible) {
			sb.append("-1");
			return;
		}
		
		// 7. 답이 존재하는 경우, 정답 출력 
		sb.append("1").append("\n");
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
	}
	
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		R = new int[N];
        C = new int[N];
        result = new int[N][N];
        
        st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			R[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[N][N];
	}

}
