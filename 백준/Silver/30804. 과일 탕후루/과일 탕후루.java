import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] fruits;

	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		HashMap<Integer, Integer> cnt = new HashMap<>();
		int left = 0;
		int answer = 0;
		
		for(int right = 0; right<N ; right++) {
			// 1. right 과일을 윈도우에 추가 
			cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0)+1);
			
			// 2. 종류가 3개 이상이면 left를 이동하여 조건 복구
			while(cnt.size()>2) {
				int fruit = fruits[left];
				int fruitCnt = cnt.get(fruit);
				if(fruitCnt==1) {
					cnt.remove(fruit);
				}
				else {
					cnt.put(fruit, fruitCnt-1);
				}
				left++;
			}
			
			// 3. 현재 윈도우는 항상 중류 <= 2를 만족 
			answer = Math.max(answer, right-left+1);
		}
		System.out.println(answer);
	}

	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		fruits = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			fruits[i]= Integer.parseInt(st.nextToken());		
		}
	}
}
