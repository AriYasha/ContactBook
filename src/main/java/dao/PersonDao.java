/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Person;
import entity.PhoneNumbers;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ирина
 */
public class PersonDao implements IPerson, AutoCloseable {

    private static final String url = "jdbc:mysql://localhost:3306/addressbooknote?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "1234";
    private PreparedStatement getAll = null;
    private PreparedStatement updateRecord = null;
    private PreparedStatement create = null;
    private PreparedStatement deleteContact = null;
    private PreparedStatement getPersonByFullName = null;
    private PreparedStatement getAllByIdPerson = null;
    private PreparedStatement getPersonByAddress = null;
    private Connection connection;

    public PersonDao() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
    }

    @Override
    public List<Person> getAll() throws SQLException {
        List<Person> listPerson = new ArrayList<>();
        try {
            getAll = connection.prepareStatement("SELECT id_person,Surname, Name,Patronymic,Address,Date FROM person");
            ResultSet resultSet = getAll.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                int id = resultSet.getInt("id_person");
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String patronymic = resultSet.getString("patronymic");
                String address = resultSet.getString("address");
                LocalDate date = LocalDate.parse(resultSet.getString("date"));
                person.setId(id);
                person.setSurname(surname);
                person.setName(name);
                person.setPatronymic(patronymic);
                person.setAddress(address);
                person.setDate(date);
                listPerson.add(person);
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return listPerson;
    }

    @Override
    public void close() throws Exception {
        SQLException exception = new SQLException("Some errors with closing");
        if (getAll != null) {
            try {
                getAll.close();
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
        if (getPersonByFullName != null) {
            try {
                getPersonByFullName.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (getPersonByAddress != null) {
            try {
                getPersonByAddress.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (getAllByIdPerson != null) {
            try {
                getAllByIdPerson.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (deleteContact != null) {
            try {
                deleteContact.close();
            } catch (SQLException e) {
                exception.addSuppressed(e);
            }
        }
        if (updateRecord != null) {
            try {

                updateRecord.close();

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
    public void update(Person person) throws SQLException {
        try {
            updateRecord = connection.prepareStatement(
                    "Update person SET surname = ?, name = ?, patronymic = ?, address = ? where id_person = ?");
            updateRecord.setString(1, person.getSurname());
            updateRecord.setString(2, person.getName());
            updateRecord.setString(3, person.getPatronymic());
            updateRecord.setString(4, person.getAddress());
            updateRecord.setInt(5, person.getId());
            updateRecord.execute();
            connection.commit();
            updateRecord.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
    }

    @Override
    public int create(Person person) throws SQLException {
        int key = 0;
        try {
            create = connection.prepareStatement(
                    "Insert into person (surname, name, patronymic, address,date)"
                    + "Values (?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
            create.setString(1, person.getSurname());
            create.setString(2, person.getName());
            create.setString(3, person.getPatronymic());
            create.setString(4, person.getAddress());
            create.setDate(5, Date.valueOf(person.getDate()));
            create.execute();
            ResultSet rs = create.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return key;
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            deleteContact = connection.prepareStatement("Delete FROM person where id_person = (?)");
            deleteContact.setInt(1, id);
            deleteContact.execute();
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.close();
        }

    }

    @Override
    public List<Person> getPersonByFullName(String surname, String name, String patronymic) throws SQLException {
        List<Person> listPerson = new ArrayList<>();
        try {
            getPersonByFullName = connection.prepareStatement("SELECT id_person,Surname, Name,Patronymic,Address,Date FROM person where surname = (?) and name =(?) and patronymic =(?)");
            getPersonByFullName.setString(1, surname);
            getPersonByFullName.setString(2, name);
            getPersonByFullName.setString(3, patronymic);
            ResultSet resultSet = getPersonByFullName.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id_person"));
                person.setSurname(resultSet.getString("surname"));
                person.setName(resultSet.getString("name"));
                person.setPatronymic(resultSet.getString("patronymic"));
                person.setAddress(resultSet.getString("address"));
                person.setDate(LocalDate.parse(resultSet.getString("date")));
                listPerson.add(person);
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return listPerson;
    }

    @Override
    public List<Person> getAllByIdPerson(int id) throws SQLException {
        List<Person> listPerson = new ArrayList<>();
        try {
            getAllByIdPerson = connection.prepareStatement("SELECT id_person,Surname, Name,Patronymic,Address,Date FROM person where id_person=(?)");
            getAllByIdPerson.setInt(1, id);
            ResultSet resultSet = getAllByIdPerson.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id_person"));
                person.setSurname(resultSet.getString("surname"));
                person.setName(resultSet.getString("name"));
                person.setPatronymic(resultSet.getString("patronymic"));
                person.setAddress(resultSet.getString("address"));
                person.setDate(LocalDate.parse(resultSet.getString("date")));
                listPerson.add(person);
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return listPerson;
    }

    @Override
    public List<Person> getPersonByAddress(String address) throws SQLException {
        List<Person> listPerson = new ArrayList<>();
        try {
            getPersonByAddress = connection.prepareStatement("SELECT id_person,Surname, Name,Patronymic,Address,Date FROM person where address = (?)");
            getPersonByAddress.setString(1, address);
            ResultSet resultSet = getPersonByAddress.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id_person"));
                person.setSurname(resultSet.getString("surname"));
                person.setName(resultSet.getString("name"));
                person.setPatronymic(resultSet.getString("patronymic"));
                person.setAddress(resultSet.getString("address"));
                person.setDate(LocalDate.parse(resultSet.getString("date")));
                listPerson.add(person);
            }
            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Something broke.\n" + ex.getMessage());
            ex.printStackTrace();
            connection.rollback();
        }
        return listPerson;
    }
}
