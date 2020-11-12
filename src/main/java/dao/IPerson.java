/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Person;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ирина
 */
public interface IPerson {

    List<Person> getAll() throws SQLException;

    void update(Person person) throws SQLException;

    int create(Person person) throws SQLException;

    void delete(int id) throws SQLException;

    List<Person> getPersonByFullName(String surname, String name, String patronymic) throws SQLException;

    List<Person> getAllByIdPerson(int id) throws SQLException;

    List<Person> getPersonByAddress(String address) throws SQLException;

}
