// 현재시간 관련 js
Date.prototype.yyyymmdd = function() {
  const yyyy = this.getFullYear();
  const MM = this.getMonth() < 9 ? `0${this.getMonth() + 1}` : this.getMonth()+1;
  const dd = this.getDate() < 10 ? `0${this.getDate()}` : this.getDate();
  const HH = this.getHours();
  const mm = this.getMinutes();

  return '' + yyyy + '-' + MM + '-' + dd + ' ' + HH + ':' + mm;
}

const date= new Date();
console.log(date);
/* Thu Dec 15 2022 15:21:08 GMT+0900 (한국 표준시) */

console.log(date.yyyymmdd());
/* 20221215 */

// 채팅 관련 js
var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    $("#send").prop("disabled", !connected);
    if (connected) {
        $("#conversation2").show();
    }
    else {
        $("#conversation2").hide();
    }
    $("#msg").html("");
}

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/public', function (message) {
            showMessage("<div class=\"card bg-white border-light p-4 mb-4 chatbubble\"><div class=\"d-flex justify-content-between align-items-center mb-2\">" 
            + "<span class=\"font-weight-bolder font-medium\">챗봇</span>" + "<span class=\"ml-2 font-small\">" 
            + date.yyyymmdd() + "</span></div><p class=\"m-0 font-weight-normal\">" + message.body + "</p></div>"); //서버에 메시지 전달 후 리턴받는 메시지
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    let message = $("#msg").val()
    let loginMember = $("#loginMember").val()
    showMessage("<div class=\"card bg-primary text-white border-light p-4 ml-lg-9 mb-4 chatbubble\"><div class=\"d-flex justify-content-between align-items-center mb-2\">"
    			 + "<span class=\"font-weight-bolder font-medium\">" + loginMember + "</span>" + "<span class=\"ml-2 font-small\">"
    			 + date.yyyymmdd() + "</span></div><p class=\"m-0 font-weight-normal\">" + message + "</p></div>");
    stompClient.send("/app/sendMessage", {}, JSON.stringify(message)); //서버에 보낼 메시지
}

function sendMessage2(id) {
    let message = $("#linkBtn"+id).val();
	let loginMember = $("#loginMember").val()
    showMessage("<div class=\"card bg-primary text-white border-light p-4 ml-lg-9 mb-4 chatbubble\"><div class=\"d-flex justify-content-between align-items-center mb-2\">"
    			 + "<span class=\"font-weight-bolder font-medium\">" + loginMember + "</span>" + "<span class=\"ml-2 font-small\">"
    			 + date.yyyymmdd() + "</span></div><p class=\"m-0 font-weight-normal\">" + message + "</p></div>");
    stompClient.send("/app/sendMessage", {}, JSON.stringify(message)); //서버에 보낼 메시지
}

function showMessage(message) {
//    $("#communicate").append("<tr><td>" + message + "</td></tr>");
    $("#communicate2").append("<div>" + message + "</div>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
});