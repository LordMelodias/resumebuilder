<%-- 
    Document   : dashboard
    Created on : 03-Sept-2023, 9:54:40?am
    Author     : Rohit
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="style2.css">
</head>
<body>
    <div class="info">
    <h1>Welcome to Your Dashboard</h1>
    <p>Hello, <%= session.getAttribute("username") %>. This is your dashboard.</p>
    
    <p>Here, you can manage your resumes, update your profile, and perform other actions.</p>
    
    <p><a href="create_resume.jsp">Create a Resume</a></p>
    <p><a href="edit_profile.jsp">Edit Profile</a></p>
    <p><a href="view_resume">View Resume</a></p>
    <p><a href="logout">Logout</a></p>
</div>
</body>
</html>

