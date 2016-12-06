package google;

public class UnionFind2D {
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
