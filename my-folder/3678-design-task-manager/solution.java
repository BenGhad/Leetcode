class TaskManager {
    Map<Integer, Integer> priorities = new HashMap<>();
    Map<Integer, Integer> task2User = new HashMap<>();

    TreeSet<Integer> tasks = new TreeSet<>((a, b) -> {
    // 1) compare by priority
    int cmp = Integer.compare(priorities.get(a), priorities.get(b));
    if (cmp != 0) return cmp;
    // 2) compare the task ID
    return Integer.compare(a, b);
    });

    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> task : tasks){
            int user = task.getFirst();
            int tId = task.get(1);
            int p = task.get(2);

            priorities.put(tId, p);
            task2User.put(tId, user);
            
            this.tasks.add(tId);
        }    
    }
    
    public void add(int userId, int taskId, int priority) {
        task2User.put(taskId, userId);
        priorities.put(taskId, priority);

        tasks.add(taskId);
    }
    
    public void edit(int taskId, int newPriority) {
        tasks.remove(taskId);
        priorities.put(taskId, newPriority);

        tasks.add(taskId);
    }
    
    public void rmv(int taskId) {
        tasks.remove(taskId);

        priorities.remove(taskId);
        task2User.remove(taskId);
    }
    
    public int execTop() {
        if(tasks.isEmpty()) return -1;
        return task2User.get(tasks.pollLast());
    }
    
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
