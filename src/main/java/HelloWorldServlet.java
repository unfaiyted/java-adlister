import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {


        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        //out.println(req.getParameter("name"));

        if(req.getParameter("name") == null) {
            out.println("<h1>Hello, World!</h1>");
        } else {
            out.println("<h1>Hello, "+ req.getParameter("name") +"</h1>");
        }

    }
}


