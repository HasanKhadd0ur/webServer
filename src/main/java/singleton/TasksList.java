package singleton;

import task.Task;

import java.util.ArrayList;
import java.util.List;

public enum TasksList {

    //Singleton
    INSTANCE;

    private List<Task> tasks;

    TasksList() {
        tasks = new ArrayList<>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public String list() {
        StringBuilder stringBuilder = new StringBuilder();
        tasks.forEach(task -> stringBuilder.append(task));
        return stringBuilder.toString();
    }
}
