package com.Desert.Model;

import com.Desert.Validator.MatchPassword;
import com.Desert.Validator.UnusedEmail;
import com.Desert.Validator.UnusedUsername;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@MatchPassword
public class RegisterModel {

    @NotNull
    @UnusedUsername
    private String username;
    @NotNull
    @Email(message = "Invalid email!")
    @Length(min = 5, max = 50)
    @UnusedEmail
    private String email;
    @NotNull(message = "Password can't be empty!")
    @Length(min = 8, max = 30, message = "Password's length must be between 8 and 30 characters!")
    private String password;
    @NotNull(message = "Password can't be empty!")
    @Length(min = 8, max = 30, message = "Password's length must be between 8 and 30 characters!")
    private String rePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public final String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
