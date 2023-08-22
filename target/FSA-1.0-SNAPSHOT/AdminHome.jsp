<%--
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
    <link rel="stylesheet" href="http://localhost:3000/css/AdminHome.css">
    <link rel="stylesheet" href="http://localhost:3000/css/Fantastic.css">
    <link rel="stylesheet" href="http://localhost:3000/css/RootCSS/components.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <style>
        .is-red{
            color: #d14b69 !important;
        }

        .is-green{
            color: #1aa385 !important;
        }
        .row-is-green{
            background-color: #1aa385 !important;
            border-radius: 4px;
            padding: 6px;
        }

    </style>
</head>
<body>
<section id="cursor-1" class="container container-cursor-1">
    <link href="https://fonts.googleapis.com/css?family=DM+Sans:400,500,700&display=swap" rel="stylesheet">
    <div class="app-container">
        <div class="left-area">
            <button class="btn-close-left">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-x-circle" viewBox="0 0 24 24">
                    <defs/>
                    <circle cx="12" cy="12" r="10"/>
                    <path d="M15 9l-6 6M9 9l6 6"/>
                </svg>
            </button>
            <div class="app-name">MyDocs</div>
            <a href="#" class="item-link active">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-grid" viewBox="0 0 24 24">
                    <defs/>
                    <path d="M3 3h7v7H3zM14 3h7v7h-7zM14 14h7v7h-7zM3 14h7v7H3z"/>
                </svg>
            </a> <a href="#" class="item-link">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-folder" viewBox="0 0 24 24">
                <defs/>
                <path d="M22 19a2 2 0 01-2 2H4a2 2 0 01-2-2V5a2 2 0 012-2h5l2 3h9a2 2 0 012 2z"/>
            </svg>
        </a> <a href="#" class="item-link">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-hard-drive" viewBox="0 0 24 24">
                <defs/>
                <path d="M22 12H2M5.45 5.11L2 12v6a2 2 0 002 2h16a2 2 0 002-2v-6l-3.45-6.89A2 2 0 0016.76 4H7.24a2 2 0 00-1.79 1.11zM6 16h.01M10 16h.01"/>
            </svg>
        </a> <a href="#" class="item-link">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-settings" viewBox="0 0 24 24">
                <defs/>
                <circle cx="12" cy="12" r="3"/>
                <path d="M19.4 15a1.65 1.65 0 00.33 1.82l.06.06a2 2 0 010 2.83 2 2 0 01-2.83 0l-.06-.06a1.65 1.65 0 00-1.82-.33 1.65 1.65 0 00-1 1.51V21a2 2 0 01-2 2 2 2 0 01-2-2v-.09A1.65 1.65 0 009 19.4a1.65 1.65 0 00-1.82.33l-.06.06a2 2 0 01-2.83 0 2 2 0 010-2.83l.06-.06a1.65 1.65 0 00.33-1.82 1.65 1.65 0 00-1.51-1H3a2 2 0 01-2-2 2 2 0 012-2h.09A1.65 1.65 0 004.6 9a1.65 1.65 0 00-.33-1.82l-.06-.06a2 2 0 010-2.83 2 2 0 012.83 0l.06.06a1.65 1.65 0 001.82.33H9a1.65 1.65 0 001-1.51V3a2 2 0 012-2 2 2 0 012 2v.09a1.65 1.65 0 001 1.51 1.65 1.65 0 001.82-.33l.06-.06a2 2 0 012.83 0 2 2 0 010 2.83l-.06.06a1.65 1.65 0 00-.33 1.82V9a1.65 1.65 0 001.51 1H21a2 2 0 012 2 2 2 0 01-2 2h-.09a1.65 1.65 0 00-1.51 1z"/>
            </svg>
        </a>
            <a class="btn-logout" href="${pageContext.request.contextPath}/logout">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-log-out" viewBox="0 0 24 24">
                    <defs/>
                    <path d="M9 21H5a2 2 0 01-2-2V5a2 2 0 012-2h4M16 17l5-5-5-5M21 12H9"/>
                </svg>
            </a>
        </div>
        <div class="main-area">
            <button class="btn-show-right-area">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-chevron-left">
                    <polyline points="15 18 9 12 15 6"/>
                </svg>
            </button>
            <button class="btn-show-left-area">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                    <line x1="3" y1="12" x2="21" y2="12"/>
                    <line x1="3" y1="6" x2="21" y2="6"/>
                    <line x1="3" y1="18" x2="21" y2="18"/>
                </svg>
            </button>
            <div class="main-area-header">
                <div class="search-wrapper" id="searchLine">
                    <input class="search-input" type="text" placeholder="e.g. files.doc">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-search" viewBox="0 0 24 24">
                        <defs/>
                        <circle cx="11" cy="11" r="8"/>
                        <path d="M21 21l-4.35-4.35"/>
                    </svg>
                </div>
            </div>
            <section class="content-section">
                <h1 class="section-header">Quick Access</h1>
                <div class="access-links">
                    <div class="access-link-wrapper see-semester">
                        <div class="access-icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="56" height="56" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1" stroke-linecap="round" stroke-linejoin="round" class="feather feather-music">
                                <path d="M9 18V5l12-2v13"/>
                                <circle cx="6" cy="18" r="3"/>
                                <circle cx="18" cy="16" r="3"/>
                            </svg>
                        </div>
                        <span class="access-text">Semester</span>
                    </div>
                    <div class="access-link-wrapper see-notification">
                        <div class="access-icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="56" height="56" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1" stroke-linecap="round" stroke-linejoin="round" class="feather feather-align-left">
                                <line x1="17" y1="10" x2="3" y2="10"/>
                                <line x1="21" y1="6" x2="3" y2="6"/>
                                <line x1="21" y1="14" x2="3" y2="14"/>
                                <line x1="17" y1="18" x2="3" y2="18"/>
                            </svg>
                        </div>
                        <span class="access-text">Notification</span>
                    </div>
                    <div class="access-link-wrapper see-exam">
                        <div class="access-icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="56" height="56" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1" stroke-linecap="round" stroke-linejoin="round" class="feather feather-layers">
                                <polygon points="12 2 2 7 12 12 22 7 12 2"/>
                                <polyline points="2 17 12 22 22 17"/>
                                <polyline points="2 12 12 17 22 12"/>
                            </svg>
                        </div>
                        <span class="access-text">Exams</span>
                    </div>
                    <div class="access-link-wrapper see-history">
                        <div class="access-icon">
                            <svg xmlns="http://www.w3.org/2000/svg" width="56" height="56" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-down-circle">
                                <circle cx="12" cy="12" r="10"/>
                                <polyline points="8 12 12 16 16 12"/>
                                <line x1="12" y1="8" x2="12" y2="16"/>
                            </svg>
                        </div>
                        <span class="access-text">History</span>
                    </div>
                </div>
            </section>

            <section class="content-section main-table">


                <div class="section-header-wrapper">
                    <h1 class="section-header">Table</h1>
                    <a class="section-header-link"> View all </a>
                    <p class="show-message"></p>
                </div>
                <div class="wrap-table">
                    <div class="table-1">
                    </div>
                    <div class="table-2">

                    </div>
                    <div class="table-3">

                    </div>
                </div>
