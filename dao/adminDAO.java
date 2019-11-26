package poli.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import poli.connectionManager;
import poli.model.admin;
import poli.model.staff;

public class adminDAO {

    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    //function
    public static admin adminLogin (admin Admin){
        String ADMID = Admin.getADMID();
        String ADMPASSWORD = Admin.getADMPASSWORD();

        String query = "select * from admin where ADMID = '" + ADMID + "' and ADMPASSWORD = '"+ ADMPASSWORD + "'";
        try{
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            boolean exist = resultSet.next();
            if(exist){
                Admin.setADMID(resultSet.getString("ADMID"));
                Admin.setADMNAME(resultSet.getString("ADMNAME"));
                Admin.setADMIC(resultSet.getString("ADMIC"));
                Admin.setADMPHONE(resultSet.getString("ADMPHONE"));
                Admin.setADMUSERNAME(resultSet.getString("ADMUSERNAME"));
                Admin.setADMPASSWORD(resultSet.getString("ADMPASSWORD"));

                Admin.setValid(true);
            }
            else if(!exist) {
                Admin.setValid(false);
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

        return Admin;

    }
    public static void createAdminInformation(admin Admin){

        String query = "insert into ADMIN(ADMID, ADMNAME, ADMIC, ADMPHONE, ADMUSERNAME, ADMPASSWORD) " +
                "values (?,?,?,?,?,?)";
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,Admin.getADMID());
            preparedStatement.setString(2,Admin.getADMNAME());
            preparedStatement.setString(3,Admin.getADMIC());
            preparedStatement.setString(4,Admin.getADMPHONE());
            preparedStatement.setString(5,Admin.getADMUSERNAME());
            preparedStatement.setString(6,Admin.getADMPASSWORD());

            preparedStatement.executeUpdate();
            System.out.println("admin create");
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

    public static admin getAdminInformation(admin Admin){

        String query = "select * from ADMIN where ADMID = '" + Admin.getADMID() + "'";
        try {
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            boolean exist = resultSet.next();
            if(exist){
                Admin.setADMID(resultSet.getString("ADMID"));
                Admin.setADMNAME(resultSet.getString("ADMNAME"));
                Admin.setADMIC(resultSet.getString("ADMIC"));
                Admin.setADMPHONE(resultSet.getString("ADMPHONE"));
                Admin.setADMUSERNAME(resultSet.getString("ADMUSERNAME"));
                Admin.setADMPASSWORD(resultSet.getString("ADMPASSWORD"));

                System.out.println("true");
                Admin.setValid(true);
            }
            else {
                System.out.println("false");
                Admin.setValid(false);
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

        return Admin;

    }

    public static void updateAdminInformation(admin Admin){

        String query = "update ADMIN " +
                "set ADMNAME = ?, " +
                "ADMIC = ?, " +
                "ADMPHONE = ?, " +
                "ADMUSERNAME = ?, " +
                "ADMPASSWORD = ? " +
                "where ADMID = ?";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,Admin.getADMNAME());
            preparedStatement.setString(2,Admin.getADMIC());
            preparedStatement.setString(3,Admin.getADMPHONE());
            preparedStatement.setString(4,Admin.getADMUSERNAME());
            preparedStatement.setString(5,Admin.getADMPASSWORD());
            preparedStatement.setString(6,Admin.getADMID());
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

    public static List<admin> displayPersonalDetails(){
        List<admin> adminDetails = new ArrayList<admin>();

        String query = "select * from ADMIN";
        try {
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                admin Admin = new admin();
                Admin.setADMID(resultSet.getString("ADMID"));
                Admin.setADMNAME(resultSet.getString("ADMNAME"));
                Admin.setADMIC(resultSet.getString("ADMIC"));
                Admin.setADMPHONE(resultSet.getString("ADMPHONE"));
                Admin.setADMUSERNAME(resultSet.getString("ADMUSERNAME"));
                Admin.setADMPASSWORD(resultSet.getString("ADMPASSWORD"));
                adminDetails.add(Admin);
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

        return adminDetails;
    }



    public static List<admin> displayAllAdmin(){
        List<admin> adminList = new ArrayList<admin>();

        String query = "select * from ADMIN";
        try {
            connection = connectionManager.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                admin Admin = new admin();
                Admin.setADMID(resultSet.getString("ADMID"));
                Admin.setADMNAME(resultSet.getString("ADMNAME"));
                Admin.setADMIC(resultSet.getString("ADMIC"));
                Admin.setADMPHONE(resultSet.getString("ADMPHONE"));
                Admin.setADMUSERNAME(resultSet.getString("ADMUSERNAME"));
                Admin.setADMPASSWORD(resultSet.getString("ADMPASSWORD"));

                adminList.add(Admin);
                System.out.println("Masuk display all admin -- dao");
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

        return adminList;
    }

    public static void deleteAdminInformation(admin Admin){

        String query = "delete from ADMIN where ADMID = ?";
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,Admin.getADMID());
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
