<%-- 
    Document   : View_resume
    Created on : 03-Sept-2023, 12:54:12 pm
    Author     : Rohit
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Resume Saved</title>
    <link rel="stylesheet" href="resume.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="full-name">
                <span class="first-name"><%= request.getAttribute("fullName") %></span>
            </div>
            <div class="contact-info">
                <span class="email">Email: </span>
                <span class="email-val"><%= request.getAttribute("email") %></span>
                <span class="separator"></span>
                <span class="phone">Phone: </span>
                <span class="phone-val"><%= request.getAttribute("phone") %></span>
            </div>

            <div class="about">
                <span class="position">About:</span>
                <span class="desc">
                    <%= request.getAttribute("address") %>
                </span>
            </div>
        </div>
        <div class="details">
            <div class="section">
                <div class="section__title">Experience</div>
                <div class="section__list">
                    <div class="section__list-item">
                        <div class="left">
                            <div class="name"><%= request.getAttribute("experience") %></div>
                        </div>
                    </div>
                    

                </div>
            </div>
            <div class="section">
                <div class="section__title">Education</div>
                <div class="section__list">
                    <div class="section__list-item">
                        <div class="left">
                            <div class="name"><%= request.getAttribute("education") %></div>
                        </div>
                    </div>
                </div>

            </div>
                        
            <div class="section">
                <div class="section__title">
                     Interests
                 </div>
             <div class="section__list">
             <div class="section__list-item">
                  <%= request.getAttribute("hobbies") %>
          </div>
       </div>
     </div>
        </div>
    </div>
</body>
</html>

