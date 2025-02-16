import java.util.*;
import java.io.*;
import java.math.BigInteger;

/*
 * 이동 횟수 : 2^x -1
 */

//B1914 하노이 탑 
public class Main {
	static int n;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		BigInteger cnt = new BigInteger("2").pow(n).subtract(new BigInteger("1"));
		System.out.println(cnt);
		
		if(n<=20) {
			go(n, 1, 3, 2, sb);
			System.out.println(sb);
		}
		
	}
	
	static void go(int n, int start, int target, int temp, StringBuilder sb) {
		if(n==0) {
			return;
		}
		
		go(n-1, start, temp, target, sb);
		sb.append(start+" "+target);
		sb.append("\n");
		go(n-1, temp, target, start, sb);
	}

}
