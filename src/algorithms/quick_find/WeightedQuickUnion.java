package algorithms.quick_find;

import java.util.*;

/**
 * This is a quick implementation of the quick-find algorithm
 * We use weighted trees to keep the tree flat
 * To enhance the flatness we also get the roots to always point to their grandparents
 * This way we get a logarithmic find with an iterative logarithmic time (1-5 array accesses) for the union
 */
public class WeightedQuickUnion {

    // array of the roots of each object
    private int[] ids;
    // sizes of trees
    private int[] sizes;

    /**
     * Initialization step for the ids to contain their respective object id's
     * @param n number of objects
     */
    public WeightedQuickUnion(int n){
        ids = new int[n];
        sizes = new int[n];
        for(int i = 0; i < n; i++){
            ids[i] = i;
            sizes[i] = 1;
        }
    }

    /**
     * Check if object p and object q are connected
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    /**
     * Gets the root and flattens the tree
     * @param i
     * @return root of i
     */
    public int root(int i){
        while(i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    /**
     * Append the shorter tree to the longer one
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(sizes[i] > sizes[j]){
            ids[j] = i;
            sizes[i] += sizes[j];
        } else {
            ids[i] = j;
            sizes[j] += sizes[i];
        }
    }

    /**
     * Get all connected components
     * @return list of lists of connected ids
     */
    public Collection<List<Integer>> connectedComponents(){
        Map<Integer, List<Integer>> components = new HashMap<>();

        for(int i = 0; i < ids.length; i++){
            components.putIfAbsent(ids[i], new ArrayList<Integer>());
            components.get(ids[i]).add(i);
        }
        return components.values();
    }

    public static void main(String[] args) {
        WeightedQuickUnion test = new WeightedQuickUnion(9);
        test.union(1, 2);
        test.union(2,3);
        System.out.println(test.connected(1,2));
        System.out.println(test.connected(0,1));
        System.out.println(test.connected(1,3));
        System.out.println(test.connectedComponents());
    }

}
