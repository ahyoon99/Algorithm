import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] height;
	static Stack<Node> stack;
	
	static class Node{
		int idx;
		int value;
		
		Node(int idx, int value){
			this.idx=idx;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		for(int i=0;i<n;i++) {
			if(stack.isEmpty()) {
				stack.push(new Node(i, height[i]));
				System.out.print(0+" ");
			}
			else {
				while(true) {
					if(stack.isEmpty()) {
						stack.push(new Node(i, height[i]));
						System.out.print(0 +" ");
						break;
					}
					Node peek = stack.peek();
					if(peek.value>height[i]) {
						System.out.print((peek.idx+1)+" ");
						stack.push(new Node(i, height[i]));
						break;
					}
					else {
						stack.pop();
					}
				}
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		height = new int[n];
		for(int i=0;i<n;i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		stack = new Stack<>();
	}
}
