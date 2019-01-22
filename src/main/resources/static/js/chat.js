var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected); //將id = connect 按鈕屬性改為disabled
    $("#disconnect").prop("disabled", !connected);  //將id = disconnect 按鈕屬性改為disabled
    if (connected) {
        $("#conversation").show();  //當連接上Websocket id = conversation 顯示
    } else {
        $("#conversation").hide(); // 將 conversation隱藏
    }
    $("#chatRoom").html(""); //將chatRoom內容清空
}

//連結WebSocket方法
function connect() {
    var socket = new SockJS('/endpointChatRoom'); //建立一個socket物件 名稱為:/endpointChatRoom
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/getResponse', function (response) {
            console.log(response)
            showConversation(JSON.parse(response.body).responseMessage); //
        });
    });
}

//關閉WebSocket方法
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

//傳送訊息方法
function sendName() {
    var name = $("#name").val()
    console.log(name);
    console.log(stompClient);
    stompClient.send("/messageControl", {}, JSON.stringify({'name': name}));
}

//顯示接收回來的訊息方法
function showConversation(responseMessage) {
    $("#chatRoom").append("<tr><td>" + responseMessage + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});