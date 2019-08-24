package com.Desert.Model;


import com.Desert.Entity.Member;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class MemberModel {

    @NotNull
    @Length(min = 3, max = 30, message = "First Name's length must be between 3 and 30!")
    private String firstName;
    @NotNull
    @Length(min = 3, max = 30, message = "Last Name's length must be between 3 and 30!")
    private String lastName;
    @NotNull
    @Email(message = "Invalid email!")
    private String email;
    @NotNull
    @Length(min = 9, max = 13, message = "Phone number must be 9-13 digits!")
    private String phone;
    @Length(max = 200, message = "Description is too long (maximum 200 characters)!")
    private String description;
    private Timestamp createdDate;

    public MemberModel() {
    }

    public MemberModel(Member member) {
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.phone = member.getPhone();
        this.email = member.getEmail();
        this.description = member.getDescription();
        this.createdDate = member.getCreatedDate();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
