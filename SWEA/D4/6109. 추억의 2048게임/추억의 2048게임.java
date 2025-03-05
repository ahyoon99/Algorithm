import java.util.*;
import java.io.*;

public class Solution {
	static int tc;
	static int n;
	static String dir;
    static int[][] matrix;
    static ArrayList<Integer> before;
    static ArrayList<Integer> after;
    
    static public void main(String args[]) throws IOException{
//        System.setIn(new FileInputStream("res/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        tc = Integer.parseInt(st.nextToken());
        
    	for(int testcase=1;testcase<=tc;testcase++) {
    		System.out.println("#"+testcase);
    		input(br, st);
    		
    		if(dir.equals("up")){
                goUp();
            }
            else if(dir.equals("down")){
                goDown();
            }
            else if(dir.equals("left")){
                goLeft();
            }
            else if(dir.equals("right")){
                goRight();
            }
    		print(matrix);
    	}
    }

    static void calculate(ArrayList<Integer> before, ArrayList<Integer> after){
    	if(before.size()==1){	// 타일이 1개만 있을 경우 
            after.add(before.get(0));
        }
        else{	// 타일이 2개 이상 있을 경우 
            for(int i=0;i<before.size();i++){
                if(i==before.size()-1){	// 마지막 타일의 경우 after 리스트에 넣어주고 반복문을 끝낸다 
                    after.add(before.get(i));
                    break;
                }
                if(before.get(i).equals(before.get(i+1))){	// 현재 타일과 다음 타일이 동일하다면 
                    after.add(before.get(i)+before.get(i+1));	// 현재 타일의 2배인 타일을 after 리스트에 넣어준다 
                    i++;	// 현재 타일과 다음 타일의 판단이 끝났으니, 그 다음 타일을 판단하기 위해 i를 1 늘려준다 
                }
                else{	// 현재 타일과 다음 타일이 동일하지 않다면 
                    after.add(before.get(i));	// 현재 타일을 after 리스트에 넣어준다 
                }
            }
        }
    }

    // 타일을 위쪽으로 이동시킬 때 
    static void goUp(){
        for(int i=0;i<n;i++){	// 세로 한 줄 씩 돌기 
            before = new ArrayList<Integer>();
            after = new ArrayList<Integer>();

            // 0이 아닌 값만 before에 저장하기 
            for(int j=0;j<n;j++){	
                if(matrix[j][i]!=0){
                    before.add(matrix[j][i]);
                }
            }

            calculate(before, after);	// 타일 이동시키기 
            
            // 이동시킨 타일의 상태를 matrix에 넣어주기 
            int[] temp = new int[n];
            for(int j=0;j<after.size();j++){
                temp[j] = after.get(j);
            }

            for(int j=0;j<n;j++){
                matrix[j][i]=temp[j];
            }
        } 
    }

    // 타일을 아래쪽으로 이동시킬 때 
    static void goDown(){
        for(int i=0;i<n;i++){	// 세로 한 줄 씩 돌기
            before = new ArrayList<Integer>();
            after = new ArrayList<Integer>();

            // 0이 아닌 값만 before에 저장하기 
            for(int j=n-1;j>=0;j--){
                if(matrix[j][i]!=0){
                    before.add(matrix[j][i]);
                }
            }

            calculate(before, after);	// 타일 이동시키기 
            
            // 이동시킨 타일의 상태를 matrix에 넣어주기 
            int[] temp = new int[n];
            for(int j=0;j<after.size();j++){
                temp[n-j-1] = after.get(j);
            }

            for(int j=0;j<n;j++){
                matrix[j][i]=temp[j];
            }
        }
    }

    // 타일을 왼쪽으로 이동시킬 때 
    static void goLeft(){
        for(int i=0;i<n;i++){	// 가로 한 줄 씩 돌기
            before = new ArrayList<Integer>();
            after = new ArrayList<Integer>();

            // 0이 아닌 값만 before에 저장하기 
            for(int j=0;j<n;j++){
                if(matrix[i][j]!=0){
                    before.add(matrix[i][j]);
                }
            }

            calculate(before, after);	// 타일 이동시키기 
            
            // 이동시킨 타일의 상태를 matrix에 넣어주기 
            int[] temp = new int[n];
            for(int j=0;j<after.size();j++){
                temp[j] = after.get(j);
            }

            for(int j=0;j<n;j++){
                matrix[i][j]=temp[j];
            }
        }
    }

    // 타일을 오른쪽으로 이동시킬 때 
    static void goRight(){
        for(int i=0;i<n;i++){	// 가로 한 줄 씩 돌기
            before = new ArrayList<Integer>();
            after = new ArrayList<Integer>();

            // 0이 아닌 값만 before에 저장하기 
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]!=0){
                    before.add(matrix[i][j]);
                }
            }

            calculate(before, after);	// 타일 이동시키기 
            
            // 이동시킨 타일의 상태를 matrix에 넣어주기 
            int[] temp = new int[n];
            for(int j=0;j<after.size();j++){
                temp[n-j-1] = after.get(j);
            }

            for(int j=0;j<n;j++){
                matrix[i][j]=temp[j];
            }
        }
    }

    static void input(BufferedReader br, StringTokenizer st) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        dir = st.nextToken();
        
        matrix = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                matrix[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        before = new ArrayList<Integer>();
        after = new ArrayList<Integer>();
    }

    static void print(int[][] arr){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
