this project is a homework in the paralell processing course.
---

# Multi-Threaded Java HTTP Server

This project contain two types of multi-threaded web servers, both equipped with thread-pooling capabilities, designed to efficiently execute a variety of simple tasks.


## Project Structure

- **Handler**: Manages incoming HTTP requests and routes them to the appropriate task.
- **Tasks**: Defines individual tasks, each implementing a generic task interface for consistent handling.
- **TaskExecutor**: Executes the specified task by dynamically instantiating it and processing the input.



## Usage

1. **Start the Server**: Compile and run the main server file to start listening for HTTP requests.
2. **Make Requests**:
   - **GET Request**: Retrieves a list of completed tasks.
   - **POST Request**: Sends a task request with parameters. Example using `curl`:
     ```bash
     curl -X POST http://localhost:8000/ -d "TaskSimulateDownload&5000"
     ```
   - Replace `TaskSimulateDownload&5000` with the desired task and input.

## the new  Tasks

- **TaskGeometricalMean**: Calculate the Geometrical Mean : Geo-Mean=(a_1*a_2*…*a_n  )^(1/n)=√(n&a_1*a_2* ..*a_n ).
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
