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
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Random;


@WebServlet(name = "staffController")
public class staffController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println(action);
        System.out.println("action");

        if (action.equalsIgnoreCase("staff-login")) {
            staff Staff = new staff();
            String STAFFID = request.getParameter("STAFFID");
            String STAFFPASSWORD = request.getParameter("STAFFPASSWORD");
            Staff.setSTAFFID(STAFFID);
            Staff.setSTAFFPASSWORD(STAFFPASSWORD);
            Staff = staffDAO.staffLogin(Staff);
            if (Staff.isValid()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", Staff);
                response.sendRedirect("/poli/StaffIndex2.jsp");
            } else {
                System.out.println("Tiada data");
                response.sendRedirect("/poli/StaffLoginError.jsp");
            }
        }

        else if (action.equalsIgnoreCase("staff-login-forgot")) {
            staff Staff = new staff();
            String STAFFID = request.getParameter("STAFFID");
            String STAFFPASSWORD = request.getParameter("STAFFPASSWORD");
            Staff.setSTAFFID(STAFFID);
            Staff.setSTAFFPASSWORD(STAFFPASSWORD);
            Staff = staffDAO.staffLogin(Staff);
            if (Staff.isValid()) {

                String nullpassword = "null";
                Staff.setSTAFFPASSWORD(nullpassword);
                staffDAO.deletePassword(Staff);

                HttpSession session = request.getSession(true);
                session.setAttribute("user", Staff);
                response.sendRedirect("/poli/StaffIndex2.jsp");
            } else {
                System.out.println("Tiada data");
                response.sendRedirect("/CS/index.jsp");
            }
        }

        else if (action.equalsIgnoreCase("forgotPassword")) {

            staff Staff = new staff();

            //retrieve value from jsp file
            String STAFFID = request.getParameter("STAFFID");

            //set the rereived staff id in the STAFFID attribute
            Staff.setSTAFFID(STAFFID);

            /*****************************BEGIN CREATING RANDOM PASSWORD***************************/
            int length = 8;

            //assign characters into variables
            String char1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String char2 = "abcdefghijklmnopqrstuvwxyz";
            String char3 = "0123456789";
            String char4 = "!@#$&*?";

            //combine all the character into one variable
            String subcombine = char1 + char2 + char3 +char4;

            //assign random method and array for password
            Random rndm_method = new Random();
            char[] password = new char[length];

            //start looping for 8 character for the random password
            for (int i = 0; i < length; i++)
            {
                password[i] = subcombine.charAt(rndm_method.nextInt(subcombine.length()));
            }

            System.out.println(password);

            /******************************END CREATING RANDOM PASSWORD****************************/

            //set the new password in the STAFFPASSWORD attribute
            Staff.setSTAFFPASSWORD(String.valueOf(password));
            staffDAO.forgotPassword(Staff);

            //retreive data of the staff based on the ID
            Staff = staffDAO.detailForgotPassword(Staff);

            //option to choose which next page will be display after forgot password
            if (Staff.isValid()) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", Staff);
                response.sendRedirect("/poli/SuccessForgotPassword.jsp");
            } else {
                System.out.println("Tiada data");
                response.sendRedirect("/CS/index.jsp");
            }
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

                response.sendRedirect("/poli/staffController?action=displayStaff");
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
            response.sendRedirect("/poli/StaffSuccessUpdate.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter ("action");
        System.out.println("testt");
        if(action.equalsIgnoreCase("displayAllStaff")){
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
        else if(action.equalsIgnoreCase("displayPersonalDetails")){
            request.setAttribute("staffDetails", staffDAO.displayPersonalDetails());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/StaffViewProfile.jsp");
            requestDispatcher.forward(request,response);
        }
        else if(action.equalsIgnoreCase("logout")){
            HttpSession session = request.getSession(true);
            session.setAttribute("user",null);
            session.invalidate();
            response.sendRedirect("/poli/staffLogin.jsp");
        }
        else if(action.equalsIgnoreCase("deleteStaff")){
            String id = request.getParameter("STAFFID");
            staff Staff = new staff();
            Staff.setSTAFFID(id);
            staffDAO.deleteStaffInformation(Staff);
            System.out.println("Data deleted");
            response.sendRedirect("/poli/staffController?action=displayAllStaff");
        }
        else if(action.equalsIgnoreCase("updateStaff")){
            String id = request.getParameter("STAFFID");
            staff Staff = new staff();
            Staff.setSTAFFID(id);
            request.setAttribute("Staff",staffDAO.getStaffInformation(Staff));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/StaffUpdateProfile2.jsp");
            requestDispatcher.forward(request,response);
        }
    }
}
