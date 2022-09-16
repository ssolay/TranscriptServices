export class CheckApiResponse {
  // check the API response to make sure that there isn't an error;
  // if no JSON, then there was a server error, or an interruption with connecting to the server;
  // if the status is `fail`, then the server return a valid response that contained an error;
  isValid (json): boolean {
    return json && json.status !== 'fail';
  }
}
