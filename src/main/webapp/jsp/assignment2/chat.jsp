<%@ page import="assignment2.User" %><%--
  Created by IntelliJ IDEA.
  User: rakhad
  Date: 1/17/21
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chat</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    <style type="text/css">
        body{
            background:#eee;
        }
        .chat-list {
            padding: 0;
            font-size: .8rem;
            height: 400px;
        }

        .chat-list li {
            margin-bottom: 10px;
            overflow: auto;
            color: #ffffff;
        }

        .chat-list .chat-img {
            float: left;
            width: 48px;
        }

        .chat-list .chat-img img {
            -webkit-border-radius: 50px;
            -moz-border-radius: 50px;
            border-radius: 50px;
            width: 100%;
        }

        .chat-list .chat-message {
            -webkit-border-radius: 50px;
            -moz-border-radius: 50px;
            border-radius: 50px;
            background: #5a99ee;
            display: inline-block;
            padding: 10px 20px;
            position: relative;
        }

        .chat-list .chat-message:before {
            content: "";
            position: absolute;
            top: 15px;
            width: 0;
            height: 0;
        }

        .chat-list .chat-message h5 {
            margin: 0 0 5px 0;
            font-weight: 600;
            line-height: 100%;
            font-size: .9rem;
        }

        .chat-list .chat-message p {
            line-height: 18px;
            margin: 0;
            padding: 0;
        }

        .chat-list .chat-body {
            margin-left: 20px;
            float: left;
            width: 70%;
        }

        .chat-list .in .chat-message:before {
            left: -12px;
            border-bottom: 20px solid transparent;
            border-right: 20px solid #5a99ee;
        }

        .chat-list .out .chat-img {
            float: right;
        }

        .chat-list .out .chat-body {
            float: right;
            margin-right: 20px;
            text-align: right;
        }

        .input-group {
            position: absolute;
            bottom: 0;
            left: 0;
            padding: 0px 16px;
        }

        .chat-list .out .chat-message {
            background: #fc6d4c;
        }

        .chat-list .out .chat-message:before {
            right: -12px;
            border-bottom: 20px solid transparent;
            border-left: 20px solid #fc6d4c;
        }

        .card {
            height: 600px;
            width: 500px;
        }

        .card .card-header:first-child {
            -webkit-border-radius: 0.3rem 0.3rem 0 0;
            -moz-border-radius: 0.3rem 0.3rem 0 0;
            border-radius: 0.3rem 0.3rem 0 0;
        }
        .card .card-header {
            background: #17202b;
            border: 0;
            font-size: 1rem;
            padding: .65rem 1rem;
            position: relative;
            font-weight: 600;
            color: #ffffff;
        }

        .content{
            margin-top:40px;
            display: flex;
            justify-content: center;
        }
    </style>
</head>
<body>
<div class="container content">
    <div class="card">
        <div class="card-header">Chat</div>
        <div class="card-body">
            <ul class="chat-list" id="chatList"></ul>
            <div class="input-group mb-3 ">
                <textarea class="form-control" placeholder="Write a message..." aria-label="Message" aria-describedby="buttonSend" name="content" id="inputMessage"></textarea>
                <button class="btn btn-outline-primary" type="button" id="buttonSend">Send</button>
            </div>
        </div>
    </div>
    <script>
        let chatUnit = {
            init(){
                this.inputMessage = document.getElementById("inputMessage")
                this.buttonSend = document.getElementById("buttonSend")
                this.chatList = document.getElementById("chatList");
                this.bindEvents()
                this.buttonSend.addEventListener("click", (e) => {
                    e.preventDefault();
                    if (this.inputMessage.value === ""){
                        alert("You are trying to send an empty message")
                        return
                    }
                    this.send()
                    this.inputMessage.value = ""
                })
                this.inputMessage.addEventListener("keyup", e => {
                    if (e.ctrlKey){
                        e.preventDefault()
                        if (this.inputMessage.value === ""){
                            alert("You are trying to send an empty message")
                            return
                        }
                        this.send()
                        this.inputMessage.value = ""
                    }
                })
            },
            bindEvents(){
                this.openSocket();
            },
            send(){
                this.sendMessage({
                    username: this.username,
                    text: this.inputMessage.value
                })
            },
            onOpenSocket(){

            },
            onMessage(msg){
                let chatList = document.getElementById("chatList");
                let messageItem = document.createElement("li");
                if (msg.username === "You")
                    messageItem.className = "out"
                else
                    messageItem.className = "in"
                let avaContainer = document.createElement("div");
                avaContainer.className = "chat-img";
                let ava = document.createElement("img");
                ava.src = "https://bootdey.com/img/Content/avatar/avatar1.png";
                let chatBody = document.createElement("div");
                chatBody.className = "chat-body";
                let chatMessage = document.createElement("div");
                chatMessage.className = "chat-message"
                let author = document.createElement("h5");
                let text = document.createElement("p");
                author.innerText = msg.username
                text.innerText = msg.text
                chatMessage.appendChild(author)
                chatMessage.appendChild(text)
                chatBody.appendChild(chatMessage)
                avaContainer.appendChild(ava)
                messageItem.appendChild(avaContainer)
                messageItem.appendChild(chatBody)
                this.chatList.appendChild(messageItem)
            },
            onClose(){

            },
            sendMessage(msg){
                this.onMessage({
                    username: "You",
                    text: msg.text
                })
                this.ws.send(JSON.stringify(msg))
            },
            openSocket(){
                this.ws = new WebSocket("ws://localhost:8088/first_servlet_project_war/chat")
                this.username = "<%=((User) session.getAttribute("user")).getUsername()%>"
                this.ws.onopen = () => this.onOpenSocket()
                this.ws.onmessage = (e) => this.onMessage(JSON.parse(e.data))
                this.ws.onclose = () => this.onClose();
            },

        }
        window.addEventListener("load", e => chatUnit.init())
    </script>
</div>
</body>
</html>