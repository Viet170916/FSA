<%@ page import="Models.Entities.User" %>
<%@ page import="Models.Entities.Student" %><%--
  Created by IntelliJ IDEA.
  User: vuquocviet
  Date: 22/06/2023
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="http://localhost:3000/css/Home.css">
    <link rel="stylesheet" href="http://localhost:3000/css/Fantastic.css">
    <link rel="stylesheet" href="http://localhost:3000/css/RootCSS/components.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <style>
        .is-red{
            color: #d14b69!important;
        }
        .is-green{
            color: #1aa385!important;
        }
    </style>
</head>
<body>
<section id="cursor-1" class="container container-cursor-1">
    <div class="wrapper">
        <div class="left-side" id="root">
            <svg viewBox="0 0 512 512" fill="currentColor" xmlns="http://www.w3.org/2000/svg" class="active">
                <path d="M197.3 170.7h-160A37.4 37.4 0 010 133.3v-96A37.4 37.4 0 0137.3 0h160a37.4 37.4 0 0137.4 37.3v96a37.4 37.4 0 01-37.4 37.4zM37.3 32c-3 0-5.3 2.4-5.3 5.3v96c0 3 2.4 5.4 5.3 5.4h160c3 0 5.4-2.4 5.4-5.4v-96c0-3-2.4-5.3-5.4-5.3zm0 0M197.3 512h-160A37.4 37.4 0 010 474.7v-224a37.4 37.4 0 0137.3-37.4h160a37.4 37.4 0 0137.4 37.4v224a37.4 37.4 0 01-37.4 37.3zm-160-266.7c-3 0-5.3 2.4-5.3 5.4v224c0 3 2.4 5.3 5.3 5.3h160c3 0 5.4-2.4 5.4-5.3v-224c0-3-2.4-5.4-5.4-5.4zm0 0M474.7 512h-160a37.4 37.4 0 01-37.4-37.3v-96a37.4 37.4 0 0137.4-37.4h160a37.4 37.4 0 0137.3 37.4v96a37.4 37.4 0 01-37.3 37.3zm-160-138.7c-3 0-5.4 2.4-5.4 5.4v96c0 3 2.4 5.3 5.4 5.3h160c3 0 5.3-2.4 5.3-5.3v-96c0-3-2.4-5.4-5.3-5.4zm0 0M474.7 298.7h-160a37.4 37.4 0 01-37.4-37.4v-224A37.4 37.4 0 01314.7 0h160A37.4 37.4 0 01512 37.3v224a37.4 37.4 0 01-37.3 37.4zM314.7 32c-3 0-5.4 2.4-5.4 5.3v224c0 3 2.4 5.4 5.4 5.4h160c3 0 5.3-2.4 5.3-5.4v-224c0-3-2.4-5.3-5.3-5.3zm0 0"></path>
            </svg>
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round">
                <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
            </svg>
            <svg viewBox="0 1 511 512" fill="currentColor">
                <path d="M498.7 222.7L289.8 13.8a46.8 46.8 0 00-66.7 0L14.4 222.6l-.2.2A47.2 47.2 0 0047 303h8.3v153.7a55.2 55.2 0 0055.2 55.2h81.7a15 15 0 0015-15V376.5a25.2 25.2 0 0125.2-25.2h48.2a25.2 25.2 0 0125.1 25.2V497a15 15 0 0015 15h81.8a55.2 55.2 0 0055.1-55.2V303.1h7.7a47.2 47.2 0 0033.4-80.4zm-21.2 45.4a17 17 0 01-12.2 5h-22.7a15 15 0 00-15 15v168.7a25.2 25.2 0 01-25.1 25.2h-66.8V376.5a55.2 55.2 0 00-55.1-55.2h-48.2a55.2 55.2 0 00-55.2 55.2V482h-66.7a25.2 25.2 0 01-25.2-25.2V288.1a15 15 0 00-15-15h-23A17.2 17.2 0 0135.5 244L244.4 35a17 17 0 0124.2 0l208.8 208.8v.1a17.2 17.2 0 010 24.2zm0 0"></path>
            </svg>
            <svg viewBox="0 0 512 512" fill="currentColor">
                <path d="M467 76H45a45 45 0 00-45 45v270a45 45 0 0045 45h422a45 45 0 0045-45V121a45 45 0 00-45-45zm-6.3 30L287.8 278a44.7 44.7 0 01-63.6 0L51.3 106h409.4zM30 384.9V127l129.6 129L30 384.9zM51.3 406L181 277.2l22 22c14.2 14.1 33 22 53.1 22 20 0 38.9-7.9 53-22l22-22L460.8 406H51.3zM482 384.9L352.4 256 482 127V385z"></path>
            </svg>
            <svg viewBox="0 0 512 512" fill="currentColor">
                <path d="M272 512h-32c-26 0-47.2-21.1-47.2-47.1V454c-11-3.5-21.8-8-32.1-13.3l-7.7 7.7a47.1 47.1 0 01-66.7 0l-22.7-22.7a47.1 47.1 0 010-66.7l7.7-7.7c-5.3-10.3-9.8-21-13.3-32.1H47.1c-26 0-47.1-21.1-47.1-47.1v-32.2c0-26 21.1-47.1 47.1-47.1H58c3.5-11 8-21.8 13.3-32.1l-7.7-7.7a47.1 47.1 0 010-66.7l22.7-22.7a47.1 47.1 0 0166.7 0l7.7 7.7c10.3-5.3 21-9.8 32.1-13.3V47.1c0-26 21.1-47.1 47.1-47.1h32.2c26 0 47.1 21.1 47.1 47.1V58c11 3.5 21.8 8 32.1 13.3l7.7-7.7a47.1 47.1 0 0166.7 0l22.7 22.7a47.1 47.1 0 010 66.7l-7.7 7.7c5.3 10.3 9.8 21 13.3 32.1h10.9c26 0 47.1 21.1 47.1 47.1v32.2c0 26-21.1 47.1-47.1 47.1H454c-3.5 11-8 21.8-13.3 32.1l7.7 7.7a47.1 47.1 0 010 66.7l-22.7 22.7a47.1 47.1 0 01-66.7 0l-7.7-7.7c-10.3 5.3-21 9.8-32.1 13.3v10.9c0 26-21.1 47.1-47.1 47.1zM165.8 409.2a176.8 176.8 0 0045.8 19 15 15 0 0111.3 14.5V465c0 9.4 7.7 17.1 17.1 17.1h32.2c9.4 0 17.1-7.7 17.1-17.1v-22.2a15 15 0 0111.3-14.5c16-4.2 31.5-10.6 45.8-19a15 15 0 0118.2 2.3l15.7 15.7a17.1 17.1 0 0024.2 0l22.8-22.8a17.1 17.1 0 000-24.2l-15.7-15.7a15 15 0 01-2.3-18.2 176.8 176.8 0 0019-45.8 15 15 0 0114.5-11.3H465c9.4 0 17.1-7.7 17.1-17.1v-32.2c0-9.4-7.7-17.1-17.1-17.1h-22.2a15 15 0 01-14.5-11.2c-4.2-16.1-10.6-31.6-19-45.9a15 15 0 012.3-18.2l15.7-15.7a17.1 17.1 0 000-24.2l-22.8-22.8a17.1 17.1 0 00-24.2 0l-15.7 15.7a15 15 0 01-18.2 2.3 176.8 176.8 0 00-45.8-19 15 15 0 01-11.3-14.5V47c0-9.4-7.7-17.1-17.1-17.1h-32.2c-9.4 0-17.1 7.7-17.1 17.1v22.2a15 15 0 01-11.3 14.5c-16 4.2-31.5 10.6-45.8 19a15 15 0 01-18.2-2.3l-15.7-15.7a17.1 17.1 0 00-24.2 0l-22.8 22.8a17.1 17.1 0 000 24.2l15.7 15.7a15 15 0 012.3 18.2 176.8 176.8 0 00-19 45.8 15 15 0 01-14.5 11.3H47c-9.4 0-17.1 7.7-17.1 17.1v32.2c0 9.4 7.7 17.1 17.1 17.1h22.2a15 15 0 0114.5 11.3c4.2 16 10.6 31.5 19 45.8a15 15 0 01-2.3 18.2l-15.7 15.7a17.1 17.1 0 000 24.2l22.8 22.8a17.1 17.1 0 0024.2 0l15.7-15.7a15 15 0 0118.2-2.3z"></path>
                <path d="M256 367.4c-61.4 0-111.4-50-111.4-111.4s50-111.4 111.4-111.4 111.4 50 111.4 111.4-50 111.4-111.4 111.4zm0-192.8a81.5 81.5 0 000 162.8 81.5 81.5 0 000-162.8z"></path>
            </svg>
            <svg viewBox="0 0 512 512" fill="currentColor">
                <path d="M255.2 468.6H63.8a21.3 21.3 0 01-21.3-21.2V64.6c0-11.7 9.6-21.2 21.3-21.2h191.4a21.2 21.2 0 100-42.5H63.8A63.9 63.9 0 000 64.6v382.8A63.9 63.9 0 0063.8 511H255a21.2 21.2 0 100-42.5z"></path>
                <path d="M505.7 240.9L376.4 113.3a21.3 21.3 0 10-29.9 30.3l92.4 91.1H191.4a21.2 21.2 0 100 42.6h247.5l-92.4 91.1a21.3 21.3 0 1029.9 30.3l129.3-127.6a21.3 21.3 0 000-30.2z"></path>
            </svg>
        </div>
        <div class="main-container">
            <div class="header">
                <div class="logo">Rent <span class=logo-det>Cr</span></div>
                <a class="header-link active" href="#">
                    <svg viewBox="-6 0 512 512" fill="currentColor">
                        <path d="M227.7 357.5a15.1 15.1 0 0021.3 0l54-54a15.1 15.1 0 10-21.4-21.3l-43.3 43.2-19.7-19.7a15.1 15.1 0 00-21.4 21.4zm0 0"></path>
                        <path d="M250.1 439.8a120.1 120.1 0 10-120-120c0 66.2 53.8 120 120 120zm0-209.7a89.9 89.9 0 010 179.5 89.9 89.9 0 010-179.5zm0 0"></path>
                        <path d="M451.3 32.2h-27.5v-17a15.1 15.1 0 00-30.3 0v17h-29.7v-17a15.1 15.1 0 00-30.2 0v17h-167v-17a15.1 15.1 0 00-30.2 0v17h-29.7v-17a15.1 15.1 0 00-30.2 0v17H48.9A49 49 0 000 81v382A49 49 0 0048.9 512h402.4a49 49 0 0049-48.9v-382a49 49 0 00-49-49zm18.7 431c0 10.2-8.4 18.6-18.7 18.6H49A18.7 18.7 0 0130.2 463V158H470zM30.2 81c0-10.3 8.4-18.7 18.7-18.7h27.6v17.1a15.1 15.1 0 0030.2 0v-17h29.7v17a15.1 15.1 0 0030.3 0v-17h166.9v17a15.1 15.1 0 0030.2 0v-17h29.7v17a15.1 15.1 0 0030.3 0v-17h27.5c10.3 0 18.7 8.3 18.7 18.6v46.6H30.2zm0 0"></path>
                    </svg>
                    Schedule </a> <a class="header-link" href="#">
                <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" fill="currentColor">
                    <path d="M10 13a2 2 0 110-4 2 2 0 010 4zm0-2.5a.5.5 0 100 1 .5.5 0 000-1z"></path>
                    <path d="M20.3 11.8h-8.8a.8.8 0 010-1.6h8.8a.8.8 0 010 1.6zM8.5 11.8H3.7a.8.8 0 010-1.6h4.8a.8.8 0 010 1.6zM15 19a2 2 0 110-4 2 2 0 010 4zm0-2.5a.5.5 0 100 1 .5.5 0 000-1z"></path>
                    <path d="M20.3 17.8h-3.8a.8.8 0 010-1.6h3.8a.8.8 0 010 1.6zM13.5 17.8H3.7a.8.8 0 010-1.6h9.8a.8.8 0 010 1.6z"></path>
                    <path d="M21.3 23H2.6A2.8 2.8 0 010 20.2V3.9C0 2.1 1.2 1 2.8 1h18.4C22.9 1 24 2.2 24 3.8v16.4c0 1.6-1.2 2.8-2.8 2.8zM2.6 2.5c-.6 0-1.2.6-1.2 1.3v16.4c0 .7.6 1.3 1.3 1.3h18.4c.7 0 1.3-.6 1.3-1.3V3.9c0-.7-.6-1.3-1.3-1.3z"></path>
                    <path d="M23.3 6H.6a.8.8 0 010-1.5h22.6a.8.8 0 010 1.5z"></path>
                </svg>
                --- </a> <a class="header-link" href="#">
                <svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg" fill="currentColor">
                    <path d="M500 113.3C326.1 78.7 337.4 80.5 333.4 81.2L281 91.7A111.2 111.2 0 00176 17c-48.6 0-90 31.3-105 74.8L18 81.3A15 15 0 000 96v352a15 15 0 0012 14.7l162.2 32.2c3.6.4-7.6 2.3 161.8-31.6l158 31.4a15 15 0 0018-14.7V128a15 15 0 00-12-14.7zM176 47a81 81 0 0181 81c0 37.7-60.3 133.3-81 165-20.7-31.6-81-127.3-81-165a81 81 0 0181-81zM30 114.2l35.2 7a112 112 0 00-.2 6.8c0 25 16.4 65.4 50 123.4 19.7 33.9 39 63 46 73.2v137.1l-131-26zm161 210.4c7-10.2 26.3-39.3 46-73.2 33.6-58 50-98.4 50-123.4 0-2.3 0-4.6-.2-6.9l34.2-6.8v321.4l-130 26zm291 137.1l-131-26V114.3l131 26z"></path>
                    <path d="M176 175a47 47 0 10-.1-94.1 47 47 0 00.1 94zm0-64a17 17 0 110 34 17 17 0 010-34z"></path>
                </svg>
                --- </a> <a class="header-link" href="#">
                <svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg" fill="currentColor">
                    <path d="M76 240c12.1 0 23.1-4.8 31.2-12.6l44.2 22A44.9 44.9 0 00196 300a45 45 0 0040.6-64.4l60-60a45 45 0 0062.3-54l52.2-39.2a45 45 0 10-18-24l-52.2 39.2a45 45 0 00-65.5 56.8l-60 60a44.7 44.7 0 00-50.6 8.2l-44.2-22A44.9 44.9 0 0076 150a45 45 0 000 90zM436 30a15 15 0 110 30 15 15 0 010-30zm-120 90a15 15 0 110 30 15 15 0 010-30zM196 240a15 15 0 110 30 15 15 0 010-30zM76 180a15 15 0 110 30 15 15 0 010-30zm0 0"></path>
                    <path d="M497 482h-16V165a15 15 0 00-15-15h-60a15 15 0 00-15 15v317h-30V255a15 15 0 00-15-15h-60a15 15 0 00-15 15v227h-30V375a15 15 0 00-15-15h-60a15 15 0 00-15 15v107h-30V315a15 15 0 00-15-15H46a15 15 0 00-15 15v167H15a15 15 0 100 30h482a15 15 0 100-30zm-76-302h30v302h-30zm-120 90h30v212h-30zM181 390h30v92h-30zM61 330h30v152H61zm0 0"></path>
                </svg>
                Reports </a>
                <div class="user-info">
                    <button class="button">All
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-down">
                            <path d="M6 9l6 6 6-6"></path>
                        </svg>
                    </button>
                    <div class="user-name">---</div>
                    <svg class="profile" viewBox="-42 0 512 512" fill="currentColor">
                        <path d="M210.4 246.6c33.8 0 63.2-12.1 87.1-36.1 24-24 36.2-53.3 36.2-87.2 0-33.9-12.2-63.2-36.2-87.2-24-24-53.3-36.1-87.1-36.1-34 0-63.3 12.2-87.2 36.1S87 89.4 87 123.3c0 33.9 12.2 63.2 36.2 87.2 24 24 53.3 36.1 87.2 36.1zm-66-189.3a89.1 89.1 0 0166-27.3c26 0 47.5 9 66 27.3a89.2 89.2 0 0127.3 66c0 26-9 47.6-27.4 66a89.1 89.1 0 01-66 27.3c-26 0-47.5-9-66-27.3a89.1 89.1 0 01-27.3-66c0-26 9-47.6 27.4-66zm0 0M426.1 393.7a304.6 304.6 0 00-12-64.9 160.7 160.7 0 00-13.5-30.3c-5.7-10.2-12.5-19-20.1-26.3a88.9 88.9 0 00-29-18.2 100.1 100.1 0 00-37-6.7c-5.2 0-10.2 2.2-20 8.5-6 4-13 8.5-20.9 13.5-6.7 4.3-15.8 8.3-27 11.9a107.3 107.3 0 01-66 0 119.3 119.3 0 01-27-12l-21-13.4c-9.7-6.3-14.8-8.5-20-8.5a100 100 0 00-37 6.7 88.8 88.8 0 00-29 18.2 114.4 114.4 0 00-20.1 26.3 161 161 0 00-13.4 30.3A302.5 302.5 0 001 393.7c-.7 9.8-1 20-1 30.2 0 26.8 8.5 48.4 25.3 64.4C41.8 504 63.6 512 90.3 512h246.5c26.7 0 48.6-8 65.1-23.7 16.8-16 25.3-37.6 25.3-64.4a437 437 0 00-1-30.2zm-44.9 72.8c-11 10.4-25.4 15.5-44.4 15.5H90.3c-19 0-33.4-5-44.4-15.5C35.2 456.3 30 442.4 30 424c0-9.5.3-19 1-28.1A272.9 272.9 0 0141.7 338a131 131 0 0110.9-24.7A84.8 84.8 0 0167.4 294a59 59 0 0119.3-12 69 69 0 0123.6-4.5c1 .5 3 1.6 6 3.6l21 13.6c9 5.6 20.4 10.7 34 15.1a137.3 137.3 0 0084.5 0c13.7-4.4 25.1-9.5 34-15.1a2721 2721 0 0027-17.2 69 69 0 0123.7 4.5 59 59 0 0119.2 12 84.5 84.5 0 0114.9 19.4c4.5 8 8.2 16.3 10.8 24.7a275.2 275.2 0 0110.8 57.8c.6 9 1 18.5 1 28.1 0 18.5-5.3 32.4-16 42.6zm0 0"></path>
                    </svg>
                    <div class="hour">---</div>
                </div>
            </div>
            <div class="user-box first-box">
                <div class="activity card" style="--delay: .2s">
                    <div class="title">Activities</div>
                    <div class="subtitle">Hoo - is an adaptive Online Courses Application with a wide range of course
                        directions. The students will have a great possibility to study.
                    </div>
                    <div class="activity-links">
                        <div class="activity-link active">Current</div>
                        <div class="activity-link notify">Request</div>
                    </div>
                    <div class="destination">
                        <div class="destination-card">
                            <div class="destination-profile">
