package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import hieu.dao.PlantDao;
import hieu.dto.Plant;
import hieu.dao.OrderDao;
import java.util.HashMap;

public final class viewCart_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss_2.css\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss_2.css\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <nav>\n");
      out.write("                <ul>\n");
      out.write("                    <div>\n");
      out.write("                        <li><a href=\"\"><img class=\"image\" src=\"images/logo.jpg\"></a> </li>\n");
      out.write("                        <li class=\"title\"><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                        <li class=\"title\"><a href=\"registration.jsp\">Register</a></li>\n");
      out.write("                        <li class=\"title\"><a href=\"mainController?action=viewcart\" >View Cart</a></li>\n");
      out.write("                        <li class=\"title\"><a href=\"personalPage.jsp\" >View Orders</a></li>\n");
      out.write("                        <li class=\"title\"><a href=\"login.jsp\" >Login</a></li>\n");
      out.write("                        <li class=\"title\"><a href=\"mainController?action=logout\" >Logout</a></li>\n");
      out.write("\n");
      out.write("                        <li class=\"title\" ><form action=\"mainController\" method=\"post\" class=\"formsearch\">\n");
      out.write("                                <input type=\"text\" name=\"txtsearch\">\n");
      out.write("                                <select name=\"searchby\">\n");
      out.write("                                    <option value=\"byname\">by name</option><option value=\"bycate\">by category</option>\n");
      out.write("                                </select>\n");
      out.write("                                <input type=\"submit\" value=\"search\" name=\"action\" >\n");
      out.write("                            </form></li>\n");
      out.write("                    </div>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <section>\n");
      out.write("            ");

                String name = (String) session.getAttribute("name");
                if (name != null) {
            
      out.write("\n");
      out.write("            <h3>Welcome ");
      out.print( session.getAttribute("name"));
      out.write(" comback </h3>\n");
      out.write("            <h3><a href=\"personalPage.jsp\">Personal Page</a></h3>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            <font style=\"color: red; font-size: large\">");
      out.print( (request.getAttribute("WARNING") == null) ? "" : (String) request.getAttribute("WARNING"));
      out.write("</font>\n");
      out.write("            <table class=\"product1\">\n");
      out.write("                <tr><td> Plant id</td>\n");
      out.write("                    <td> Plant name</td>\n");
      out.write("                    <td> Price</td>\n");
      out.write("                    <td> Image</td>\n");
      out.write("                    <td> Quantity</td>\n");
      out.write("                    <td> Update</td>\n");
      out.write("                    <td> Remove</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    HashMap<String, Integer> cart = (HashMap) session.getAttribute("cart");
                    if (cart != null) {
                        int total = 0;
                        for (String plantID : cart.keySet()) {
                            Plant item = PlantDao.getPlant(Integer.parseInt(plantID));
                
      out.write("\n");
      out.write("                <form action=\"mainController\" method=\"post\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"hidden\" value=\"");
      out.print(  item.getPid());
      out.write("\" name=\"txtitemid\"> <a href=\"getPlantServlet?txtitemid=");
      out.print( item.getPid());
      out.write('"');
      out.write('>');
      out.print( item.getPid());
      out.write("</a></td>\n");
      out.write("                        <td> ");
      out.print(  item.getPname());
      out.write("</td>\n");
      out.write("                        <td> ");
      out.print(  item.getPrice());
      out.write("</td>\n");
      out.write("                        <td><img src=\"");
      out.print( item.getImgPath());
      out.write("\" width=\"100\" height=\"100\"></td>\n");
      out.write("                        <td><input type=\"number\" min=\"1\" max=\"10\" value=\"");
      out.print( cart.get(plantID));
      out.write("\" name=\"txtquantity\"></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"updateQuantity\" name=\"action\"></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"removeItem\" name=\"action\"></td>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                ");

                        total = total + item.getPrice() * cart.get(plantID);
                    }
                
      out.write("\n");
      out.write("                <tr><td>Total:  ");
      out.print( total);
      out.write(" VND</td></tr>\n");
      out.write("                <tr><td>Order Date:  ");
      out.print( (new Date()).toString());
      out.write(" </td></tr>\n");
      out.write("                <tr><td>Ship Date:  N/A </td></tr>\n");
      out.write("            </table>\n");
      out.write("            <section><form action=\"mainController\" method=\"post\">\n");
      out.write("                    <input type=\"submit\" value=\"saveOrder\" name=\"action\" class=\"submitorder\">\n");
      out.write("                </form>\n");
      out.write("            </section>\n");
      out.write("            ");
} else {
            
      out.write("\n");
      out.write("            <h2 style=\"color: red\">Your cart is empty</h2>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss_2.css\" type=\"text/css\" />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <p style=\" color: white; font-size: large; text-align: center;\">Copyright &copy; 2022</p>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
