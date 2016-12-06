package fb;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	
	/*
	 * Topological sort
	 * matrix[i][j] means first take i and then take j
	 * every time take the course that in degree is 0
	 * and then update other courses' in degree  
	 */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        boolean[][] matrix = new boolean[n][n];
        // matrix[i][j] means i -> j, first take i then take j
        for(int[] nums : prerequisites){
            matrix[nums[1]][nums[0]] = true;
        }
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            // indegree[i]
            for(int j = 0; j < n; j++){
                indegree[i] += matrix[j][i] ? 1 : 0;
            }
            if(indegree[i] == 0) q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            cnt++;
            int course = q.poll();
            for(int i = 0;  i < n; i++){
                if(matrix[course][i]){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        q.add(i);
                    }
                }
            }
        }
        return cnt == n;
    }
    
    /*
     * detect cycle, different from the above one when construct the matrix
     * matrix[i][j], mean first take the j and then take i
     * may be 2 -> 1
     *         \
     *          0
     * this means need to first take 0 and 1 to take 2
     * so, traverse(DFS) from 2, then 0 and 1 
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        boolean[][] matrix = new boolean[n][n];
        for(int[] nums : prerequisites){
            // pre: nums[1], then, nums[0]
            matrix[nums[0]][nums[1]] = true;
        }
        int[] canFinish = new int[n]; // 0: unknown, 1: yes, -1: no
        for(int i = 0; i < n; i++){
            if(!canFinish(n, i, matrix, new boolean[n], canFinish)) return false;
        }
        return true;
    }
    
    private boolean canFinish(int n, int start, boolean[][] matrix, boolean[] visited, int[] canFinish){
        if(canFinish[start] == 1) return true;
        if(canFinish[start] == -1) return false;
        if(visited[start]) return false;
        visited[start] = true;
        for(int i = 0; i < n; i++){
            if(matrix[start][i]){
                if(!canFinish(n, i, matrix, visited, canFinish)){
                    canFinish[start] = -1;
                    return false;
                } 
            }
        }
        visited[start] = false;
        canFinish[start] = 1; 
        return true;
    }
}