<%--                 <div class="files-table">table</div> --%>
            </section>
        </div>
        <div class="right-area">
            <button class="btn-close-right">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="feather feather-x-circle" viewBox="0 0 24 24">
                    <defs/>
                    <circle cx="12" cy="12" r="10"/>
                    <path d="M15 9l-6 6M9 9l6 6"/>
                </svg>
            </button>
            <div class="right-area-header-wrapper">
                <p class="right-area-header">Downloads</p>
                <button class="more-action"></button>
            </div>
            <div class="download-item-line">
                <div class="line-header">Today</div>

                <div class="download-area">
                    <form action="${pageContext.request.contextPath}/update/course-schedule" method="post" class="update">
                        <button>Update</button>
                    </form>

                </div>
            </div>
            <div class="download-item-line">
                <div class="line-header">Yesterday</div>
                <div class="download-area">
                    <div class="download-item-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" class="">
                            <defs></defs>
                            <circle cx="256" cy="256" r="256" fill="#4bc0dd"></circle>
                            <path fill="#f5f5f5" d="M192 64h176c4.4 0 8 3.6 8 8v328c0 4.4-3.6 8-8 8H120c-4.4 0-8-3.6-8-8V148l80-84z"></path>
                            <path fill="#e6e6e6" d="M184 148c4.4 0 8-3.6 8-8V64l-80 84h72z"></path>
                            <circle cx="352" cy="384" r="52" fill="#2179a6"></circle>
                            <g fill="#f5f5f5" class="g">
                                <path d="M352 416c-2.208 0-4-1.788-4-4v-56c0-2.212 1.792-4 4-4s4 1.788 4 4v56c0 2.212-1.792 4-4 4z"></path>
                                <path d="M352 416a3.989 3.989 0 01-2.828-1.172l-20-20c-1.564-1.564-1.564-4.092 0-5.656s4.092-1.564 5.656 0L352 406.344l17.172-17.172c1.564-1.564 4.092-1.564 5.656 0s1.564 4.092 0 5.656l-20 20A3.989 3.989 0 01352 416z"></path>
                            </g>
                        </svg>
                    </div>
                    <div class="download-item-texts">
                        <p class="download-text-header">Glitter.mp4</p>
                        <div class="progress-bar">
                            <span class="progress"></span>
                        </div>
                    </div>
                    <div class="download-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="1 1 512 512">
                            <defs/>
                            <path d="M256 512C114.613 512 0 397.383 0 256S114.613 0 256 0s256 114.613 256 256c-.168 141.316-114.684 255.832-256 256zm0-480C132.29 32 32 132.29 32 256s100.29 224 224 224 224-100.29 224-224c-.133-123.656-100.344-223.867-224-224zm0 0"/>
                            <path d="M208 368c-8.836 0-16-7.164-16-16V160c0-8.836 7.164-16 16-16s16 7.164 16 16v192c0 8.836-7.164 16-16 16zm0 0M304 368c-8.836 0-16-7.164-16-16V160c0-8.836 7.164-16 16-16s16 7.164 16 16v192c0 8.836-7.164 16-16 16zm0 0"/>
                        </svg>
                    </div>
                </div>
            </div>
            <div class="right-area-header-wrapper">
                <p class="right-area-header">File Received</p>
            </div>
            <div class="received-item-line">
                <div class="progress-line">
                    <span class="time start">15:30</span> <span class="time end">18:30</span>
                </div>
                <div class="received-items-content">
                    <div class="received-files">
                        <div class="image-wrapper">
                            <img src="https://images.unsplash.com/photo-1523987355523-c7b5b0dd90a7?ixlib=rb-1.2.1&auto=format&fit=crop&w=2250&q=80"/>
                        </div>
                        <div class="image-wrapper">
                            <img src="https://images.unsplash.com/photo-1498855926480-d98e83099315?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2250&q=80"/>
                        </div>
                        <div class="image-wrapper">
                            <img src="https://images.unsplash.com/photo-1492648272180-61e45a8d98a7?ixlib=rb-1.2.1&auto=format&fit=crop&w=2250&q=80"/>
                        </div>
                    </div>
                    <div class="received-files-info">
                        Received <span class="info-purple">3 images</span> total
                        <span class="info-purple">50.3 MB</span>
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
<script src="http://localhost:3000/Script/component/AdminHome.js"></script>
<script src="http://localhost:3000/Script/component/Fantastic.js"></script>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

<script src="http://localhost:3000/Script/controllers/AdminHomeController.js" type="module"></script>

<%-- <script src="http://localhost:3000/Script/component/ScheduleHandler.js" type="module" ;></script> --%>
<%-- <script src="http://localhost:3000/Script/component/Calender2.js" type="module"></script> --%>
</body>
</html>
