package poli.controller;

import poli.dao.staffDAO;
import poli.dao.adminDAO;
import poli.model.staff;
import poli.model.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "adminController")
public class adminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println(action);
        System.out.println("action");

        if (action.equalsIgnoreCase("admin-login")) {
            admin Admin = new admin();
            String ADMID = request.getParameter("ADMID");
            String ADMPASSWORD = request.getParameter("ADMPASSWORD");
            Admin.setADMID(ADMID);
            Admin.setADMPASSWORD(ADMPASSWORD);
            Admin = adminDAO.adminLogin(Admin);
            if (Admin.isValid()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", Admin);
                response.sendRedirect("/poli/AdminIndex.jsp");
            } else {
                System.out.println("Tiada data");
                response.sendRedirect("/poli/AdminLoginError.jsp");
            }
        }
        else if(action.equalsIgnoreCase("create-admin")){
            admin Admin = new admin();
            Admin.setADMID(request.getParameter("ADMID"));
            Admin.setADMNAME(request.getParameter("ADMNAME"));
            Admin.setADMIC(request.getParameter("ADMIC"));
            Admin.setADMPHONE(request.getParameter("ADMPHONE"));
            Admin.setADMUSERNAME(request.getParameter("ADMUSERNAME"));
            Admin.setADMPASSWORD(request.getParameter("ADMPASSWORD"));


            Admin = adminDAO.getAdminInformation(Admin);
            if(!Admin.isValid()){
                adminDAO.createAdminInformation(Admin);
                response.sendRedirect("/poli/adminController?action=displayAllAdmin");
            }
            else {
                System.out.println("Data already available");
                response.sendRedirect("/poli/create-staff.jsp");
            }

        }
        else if(action.equalsIgnoreCase("update-admin")){
            System.out.println("admin update");
            admin Admin = new admin();
            Admin.setADMID(request.getParameter("ADMID"));
            Admin.setADMNAME(request.getParameter("ADMNAME"));
            Admin.setADMIC(request.getParameter("ADMIC"));
            Admin.setADMPHONE(request.getParameter("ADMPHONE"));
            Admin.setADMUSERNAME(request.getParameter("ADMUSERNAME"));
            Admin.setADMPASSWORD(request.getParameter("ADMPASSWORD"));
            adminDAO.updateAdminInformation(Admin);
            response.sendRedirect("/poli/adminController?action=displayAllAdmin");
        }

        else if(action.equalsIgnoreCase("create-staff")){
            staff Staff = new staff();

            //retrieve value from jsp file
            Staff.setSTAFFID(request.getParameter("STAFFID"));
            Staff.setSTAFFNAME(request.getParameter("STAFFNAME"));
            Staff.setSTAFFLASTNAME(request.getParameter("STAFFLASTNAME"));
            Staff.setSTAFFIC(request.getParameter("STAFFIC"));
            Staff.setSTAFFADDRESS(request.getParameter("STAFFADDRESS"));
            Staff.setSTAFFPOS(request.getParameter("STAFFPOS"));
            Staff.setSTAFFDEPT(request.getParameter("STAFFDEPT"));
            Staff.setSTAFFEMAIL(request.getParameter("STAFFEMAIL"));
            Staff.setSTAFFPHONE(request.getParameter("STAFFPHONE"));

            /****************************BEGIN CREATING PASSWORD***************************/

            //assigning user input into variables --- FIRST STEP

            String STAFFNAME=request.getParameter("STAFFNAME");
            String STAFFIC=request.getParameter("STAFFIC");
            String STAFFADDRESS=request.getParameter("STAFFADDRESS");

            //creating 3 substring to generate password ---- SECOND STEP
            String sub1 = STAFFNAME.substring(0, 3);
            String sub2 = STAFFIC.substring(0, 2);
            String sub3 = STAFFADDRESS.substring(0, 3);
            System.out.println(sub1);
            System.out.println(sub2);
            System.out.println(sub3);

            //combining all the substring into one string --- THIRD STEP
            String password = sub1 + sub2 + sub3;
            System.out.println(password);

            //change the first letter of password into capital letter --- FOURTH STEP
            String pass = password.substring(0, 1).toUpperCase() + password.substring(1);
            System.out.println(pass);

            //set the new password in the staff PASSWORD attribute
            Staff.setSTAFFPASSWORD(pass);

            /****************************END CREATING PASSWORD***************************/

            /******************************BEGIN CREATING EMAIL****************************/

            //assigning staff id into a variable
            String STAFFID=request.getParameter("STAFFID");

            //remove space in staff name
            String sub5 = STAFFNAME.replace(" ","");
            System.out.println(sub5);

            //assigning email address into a variable
            String sub6 = "@poli.edu.melaka";
            System.out.println(sub6);

            //combining sub4 and sub5 into one string
            String emailname = sub5 + STAFFID +sub6;
            System.out.println(emailname);

            //set the new email in the staff  attribute
            Staff.setNEWEMAIL(emailname);

            /******************************END CREATING EMAIL****************************/

            Staff = staffDAO.getStaffInformation(Staff);
            if(!Staff.isValid()){
                staffDAO.createStaffInformation(Staff);

                response.sendRedirect("/poli/adminController?action=displayAllStaff");
            }
            else {
                System.out.println("Data already available");
                response.sendRedirect("/poli/create-staff.jsp");
            }

        }
        else if(action.equalsIgnoreCase("update-staff")){
            System.out.println("updateee");
            staff Staff = new staff();
            Staff.setSTAFFID(request.getParameter("STAFFID"));
            Staff.setSTAFFNAME(request.getParameter("STAFFNAME"));
            Staff.setSTAFFLASTNAME(request.getParameter("STAFFLASTNAME"));
            Staff.setSTAFFIC(request.getParameter("STAFFIC"));
            Staff.setSTAFFADDRESS(request.getParameter("STAFFADDRESS"));
            Staff.setSTAFFPOS(request.getParameter("STAFFPOS"));
            Staff.setSTAFFDEPT(request.getParameter("STAFFDEPT"));
            Staff.setSTAFFEMAIL(request.getParameter("STAFFEMAIL"));
            Staff.setSTAFFPHONE(request.getParameter("STAFFPHONE"));
            Staff.setSTAFFPASSWORD(request.getParameter("STAFFPASSWORD"));
            Staff.setNEWEMAIL(request.getParameter("NEWEMAIL"));
            staffDAO.updateStaffInformation(Staff);
            response.sendRedirect("/poli/adminController?action=displayAllStaff");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter ("action");
        System.out.println("testt");
        if(action.equalsIgnoreCase("displayAllAdmin")){
            System.out.println("display all admin");
            request.setAttribute("adminList", adminDAO.displayAllAdmin());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminViewAdmin.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(action.equalsIgnoreCase("displayPersonalDetails")){
            request.setAttribute("adminDetails", adminDAO.displayPersonalDetails());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminViewProfile.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(action.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession(true);
            session.setAttribute("user",null);
            session.invalidate();
            response.sendRedirect("/poli/staffLogin.jsp");
        }
        else if(action.equalsIgnoreCase("deleteAdmin")){
            String id = request.getParameter("ADMID");
            admin Admin = new admin();
            Admin.setADMID(id);
            adminDAO.deleteAdminInformation(Admin);
            System.out.println("Data deleted");
            response.sendRedirect("/poli/adminController?action=displayAllAdmin");
        }
        else if(action.equalsIgnoreCase("updateAdmin")){
            String id = request.getParameter("ADMID");
            admin Admin = new admin();
            Admin.setADMID(id);
            request.setAttribute("Admin",adminDAO.getAdminInformation(Admin));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminUpdateAdmin.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(action.equalsIgnoreCase("displayAllStaff")){
            System.out.println("DISPLAY ALL STAFF");
            request.setAttribute("staffList", staffDAO.displayAllStaff());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminViewEmail.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(action.equalsIgnoreCase("displayStaff")){
            System.out.println("DISPLAY ALL STAFF");
            request.setAttribute("staffList", staffDAO.displayStaff());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/StaffSuccess.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(action.equalsIgnoreCase("displayDetails")){
            request.setAttribute("staffDetails", staffDAO.displayPersonalDetails());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/StaffUpdateProfile.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(action.equalsIgnoreCase("deleteStaff")){
            String id = request.getParameter("STAFFID");
            staff Staff = new staff();
            Staff.setSTAFFID(id);
            staffDAO.deleteStaffInformation(Staff);
            System.out.println("Data deleted");
            response.sendRedirect("/poli/adminController?action=displayAllStaff");
        }
        else if(action.equalsIgnoreCase("updateStaff")){
            String id = request.getParameter("STAFFID");
            staff Staff = new staff();
            Staff.setSTAFFID(id);
            request.setAttribute("Staff",staffDAO.getStaffInformation(Staff));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/AdminUpdateEmail.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