<%--                                 <img class="profile-img" src="https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1650&q=80" alt=""/> --%>
                                <div class="destination-length">

                                    ---
                                </div>
                            </div>
                            <div class="destination-points">
                                <div class="point">-- --</div>
                                <div class="sub-point">Brooklyn St, NY</div>
                            </div>
                        </div>
                        <div class="destination-card">
                            <div class="destination-profile">
<%--                                 <img class="profile-img" src="https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1400&q=80" alt=""/> --%>
                                <div class="destination-length">

                                    ---
                                </div>
                            </div>
                            <div class="destination-points">
                                <div class="point">---</div>
                                <div class="sub-point">Maryland 17, NY</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="discount card" style="--delay: .4s">
                    <div class="title">---</div>
                    <div class="discount-wrapper">
                        <div class="discount-info">
                            <div class="subtitle">---</div>
                            <div class="subtitle-count">---</div>
                            <div class="subtitle">---</div>
                            <div class="subtitle-count dist">---</div>
                        </div>
                        <div class="discount-chart">
                            <div class="circle">
                                <div class="pie">
                                    <svg>
                                        <circle cx="60" cy="60" r="50"></circle>
                                    </svg>
                                </div>
                                <div class="counter">0</div>
                            </div>
                        </div>
                    </div>
                    <div class="discount-profile">
                        <span class="by">By:</span>
