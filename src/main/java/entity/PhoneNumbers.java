/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author ирина
 */
public class PhoneNumbers {

    private int id;
    private String number;
    private String type;
    private int idPerson;

    public PhoneNumbers() {

    }

    public PhoneNumbers(String number, String type, int idPerson) {
        this.number = number;
        this.type = type;
        this.idPerson = idPerson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public String toString() {
        return "Id - " + id + " "
                + "Number - " + number + " "
                + "Type - " + type + " "
                + "Id person - " + idPerson;
    }

}
