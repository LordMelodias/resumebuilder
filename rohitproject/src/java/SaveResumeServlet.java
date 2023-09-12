import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/SaveResumeServlet")
public class SaveResumeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data from the request
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        String sex = request.getParameter("sex");
        String lang = request.getParameter("lang");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String skill = request.getParameter("skill");
        String about = request.getParameter("about");
        String experience = request.getParameter("experience");
        String education = request.getParameter("education");
        String hobbies = request.getParameter("hobbies");

        // Database connection parameters
        String jdbcURL = "jdbc:mysql://localhost:3306/cv";
        String dbUser = "root";
        String dbPassword = "root";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cv","root","root");

            // Create a SQL query to insert resume data into the database
            String sql = "INSERT INTO resumes (name, birth, sex, lang, email, phone, skill, about, experience, education, hobbies) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, birth);
            preparedStatement.setString(3, sex);
            preparedStatement.setString(4, lang);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, phone);
            preparedStatement.setString(7, skill);
            preparedStatement.setString(8, about);
            preparedStatement.setString(9, experience);
            preparedStatement.setString(10, education);
            preparedStatement.setString(11, hobbies);

            // Execute the query to save the resume data
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

            if (rowsAffected > 0) {
                // Resume saved successfully, redirect to a success page
                response.sendRedirect("registration_success.jsp");
            } else {
                // Resume save failed, redirect to an error page
                response.sendRedirect("create_resume.jsp?error=Resume not saved");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("create_resume.jsp?error=Database error");
        }
    }
}
