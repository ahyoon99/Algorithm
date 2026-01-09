import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int TC;
	static String command;
	static int N;
	static Deque<Integer> dq;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		TC = Integer.parseInt(st.nextToken());
		
		for(int testcase=0;testcase<TC;testcase++) {
			input(br);
			solution();
		}
		System.out.println(sb.toString());
	}
	
	static void solution() {
		boolean isError = false;
		boolean first = true;
		error : for(int i=0;i<command.length();i++) {
			if(command.charAt(i)=='R') {
				first = !first;
			}else if(command.charAt(i)=='D') {
				if(dq.size()==0) {
					isError = true;
					break error;
				} else {
					if(first) {
						dq.removeFirst();
					} else {
						dq.removeLast();
					}
				}
			}
		}
		
		if(isError) {
			sb.append("error").append("\n");
		}
		else {
			// 배열 출력하기
			sb.append("[");
			if(!dq.isEmpty()) {
				if(first) {
					while(!dq.isEmpty()) {
						sb.append(dq.pollFirst()).append(",");
					}
				}else {
					while(!dq.isEmpty()) {
						sb.append(dq.pollLast()).append(",");
					}
				}
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append("]").append("\n");
		}
	}

	static void input(BufferedReader br) throws IOException{
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		command = st.nextToken();
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		String arrayStr = st.nextToken();
		dq = new ArrayDeque<>();
		if(arrayStr.length()>2) {
			arrayStr = arrayStr.substring(1, arrayStr.length()-1);
			String[] temp = arrayStr.split(",");
			for(int i=0;i<temp.length;i++) {
				dq.addLast(Integer.parseInt(temp[i]));
			}
		}
	}
}
