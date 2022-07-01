/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieu.dto;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Order {
    private int OrderID;
    private Date OrdDate;
    private Date shipdate;
    private int status;
    private int AccID;

    public Order(int OrderID, Date OrdDate, Date shipdate, int status, int AccID) {
        this.OrderID = OrderID;
        this.OrdDate = OrdDate;
        this.shipdate = shipdate;
        this.status = status;
        this.AccID = AccID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public Date getOrdDate() {
        return OrdDate;
    }

    public Date getShipdate() {
        return shipdate;
    }

    public int getStatus() {
        return status;
    }

    public int getAccID() {
        return AccID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setOrdDate(Date OrdDate) {
        this.OrdDate = OrdDate;
    }

    public void setShipdate(Date shipdate) {
        this.shipdate = shipdate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setAccID(int AccID) {
        this.AccID = AccID;
    }

    @Override
    public String toString() {
        return "Order{" + "OrderID=" + OrderID + ", OrdDate=" + OrdDate + ", shipdate=" + shipdate + ", status=" + status + ", AccID=" + AccID + '}';
    }
    
}
