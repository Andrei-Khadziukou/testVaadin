/**
 *
 */
package com.example.testvaadin.pojo;

import java.io.Serializable;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class Person implements Serializable {
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String phoneNumber = "";
    private String streatAddress = "";
    private String postalCode = "";
    private String city = "";
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @return the phoneNamber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * @return the streatAddress
     */
    public String getStreatAddress() {
        return streatAddress;
    }
    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @param phoneNamber the phoneNamber to set
     */
    public void setPhoneNumber(String phoneNamber) {
        this.phoneNumber = phoneNamber;
    }
    /**
     * @param streatAddress the streatAddress to set
     */
    public void setStreatAddress(String streatAddress) {
        this.streatAddress = streatAddress;
    }
    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }


}
