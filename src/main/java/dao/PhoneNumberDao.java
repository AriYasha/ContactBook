/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.PhoneNumbers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ирина
 */
public class PhoneNumberDao implements IPhoneNumber, AutoCloseable {

    private static final String url = "jdbc:mysql://localhost:3306/addressbooknote?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "1234";
    private Connection connection;
    private PreparedStatement getByPersonId = null;
    private PreparedStatement update = null;
    private PreparedStatement deleteNumbers = null;
    private PreparedStatement deleteByIdPerson = null;
    private PreparedStatement create = null;
    private PreparedStatement getAllByNumber = null;

    public PhoneNumberDao() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
    }

    @Override
    public void close() throws Exception {
        SQLException exception = new SQLException("Some errors with closing");
        if (getByPersonId != null) {
            try {
                getByPersonId.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (getAllByNumber != null) {
            try {
                getAllByNumber.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (deleteByIdPerson != null) {
            try {
                deleteByIdPerson.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (deleteNumbers != null) {
            try {
                deleteNumbers.close();

            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }

        if (update != null) {
            try {
                update.close();

            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (create != null) {
            try {
                create.close();

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
    public List<PhoneNumbers> getByPersonId(int personId) throws SQLException {
        List<PhoneNumbers> phoneNumbers = new ArrayList<>();
        try {
            getByPersonId = connection.prepareStatement("SELECT id_phoneNumbers, number, type  FROM phonenumbers where id_person = (?)");
            getByPersonId.setInt(1, personId);
            ResultSet resultSet = getByPersonId.executeQuery();
            while (resultSet.next()) {
                PhoneNumbers phoneNumber = new PhoneNumbers();
                phoneNumber.setId(resultSet.getInt("id_phoneNumbers"));
                phoneNumber.setNumber(resultSet.getString("number"));
                phoneNumber.setType(resultSet.getString("type"));
                phoneNumber.setIdPerson(personId);
                phoneNumbers.add(phoneNumber);
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return phoneNumbers;
    }

    @Override
    public void update(List<PhoneNumbers> phoneNumbers) throws SQLException {
        try {
            update = connection.prepareStatement(
                    "Update phoneNumbers SET number = (?), type = (?)"
                    + "where id_phoneNumbers = (?)");
            for (PhoneNumbers listPhoneNumbers : phoneNumbers) {
                update.setString(1, listPhoneNumbers.getNumber());
                update.setString(2, listPhoneNumbers.getType());
                update.setInt(3, listPhoneNumbers.getId());
                update.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
    }

    @Override
    public void delete(List<PhoneNumbers> listNumbers) throws SQLException {
        try {
            deleteNumbers = connection.prepareStatement("Delete FROM phonenumbers where id_phoneNumbers = (?)");
            for (PhoneNumbers phoneNumbers : listNumbers) {
                deleteNumbers.setInt(1, phoneNumbers.getId());
                deleteNumbers.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.close();
        }

    }

    @Override
    public void update(PhoneNumbers phoneNumber) throws SQLException {
        try {
            update = connection.prepareStatement(
                    "Update phoneNumbers SET number = (?), type = (?)"
                    + "where id_phoneNumbers = (?)");
            update.setString(1, phoneNumber.getNumber());
            update.setString(2, phoneNumber.getType());
            update.setInt(3, phoneNumber.getId());
            update.executeUpdate();
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
    }

    @Override
    public void create(PhoneNumbers phoneNumbers) throws SQLException {
        try {
            create = connection.prepareStatement("insert into phoneNumbers ( number, type, id_person) Values (?,?,?)");
            create.setString(1, phoneNumbers.getNumber());
            create.setString(2, phoneNumbers.getType());
            create.setInt(3, phoneNumbers.getIdPerson());
            create.execute();
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }

    }

    @Override
    public void addNewContacts(List<PhoneNumbers> phoneNumbers) throws SQLException {
        try {
            create = connection.prepareStatement("insert into phonenumbers ( number, type, id_person) Values (?,?,?)");
            for (PhoneNumbers phoneNumber : phoneNumbers) {
                create.setString(1, phoneNumber.getNumber());
                create.setString(2, phoneNumber.getType());
                create.setInt(3, phoneNumber.getIdPerson());
                create.execute();
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
    }

    @Override
    public void deleteByIdPeson(int id) throws SQLException {
        try {
            deleteByIdPerson = connection.prepareStatement("Delete FROM phonenumbers where id_person = (?)");
            deleteByIdPerson.setInt(1, id);
            deleteByIdPerson.execute();
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.close();
        }

    }

    @Override
    public PhoneNumbers getAllByNumber(String number) throws SQLException {
        PhoneNumbers phoneNumber = new PhoneNumbers();
        try {
            getAllByNumber = connection.prepareStatement("SELECT id_phoneNumbers, number, type, id_person  FROM phonenumbers where number = (?)");
            getAllByNumber.setString(1, number);
            ResultSet resultSet = getAllByNumber.executeQuery();
            while (resultSet.next()) {
                phoneNumber.setId(resultSet.getInt("id_phoneNumbers"));
                phoneNumber.setNumber(resultSet.getString("number"));
                phoneNumber.setType(resultSet.getString("type"));
                phoneNumber.setIdPerson(resultSet.getInt("id_person"));
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return phoneNumber;

    }

}
