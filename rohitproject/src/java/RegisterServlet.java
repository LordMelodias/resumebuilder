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


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");

        // Validate user input (add more validation as needed)
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || cpassword == null || cpassword.isEmpty()) {
            response.sendRedirect("index.jsp?error=Invalid input");
            return;
        }

        // Database connection parameters
        if(password.equals(cpassword))
        {

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");

            // Create a SQL query to insert a new user into the database
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

            if (rowsAffected > 0) {
                // Registration successful, redirect to a success page
                response.sendRedirect("registration_success.jsp");
            } else {
                // Registration failed, redirect to an error page
                response.sendRedirect("index.jsp?error=Registration failed");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=Database error");
        }
       }
        else
        {
            response.sendRedirect("index.jsp?error=Registration failed");
        }
    }
}
