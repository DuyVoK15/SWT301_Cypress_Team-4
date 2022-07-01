/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieu.dao;

import hieu.dto.Category;
import hieu.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class CategoryDao {

    public static ArrayList<Category> getCategories() {
        ArrayList<Category> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select CateID, CateName \n"
                        + "from Categories\n";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int CateID = rs.getInt("CateID");
                        String CateName = rs.getString("CateName");
                        Category cate = new Category(CateID, CateName);
                        list.add(cate);
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

    public static boolean insertCategory(String newcatename) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "Insert Categories\n"
                        + "Values(?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, newcatename);
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

    public static ArrayList<Category> getCategories(String keyword, String searchby) {
        ArrayList<Category> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select CateID, CateName\n"
                        + "from Categories\n";
                if (searchby.equalsIgnoreCase("byname")) {
                    sql = sql + "where CateName like ?";
                } else {
                    sql = sql + "where CateID like ?";
                }
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + keyword + "%");
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int cateID = rs.getInt("CateID");
                        String CateName = rs.getString("CateName");
                        Category plant = new Category(cateID, CateName);
                        list.add(plant);
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

    public static boolean updateCategory(int cateID, String catename) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE Categories\n"
                        + "SET CateName = ?\n"
                        + "where CateID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, catename);
                st.setInt(2, cateID);
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
