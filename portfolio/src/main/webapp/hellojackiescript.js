/** Fetches the current date from the server and adds it to the page. */
async function hellojackie() {
  const responseFromServer = await fetch('/hellojackie');
  const textFromResponse = await responseFromServer.text();

  const helloContainer = document.getElementById('hello-jackie-container');
  helloContainer.innerText = textFromResponse;
}
