package de.schmidtdennis.challenges.leetcode.graph.MST;

import java.util.PriorityQueue;

// 1584. Min Cost to Connect All Points
public class Kruskal {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        int[] parents = new int[points.length];
        int[] size = new int[points.length];

        for(int i = 0; i < points.length; i++){
            parents[i] = i;
            size[i] = 1;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                int[] edge = new int[]{dist, i, j};
                q.offer(edge);
            }
        }

        int sum = 0;

        while(!q.isEmpty()){
            int[] node = q.poll();

            // Check if cycle
            if(find(node[1], parents) == find(node[2], parents)){
                continue;
            }

            union(node[1], node[2], parents, size);

            // Else add to sum
            sum += node[0];
        }


        return sum;
    }

    private int find(int node, int[] parents){
        // With path compression
        if(node == parents[node]) return node;
        return parents[node] = find(parents[node], parents);
    }

    private void union(int a, int b, int[] parents, int[] size){

        // find a root
        int aRoot = find(a, parents);
        // find b root
        int bRoot = find(b, parents);

        if(aRoot == bRoot) return;

        if(size[a] >= size[b]){
            // set a as b's root
            parents[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
        } else {
            // set b as a's root
            parents[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
        }

    }

}
