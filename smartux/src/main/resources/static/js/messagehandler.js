function connect() {
  var socket = new SockJS("/smartux");
  stompClient = Stomp.over(socket);
  stompClient.reconnect_delay = 5000;
  stompClient.connect({}, onConnected, onError);


}

function onConnected() {


  console.log(stringArray)


  // Subscribe to the Public Topic

  stringArray.forEach(value => {
    console.log("/ItemStateChangedEvent/"+ value)
    stompClient.subscribe("/ItemStateChangedEvent/"+ value, (message) => {
      console.log("message.body");
});});
  // Tell your username to the server
  /*stompClient.send(
    "/app/addUser",
    {},
    JSON.stringify({ sender: username, type: "JOIN" })
  );*/

  
}

function onMessageReceived(event)
{
  console.log(event)
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