import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static boolean[] isUsed;			// 단축키로 이미 쓰였는지 사용 여부 저장 
	
	static class Info{
		int wordIdx;
		int charIdx;
		
		Info(int wordIdx, int charIdx){
			this.wordIdx = wordIdx;
			this.charIdx = charIdx;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isUsed = new boolean[26];
		
		pointA : for(int now = 0; now<N; now++) {
			// 단어 단위로 분리 
			String[] inputArr = br.readLine().split(" ");
			
			// 1. 첫번째 규칙 
			for(int i=0;i<inputArr.length;i++) {
				String str = inputArr[i].substring(0,1).toLowerCase();
				if(!isUsed[str.charAt(0)-'a']) {
					isUsed[str.charAt(0)-'a'] = true;
					
					// 괄호 추가하기 
					StringBuilder sb = new StringBuilder(inputArr[i]);
					sb.insert(0,  '[');
					sb.insert(2,  ']');
					inputArr[i] = sb.toString();
					
					// 출력하기 
					printAnswer(inputArr);
					continue pointA;
				}
			}
			
			// 2. 두번째 규칙 
			for(int i=0;i<inputArr.length;i++) {
				for(int j=0;j<inputArr[i].length();j++) {
					String str = inputArr[i].substring(j,j+1).toLowerCase();
					if(!isUsed[str.charAt(0)-'a']) {
						isUsed[str.charAt(0)-'a'] = true;
						
						// 괄호 추가하기 
						StringBuilder sb = new StringBuilder(inputArr[i]);
						sb.insert(j, '[');
						sb.insert(j+2, ']');
						inputArr[i] = sb.toString();
						
						// 출력하기 
						printAnswer(inputArr);
						continue pointA;
						
					}
				}
			}
			
			// 단축키 없을 경우 
			printAnswer(inputArr);
		}
	}
	
	static void printAnswer(String[] inputArr) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<inputArr.length;i++) {
			if(i==inputArr.length -1) {
				sb.append(inputArr[i]);
			}
			else {
				sb.append(inputArr[i]).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}