class TaskManager {
    class Pair{
        int id;
        int prio;
        public Pair(int id, int prio){
            this.id = id;
            this.prio = prio;
        }
    }
    // HashMap<Integer, PrioirtyQueue<Integer>> hm = new HashMap<>();
    HashMap<Integer, Integer> taskToUser = new HashMap<>();
    HashMap<Integer, Integer> changed = new HashMap<>();
    PriorityQueue<Pair> allTasks = new PriorityQueue<>((a, b) -> a.prio != b.prio ? Integer.compare(b.prio, a.prio) : Integer.compare(b.id, a.id));

    public TaskManager(List<List<Integer>> tasks) {
        for(int i = 0; i < tasks.size(); i++){
            int userId = tasks.get(i).get(0);
            int taskId = tasks.get(i).get(1);
            int priority = tasks.get(i).get(2);
            taskToUser.put(taskId, userId);
            changed.put(taskId, priority);
            allTasks.offer(new Pair(taskId, priority));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskToUser.put(taskId, userId);
        changed.put(taskId, priority);
        allTasks.offer(new Pair(taskId, priority));
    }
    
    public void edit(int taskId, int newPriority) {
        changed.put(taskId, newPriority);
        allTasks.offer(new Pair(taskId, newPriority));
    }
    
    public void rmv(int taskId) {
        changed.put(taskId, -1);
    }
    
    public int execTop() {
        while(!allTasks.isEmpty() && allTasks.peek().prio != changed.get(allTasks.peek().id)) allTasks.poll();

        if(allTasks.isEmpty()) return -1;
        Pair p = allTasks.poll();
        changed.put(p.id, -1);
        return taskToUser.get(p.id);
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