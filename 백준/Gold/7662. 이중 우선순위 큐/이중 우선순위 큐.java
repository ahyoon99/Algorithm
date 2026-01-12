import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int K;

	static TreeMap<Integer, Integer> tm;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		
		for(int testcase=0;testcase<T;testcase++) {
			solution(br);
			if(tm.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				int max = tm.lastKey();
				int min = tm.firstKey();
				System.out.println(max+" "+min);
			}
		}
	}
	
	static void solution(BufferedReader br) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		
		tm = new TreeMap<Integer, Integer>();
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();  // "I" or "D"
			int n = Integer.parseInt(st.nextToken());
			if(com.equals("I")) {
				tm.put(n, tm.getOrDefault(n, 0)+1);
			} else if(com.equals("D")) {
				if(tm.isEmpty()) {
					continue;
				}
				if(n==1) {
					// 최댓값 삭제하기 
					int key = tm.lastKey();
					int value = tm.get(key);
					if(value==1) {
						tm.remove(key);
					} else {
						tm.put(key, value-1);
					}
				}else if(n==-1) {
					// 최소값 삭제하기 
					int key = tm.firstKey();
					int value = tm.get(key);
					if(value==1) {
						tm.remove(key);
					}else {
						tm.put(key, value-1);
					}
				}
			}
		}
	}

}
