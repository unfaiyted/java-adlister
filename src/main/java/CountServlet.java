import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {
    private int hitCount;


    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if(req.getParameter("reset") != null && req.getParameter("reset").equalsIgnoreCase("yes")) {
             hitCount = 0;
        }
        hitCount++;

        out.println("<h1>Count: "+ hitCount  +"</h1>");


    }
}