package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hieu.dao.PlantDao;
import hieu.dto.Plant;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"mycss_2.css\" type=\"text/css\" />\n");
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
      out.write("    <session>\n");
      out.write("        ");

            String keyword = request.getParameter("txtsearch");
            String searchby = request.getParameter("searchby");
            ArrayList<Plant> list;
            String[] tmp = {"out of stock", "availble"};
            if (keyword == null && searchby == null) {
                list = PlantDao.getPlants("", "");
            } else {
                list = PlantDao.getPlants(keyword, searchby);
            }
            if (list != null && !list.isEmpty()) {
                for (Plant p : list) {
                    if (p.getStatus()== 1) {
        
      out.write(" <table class=\"product\" >\n");
      out.write("            <tr><td></td><td>ID</td><td>Name</td><td>Price</td><td>Status</td><td>Category</td><td>Action</td></tr>\n");
      out.write("            <tr >\n");
      out.write("                <td style=\"width: 230px\" > <img style=\"border-radius: 50%; width: 200px; height: 200px; margin: 0\" src=\"");
      out.print( p.getImgPath());
      out.write("\" class=\"plantimg\"/></td>\n");
      out.write("                <td >");
      out.print( p.getPid());
      out.write(" </td> \n");
      out.write("                <td>");
      out.print(p.getPname());
      out.write(" </td> \n");
      out.write("                <td>");
      out.print(p.getPrice());
      out.write(" </td>\n");
      out.write("                <td>");
      out.print( tmp[p.getStatus()]);
      out.write(" </td>\n");
      out.write("                <td>");
      out.print( p.getCatename());
      out.write("  </td>\n");
      out.write("                <td><a href =\"mainController?action=addtoCart&pid=");
      out.print( p.getPid());
      out.write("\" style=\"font-size: small; color: red; font-size: large;\">add to cart</a></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");
 }
                }

            }
        
      out.write("\n");
      out.write("    </session>\n");
      out.write("    <footer>\n");
      out.write("        ");
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
      out.write("    </footer>\n");
      out.write("</body>\n");
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
