import java.util.*;
import java.io.*;

/*
 * - 두 지붕을 잇는 선분이 A와 B
 *   : 기울기 문제
 *   
 * - 다른 고층 빌딩을 지나거나 접하지 않아야 한다
 *   : 중간 빌딩이 더 낮다 X
 *   : 중간 빌딩이 선 위에 닿아도 안되고, 선 위로 올라와도 안된다 O
 * 
 * -> 즉, 기준 빌딩에서 가까운 빌딩 부터 점검
 *    기준 빌딩 보다 앞에 있는 빌딩 기울기가 작을 때만 +1
 *    기준 빌딩 보다 뒤에 있는 빌딩 기울기가 클 때만 +1
 *     
 */
public class Main {
	static int N;
	static int[] buildings;
	static int result;
	
	public static void main(String[] args) throws IOException{
		input();
		for(int i=0;i<N;i++) {
			solution(i);
		}
		System.out.println(result);
	}

	static void solution(int idx) {
		int cnt = 0;
		double minGradient = Double.MAX_VALUE;
		// 기준 빌딩 앞 판별 
		for(int i=idx-1;i>=0;i--) {
			double gradient = (double)(buildings[i]-buildings[idx])/(i-idx);
			if(minGradient > gradient) {
				minGradient = gradient;
				cnt++;
			}
		}
		
		// 기준 빌딩 뒤 판별 
		double maxGradient = -Double.MAX_VALUE;
		for(int i=idx+1;i<N;i++) {
			double gradient = (double)(buildings[i]-buildings[idx])/(i-idx);
			if(maxGradient < gradient) {
				maxGradient = gradient;
				cnt++;
			}
		}
		result = Math.max(result, cnt);
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		buildings = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		result=0;
	}

}
