import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int N;
	static HashMap<String, Integer> stringToIdx;
	static ArrayList<Integer> cnt;
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(st.nextToken());
		
		for(int testcase=0;testcase<T;testcase++) {
			solution(br);
			System.out.println(result);
		}
	}
	
	static void solution(BufferedReader br) throws IOException{
		stringToIdx = new HashMap<String, Integer>();
		cnt = new ArrayList<Integer>();
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String type = st.nextToken();
			if(stringToIdx.containsKey(type)) {
				int idx = stringToIdx.get(type);
				int count = cnt.get(idx);
				cnt.set(idx, count+1);
			}
			else {
				int idx = cnt.size();
				stringToIdx.put(type, idx);
				cnt.add(1);
			}
		}
		
		result = 1;
		for(int i=0;i<cnt.size();i++) {
			result*=(cnt.get(i)+1);
		}
		result--;
		
	}

}
