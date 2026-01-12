import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static Node[] info;
	static int[] result;
	
	static class Node{
		int idx;
		int weight;
		int height;
		
		Node(int idx, int weight, int height){
			this.idx = idx;
			this.weight = weight;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(info[i].weight<info[j].weight && info[i].height<info[j].height) {
					result[i]++;
				}
			}
		}
	
		for(int i=0;i<N;i++) {
			System.out.print(result[i]+" ");
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() ," ");
		N = Integer.parseInt(st.nextToken());
		
		info = new Node[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			info[i] = new Node(i, w, h);
		}
		
		result = new int[N];
		Arrays.fill(result, 1);
	}
}
