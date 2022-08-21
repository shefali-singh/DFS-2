
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
class Solution {
    Queue<Pair<Integer,Integer>> q = new LinkedList();
    HashSet<Pair<Integer,Integer>> visited = new HashSet();
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int island = 0;
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(grid[i][j]=='1' && !visited.contains(new Pair<Integer,Integer>(i,j))){
                  q.add(new Pair<Integer,Integer>(i,j));
                  visited.add(new Pair<Integer,Integer>(i,j));
                  island++;
                  makeOneIsland(grid);
              }
          }
      }
        return island;
    }
    
    public void makeOneIsland(char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        while(!q.isEmpty()){
            Pair<Integer,Integer> p = q.poll();
            for(int[] dir : dirs){
                int r = dir[0] + (int)p.getKey();
                int c = dir[1] + (int)p.getValue();
                if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == '1' && !visited.contains(new Pair<Integer,Integer>(r,c))){
                    visited.add(new Pair<Integer,Integer>(r,c));
                    q.add(new Pair<Integer,Integer>(r,c));
                }
            }
        }
        
    }
}
