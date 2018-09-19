//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

//Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

//Example 1:
//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        Islands il = new Islands(grid);
        return il.getMaxIslandSize();
    }
    
    public class Islands{
        public int[][] IMap;
        public int MaxCount;
        public Islands (int[][] grid){
            this.IMap = grid;
            MaxCount = 0;
        }

        public int getMaxIslandSize(){
            for(int i = 0; i < IMap.length; i++){
                for(int j = 0; j < IMap[0].length; j++){
                    int count = getConnectedCounts(i,j);
                    if(count > MaxCount)
                        MaxCount = count;
                }
            }
            return MaxCount;
        }

        public int getConnectedCounts(int x, int y){
            if(x>=0 && x<IMap.length && y>=0 && y < IMap[0].length && IMap[x][y] == 1){
                IMap[x][y] = 2; // 2 means Visited
                return 1 + getConnectedCounts(x+1,y) + getConnectedCounts(x-1,y) + getConnectedCounts(x,y+1) + getConnectedCounts(x,y-1);
            }
            return 0;
        }
    }
    
    
}

