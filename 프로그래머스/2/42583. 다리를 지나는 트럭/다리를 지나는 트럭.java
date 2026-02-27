import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int times = 0;
    
        int currentWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++){
            int truck = truck_weights[i];
            
            while(true){
                if(bridge.size() == bridge_length){
                    currentWeight-=bridge.peek();
                    bridge.poll();
                } else {
                    if(currentWeight + truck <= weight){
                        currentWeight+=truck;
                        bridge.add(truck);
                        times++;
                        break;
                    }else{
                        bridge.add(0);
                        times++;
                    }
                }
            }
        }
        
        return times+bridge_length;
    }
}