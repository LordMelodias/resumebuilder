<%-- 
    Document   : create_resume
    Created on : 03-Sept-2023, 9:55:07?am
    Author     : Rohit
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Resume</title>
    <link rel="stylesheet" href="style4.css">
</head>
<body>
    <div class="info">
        <h1 align="center">Create Your Resume</h1>
        <form action="SaveResumeServlet" method="post">
            <h3>Personal Information:</h3>
            <label for="name">Full Name:</label>
            <input type="text" name="name" required>
            <br><br>
            <label for="birth">Date of Birth:</label>
            <input type="text" name="birth" required>
            <br><br>
            <label for="sex">Sex:</label>
            <input type="text" name="sex" required>
            <br><br>
            <label for="lang">Language Know:</label>
            <input type="text" name="lang" required>
            <br><br>
            <label for="email">Email:</label>
            <input type="email" name="email" required>
            <br><br>
            <label for="phone">Phone:</label>
            <input type="tel" name="phone">
            <br><br>
            <label for="skill">Skills:</label>
            <textarea name="skill" rows="6" cols="30"></textarea>
            <br><br>
            <label for="about">Carrer Objective:</label>
            <textarea name="about" rows="6" cols="30"></textarea>
            <br><br>
            <label for="experience">Work Experience:</label>
            <textarea name="experience" rows="6" cols="30"></textarea>
            <br><br>
            <label for="education">Education:</label>
            <textarea name="education" rows="6" cols="30"></textarea>
            <br><br>
            <label for="hobbies">Hobbies:</label>
            <textarea name="hobbies" rows="3"></textarea>
            <br><br>
            <div class="btn"><input type="submit" value="Save Resume"></div>
        </form>
    </div>

</body>
</html>
