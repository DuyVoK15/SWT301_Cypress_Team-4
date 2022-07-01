/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class mainController extends HttpServlet {

    private String url = "index.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            switch (action) {
                case "login":
                    url = "loginServlet";
                    break;
                case "search":
                    url = "index.jsp";
                    break;
                case "searchAccount":
                    url = "searchAccountsServlet";
                    break;
                case "searchOrder":
                    url = "searchOrderServlet";
                    break;
                case "searchPlant":
                    url = "searchPlantServlet";
                    break;
                case "searchCate":
                    url = "searchCateServlet";
                    break;
                case "changeprofile":
                    url = "changeProfile.jsp";
                    break;
                case "Change":
                    url = "changeProfileServlet";
                    break;
                case "register":
                    url = "registerServlet";
                    break;
                case "logout":
                    url = "logoutServlet";
                    break;
                case "viewOrders":
                    url = "personalPage.jsp";
                    break;
                case "addtoCart":
                    url = "addtoCartServlet";
                    break;
                case "viewcart":
                    url = "viewCart.jsp";
                    break;
                case "updateQuantity":
                    url = "updateQuantityCartServlet";
                    break;
                case "removeItem":
                    url = "removeItemServlet";
                    break;
                case "saveOrder":
                    url = "saveShoppingCartServlet";
                    break;
                case "manageAccounts":
                    url = "manageAccountsServlet";
                    break;
                case "manageOrders":
                    url = "manageOrdersServlet";
                    break;
                case "managePlants":
                    url = "managePlantsServlet";
                    break;
                case "manageCategories":
                    url = "manageCategoriesServlet";
                    break;
                case "updateStatusAccounts":
                    url = "updateStatusAccountServlet";
                    break;
                case "cancelOrder":
                    url = "cancelOrderServlet";
                    break;
                case "cancelorderforuser":
                    url = "cancelOrderForUserServlet";
                    break;

                case "completeOrder":
                    url = "completeOrderServlet";
                    break;
                case "updatePlant":
                    url = "updatePlantServlet";
                    break;
                case "updatecate":
                    url = "updateCateServlet";
                    break;
                case "deletePlant":
                    url = "deletePlantServlet";
                    break;
                case "restore":
                    url = "deletePlantServlet";
                    break;
                case "insertplant":
                    url = "insertPlantServlet";
                    break;
                case "insetCategory":
                    url = "insetCategoryServlet";
                    break;
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
