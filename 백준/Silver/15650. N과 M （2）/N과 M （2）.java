import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] order;
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		order = new int[m];
		go(0, 0);
	}
	
	static void go(int depth, int start) {
		if(depth>=m) {
			for(int i=0;i<order.length;i++) {
				System.out.print(order[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<n;i++) {	// 증가하는 수열 만들기 
			order[depth]=(i+1);
			go(depth+1, i+1);
			order[depth]=0;
		}
	}

}
