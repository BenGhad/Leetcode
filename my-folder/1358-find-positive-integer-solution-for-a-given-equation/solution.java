/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction cf, int z) {
        int x = 1;
        int y = 1000;
        List<List<Integer>> list = new ArrayList<>();

        while(x <= 1000 && y >= 1){
            int v = cf.f(x, y);
            if(v < z){
                x++;
            } else if (v > z){
                y--;
            } else {
                list.add(Arrays.asList(x++, y--));
            }
        }

        return list;
    }
}
