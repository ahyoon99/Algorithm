import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] nums;
	static int[] popular;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		Arrays.sort(nums);
		System.out.println(calculateAverage());
		System.out.println(printMid());
		System.out.println(printPopular());
		System.out.println(printRange());
	}
	
	static int calculateAverage() {
		int total = 0;
		for(int i=0;i<nums.length;i++) {
			total+=nums[i];
		}
		
		double average = (double) total/nums.length;
		return (int) Math.round(average);
	}
	
	static int printMid() {
		return nums[nums.length/2];
	}

	static int printPopular() {
		// 1. 최대 빈도 찾기 
		int maxCnt = 0;
		for(int i=0;i<popular.length;i++) {
			if(popular[i]>maxCnt) {
				maxCnt = popular[i];
			}
		}
			
		// 2. 최빈값 중 첫 번째로 작은 값, 두 번째로 작은 값 찾기
		boolean firstFound = false;
		int firstNum = Integer.MAX_VALUE;
		for(int i=0;i<popular.length;i++) {
			if(popular[i]==maxCnt) {
				if(!firstFound) {
					firstFound=true;
					firstNum = i-4000;
				}else {
					// 두번째로 작은 값이 존재하면, 그 값 리턴
					return i-4000;
				}
			}
		}

		// 3. 두 번째로 작은 값이 없었던 경우, 첫 번째로 작은 값 리턴 
		return firstNum;
	}
	
	static int printRange() {
		return nums[nums.length-1] - nums[0];
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		popular = new int[8001];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nums[i] = Integer.parseInt(st.nextToken());
			popular[nums[i]+4000]++;
		}
		
	}
}
