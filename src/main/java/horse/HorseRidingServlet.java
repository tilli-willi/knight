package horse;

import horse.algorythm.HorseRiding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class HorseRidingServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.print(new HorseRiding(
                Integer.parseInt(request.getParameter("width")),
                Integer.parseInt(request.getParameter("height")),
                request.getParameter("start"),
                request.getParameter("end")).countDistance());
    }
}
