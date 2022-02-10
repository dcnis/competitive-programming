# Competitive Programming

My random competitive programming solutions (and other stuff)

# Requirements

All coding examples are written in Java 11
    
    openjdk version "11.0.7" 2020-04-14 LTS
    OpenJDK Runtime Environment Corretto-11.0.7.10.1 (build 11.0.7+10-LTS)
    OpenJDK 64-Bit Server VM Corretto-11.0.7.10.1 (build 11.0.7+10-LTS, mixed mode)

# Cheat Sheet

### 0) Time Complexity

10<sup>3</sup> -> **O(n<sup>2</sup>)**<br>
10<sup>5</sup> -> **O(nlogn)**<br>
10<sup>7</sup> -> **O(n)**<br>
10<sup>8</sup> -> **O(logn)**<br>

### 1) Map coordinates of 1-D array onto 2-D matrix

Map 1-D array

| 0  | 1  | 2  | 3  | 4  | 5  |
|---|---|---|---|---|---|

to 2-D matrix

| 0  | 1  |  2 |
|---|---|---|
|  3 | 4  |  5 |

**2D [i/columns] [i%columns]**

Practise problem: <br>
74. Search a 2D Matrix https://leetcode.com/problems/search-a-2d-matrix/

### 2) Map coordinates of 2-D matrix onto 1-D array

Map 2-D matrix 

| 0  | 1  |  2 |
|---|---|---|
|  3 | 4  |  5 |

to 1-D array

| 0  | 1  | 2  | 3  | 4  | 5  |
|---|---|---|---|---|---|

**1D [i*column + j]**

### 3) Tree level traversal with level delimiter

```
    Queue<Node> q = new LinkedList<>(); 
  
    // Pushing root node into the queue. 
    q.offer(root); 
  
    // Pushing delimiter into the queue. 
    q.offer(null); 
  
    while (!q.isEmpty()) { 
  
      Node curr = q.poll(); 
  
      // condition to check the occurence of next level 
      if (curr == null) { 
        if (!q.isEmpty()) { 
          q.offer(null);
        } 
      } else { 
      
        if (curr.left != null){
          q.add(curr.left); 
        }
  
        if (curr.right != null){
          q.add(curr.right); 
        }
      } 
    } 
  } 
```


### 3) BFS doing stuff for each level without level delimiter
```
        Queue<Node> q = new LinkedList<Node>(); 
        q.offer(root);
        
        // Outer while loop which iterates over each level
        while (!q.isEmpty()) {
            
            // Note the size of the queue
            int size = q.size();
            
            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++) {
                
                // Pop a node from the front of the queue
                Node node = q.poll();
                
                // do sth with the node
                
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
```

### 4) Reverse Linked List recursively 

Assume from node nk+1 to nm had been reversed and you are at node nk.

n<sub>1</sub> → … → n<sub>k-1</sub> → n<sub>k</sub> → n<sub>k+1</sub> ← … ← n<sub>m</sub>

We want n<sub>k+1</sub>’s next node to point to n<sub>k</sub>.

So,

n<sub>k</sub>.next.next = n<sub>k</sub>;

```
    public ListNode reverseList(ListNode node) {
        if(node == null || node.next == null) return node;
        
        ListNode tail = reverseList(node.next);
        node.next.next = node;
        node.next = null; 
        return tail; 
    }
```

### 5) Find cycle in a graph

- DFS with Backtracking
- visited [T/F]

### 6) Topolocal Sort with Kahn's Algorithm

The intuition behind Kahn's algorithm is to repeatedly remove nodes with indegree of zero from the graph 
and add them to the topological ordering. We remove nodes with indegree zero from the graph 
until all nodes are processed or a cycle is discovered. 
```
        public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses == 1 ) return new int[1];
        
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }
        
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        
        // Push every node with indegree=0 to queue
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            
            Integer courseNumber = q.poll();
            order.add(courseNumber);
            
            for(int pre : adj.get(courseNumber)){
                // decrease neighbour's indegree by one
                indegree[pre]--;
                
                if(indegree[pre] == 0){
                    q.offer(pre);
                }
            }
        }
        
        if(order.size() != numCourses){
            return new int[0];
        }
        
        return order.stream().mapToInt(x -> x).toArray();
    }
```
