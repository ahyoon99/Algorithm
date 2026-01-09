import java.util.*;
import java.io.*;

public class Main {
	static int N;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		int num = 666;
		int cnt = 1;
		if(N==1) {
			System.out.println(num);
			return;
		}
		
		while(true) {
			if(cnt==N) {
				System.out.println(num);
				return;
			}
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
	}

}
