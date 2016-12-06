package google;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
	class UnionFind2D{
        private int[] id;
        private int[] sz;
        private int m, n, count;
        
        public UnionFind2D(int m, int n){
            this.count = 0;
            this.m = m;
            this.n = n;
            this.id = new int[m * n + 1];
            this.sz = new int[m * n + 1];
        }
        
        public int index(int x, int y){
            return x * n + y + 1;
        }
        
        public int size(){
            return this.count;
        }
        
        public int getID(int x, int y){
            if(x >= 0 && x < m && y >= 0 && y < n){
                return id[index(x,y)];
            }
            return 0;
        }
        
        public boolean sameUnion(int p, int q){
            return root(p) == root(q);
        }
        
        public int add(int x, int y){
            int i = index(x, y);
            id[i] = i;
            sz[i] = 1;
            count++;
            return i;
        }
        
        public void unite(int p, int q){
            int i = root(p);
            int j = root(q);
            if(sz[i] < sz[j]){ // put the smaller one to bigger one
                id[i] = j;
                sz[j] += sz[i];
            }else{
                id[j] = i;
                sz[i] += sz[j];
            }
            count--;
        }
        
        private int root(int i){
            for(; i != id[i]; i=id[i]){
                id[i] = id[id[i]];
            }
            return i;
        }
    }
    
    private int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind2D islands = new UnionFind2D(m, n);
        List<Integer> list = new ArrayList<>();
        for(int[] position : positions){
            int x = position[0];
            int y = position[1];
            int p = islands.add(x, y);
            for(int[] d : dir){
                int q = islands.getID(x + d[0], y + d[1]);
                if(q > 0 && !islands.sameUnion(p, q)){
                    islands.unite(p,q);
                }
            }
            list.add(islands.size());
        }
        return list;
    }
}
