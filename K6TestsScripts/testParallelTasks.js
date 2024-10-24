import http from 'k6/http';
import { check } from 'k6';
import { sleep } from 'k6';

// Define test configuration
export let options = {
    vus: 100, // Number of virtual users (parallel requests)
    duration: '60s', // Duration to run the test
};

// Array of task names and  inputs
const tasks = [
    { taskName: 'TaskBubbleSort', input: '4,1,3,2,5' },
    { taskName: 'TaskSum', input: '9,3,7,1,6' },
    { taskName: 'TaskFactorial', input: '5' },
    { taskName: 'TaskPrimeNumbers', input: '28799' },
    { taskName: 'TaskFibonacci', input: '10' },
    { taskName: 'TaskGeometricMean', input: '2,3,4,5' },
];

function getRandomTask() {
    let randomIndex = Math.floor(Math.random() * tasks.length);
    return tasks[randomIndex];
}

export default function () {

    // Define The target  Java server URL 
    const url = 'http://localhost:8000/';

		
    // Get a random task and input
    const task = getRandomTask();

    const payload = `${task.taskName}&${task.input}`;

    // Define request headers
    const params = {
        headers: {
            'Content-Type': 'application/plain-text',
        },
    };

    // Send POST request with random task and input
    let res = http.post(url, payload, params);

    // Check if the request succeeded (HTTP status 200)
    check(res, {
        'status was 200': (r) => r.status === 200,
    });

    // wait for 0.4 second between requests
    sleep(0.4);
}
