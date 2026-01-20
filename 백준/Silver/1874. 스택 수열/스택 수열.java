import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Queue<Integer> result;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		Stack<Integer> st = new Stack<>();
		int num = 0;
		while(!result.isEmpty()) {
			int top = result.peek();
			if(num<top) {
				num++;
				st.push(num);
				sb.append("+").append("\n");
			}else if(num>=top) {
				if(st.peek()>top) {
					System.out.println("NO");
					return;
				}
				sb.append("-").append("\n");
				st.pop();
				result.poll();
			}
		}
		System.out.println(sb.toString());
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		result = new LinkedList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			result.add(Integer.parseInt(st.nextToken()));
		}
	}

}
