package poli.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poli.model.staff;
import poli.dao.staffDAO;

public class SMSController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SMSController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String STAFFID = request.getParameter("STAFFID");
        String STAFFPHONE = request.getParameter("STAFFPHONE");
        String STAFFPASSWORD = request.getParameter("STAFFPASSWORD");
        System.out.println(STAFFID);

        String str="You have requested a recovery password for Email Management System in Polytechnic Malacca. Your ID Number : " + STAFFID + ". Your recovery password is : " + STAFFPASSWORD + ". This password can be used only once. Please update your password in the system. Thank you.";

        String dstno=STAFFPHONE;

        String user="sms2017";
        String pass="sms2017";
        String sendid="60199861329";
        int type=2;
        String agreement="Yes";
        try
        {
            String msg=str.replace(" ","%20");
            URL myUrl = new URL("http://www.isms.com.my/isms_send.php?un=" + user + "&pwd=" + pass + "&dstno=" + dstno + "&msg=" + msg + "&type=" + type + "&sendid=" + sendid + "&agreedterm=" + agreement);
            URLConnection conn=myUrl.openConnection();
            conn.setDoOutput(true);
            //get response
            BufferedReader rd= new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line=rd.readLine())!=null)
            {
                System.out.println(line);
                out.println("<script type=\"text/javascript\">");
                out.println("alert('"+line+"');");
                out.println("location='StaffLoginForgotPassword.jsp';");
                out.println("</script>");
            }
            rd.close();
            System.out.println(myUrl);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
