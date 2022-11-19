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
import java.sql.ResultSet;

/**
 *
 * @author Shiroi
 */
public class Select extends HttpServlet {

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
            out.println("<title>Consulta</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Consulta (Servlet Select " + request.getContextPath() + ")</h1>");
            String cons = request.getParameter("cons");
            SQL sql = new SQL(); // Se uso la libreria creada para crear el conector y ejectuar el comando
            if (cons == null){
                ResultSet rs = sql.exeQuery("SELECT * FROM phones;");
                out.println("<h2>Consulta completa de base de datos (Accede al link para consultar un dispositivo especifico)</h2>");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String brand = rs.getString("brand");
                    String name = rs.getString("name");
                    String codename = rs.getString("codename");
                    String img_ref = rs.getString("img_ref");
                    // print the results
                    out.println("<h3>Dispositivo: " + "<a href=\"Select?cons=" + codename + "\">" + brand + " - " + name + "</a></h3>"); //Reparado
                    System.out.format("%s, %s, %s, %s, %s\n", id, brand, name, codename, img_ref);
                }
                out.println("<br>");
                out.println("</h3><h3><a href=\"\\PracticaWeb\\index.html\">-- Regresar --</a></h3>");
            }else{
                ResultSet rs = sql.exeQuery("SELECT * FROM phones WHERE codename='" + cons + "';");
                rs.next();
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                String name = rs.getString("name");
                String codename = rs.getString("codename");
                String img_ref = rs.getString("img_ref");
                out.println("<h2>Consulta de dispositivo (Accede al link para eliminarlo de la base de datos)</h2>");
                out.println("<h3>Dispositivo:");
                out.println("<br>");
                out.println("Marca: " + brand);
                out.println("<br>");
                out.println("Nombre: " + name);
                out.println("<br>");
                out.println("Nombre en clave: " + codename);
                out.println("<br>");
                out.println("Imagen de referencia: " + img_ref);
                out.println("<br>");
                out.println("</h3><h3><a href=\"Delete?name=" + name + "\">Eliminar</a></h3>");
                out.println("<br>");
                out.println("</h3><h3><a href=\"\\PracticaWeb\\index.html\">-- Regresar --</a></h3>");
                System.out.format("%s, %s, %s, %s, %s\n", id, brand, name, codename, img_ref);
            }
            out.println("<script src=\"js/bootstrap.bundle.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
        catch (Exception e){
            System.err.println("Got an exception showing database!");
            System.err.println(e.getMessage());
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
