/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.PhoneNumbers;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ирина
 */
public interface IPhoneNumber {

    List<PhoneNumbers> getByPersonId(int personId) throws SQLException;

    void update(List<PhoneNumbers> phoneNumbers) throws SQLException;

    void update(PhoneNumbers phoneNumber) throws SQLException;

    void delete(List<PhoneNumbers> listNumbers) throws SQLException;

    void create(PhoneNumbers phoneNumbers) throws SQLException;

    void addNewContacts(List<PhoneNumbers> phoneNumbers) throws SQLException;

    void deleteByIdPeson(int id) throws SQLException;

    PhoneNumbers getAllByNumber(String number) throws SQLException;
}
