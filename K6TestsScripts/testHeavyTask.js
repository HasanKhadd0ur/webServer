import http from 'k6/http';
import { check } from 'k6';
import { sleep } from 'k6';

// Define test configuration
export let options = {
    vus: 100, // Number of virtual users (parallel requests)
    duration: '30s', // Duration to run the test
};

export default function () {

    // Define The target  Java server URL 
    const url = 'http://localhost:8000/';

		
    // Get a random task and input
    const task =     { taskName: 'TaskPrimeNumbers', input: '100000' };

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

    // wait for 1 second between requests
    sleep(0.4);
}
