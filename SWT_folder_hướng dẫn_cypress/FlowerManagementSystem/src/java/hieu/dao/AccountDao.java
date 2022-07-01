/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieu.dao;

import hieu.dto.Account;
import hieu.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class AccountDao {

    public static ArrayList<Account> getAccounts() {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accId,email,fullName,password,phone,status,role\n"
                        + "from dbo.Accounts\n";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("accId");
                        String email = rs.getString("email");
                        String fullname = rs.getString("fullName");
                        String password = rs.getString("password");
                        String phone = rs.getString("phone");
                        int status = rs.getInt("status");
                        int role = rs.getInt("role");
                        acc = new Account(id, email, fullname, password, phone, status, role);
                        list.add(acc);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static Account getAccounts(String Email, String Password) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accId,email,fullName,password,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where status=1 and email = ? and password = ? COLLATE Latin1_General_CS_AS ";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, Email);
                st.setString(2, Password);
                ResultSet rs = st.executeQuery();
                if (rs != null && rs.next()) {
                    int id = rs.getInt("accId");
                    String email = rs.getString("email");
                    String fullname = rs.getString("fullName");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int role = rs.getInt("role");
                    acc = new Account(id, email, fullname, password, phone, status, role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return acc;
    }

    public static Account getAccounts(String Email) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accId,email,fullName,password,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where email = ? COLLATE Latin1_General_CS_AS ";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, Email);
                ResultSet rs = st.executeQuery();
                if (rs != null && rs.next()) {
                    int id = rs.getInt("accId");
                    String email = rs.getString("email");
                    String fullname = rs.getString("fullName");
                    String password = rs.getString("password");
                    String phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int role = rs.getInt("role");
                    acc = new Account(id, email, fullname, password, phone, status, role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return acc;
    }
     public static ArrayList<Account> getAccountList(String keyword, String searchby) {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accId,email,fullName,password,phone,status,role\n"
                        + "from Accounts \n";
                if (searchby.equalsIgnoreCase("byemail")) {
                    sql = sql + "where email like ?";
                } else {
                    sql = sql + "where fullName like ?";
                }
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + keyword + "%");
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("accId");
                        String email = rs.getString("email");
                        String fullname = rs.getString("fullName");
                        String password = rs.getString("password");
                        String phone = rs.getString("phone");
                        int status = rs.getInt("status");
                        int role = rs.getInt("role");
                        acc = new Account(id, email, fullname, password, phone, status, role);
                        list.add(acc);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    public static boolean updateAccountStatus(int accid, int Status) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.Accounts\n"
                        + "SET status = ?\n"
                        + "where accId = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, Status);
                st.setInt(2, accid);
                st.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }

    public static boolean updateAccount(String email, String newPassword, String newFullname, String newPhone) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.Accounts\n"
                        + "SET password = ?, fullname = ?, phone = ? \n"
                        + "where email = ? COLLATE Latin1_General_CS_AS";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, newPassword);
                st.setString(2, newFullname);
                st.setString(3, newPhone);
                st.setString(4, email);
                st.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }

    public static boolean insertAccount(String newEmail, String newPassword, String newFullname, String newPhone, int newSatus, int newRole, String token) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "Insert Accounts\n"
                        + "Values(?,?,?,?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, newEmail);
                st.setString(2, newPassword);
                st.setString(3, newFullname);
                st.setString(4, newPhone);
                st.setInt(5, newSatus);
                st.setInt(6, newRole);
                st.setString(7,token);
                st.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }

    public static boolean updateToken(String token, String email) {
        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.Accounts\n"
                        + "SET Token = ?\n"
                        + "where email = ? COLLATE Latin1_General_CS_AS";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, token);
                st.setString(2, email);
                st.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}
