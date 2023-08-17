package com.infopass.genr.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dob;
    private String collegeAddress;
    private String generatedPassword;

    // Constructors
    public Participant() {
    }

    public Participant(String firstName, String middleName, String lastName, LocalDate dob, String collegeAddress) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.collegeAddress = collegeAddress;
    }

    // Getters and Setters
    public Long getId() {
        return id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    
    public void generatePassword() {
        generatedPassword = generatePasswordFromInfo();
    }

    private String generatePasswordFromInfo() {
        
        String password = firstName.substring(0, 2) + middleName.substring(0, 2) + lastName.substring(0, 2) + dob.toString().substring(0, 2);
        
        return password;
    }
}


