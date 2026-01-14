import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] scores;
	
	public static void main(String[] args) throws IOException{
		input();
		Arrays.sort(scores);
		
		int cnt = (int) Math.round(N * (0.15));
		int total = 0;
		for(int i=cnt;i<N-cnt;i++) {
			total+=scores[i];
		}
		int result = (int) Math.round((double) total /(N-cnt*2));
		System.out.println(result);
	}

	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		scores = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			scores[i] = Integer.parseInt(st.nextToken());
		}
	}
}
