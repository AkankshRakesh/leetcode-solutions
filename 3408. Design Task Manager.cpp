class TaskManager {
    struct Pair {
        int id;
        int prio;
        Pair(int i, int p) : id(i), prio(p) {}
    };

    struct cmp {
        bool operator()(const Pair &a, const Pair &b) const {
            if (a.prio != b.prio)
                return a.prio < b.prio; 
            return a.id < b.id;      
        }
    };

    unordered_map<int, int> taskToUser;
    unordered_map<int, int> changed;  
    priority_queue<Pair, vector<Pair>, cmp> allTasks;

public:
    TaskManager(vector<vector<int>> &tasks) {
        for (auto &t : tasks) {
            int userId = t[0];
            int taskId = t[1];
            int priority = t[2];
            taskToUser[taskId] = userId;
            changed[taskId] = priority;
            allTasks.push(Pair(taskId, priority));
        }
    }

    void add(int userId, int taskId, int priority) {
        taskToUser[taskId] = userId;
        changed[taskId] = priority;
        allTasks.push(Pair(taskId, priority));
    }

    void edit(int taskId, int newPriority) {
        changed[taskId] = newPriority;
        allTasks.push(Pair(taskId, newPriority));
    }

    void rmv(int taskId) {
        changed[taskId] = -1; 
    }

    int execTop() {
        while (!allTasks.empty() &&
               allTasks.top().prio != changed[allTasks.top().id]) {
            allTasks.pop();
        }

        if (allTasks.empty()) return -1;

        Pair p = allTasks.top();
        allTasks.pop();
        changed[p.id] = -1; 
        return taskToUser[p.id];
    }
};
