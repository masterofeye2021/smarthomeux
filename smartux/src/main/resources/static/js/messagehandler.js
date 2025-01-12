
/**
 * @brief Connect ot the SMARTUX websocket to retrieve updates from Openhab. 
 * */
function connect() {
  var socket = new SockJS("/smartux");
  this.stompClient = Stomp.over(socket);
  this.stompClient.reconnect_delay = 5000;
  this.stompClient.connect({}, onConnected, onError);
  //this.stompClient.debug = () => {}
}

/**
 * @brief Sofern wir uns mit dem Websocket verbinden konnten, werden die Subscribens durchführt.
 *        Dafür besitzt die View eine Liste aber Openhab Item Tags die für die jeweilige View von Interesse sind. 
 */
function onConnected() {
  Object.entries(listOfTagsToSubscribe).forEach(([key, value]) => {
    stompClient.subscribe("/ItemStateChangedEvent/" + value, ItemStateChangedEventCallback);
    stompClient.subscribe("/ItemStateUpdatedEvent/" + value, ItemStateUpdatedEventCallback);
  });
}

function getLastPartOfString(input) {
  if (typeof input !== "string") {
    throw new Error("Eingabe muss ein String sein");
  }

  // String nach '/' splitten und letztes Element zurückgeben
  const parts = input.split("/");
  return parts[parts.length - 1];
}

ItemStateChangedEventCallback = function (message) {
  // called when the client receives a STOMP message from the server
  const topic = getLastPartOfString(message.headers.destination);
  const payload = JSON.parse(message.body);
  const date = new Date(Date.now());
  const timestamp = date.toLocaleDateString('de-DE', {
    day: "2-digit",
    month: "2-digit",
    year: "numeric",
    hour: "2-digit",
    minute: "2-digit",
    second: "2-digit",
    hour12: false
  });

  switch (topic) {
    case "TKR_R_NTP_Datetime":
      window["TKR_R_NTP_Datetime_Handle"](payload.value);
      console.log("topic: " + topic + " value: " + payload.value + " timestamp: " + timestamp);
      break;
    default:
      try {
        const value = JSON.parse(payload.value);
        $("#" + topic).html(value.value);
        $("#" + topic).attr("data-timestamp", timestamp);
        $("#" + topic + "-timedate").html(timestamp);
        console.log("topic: " + topic + " value: " + value.value + " timestamp: " + timestamp);
      } catch (e) {
        $("#" + topic).html(payload.value);
        $("#" + topic).attr("data-timestamp", timestamp);
        $("#" + topic + "-timedate").html(timestamp);
        console.log("topic: " + topic + " value: " + payload.value + " timestamp: " + timestamp);
      }
  }
};


ItemStateUpdatedEventCallback = function (message) {
  // called when the client receives a STOMP message from the server
  const topic = getLastPartOfString(message.headers.destination);
  const payload = JSON.parse(message.body);
  const date = new Date(Date.now());
  const timestamp = date.toLocaleDateString('de-DE', {
    day: "2-digit",
    month: "2-digit",
    year: "numeric",
    hour: "2-digit",
    minute: "2-digit",
    second: "2-digit",
    hour12: false
  });

  switch (topic) {
    case "TKR_R_NTP_Datetime":
      window["TKR_R_NTP_Datetime_Handle"](payload.value);
      console.log("topic: " + topic + " value: " + payload.value + " timestamp: " + timestamp);
      break;
    default:
      try {
        const value = JSON.parse(payload.value);
        $("#" + topic).html(value.value);
        $("#" + topic).attr("data-timestamp", timestamp);
        $("#" + topic + "-timedate").html(timestamp);
        console.log("topic: " + topic + " value: " + value.value + " timestamp: " + timestamp);
      } catch (e) {
        $("#" + topic).html(payload.value);
        $("#" + topic).attr("data-timestamp", timestamp);
        $("#" + topic + "-timedate").html(timestamp);
        console.log("topic: " + topic + " value: " + payload.value + " timestamp: " + timestamp);
      }
  }
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
