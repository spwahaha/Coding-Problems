package fb;
import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        boolean[][] matrix = new boolean[numCourses][numCourses];
        for(int[] requi : prerequisites){
            int first = requi[1];
            int then = requi[0];
            if(matrix[first][then]) continue;
            matrix[first][then] = true;
            indegree[then]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int index = 0;
        while(!q.isEmpty()){
            int take = q.poll();
            res[index++] = take;
            for(int i = 0; i < numCourses; i++){
                if(matrix[take][i]){
                    indegree[i]--;
                    if(indegree[i] == 0) q.add(i);
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
}
