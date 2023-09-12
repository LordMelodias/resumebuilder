<%-- 
    Document   : edit_profile
    Created on : 03-Sept-2023, 9:58:04?am
    Author     : Rohit
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="style3.css">
</head>
<body>
    <div class="info">
    <h1 align="center">Edit Your Profile</h1>
    
    <form action="UpdateProfileServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" value="<%= session.getAttribute("username") %>" disabled>
        <br><br>
        <label for="name">Full Name:</label>
        <input type="text" name="name" required>
        <br><br>
        <label for="email">Email:</label>
        <input type="email" name="email" required>
        <br><br>
        <label for="phone">Phone:</label>
        <input type="tel" name="phone">
        <br><br>
        <label for="about">About:</label>
        <textarea name="about" ></textarea>
        <br><br>
        <label for="experience">Work Experience:</label>
        <textarea name="experience" ></textarea>
        <br><br>
        <label for="education">Education:</label>
        <textarea name="education" ></textarea>
        <br><br>
        <label for="hobbies">Hobbies:</label>
        <textarea name="hobbies" ></textarea>
        <br><br>
        <div class="btn"><input type="submit" value="Save Resume"></div>
    </form>
</div>
</body>
</html>



