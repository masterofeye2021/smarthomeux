
/**
 * @brief Connect ot the SMARTUX websocket to retrieve updates from Openhab. 
 * */
function connect() {
  var socket = new SockJS("/smartux");
  stompClient = Stomp.over(socket);
  stompClient.reconnect_delay = 5000;
  stompClient.connect({}, onConnected, onError);
}

/**
 * @brief Sofern wir uns mit dem Websocket verbinden konnten, werden die Subscribens durchführt.
 *        Dafür besitzt die View eine Liste aber Openhab Item Tags die für die jeweilige View von Interesse sind. 
 */
function onConnected() {

  listOfTagsToSubscribe.forEach((value) => {
    stompClient.subscribe("/ItemStateChangedEvent/" + value, callback);

  });
}

function onMessageReceived(event) {
  console.log(event);
}

function onError(error) {
  connectingElement.textContent =
    "Could not connect to WebSocket server. Please refresh this page to try again!";
  connectingElement.style.color = "red";
}

function sendMessage(event) {
  var messageContent = messageInput.value.trim();
  if (messageContent && stompClient) {
    var chatMessage = {
      sender: username,
      content: messageInput.value,
      type: "CHAT",
    };
    stompClient.send("/app/sendMessage", {}, JSON.stringify(chatMessage));
    messageInput.value = "";
  }
  event.preventDefault();
}

connect();
