/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieu.dao;

import hieu.dto.OrderDetail;
import hieu.dto.Order;
import hieu.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
public class OrderDao {

    public static ArrayList<Order> getOrders(String email) {
        ArrayList<Order> arr = new ArrayList<>();
        Connection cn = null;
        Order acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID, OrdDate, shipdate, Orders.status, Orders.AccID\n"
                        + "from Accounts join Orders on Accounts.AccID= Orders.AccID\n"
                        + "where email like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, email);
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int OrderID = rs.getInt("OrderID");
                        Date OrdDate = rs.getDate("OrdDate");
                        Date shipdate = rs.getDate("shipdate");
                        int status = rs.getInt("status");
                        int AccID = rs.getInt("AccID");
                        acc = new Order(OrderID, OrdDate, shipdate, status, AccID);
                        arr.add(acc);
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
        return arr;
    }

    public static ArrayList<Order> getOrders() {
        ArrayList<Order> arr = new ArrayList<>();
        Connection cn = null;
        Order acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID, OrdDate, shipdate, Orders.status, Orders.AccID\n"
                        + "from Accounts join Orders on Accounts.AccID= Orders.AccID\n";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int OrderID = rs.getInt("OrderID");
                        Date OrdDate = rs.getDate("OrdDate");
                        Date shipdate = rs.getDate("shipdate");
                        int status = rs.getInt("status");
                        int AccID = rs.getInt("AccID");
                        acc = new Order(OrderID, OrdDate, shipdate, status, AccID);
                        arr.add(acc);
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
        return arr;
    }

    public static ArrayList<OrderDetail> getOrderDetail(int orderID) {
        ArrayList<OrderDetail> arr = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select DetailId, OrderID, PID, PName, price, imgPath, quantity\n"
                        + "from OrderDetails, Plants\n"
                        + "where OrderID=? and OrderDetails.FID=Plants.PID";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, orderID);
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int DetailId = rs.getInt("DetailId");
                        int plantID = rs.getInt("PID");
                        String PlantName = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgPath = rs.getString("imgPath");
                        int quantity = rs.getInt("quantity");
                        OrderDetail orderdetail = new OrderDetail(DetailId, orderID, plantID, PlantName, price, imgPath, quantity);
                        arr.add(orderdetail);
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
        return arr;
    }

    public static boolean insertOrder(String email, HashMap<String, Integer> cart) {
        ArrayList<OrderDetail> arr = new ArrayList<>();
        Connection cn = null;
        boolean result = false;
        int accid = -1;
        int orderid = -1;
        System.out.println(email);
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID\n"
                        + "from Accounts\n"
                        + "where email = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, email);
                ResultSet rs = st.executeQuery();
                if (rs != null && rs.next()) {
                    accid = rs.getInt("accID");
                }
                System.out.println("accountID:" + accid);
                Date date = new Date(System.currentTimeMillis());
                System.out.println("order date:" + date);
                sql = "insert Orders(OrdDate, status, AccID) values(?,?,?)";
                st = cn.prepareStatement(sql);
                st.setDate(1, date);
                st.setInt(2, 1);
                st.setInt(3, accid);
                st.executeUpdate();
                sql = "select top 1 orderID from Orders order by orderId desc";
                st = cn.prepareStatement(sql);
                rs = st.executeQuery();
                if (rs != null && rs.next()) {
                    orderid = rs.getInt("orderID");
                }
                System.out.println("orderid:" + orderid);
                Set<String> pids = cart.keySet();
                for (String pid : pids) {
                    sql = "insert OrderDetails values (?, ?,?) ";
                    st = cn.prepareStatement(sql);
                    st.setInt(1, orderid);
                    st.setInt(2, Integer.parseInt(pid.trim()));
                    st.setInt(3, cart.get(pid));
                    st.executeUpdate();
                    cn.commit();
                    cn.setAutoCommit(true);
                }
                return true;
            } else {
                System.out.println("Khong them vao order được");
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
        return result;
    }

    public static boolean cancelOrder(int orderID, int Status) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.Orders\n"
                        + "SET status = ?\n"
                        + "where orderID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setInt(1, Status);
                st.setInt(2, orderID);
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

    public static boolean completeOrder(int orderID, int status, int accId) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE dbo.Orders\n"
                        + "SET shipdate = ?, status = ?, AccID = ?\n"
                        + "where orderID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                Date date = new Date(System.currentTimeMillis());
                st.setDate(1, date);
                st.setInt(2, 2);
                st.setInt(3, accId);
                st.setInt(4, orderID);
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

    public static ArrayList<Order> getOrders(String keyword, String searchby) {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID, OrdDate, shipdate, Orders.status, Orders.AccID\n"
                        + "from Accounts join Orders on Accounts.AccID= Orders.AccID\n";
                if (searchby.equalsIgnoreCase("byorderID")) {
                    sql = sql + "where Orders.OrderID like ?";
                } else {
                    sql = sql + "where Orders.AccID like ?";
                }
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + keyword + "%");
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int OrderID = rs.getInt("OrderID");
                        Date OrdDate = rs.getDate("OrdDate");
                        Date shipdate = rs.getDate("shipdate");
                        int status = rs.getInt("status");
                        int AccID = rs.getInt("AccID");
                        Order plant = new Order(OrderID, OrdDate, shipdate, status, AccID);
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

}
