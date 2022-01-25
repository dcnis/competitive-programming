package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CombinationLock {

    public int openLock(String startCombination, String target) {
        // BFS
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(startCombination);
        q.offer(startCombination);
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++){
                // poll all the elements in queue
                String choice = q.poll();

                if(target.equals(choice)){
                    return count;
                }

                String firstUp = upOne(choice, 0);
                String secondUp = upOne(choice, 1);
                String thirdUp = upOne(choice, 2);
                String fourthUp = upOne(choice, 3);

                String firstDown = downOne(choice, 0);
                String secondDown = downOne(choice, 1);
                String thirdDown = downOne(choice, 2);
                String fourthDown = downOne(choice, 3);

                if(!visited.contains(firstUp)){
                    q.offer(firstUp);
                    visited.add(firstUp);
                }

                if(!visited.contains(secondUp)){
                    q.offer(secondUp);
                    visited.add(secondUp);
                }

                if(!visited.contains(thirdUp)){
                    q.offer(thirdUp);
                    visited.add(thirdUp);
                }

                if(!visited.contains(fourthUp)){
                    q.offer(fourthUp);
                    visited.add(fourthUp);
                }

                if(!visited.contains(firstDown)){
                    q.offer(firstDown);
                    visited.add(firstDown);
                }

                if(!visited.contains(secondDown)){
                    q.offer(secondDown);
                    visited.add(secondDown);
                }

                if(!visited.contains(thirdDown)){
                    q.offer(thirdDown);
                    visited.add(thirdDown);
                }

                if(!visited.contains(fourthDown)){
                    q.offer(fourthDown);
                    visited.add(fourthDown);
                }

            }
            count++;
        }
        return -1;
    }

    String upOne(String s, int index){
        char[] arr = s.toCharArray();
        if(arr[index] == '9')
            arr[index] = '0';
        else
            arr[index]++;
        return new String(arr);
    }

    String downOne(String s, int index){
        char[] arr = s.toCharArray();
        if(arr[index] == '0')
            arr[index] = '9';
        else
            arr[index]--;
        return new String(arr);
    }

    public static void main(String[] args) {
        CombinationLock solution = new CombinationLock();
        System.out.println(solution.openLock("1100", "1111"));
    }


}
