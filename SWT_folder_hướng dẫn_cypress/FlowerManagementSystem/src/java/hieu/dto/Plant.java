/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieu.dto;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Plant implements Serializable{

    private int pid;
    private String pname;
    private int price;
    private String imgPath;
    private String description;
    private int status;
    private int cateID;
    private String  catename;

    public Plant() {
    }

    public Plant(int pid, String pname, int price, String imgPath, String description, int status, int cateID, String catename) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.imgPath = imgPath;
        this.description = description;
        this.status = status;
        this.cateID = cateID;
        this.catename = catename;
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public int getPrice() {
        return price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public int getCateID() {
        return cateID;
    }

    public String getCatename() {
        return catename;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    @Override
    public String toString() {
        return "Plant{" + "pid=" + pid + ", pname=" + pname + ", price=" + price + ", imgPath=" + imgPath + ", description=" + description + ", status=" + status + ", cateID=" + cateID + ", catename=" + catename + '}';
    }
    
   
}
