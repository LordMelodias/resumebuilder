import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the session associated with the request
        HttpSession session = request.getSession();

        // Invalidate the session (log the user out)
        session.invalidate();

        // Redirect to a login or home page after logout
        response.sendRedirect("login.jsp"); // Replace with the appropriate URL
    }
}
