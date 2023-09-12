import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class view_resume extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("select * from cv where username = 'Rohit'");

            if (res.next()) {
                // Retrieve data from the ResultSet and set it as request attributes
                request.setAttribute("fullName", res.getString(3));
                request.setAttribute("email", res.getString(4));
                request.setAttribute("phone", res.getString(5));
                request.setAttribute("address", res.getString(6));
                request.setAttribute("experience", res.getString(7));
                request.setAttribute("education", res.getString(8));
                request.setAttribute("hobbies", res.getString(9));

                // Forward the request to the JSP page for rendering
                request.getRequestDispatcher("View_resume.jsp").forward(request, response);
            } else {
                // Data not found
                response.getWriter().println("Data not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Database error.");
        }
    }
}
