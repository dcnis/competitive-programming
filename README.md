# Competitive Programming

My random competitive programming solutions (and other stuff)

# Requirements

All coding examples are written in Java 11
    
    openjdk version "11.0.7" 2020-04-14 LTS
    OpenJDK Runtime Environment Corretto-11.0.7.10.1 (build 11.0.7+10-LTS)
    OpenJDK 64-Bit Server VM Corretto-11.0.7.10.1 (build 11.0.7+10-LTS, mixed mode)

# Cheat Sheet

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