<%--                         <img class="discount-img" src="https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1400&q=80" alt=""> --%>
                        <div class="discount-detail">
                            <div class="discount-name">---</div>
                            <div class="discount-type">---</div>
                        </div>
                    </div>
                    <div class="button offer-button">Get Offer</div>
                </div>
                <%-- start calender --%>
                <div class="cards-wrapper content-wrapper" style="--delay: .6s">
                    <div class="left-wrapper">
                        <div class="cards-header">
                            <div class="month cards-header-date">
                            <span class="prev fa fa-angle-left">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left">
                                <path d="M15 18l-6-6 6-6"></path>
                            </svg>
                            </span>
                                <div class="title">
                                    <p class="month">January</p>
                                    <p class="year">2016</p>
                                </div>
                                <span class="next fa fa-angle-right">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-right">
                                <path d="M9 18l6-6-6-6"></path>
                            </svg>
                            </span>
                            </div>
                        </div>
                        <div class="cards card">
                            <div class="cards-head">
                                <div class="cards-info">
                                    <div class="calendar-hour">08.20 <span class="am-pm">pm</span></div>
                                    <div class="degree">
                                        <svg viewBox="0 0 512 512">
                                            <circle cx="330.2" cy="240.1" fill="#feb137" r="78.9"></circle>
                                            <g fill="#ffd15b">
                                                <path d="M320.5 130c-7.4.6-14-5-14.6-12.3l-4.1-47a13.5 13.5 0 0126.9-2.4l4 47c.7 7.4-4.8 14-12.2 14.6z"></path>
                                                <path d="M320.5 130c-7.4.6-14-5-14.6-12.3l-4.1-47a13.5 13.5 0 0126.9-2.4l4 47c.7 7.4-4.8 14-12.2 14.6zM438 228.5c-.6-7.4 4.9-14 12.3-14.6l47-4a13.5 13.5 0 012.4 26.8l-47 4.1c-7.5.7-14-4.8-14.7-12.3zM413 307.7a13.5 13.5 0 0119-1.6l36.2 30.3a13.5 13.5 0 01-17.3 20.7l-36.2-30.4a13.5 13.5 0 01-1.6-19z"></path>
                                                <path d="M413 307.7a13.5 13.5 0 0119-1.6l36.2 30.3a13.5 13.5 0 01-17.3 20.7l-36.2-30.4a13.5 13.5 0 01-1.6-19zM190 120.6a13.5 13.5 0 0119-1.7l36.2 30.4a13.5 13.5 0 01-17.3 20.6l-36.2-30.3a13.5 13.5 0 01-1.7-19zM447.4 98a13.5 13.5 0 011.7 19l-30.4 36.2A13.5 13.5 0 01398 136l30.4-36.2a13.5 13.5 0 0119-1.6z"></path>
                                            </g>
                                            <path d="M360 335.4a70.8 70.8 0 00-87.4-74A95 95 0 0085 286a85 85 0 00-3.4 170h273a60.4 60.4 0 005.2-120.6z" fill="#d8ecfe"></path>
                                            <path d="M360 335.4a70.8 70.8 0 00-87.4-74 95 95 0 00-125.7-68.3 95 95 0 0190.6 74.2 70.8 70.8 0 0187.4 74A60.4 60.4 0 01345.6 456h9.2a60.4 60.4 0 005.1-120.6z" fill="#c4e2ff"></path>
                                        </svg>
                                        81.2° F in Sylhet
                                    </div>
                                </div>
                                <svg viewBox="0 0 512 512" fill="currentColor">
                                    <path d="M272 512h-32c-26 0-47.2-21.1-47.2-47.1V454c-11-3.5-21.8-8-32.1-13.3l-7.7 7.7a47.1 47.1 0 01-66.7 0l-22.7-22.7a47.1 47.1 0 010-66.7l7.7-7.7c-5.3-10.3-9.8-21-13.3-32.1H47.1c-26 0-47.1-21.1-47.1-47.1v-32.2c0-26 21.1-47.1 47.1-47.1H58c3.5-11 8-21.8 13.3-32.1l-7.7-7.7a47.1 47.1 0 010-66.7l22.7-22.7a47.1 47.1 0 0166.7 0l7.7 7.7c10.3-5.3 21-9.8 32.1-13.3V47.1c0-26 21.1-47.1 47.1-47.1h32.2c26 0 47.1 21.1 47.1 47.1V58c11 3.5 21.8 8 32.1 13.3l7.7-7.7a47.1 47.1 0 0166.7 0l22.7 22.7a47.1 47.1 0 010 66.7l-7.7 7.7c5.3 10.3 9.8 21 13.3 32.1h10.9c26 0 47.1 21.1 47.1 47.1v32.2c0 26-21.1 47.1-47.1 47.1H454c-3.5 11-8 21.8-13.3 32.1l7.7 7.7a47.1 47.1 0 010 66.7l-22.7 22.7a47.1 47.1 0 01-66.7 0l-7.7-7.7c-10.3 5.3-21 9.8-32.1 13.3v10.9c0 26-21.1 47.1-47.1 47.1zM165.8 409.2a176.8 176.8 0 0045.8 19 15 15 0 0111.3 14.5V465c0 9.4 7.7 17.1 17.1 17.1h32.2c9.4 0 17.1-7.7 17.1-17.1v-22.2a15 15 0 0111.3-14.5c16-4.2 31.5-10.6 45.8-19a15 15 0 0118.2 2.3l15.7 15.7a17.1 17.1 0 0024.2 0l22.8-22.8a17.1 17.1 0 000-24.2l-15.7-15.7a15 15 0 01-2.3-18.2 176.8 176.8 0 0019-45.8 15 15 0 0114.5-11.3H465c9.4 0 17.1-7.7 17.1-17.1v-32.2c0-9.4-7.7-17.1-17.1-17.1h-22.2a15 15 0 01-14.5-11.2c-4.2-16.1-10.6-31.6-19-45.9a15 15 0 012.3-18.2l15.7-15.7a17.1 17.1 0 000-24.2l-22.8-22.8a17.1 17.1 0 00-24.2 0l-15.7 15.7a15 15 0 01-18.2 2.3 176.8 176.8 0 00-45.8-19 15 15 0 01-11.3-14.5V47c0-9.4-7.7-17.1-17.1-17.1h-32.2c-9.4 0-17.1 7.7-17.1 17.1v22.2a15 15 0 01-11.3 14.5c-16 4.2-31.5 10.6-45.8 19a15 15 0 01-18.2-2.3l-15.7-15.7a17.1 17.1 0 00-24.2 0l-22.8 22.8a17.1 17.1 0 000 24.2l15.7 15.7a15 15 0 012.3 18.2 176.8 176.8 0 00-19 45.8 15 15 0 01-14.5 11.3H47c-9.4 0-17.1 7.7-17.1 17.1v32.2c0 9.4 7.7 17.1 17.1 17.1h22.2a15 15 0 0114.5 11.3c4.2 16 10.6 31.5 19 45.8a15 15 0 01-2.3 18.2l-15.7 15.7a17.1 17.1 0 000 24.2l22.8 22.8a17.1 17.1 0 0024.2 0l15.7-15.7a15 15 0 0118.2-2.3z"></path>
                                    <path d="M256 367.4c-61.4 0-111.4-50-111.4-111.4s50-111.4 111.4-111.4 111.4 50 111.4 111.4-50 111.4-111.4 111.4zm0-192.8a81.5 81.5 0 000 162.8 81.5 81.5 0 000-162.8z"></path>
                                </svg>
                            </div>
                            <div class="calender">
                                <table>
                                    <thead class="items-2 days weeks">
                                    <tr class="weedays">
                                        <th class="item" data-weekday="sun" class="item-2" data-column="0">Sun</th>
                                        <th class="item" data-weekday="mon" class="item-2" data-column="1">Mon</th>
                                        <th class="item" data-weekday="tue" class="item-2" data-column="2">Tue</th>
                                        <th class="item" data-weekday="wed" class="item-2" data-column="3">Wed</th>
                                        <th class="item" data-weekday="thu" class="item-2" data-column="4">Thu</th>
                                        <th class="item" data-weekday="fri" class="item-2" data-column="5">Fri</th>
                                        <th class="item" data-weekday="sat" class="item-2" data-column="6">Sat</th>
                                    </tr>
                                    </thead>
                                    <tbody class="all-days items-2 numbers">
                                    <%--@elvariable id="data_colum" type=""--%> <%--@elvariable id="i" type=""--%><%for(int i = 0; i <= 5; i++){%>
                                    <tr class="days" data-row="${i}">
                                        <%for(int data_colum = 0; data_colum <= 6; data_colum++){%>
                                        <td class="item-2" data-column="${data_colum}"></td>
                                        <%}%>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <%-- end calender --%>
                <div class="account-wrapper" style="--delay: .8s">
                    <a href="http://localhost:8080/<%=((User)request.getSession().getAttribute("user")).getStudentId()!=null?("student/profile"):""%>">
                        <div class="account-profile">
                            <img src="https://images.unsplash.com/photo-1550314124-301ca0b773ae?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2215&q=80" alt="">
                            <div class="blob-wrap">
                                <div class="blob"></div>
                                <div class="blob"></div>
                                <div class="blob"></div>
                            </div>
                            <div class="account-name"><p class="name">loading...</p></div>
                            <div class="account-title"><p class="student-code"></p></div>
                        </div>
                    </a>
                    <div class="account card">
                        <div class="account-cash">$ 5637.04</div>
                        <div class="account-income">Balance</div>
                        <div class="account-iban">FAP wallet</div>
                    </div>
                </div>
            </div>
            <div class="user-box second-box">
                <div class="cards-wrapper" style="--delay: 1s">
                    <div class="cards-header">
                        <div class="cards-view">
                            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-calendar">
                                <rect x="3" y="4" width="18" height="18" rx="2" ry="2"></rect>
                                <path d="M16 2v4M8 2v4M3 10h18"></path>
                            </svg>
                            Calendar View <span class="today">Today</span>
                        </div>
                        <div class="cards-header-date">
                            <div class="prev-day">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left">
                                    <path d="M15 18l-6-6 6-6"></path>
                                </svg>
                            </div>
                            <div class="title">Sat, Nov 25 2020</div>
                            <div class="next-day">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-right">
                                    <path d="M9 18l6-6-6-6"></path>
                                </svg>
                            </div>
                        </div>
                        <div class="cards-button button">
                            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus">
                                <path d="M12 5v14M5 12h14"></path>
                            </svg>
                            Create
                        </div>
                    </div>
                    <div class="cards card">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>Time</th>
                                <th>Course</th>
                                <th>Room</th>
                                <th>Material</th>
                                <th>Attendance</th>
                                <th>Status</th>
                            </tr>
                            </thead>
                            <tbody class="schedule-table">
                            <tr>
                                <td>
                                    Slot 1
                                    <span class="time">07:30-09:50</span>
                                </td>
                                <td>
                                    <div class="status is-wait">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-loader">
                                            <path d="M12 2v4M12 18v4M4.93 4.93l2.83 2.83M16.24 16.24l2.83 2.83M2 12h4M18 12h4M4.93 19.07l2.83-2.83M16.24 7.76l2.83-2.83"></path>
                                        </svg>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Slot 2
                                    <span class="time">10:00-12:20</span>
                                </td>
                                <td>
                                    <div class="status is-wait">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-loader">
                                            <path d="M12 2v4M12 18v4M4.93 4.93l2.83 2.83M16.24 16.24l2.83 2.83M2 12h4M18 12h4M4.93 19.07l2.83-2.83M16.24 7.76l2.83-2.83"></path>
                                        </svg>
                                    </div>
                            </tr>
                            <tr>
                                <td>
                                    Slot 3
                                    <span class="time is-wait">12:50-15:10</span>
                                </td>
                                <td>
                                    <div class="status is-wait">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-loader">
                                            <path d="M12 2v4M12 18v4M4.93 4.93l2.83 2.83M16.24 16.24l2.83 2.83M2 12h4M18 12h4M4.93 19.07l2.83-2.83M16.24 7.76l2.83-2.83"></path>
                                        </svg>
                                    </div>
                            </tr>
                            <tr>
                                <td>
                                    Slot 4
                                    <span class="time">15:20-17:40</span>
                                </td>
                                <td>
                                    <div class="status is-wait">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-loader">
                                            <path d="M12 2v4M12 18v4M4.93 4.93l2.83 2.83M16.24 16.24l2.83 2.83M2 12h4M18 12h4M4.93 19.07l2.83-2.83M16.24 7.76l2.83-2.83"></path>
                                        </svg>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card transection" style="--delay: 1.2s">
                    <div class="transection-header">
                        <div class="head">Notification</div>
                        <div class="head is-wait">View All</div>
                    </div>
                    <div class="credit-wrapper">

                        <div class="credit-name">
                            <div class="credit-type">1 New email</div>
                            <div class="credit-status">...</div>
                        </div>
                        <div class="credit-money is-active">...</div>
                    </div>
                    <div class="credit-wrapper">

                        <div class="credit-name">
                            <div class="credit-type">Summer holiday</div>
                            <div class="credit-status">...</div>
                        </div>
                        <div class="credit-money is-active">...</div>
                    </div>
                    <div class="credit-wrapper">

                        <div class="credit-name">
                            <div class="credit-type">---</div>
                            <div class="credit-status">--- Waiting</div>
                        </div>
                        <div class="credit-money is-wait">...</div>
                    </div>
                    <div class="credit-wrapper">

                        <div class="credit-name">
                            <div class="credit-type">---</div>
                            <div class="credit-status">---</div>
                        </div>
                        <div class="credit-money is-cancel">...</div>
                    </div>
                </div>
            </div>
        </div>
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
<script>
  const counter = document.querySelector( ".counter" );
  let count = 0;
  setInterval( () => {
    if( count === 92 ){
      clearInterval( count );
    }else{
      count += 1;
      counter.textContent = count + "%";
    }
  }, 42 );
</script>
<script src="http://localhost:3000/Script/component/ScheduleHandler.js" type="module" ;></script>
<script src="http://localhost:3000/Script/component/Calender2.js" type="module"></script>
<script src="http://localhost:3000/Script/Controllers/ProfileController.js" type="module"></script>
<script src="http://localhost:3000/Script/Controllers/HomeController.js" type="module"></script>
<script src="http://localhost:3000/Script/Controllers/GetScheduleAPIController.js" type="module"></script>

</body>
</html>
