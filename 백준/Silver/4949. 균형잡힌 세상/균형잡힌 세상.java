import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static String com;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack;
		
		while(true) {
			com = br.readLine();
			if(com.equals(".")) {
				break;
			}
			stack = new Stack<>();
			com = com.replace(" ","");
			boolean isFinish = false;
			flag : for(int i=0;i<com.length();i++) {
				if(com.charAt(i)=='(') {
					stack.add(0);
				} else if(com.charAt(i)==')') {
					if(!stack.isEmpty() && stack.peek()==0){
						stack.pop();
					}else {
						sb.append("no").append("\n");
						isFinish = true;
						break flag;
					}
				} else if(com.charAt(i)=='[') {
					stack.add(1);
				} else if(com.charAt(i)==']') {
					if(!stack.isEmpty() && stack.peek()==1){
						stack.pop();
					}else {
						sb.append("no").append("\n");
						isFinish = true;
						break flag;
					}
				}
			}
			if(!isFinish) {
				if(stack.isEmpty()) {
					sb.append("yes").append("\n");
				} else if(!stack.isEmpty()) {
					sb.append("no").append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
