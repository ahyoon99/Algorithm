import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb  = new StringBuilder();
	static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		go(0,0);
		System.out.println(sb);
	}
	
	static void go(int num, int length) {
		if(length==n) {	// 값의 길이가 n인 경우, 
			if(isPrime(num)) {	// 소수라면, 
				sb.append(num);	// 결과에 넣어주기 
				sb.append("\n");
			}
			return;
		}
		
		for(int i=0;i<10;i++) {	// 다음 자릿수에 0~9까지 더해주기 
			if(isPrime(num*10+i)) {	// 더해준 값이 소수인 경우, 
				go(num*10+i, length+1);	// 재귀로 반복하기 
			}
		}
	}
	
	// 소수인지 판별하기 
	static boolean isPrime(int num) {
		if(num<2) {
			return false;
		}
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}

}
