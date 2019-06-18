package model.entity;

import db.DataBase;
import exception.NotUniqueLoginException;
import view.TextConstants;

import java.time.LocalDate;

import static view.TextConstants.SPACE;
import static view.TextConstants.STRING_EMPTY;

/**
 * Represents a record in notebook data structure
 *
 * Created by o-morenets on 03.06.2019
 */
public class Record {

    private String login;

    private String lastName;
    private String firstName;
    private String middleName;

    private String nickName;
    private String comment;
    private Group group;
    private String homePhone;
    private String cellPhone;

    /** cell phone 2, unnecessary */
    private String cellPhone2 = STRING_EMPTY;

    private String email;
    private String skype;
    private Address address;

    private LocalDate dateRecordCreated;
    private LocalDate dateRecordUpdated;

    /**
     * Constructor
     */
    public Record() {
        this.address = new Address();
    }

    // Getters & Setters

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        if (lastName == null || firstName == null) {
            return STRING_EMPTY;
        }

        return lastName + SPACE + firstName.charAt(0) + TextConstants.DOT;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCellPhone2() {
        return cellPhone2;
    }

    public void setCellPhone2(String cellPhone2) {
        this.cellPhone2 = cellPhone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFullAddress() {
        return "" + address.getPostalCode() + ", " + address.getCity() + ", " + address.getStreet() + ", "
                + address.getHomeNumber() + ", " + address.getApartmentNumber();
    }

    public LocalDate getDateRecordCreated() {
        return dateRecordCreated;
    }

    public void setDateRecordCreated(LocalDate dateRecordAdded) {
        this.dateRecordCreated = dateRecordAdded;
    }

    public LocalDate getDateRecordUpdated() {
        return dateRecordUpdated;
    }

    public void setDateRecordUpdated(LocalDate dateRecordUpdated) {
        this.dateRecordUpdated = dateRecordUpdated;
    }
}
