package matrix;


public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int maxAreaOfIsland = 0;

        for(int y = 0; y < grid.length; y++){
            for(int x = 0; x < grid[0].length; x++){
                if(grid[y][x] == 1){
                    // start a bfs on this node and put the result into an set.
                    int areaOfIsland = bfs(grid, y, x);
                    if(areaOfIsland > maxAreaOfIsland){
                        maxAreaOfIsland = areaOfIsland;
                    }
                }
            }
        }

        return maxAreaOfIsland;
    }

    private int bfs(int[][] grid, int y, int x){

        if(y == grid.length || y == -1) return 0;
        if(x == grid[0].length || x == -1) return 0;
        if(grid[y][x] == 0) return 0; // water
        if(grid[y][x] == -1) return 0; // already seen

        // mark current node visited
        grid[y][x] = -1;

        int right = 0;
        int left = 0;
        int up = 0;
        int down = 0;

        if(x != 0){
            // spread three left
            left = bfs(grid, y, x-1);
        }

        if (x != (grid[0].length-1)) {
            // spread three right
            right = bfs(grid, y, x + 1);
        }

        if (y != 0){
            // spread up
            up = bfs(grid, y-1, x);
        }

        if(y != (grid.length-1)){
            // spread down
            down = bfs(grid, y+1, x);
        }

        return left + right + up + down + 1;

    }

    public static void main(String[] args) {

    }


}
