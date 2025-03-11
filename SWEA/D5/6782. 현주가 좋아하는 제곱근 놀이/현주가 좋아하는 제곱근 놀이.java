import java.util.*;
import java.io.*;

public class Solution {
	static int tc;
	static long n;
	static int result;
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("res/Day0305/input_swea6782.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		tc = Integer.parseInt(st.nextToken());
		for(int testcase=1;testcase<=tc;testcase++) {
			System.out.print("#"+testcase+" ");
			input(br, st);
			solution();
			System.out.println(result);
		}
	}
	
	static void solution() {
		while(true) {
			if(n==2) {
				break;
			}
			if(Math.sqrt(n)==(long)(Math.sqrt(n))) {
				n = (long)(Math.sqrt(n));
				result++;
			}
			else {
				long nextNum = (long) Math.pow((long)(Math.sqrt(n)) + 1, 2);
				result+=(nextNum-n);
				n = nextNum;
			}
		}
	}
	
	
	static void input(BufferedReader br, StringTokenizer st) throws IOException{
		st = new StringTokenizer(br.readLine(), " ");
		n = Long.parseLong(st.nextToken());
		result = 0;
	}

}