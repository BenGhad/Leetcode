/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int start) {
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        int ans = 0;

        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            Employee e = map.get(queue.poll());
            ans += e.importance;
            for(int sub : e.subordinates){
                queue.offer(sub);
            }
        }
        
        
        return ans;
    }
}
