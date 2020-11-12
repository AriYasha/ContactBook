/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Login;
import java.sql.SQLException;

/**
 *
 * @author ирина
 */
public interface ILoginForm {

    void addNewGuest(String login, String password) throws SQLException;

    String getGuest() throws SQLException;

    String getLogin(String login) throws SQLException;

    String getPassword(String password) throws SQLException;

    Login getLoginPassword(String login, String pass) throws SQLException;

}
