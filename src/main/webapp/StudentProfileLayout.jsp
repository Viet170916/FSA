<%--
  Created by IntelliJ IDEA.
  User: vuquocviet
  Date: 22/06/2023
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student profile</title>
    <link rel="stylesheet" href="http://localhost:3000/css/Profile.css">
    <link rel="stylesheet" href="http://localhost:3000/css/Table.css">
</head>
<body>
<div class="container">
    <div class="base-information">
        <div class="personal-image">
            <div class="banner">
            </div>
            <div class="avatar">
                <img src="" alt="">
            </div>
        </div>
        <p class="name">loading...</p>
    </div>
    <div class="detail-information">
        <div class="description">
            <div class="info-box">
                Student code:
                <p class="student-code">loading...</p>
            </div>
            <div class="info-box">
                Gender:
                <p class="gender">loading...</p>
            </div>
            <div class="info-box">
                Birth date:
                <p class="birth-date">loading...</p>
            </div>
            <div class="info-box">
                Address:
                <p class="address">loading...</p>
            </div>
            <div class="info-box">
                Email:
                <p class="email">loading...</p>
            </div>
            <div class="info-box">
                Phone:
                <p class="phone">loading...</p>
            </div>
        </div>
        <div class="attendance-information">
            <table class="rwd-table">
            </table>
        </div>
    </div>
</div>
<script src="http://localhost:3000/Script/component/Table.js"></script>
<script src="http://localhost:3000/Script/Controllers/ProfileController.js"></script>
<script>
  const initAttendance = {
    'Date': "__-__-____",
    'Course': "__",
    'Attendance': "__",
  };
  //add attendance table
  Table( document.querySelector( ".rwd-table" )
    , [ initAttendance, initAttendance, initAttendance, initAttendance ] )
</script>
<!--Code javaScript start here!-->
<script>
  getStudentData( "http://localhost:8080/api/student-profile<%=request.getAttribute("id")!=null?"?id="+request.getAttribute("id"):""%>" );
</script>
<!--Code javaScript end here!-->
</body>
</html>
