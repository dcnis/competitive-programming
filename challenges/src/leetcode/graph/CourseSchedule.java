package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> list = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            list.put(i, new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }


        int[] visiting = new int[numCourses];

        for(int i = 0; i < list.size(); i++){
            if(!dfs(i, visiting, list)){
                return false;
            }
        }

        return true;

    }


    private boolean dfs(int node, int[] visiting, HashMap<Integer, List<Integer>> list){
        if(visiting[node] == -1) return false;
        if(visiting[node] == 1) return true;

        visiting[node] = -1;

        for(int child : list.get(node)){
            if(!dfs(child, visiting, list)){
                return false;
            }
        }

        visiting[node] = 1;
        return true;
    }


    public static void main(String[] args) {
        CourseSchedule program = new CourseSchedule();
        // Should output false
        System.out.print("expected: false");
        System.out.println(" -> actual: " + program.canFinish(4, new int[][]{
                {2, 0},
                {1, 0},
                {3, 1},
                {3, 2},
                {1, 3}
        }));

        // Should output true
        System.out.print("expected: true");
        System.out.println(" -> actual: " + program.canFinish(5, new int[][]{
                {1, 4},
                {2, 4},
                {3, 1},
                {3, 2}
        }));
    }

}
