package poli.controller;

import poli.dao.staffDAO;
import poli.model.staff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginController")
public class loginController extends HttpServlet {

    private staffDAO staffDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            staff Staff = new staff();
            Staff.setSTAFFID(request.getParameter("STAFFID"));
            Staff.setSTAFFNAME(request.getParameter("STAFFNAME"));
            Staff.setSTAFFIC(request.getParameter("STAFFIC"));
            Staff.setSTAFFADDRESS(request.getParameter("STAFFADDRESS"));
            Staff.setSTAFFPOS(request.getParameter("STAFFPOS"));
            Staff.setSTAFFDEPT(request.getParameter("STAFFDEPT"));
            Staff.setSTAFFEMAIL(request.getParameter("STAFFEMAIL"));
            Staff.setSTAFFPHONE(request.getParameter("STAFFPHONE"));
            Staff = staffDAO.staffLogin(Staff);
            if(Staff.isValid()){
                HttpSession session = request.getSession(true);
                session.setAttribute("user",Staff);
                response.sendRedirect("/poli/AdminIndex.jsp");
            }
            else {
                System.out.println("Tak ada");
            }
        }
        catch(Exception e){e.printStackTrace();}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
