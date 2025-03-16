import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] info;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		Arrays.sort(info);
		
		int start = 0;
		int end = info[info.length-1];
		int mid = -1;
		while(start<end) {
			mid = (start+end)/2;
			long wood = getWood(mid);
			if(wood<m) {
				end = mid;
			}
			else if(wood>=m) {
				start = mid+1;
			}
		}
		System.out.println(start-1);
	}
	
	static long getWood(int key) {
		long result = 0;
		for(int i=0;i<n;i++) {
			if(info[i]<=key) continue;
			result += (info[i]-key);
		}
		return result;
	}

	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		info = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
	}
}
