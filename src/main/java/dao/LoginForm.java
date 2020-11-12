/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Login;
import entity.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ирина
 */
public class LoginForm implements ILoginForm, AutoCloseable {

    private static final String url = "jdbc:mysql://localhost:3306/addressbooknote?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "1234";
    private PreparedStatement addGuest = null;
    private PreparedStatement getLogin = null;
    private PreparedStatement getPassword = null;
    private Connection connection;

    public LoginForm() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
    }

    @Override
    public void addNewGuest(String login, String password) throws SQLException {
        try {
            addGuest = connection.prepareStatement("Insert into loginform (login, pass) Values (?,?)");
            addGuest.setString(1, login);
            addGuest.setString(2, password);
            addGuest.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
    }

    @Override
    public String getGuest() {
        return null;
    }

    @Override
    public void close() throws Exception {
        SQLException exception = new SQLException("Some errors with closing");
        if (addGuest != null) {
            try {
                addGuest.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (getLogin != null) {
            try {

                getLogin.close();

            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (getPassword != null) {
            try {

                getPassword.close();

            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (connection != null) {
            try {

                connection.close();

            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }

    }

    @Override
    public String getLogin(String login) throws SQLException {
        String log = null;
        try {
            getLogin = connection.prepareStatement("SELECT login  FROM loginform where login = (?)");
            getLogin.setString(1, login);
            ResultSet resultSet = getLogin.executeQuery();
            while (resultSet.next()) {
                log = resultSet.getString("login");

            }
            connection.commit();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return log;
    }

    @Override
    public String getPassword(String password) throws SQLException {
        String pass = null;
        try {
            getPassword = connection.prepareStatement("SELECT pass  FROM loginform where pass = (?)");
            getPassword.setString(1, password);
            ResultSet resultSet = getPassword.executeQuery();
            while (resultSet.next()) {
                pass = resultSet.getString("pass");

            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return pass;
    }

    @Override
    public Login getLoginPassword(String login, String pass) throws SQLException {
        Login loginForm = new Login();
        try {
            getLogin = connection.prepareStatement("SELECT login, pass  FROM loginform where login = (?)");
            getLogin.setString(1, login);
            ResultSet resultSet = getLogin.executeQuery();
            while (resultSet.next()) {
                loginForm.setLogin(resultSet.getString("login"));
                loginForm.setPass(resultSet.getString("pass"));
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return loginForm;
    }
}
