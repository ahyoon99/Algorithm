import java.util.*;

// B11279 
public class Main {
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            if(num==0){
                if(pq.size()==0){
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll());
                }
                continue;
            }
            pq.add(num);
        }
    }    
}
