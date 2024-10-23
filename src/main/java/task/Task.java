package task;

public interface Task {

    String getInput();

    void setInput(String input);

    void execute();

    void setExecutedTime(String executedTime);

    String getResult();
}
