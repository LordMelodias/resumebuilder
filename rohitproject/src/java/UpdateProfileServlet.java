import jakarta.resource.cci.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/update_profile")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve user inputs from the form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String about = request.getParameter("about");
        String experience = request.getParameter("experience");
        String education = request.getParameter("education");
        String hobbies = request.getParameter("hobbies");

        // Validate the data (add more validation as needed)
        if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
            // Handle validation errors
            response.sendRedirect("edit_profile.jsp?error=Invalid input");
            return;
        }

        // Assuming you have already stored the username in the session during login
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Establish a database connection
            connection = getConnection();

            // Create a SQL query to update the user's profile data
            String sql = "UPDATE cv SET name = ?, email = ?, phone = ?, about = ?, experience = ?, education = ?, hobbies = ? WHERE username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, about);
            preparedStatement.setString(5, experience);
            preparedStatement.setString(6, education);
            preparedStatement.setString(7, hobbies);
            preparedStatement.setString(8, username);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Profile updated successfully, redirect to a success page
                response.sendRedirect("profile_updated.jsp");
            } else {
                // Profile update failed, redirect to an error page
                response.sendRedirect("edit_profile.jsp?error=Profile not updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("edit_profile.jsp?error=Database error");
        } finally {
            // Close resources in a finally block to ensure they are always closed
            closeResources(connection, preparedStatement, null);
        }
    }

    // Helper method to get a database connection
    private Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/project";
        String dbUsername = "root";
        String dbPassword = "root";
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
    }

    // Helper method to close database resources
    private void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
