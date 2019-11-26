package poli.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import poli.connectionManager;
import poli.model.staff;

public class staffDAO {

    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    //function
    public static staff staffLogin (staff Staff){
        String STAFFID = Staff.getSTAFFID();
        String STAFFPASSWORD = Staff.getSTAFFPASSWORD();

        String query = "select * from staff where STAFFID = '" + STAFFID + "' and STAFFPASSWORD = '"+ STAFFPASSWORD + "'";
        try{
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            boolean exist = resultSet.next();
            if(exist){
                Staff.setSTAFFID(resultSet.getString("STAFFID"));
                Staff.setSTAFFNAME(resultSet.getString("STAFFNAME"));
                Staff.setSTAFFLASTNAME(resultSet.getString("STAFFLASTNAME"));
                Staff.setSTAFFIC(resultSet.getString("STAFFIC"));
                Staff.setSTAFFADDRESS(resultSet.getString("STAFFADDRESS"));
                Staff.setSTAFFPOS(resultSet.getString("STAFFPOS"));
                Staff.setSTAFFDEPT(resultSet.getString("STAFFDEPT"));
                Staff.setSTAFFEMAIL(resultSet.getString("STAFFEMAIL"));
                Staff.setSTAFFPHONE(resultSet.getString("STAFFPHONE"));
                Staff.setSTAFFPASSWORD(resultSet.getString("STAFFPASSWORD"));
                Staff.setNEWEMAIL(resultSet.getString("NEWEMAIL"));

                Staff.setValid(true);
            }
            else if(!exist) {
                Staff.setValid(false);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        finally {
            if(resultSet != null){
                try {resultSet.close();}
                catch (Exception e){}
                resultSet = null;
            }
            if(statement != null){
                try {statement.close();}
                catch (Exception e){}
                statement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }

        return Staff;

    }

    //FORGOT PASSWORD
    public static staff detailForgotPassword (staff Staff){
        String STAFFID = Staff.getSTAFFID();

        String query = "select * from STAFF where STAFFID = '" + STAFFID + "'";
        try{
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            boolean exist = resultSet.next();
            if(exist){
                Staff.setSTAFFID(resultSet.getString("STAFFID"));
                Staff.setSTAFFNAME(resultSet.getString("STAFFNAME"));
                Staff.setSTAFFLASTNAME(resultSet.getString("STAFFLASTNAME"));
                Staff.setSTAFFIC(resultSet.getString("STAFFIC"));
                Staff.setSTAFFADDRESS(resultSet.getString("STAFFADDRESS"));
                Staff.setSTAFFPOS(resultSet.getString("STAFFPOS"));
                Staff.setSTAFFDEPT(resultSet.getString("STAFFDEPT"));
                Staff.setSTAFFEMAIL(resultSet.getString("STAFFEMAIL"));
                Staff.setSTAFFPHONE(resultSet.getString("STAFFPHONE"));
                Staff.setSTAFFPASSWORD(resultSet.getString("STAFFPASSWORD"));
                Staff.setNEWEMAIL(resultSet.getString("NEWEMAIL"));

                Staff.setValid(true);
            }
            else if(!exist) {
                Staff.setValid(false);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        finally {
            if(resultSet != null){
                try {resultSet.close();}
                catch (Exception e){}
                resultSet = null;
            }
            if(statement != null){
                try {statement.close();}
                catch (Exception e){}
                statement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }

        return Staff;

    }

    public static void forgotPassword(staff Staff){

        String query = "update STAFF " +
                "set STAFFPASSWORD = ? " +
                "where STAFFID = ?";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,Staff.getSTAFFPASSWORD());
            preparedStatement.setString(2,Staff.getSTAFFID());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){e.printStackTrace();}
        finally {
            if(preparedStatement != null){
                try {preparedStatement.close();}
                catch (Exception e){}
                preparedStatement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }

    }

    public static void deletePassword(staff Staff){

        String query = "update STAFF " +
                "set STAFFPASSWORD = ? " +
                "where STAFFID = ?";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,Staff.getSTAFFPASSWORD());
            preparedStatement.setString(2,Staff.getSTAFFID());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){e.printStackTrace();}
        finally {
            if(preparedStatement != null){
                try {preparedStatement.close();}
                catch (Exception e){}
                preparedStatement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }

    }

    public static void createStaffInformation(staff Staff){

        String query = "insert into STAFF(STAFFID, STAFFNAME, STAFFLASTNAME, STAFFIC, STAFFADDRESS, STAFFPOS, STAFFDEPT, STAFFEMAIL, STAFFPHONE, STAFFPASSWORD, NEWEMAIL) " +
                "values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,Staff.getSTAFFID());
            preparedStatement.setString(2,Staff.getSTAFFNAME());
            preparedStatement.setString(3,Staff.getSTAFFLASTNAME());
            preparedStatement.setString(4,Staff.getSTAFFIC());
            preparedStatement.setString(5,Staff.getSTAFFADDRESS());
            preparedStatement.setString(6,Staff.getSTAFFPOS());
            preparedStatement.setString(7,Staff.getSTAFFDEPT());
            preparedStatement.setString(8,Staff.getSTAFFEMAIL());
            preparedStatement.setString(9,Staff.getSTAFFPHONE());
            preparedStatement.setString(10,Staff.getSTAFFPASSWORD());
            preparedStatement.setString(11,Staff.getNEWEMAIL());

            preparedStatement.executeUpdate();
            System.out.println("createe");
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        finally {
            if(preparedStatement != null){
                try {preparedStatement.close();}
                catch (Exception e){}
                preparedStatement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }


    }

    public static staff getStaffInformation(staff Staff){

        String query = "select * from STAFF where STAFFID = '" + Staff.getSTAFFID() + "'";
        try {
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            boolean exist = resultSet.next();
            if(exist){
                Staff.setSTAFFID(resultSet.getString("STAFFID"));
                Staff.setSTAFFNAME(resultSet.getString("STAFFNAME"));
                Staff.setSTAFFLASTNAME(resultSet.getString("STAFFLASTNAME"));
                Staff.setSTAFFIC(resultSet.getString("STAFFIC"));
                Staff.setSTAFFADDRESS(resultSet.getString("STAFFADDRESS"));
                Staff.setSTAFFPOS(resultSet.getString("STAFFPOS"));
                Staff.setSTAFFDEPT(resultSet.getString("STAFFDEPT"));
                Staff.setSTAFFEMAIL(resultSet.getString("STAFFEMAIL"));
                Staff.setSTAFFPHONE(resultSet.getString("STAFFPHONE"));
                Staff.setSTAFFPASSWORD(resultSet.getString("STAFFPASSWORD"));
                Staff.setNEWEMAIL(resultSet.getString("NEWEMAIL"));
                System.out.println("true");
                Staff.setValid(true);
            }
            else {
                System.out.println("false");
                Staff.setValid(false);
            }
        }catch(SQLException e){e.printStackTrace();}

        finally {
            if(resultSet != null){
                try {resultSet.close();}
                catch (Exception e){}
                resultSet = null;
            }
            if(statement != null){
                try {statement.close();}
                catch (Exception e){}
                statement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }

        return Staff;

    }

    public static void updateStaffInformation(staff Staff){

        String query = "update STAFF " +
                "set STAFFNAME = ?, " +
                "STAFFLASTNAME = ?, " +
                "STAFFIC = ?, " +
                "STAFFADDRESS = ?, " +
                "STAFFPOS = ?, " +
                "STAFFDEPT = ?, " +
                "STAFFEMAIL = ?, " +
                "STAFFPHONE = ?, " +
                "STAFFPASSWORD = ?, " +
                "NEWEMAIL = ? " +
                "where STAFFID = ?";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,Staff.getSTAFFNAME());
            preparedStatement.setString(2,Staff.getSTAFFLASTNAME());
            preparedStatement.setString(3,Staff.getSTAFFIC());
            preparedStatement.setString(4,Staff.getSTAFFADDRESS());
            preparedStatement.setString(5,Staff.getSTAFFPOS());
            preparedStatement.setString(6,Staff.getSTAFFDEPT());
            preparedStatement.setString(7,Staff.getSTAFFEMAIL());
            preparedStatement.setString(8,Staff.getSTAFFPHONE());
            preparedStatement.setString(9,Staff.getSTAFFPASSWORD());
            preparedStatement.setString(10,Staff.getNEWEMAIL());
            preparedStatement.setString(11,Staff.getSTAFFID());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){e.printStackTrace();}
        finally {
            if(preparedStatement != null){
                try {preparedStatement.close();}
                catch (Exception e){}
                preparedStatement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }

    }

    public static List<staff> displayPersonalDetails(){
        List<staff> staffDetails = new ArrayList<staff>();

        String query = "select * from STAFF";
        try {
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                staff Staff = new staff();
                Staff.setSTAFFID(resultSet.getString("STAFFID"));
                Staff.setSTAFFNAME(resultSet.getString("STAFFNAME"));
                Staff.setSTAFFLASTNAME(resultSet.getString("STAFFLASTNAME"));
                Staff.setSTAFFIC(resultSet.getString("STAFFIC"));
                Staff.setSTAFFADDRESS(resultSet.getString("STAFFADDRESS"));
                Staff.setSTAFFPOS(resultSet.getString("STAFFPOS"));
                Staff.setSTAFFDEPT(resultSet.getString("STAFFDEPT"));
                Staff.setSTAFFEMAIL(resultSet.getString("STAFFEMAIL"));
                Staff.setSTAFFPHONE(resultSet.getString("STAFFPHONE"));
                Staff.setSTAFFPASSWORD(resultSet.getString("STAFFPASSWORD"));
                Staff.setNEWEMAIL(resultSet.getString("NEWEMAIL"));
                staffDetails.add(Staff);
                System.out.println("Masuk display personal detail staff dao");
            }
        }
        catch(SQLException e){e.printStackTrace();}

        finally {
            if(resultSet != null){
                try {resultSet.close();}
                catch (Exception e){}
                resultSet = null;
            }
            if(statement != null){
                try {statement.close();}
                catch (Exception e){}
                statement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }

        return staffDetails;
    }


    public static List<staff> displayAllStaff(){
        List<staff> staffList = new ArrayList<staff>();

        String query = "select * from STAFF";
        try {
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                staff Staff = new staff();
                Staff.setSTAFFID(resultSet.getString("STAFFID"));
                Staff.setSTAFFNAME(resultSet.getString("STAFFNAME"));
                Staff.setSTAFFLASTNAME(resultSet.getString("STAFFLASTNAME"));
                Staff.setSTAFFIC(resultSet.getString("STAFFIC"));
                Staff.setSTAFFADDRESS(resultSet.getString("STAFFADDRESS"));
                Staff.setSTAFFPOS(resultSet.getString("STAFFPOS"));
                Staff.setSTAFFDEPT(resultSet.getString("STAFFDEPT"));
                Staff.setSTAFFEMAIL(resultSet.getString("STAFFEMAIL"));
                Staff.setSTAFFPHONE(resultSet.getString("STAFFPHONE"));
                Staff.setSTAFFPASSWORD(resultSet.getString("STAFFPASSWORD"));
                Staff.setNEWEMAIL(resultSet.getString("NEWEMAIL"));
                staffList.add(Staff);
                System.out.println("Masuk diaplay all staff -- dao");
            }
        }
        catch(SQLException e){e.printStackTrace();}

        finally {
            if(resultSet != null){
                try {resultSet.close();}
                catch (Exception e){}
                resultSet = null;
            }
            if(statement != null){
                try {statement.close();}
                catch (Exception e){}
                statement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }

        return staffList;
    }

    public static List<staff> displayStaff(){
        List<staff> staffList = new ArrayList<staff>();

        String query = "select * from STAFF where rownum = 1";
        try {
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                staff Staff = new staff();
                Staff.setSTAFFID(resultSet.getString("STAFFID"));
                Staff.setSTAFFNAME(resultSet.getString("STAFFNAME"));
                Staff.setSTAFFLASTNAME(resultSet.getString("STAFFLASTNAME"));
                Staff.setSTAFFIC(resultSet.getString("STAFFIC"));
                Staff.setSTAFFADDRESS(resultSet.getString("STAFFADDRESS"));
                Staff.setSTAFFPOS(resultSet.getString("STAFFPOS"));
                Staff.setSTAFFDEPT(resultSet.getString("STAFFDEPT"));
                Staff.setSTAFFEMAIL(resultSet.getString("STAFFEMAIL"));
                Staff.setSTAFFPHONE(resultSet.getString("STAFFPHONE"));
                Staff.setSTAFFPASSWORD(resultSet.getString("STAFFPASSWORD"));
                Staff.setNEWEMAIL(resultSet.getString("NEWEMAIL"));
                staffList.add(Staff);
                System.out.println("Masuk diaplay all staff -- dao");
            }
        }
        catch(SQLException e){e.printStackTrace();}

        finally {
            if(resultSet != null){
                try {resultSet.close();}
                catch (Exception e){}
                resultSet = null;
            }
            if(statement != null){
                try {statement.close();}
                catch (Exception e){}
                statement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }

        return staffList;
    }

    public static void deleteStaffInformation(staff Staff){

        String query = "delete from STAFF where STAFFID = ?";
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,Staff.getSTAFFID());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){e.printStackTrace();}
        finally {
            if(preparedStatement != null){
                try {preparedStatement.close();}
                catch (Exception e){}
                preparedStatement = null;
            }
            if(connection != null){
                try {connection.close();}
                catch (Exception e){}
                connection = null;
            }
        }
    }


}
