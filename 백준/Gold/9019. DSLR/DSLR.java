import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int num1;
	static int num2;
	
	static class Node{
		int num;
		String command;
		
		Node(int num, String command){
			this.num = num;
			this.command = command;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		
		for(int testcase=0;testcase<T;testcase++) {
			input(br);
			bfs();
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		
		q.add(new Node(num1, ""));
		visited[num1] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.num == num2) {
				sb.append(node.command);
				break;
			}
			
			int result = calculate('D', node.num);
			if(!visited[result]) {
				q.add(new Node(result, node.command+"D"));
				visited[result]=true;
			}
			result = calculate('S', node.num);
			if(!visited[result]) {
				q.add(new Node(result, node.command+"S"));
				visited[result]=true;
			}
			result = calculate('L', node.num);
			if(!visited[result]) {
				q.add(new Node(result, node.command+"L"));
				visited[result]=true;
			}
			result = calculate('R', node.num);
			if(!visited[result]) {
				q.add(new Node(result, node.command+"R"));
				visited[result]=true;
			}
		}
	}

	static int calculate(char op, int num) {
		if(op=='D') {
			num = (num*2)%10000;
		} else if(op=='S') {
			if(num==0) {
				num = 10000;
			}
			num--;
		} else if(op=='L') {
			int temp1 = num%1000;
			int temp2 = num/1000;
			num = temp1*10 + temp2;
		} else if(op=='R') {
			int temp1 = num%10;
			int temp2 = num/10;
			num = (int) Math.pow(10, 3)*temp1 + temp2;
		}
		return num;
	}
	
	static void input(BufferedReader br) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
	}

}
