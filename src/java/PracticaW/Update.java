/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package PracticaW;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilsT.SQL;

/**
 *
 * @author Shiroi
 */
public class Update extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update</title>");   
            out.println("<meta http-equiv=\"refresh\" content=\"0; URL=\\PracticaWeb\\index.html\"/>");         
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update at " + request.getContextPath() + "</h1>");
            String cons = request.getParameter("cons");
            String brand = request.getParameter("brand");
            String name = request.getParameter("name");
            String codename = request.getParameter("codename");
            String img_ref = request.getParameter("img_ref");
            SQL sql = new SQL("jdbc:mysql://localhost/practica_web", "root", "1234"); // Se uso la libreria creada para crear el conector y ejectuar el comando
            if (brand != ""){
                sql.exeUpdate("UPDATE phones SET brand='" + brand + "' WHERE codename='" + cons + "';");
            }
            if (name != ""){
                sql.exeUpdate("UPDATE phones SET name='" + name + "' WHERE codename='" + cons + "';");
            }
            if (codename != ""){
                sql.exeUpdate("UPDATE phones SET codename='" + codename + "' WHERE codename='" + cons + "';");
            }
            if (img_ref != ""){
                sql.exeUpdate("UPDATE phones SET img_ref='" + img_ref + "' WHERE codename='" + cons + "';");
            }
            out.println("</body>");
            out.println("</html>");
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
