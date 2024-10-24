import http from 'k6/http';
import { check } from 'k6';

export const options = {
  vus: 1, // 1 virtual user
  duration: '10s', // test for 10 seconds
};

export default function () {

    // Define The target  Java server URL
  const url = 'http://localhost:8000';


  // Define the payload
  const payload = 'TaskBubbleSort&1,5,3,4,2';

  // Send the POST request
  const res = http.post(url, payload);

  // Log the response
  //console.log('Response body: ' + res.body);

  // Check the status and result
  check(res, {
    'status is 200': (r) => r.status === 200,
    'result is correct': (r) => r.body.includes('[1,2,3,4,5]'), // Expected output of sorting task
  });
}
