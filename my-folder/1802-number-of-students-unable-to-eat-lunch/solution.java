class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ptr = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i : students){
            queue.offer(i);    
        }
        
        int count = 0;
        int len = students.length;
        while(!queue.isEmpty()){
            int s = queue.poll();
            if(sandwiches[ptr] == s){
                len--;
                ptr++;
                count = 0;
            } else {
                queue.offer(s);
                count++;
                if(count == len) return len;
            }
            
        }
                
    
        
        return 0;
    }
}
