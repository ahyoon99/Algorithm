import java.util.*;
import java.io.*;

public class Main {
	static long a;
	static long b;
	static long c;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(pow(a, b));
	}
	
	// a^b % c를 빠르게 계산
	static long pow(long a, long b) {
		if(b==0) return 1%c;
		if(b==1) return a%c;
		
		long half = pow(a,b/2);
		long result = (half * half) % c;	// ( a^(b/2) )^2 % c
		
		// 홀수면 한 번 더 a를 곱해줌
		if(b%2 == 1) {
			result = (result * a) % c;
		}
		return result;
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
	}

}
