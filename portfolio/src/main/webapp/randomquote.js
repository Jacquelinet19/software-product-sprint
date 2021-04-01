/** Fetches the current date from the server and adds it to the page. */
async function randomquote() {
  const responseFromServer = await fetch('/randomquote');
  const textFromResponse = await responseFromServer.json();
  console.log(textFromResponse)

  const quote = textFromResponse[Math.floor(Math.random() * textFromResponse.length)];
  const randomQuoteContainer = document.getElementById('random-quote-container');
  randomQuoteContainer.innerHTML = quote;
}