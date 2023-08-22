<%--
  Created by IntelliJ IDEA.
  User: vuquocviet
  Date: 09/06/2023
  Time: 00:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://localhost:3000/css/Fantastic.css">
    <link rel="stylesheet" href="http://localhost:3000/css/LoginLayout.css">
    <link rel="stylesheet" href="http://localhost:3000/css/RootCSS/components.css">
    <style>
        ion-icon{
            color: #dd5;
            height: 2rem;
            width: 2rem;
            --ionicon-stroke-width: 60px;
        }

        .user-icon ion-icon{
            height: 6rem;
            width: 6rem;
            --ionicon-stroke-width: 60px;
        }
    </style>
</head>
<body>
<section id="cursor-1" class="container container-cursor-1">
    <div class=${ "login-layout login-sign-in-layout" }>
        <form class="login-form" action="login" method="post">
            <div class="user-icon">
                <ion-icon name="person-circle-outline" ize="large"></ion-icon>
            </div>
            <div class="account-text-input login-sign-in-form">
                <div>
                    <ion-icon name="person-outline"></ion-icon>
                </div>
                <div>
                    <div class="form">
                        <label> <input
                                class="textBox form__input"
                                name="user-name"
                                type="text"
                                placeholder="user"
                                autocomplete="off"
                        > </label>
                    </div>
                </div>
            </div>
            <div class="account-text-input">
                <div>
                    <ion-icon name="lock-closed-outline"></ion-icon>
                </div>
                <div>
                    <div class="form">
                        <label> <input
                                class="textBox form__input"
                                name="password"
                                type="password"
                                placeholder="password"> </label>
                    </div>
                </div>
            </div>
            <p class="notification"><%=request.getAttribute("err")==null?"":request.getAttribute("err")%>
            </p>
            <button>Login</button>
        </form>
    </div>
</section>
<footer>
    <span class="curzr-hover btn btn-previous">
  </span> <span class="curzr-hover btn btn-next">
  </span>
</footer>
<div class="curzr-arrow-pointer" hidden>
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32">
        <path class="inner" d="M25,30a5.82,5.82,0,0,1-1.09-.17l-.2-.07-7.36-3.48a.72.72,0,0,0-.35-.08.78.78,0,0,0-.33.07L8.24,29.54a.66.66,0,0,1-.2.06,5.17,5.17,0,0,1-1,.15,3.6,3.6,0,0,1-3.29-5L12.68,4.2a3.59,3.59,0,0,1,6.58,0l9,20.74A3.6,3.6,0,0,1,25,30Z" fill="#F2F5F8"></path>
        <path class="outer" d="M16,3A2.59,2.59,0,0,1,18.34,4.6l9,20.74A2.59,2.59,0,0,1,25,29a5.42,5.42,0,0,1-.86-.15l-7.37-3.48a1.84,1.84,0,0,0-.77-.17,1.69,1.69,0,0,0-.73.16l-7.4,3.31a5.89,5.89,0,0,1-.79.12,2.59,2.59,0,0,1-2.37-3.62L13.6,4.6A2.58,2.58,0,0,1,16,3m0-2h0A4.58,4.58,0,0,0,11.76,3.8L2.84,24.33A4.58,4.58,0,0,0,7,30.75a6.08,6.08,0,0,0,1.21-.17,1.87,1.87,0,0,0,.4-.13L16,27.18l7.29,3.44a1.64,1.64,0,0,0,.39.14A6.37,6.37,0,0,0,25,31a4.59,4.59,0,0,0,4.21-6.41l-9-20.75A4.62,4.62,0,0,0,16,1Z" fill="#111920"></path>
    </svg>
</div>
<script src="http://localhost:3000/Script/component/Fantastic.js"></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</body>
</html>
