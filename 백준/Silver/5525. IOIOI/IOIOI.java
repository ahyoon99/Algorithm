import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int s;
    static String m;
    static int result;

    public static void main(String[] args) throws IOException{
        // System.setIn(new FileInputStream("res/input.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        input(br);
        solution();
        
        System.out.println(result);
    }

    static void solution() {
        
        int count = 0;
        for(int i=1;i<m.length()-1;i++){
            if(m.charAt(i-1)=='I' && m.charAt(i)=='O' && m.charAt(i+1)=='I'){
                count++;
                i++;
                if(count==n){
                    result++;
                    count--;
                }
            }
            else{
                count=0;
            }
        }
    }

    static void input(BufferedReader br) throws IOException{

        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        

        st = new StringTokenizer(br.readLine(), " ");
        m = st.nextToken();
        
        result = 0;
    }
}
