/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieu.dto;

/**
 *
 * @author ADMIN
 */
public class Account {
    private int accId;
    private String email;
    private String fullname;
    private String password;
    private String phone;
    private int status;
    private int role;
    private String token;
    public Account(int accId, String email, String fullname, String password, String phone, int status, int role) {
        this.accId = accId;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.role = role;
    }

    public Account() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getAccId() {
        return accId;
    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public int getStatus() {
        return status;
    }

    public int getRole() {
        return role;
    }

    public String getToken() {
        return token;
    }
    
    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    @Override
    public String toString() {
        return "Account{" + "accId=" + accId + ", email=" + email + ", fullname=" + fullname + ", password=" + password + ", phone=" + phone + ", status=" + status + ", role=" + role + '}';
    }
    
}

