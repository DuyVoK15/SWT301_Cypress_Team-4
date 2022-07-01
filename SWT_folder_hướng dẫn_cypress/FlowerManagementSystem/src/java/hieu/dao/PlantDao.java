/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieu.dao;

import hieu.dto.Plant;
import hieu.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class PlantDao {

    public static ArrayList<Plant> getPlants(String keyword, String searchby) {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select PID,PName,price,imgPath,description,status,Plants.CateID as 'CateID',Catename\n"
                        + "from Plants join Categories on Plants.CateID=Categories.CateID\n";
                if (searchby.equalsIgnoreCase("byname")) {
                    sql = sql + "where Plants.PName like ?";
                } else {
                    sql = sql + "where CateName like ?";
                }
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + keyword + "%");
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int PID = rs.getInt("PID");
                        String PName = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgPath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateID = rs.getInt("CateID");
                        String Catename = rs.getString("Catename");
                        Plant plant = new Plant(PID, PName, price, imgPath, description, status, cateID, Catename);
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

    public static Plant getPlant(int plantID) {
        Connection cn = null;
        Plant plant = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select PID,PName,price,imgPath,description,status,Plants.CateID as 'CateID',Catename\n"
                        + "from Plants join Categories on Plants.CateID=Categories.CateID\n"
                        + "where PID = ?\n";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, plantID);
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int PID = rs.getInt("PID");
                        String PName = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgPath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateID = rs.getInt("CateID");
                        String Catename = rs.getString("Catename");
                        plant = new Plant(PID, PName, price, imgPath, description, status, cateID, Catename);
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
        return plant;
    }

    public static ArrayList<Plant> getPlants() {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select PID,PName,price,imgPath,description,status,Plants.CateID as 'CateID',Catename\n"
                        + "from Plants join Categories on Plants.CateID=Categories.CateID\n";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int PID = rs.getInt("PID");
                        String PName = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgPath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateID = rs.getInt("CateID");
                        String Catename = rs.getString("Catename");
                        Plant plant = new Plant(PID, PName, price, imgPath, description, status, cateID, Catename);
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

    public static boolean deleteplant(int id, int status) {
        Connection cn = null;
        Plant plant = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE Plants\n"
                        + "SET status = ? \n"
                        + "where PID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, status);
                st.setInt(2, id);
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

    public static boolean updatePlant(int pid, String pname, int price, String description, int cateid, String catename) {
        Connection cn = null;
        Plant plant = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE Plants\n"
                        + "SET PName = ?, price = ?, description = ?, CateID = ?\n"
                        + "where PID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, pname);
                st.setInt(2, price);
                st.setString(3, description);
                st.setInt(4, cateid);
                st.setInt(5, pid);
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

    public static boolean insertPlant(String PName, int price, String imgPath, String description, int status, int CateID) {
        Connection cn = null;
        Plant acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "Insert Plants\n"
                        + "Values(?,?,?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, PName);
                st.setInt(2, price);
                st.setString(3, imgPath);
                st.setString(4, description);
                st.setInt(5, status);
                st.setInt(6, CateID);
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
