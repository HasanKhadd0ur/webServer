this project is a homework in the paralell processing course.
---

# Multi-Threaded Java web Server

This project contain two types of multi-threaded web servers, both equipped with thread-pooling capabilities, designed to efficiently execute a variety of simple tasks.


## Project Structure

- **Handler**: Manages incoming HTTP requests and routes them to the appropriate task.
- **Tasks**: Defines individual tasks, each implementing a generic task interface for consistent handling.
- **TaskExecutor**: Executes the specified task by dynamically instantiating it and processing the input.


## How to Run

### Running the Server Locally

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/task-manager-server.git
    cd task-manager-server
    ```

2. **Compile and Run the Project**:
    - Use your preferred Java IDE or run from the terminal:
    ```bash
    javac -d bin -sourcepath src src/main/WebServerHttp.java
    java -cp bin main.WebServerHttp
    ```
    - The server will start on port `8000`.

### Running with Docker

1. **Build the Docker Image**:
    ```bash
    docker build -t task-manager-server .
    ```

2. **Run the Docker Container**:
    ```bash
    docker run -p 8000:8000 task-manager-server
    ```

    The server will now be available on `localhost:8000`.

## Sending Requests

You can use `curl` to send requests to the server. The server supports `POST` requests for executing tasks and `GET` requests to view the list of completed tasks.

### Example Requests

- **Geometric Mean Task**:
    ```bash
    curl -X POST http://localhost:8000 -d "TaskGeometricMean&1,2,3,4,5"
    ```

- **Bubble Sort Task**:
    ```bash
    curl -X POST http://localhost:8000 -d "TaskBubbleSort&5,3,8,1,2"
    ```


## the new  Tasks

- **TaskGeometricalMean**: Calculate the Geometrical Mean : Geo-Mean = (a<sub>1</sub> × a<sub>2</sub> × ... × a<sub>n</sub>)<sup>1/n</sup>.


- **TaskPrimeNumberFinder**: Finds prime numbers up to a specified limit.


## Requirements

- **Java 8** or higher
- **curl** (for command-line requests)
- **K6** (for test parallel requests)

## Testing

You can test the server's performance and concurrency with the tool **K6**. by running the follwoing commands on the K6TestScripts folder 

``` bash
k6 run testParallelTasks.js
```

``` bash
k6 run testHeavyTask.js
```

``` bash
k6 run testSingleTaskResponse.js
```


## License

This project is open-source and available under the MIT License.

--- 


