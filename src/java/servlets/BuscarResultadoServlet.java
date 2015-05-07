/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import basicos.Resultado;
import fachadas.FachadaResultado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Barbara
 */
public class BuscarResultadoServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   processRequest(request, response);
        
        
        ArrayList<Resultado> resultadoSimulado;
        FachadaResultado fachada = FachadaResultado.getInstance();
        resultadoSimulado = fachada.visualizarResultado();
        
        request.setAttribute("resultadoSimulado", resultadoSimulado);
        request.getRequestDispatcher("professor/resultado.jsp").forward(request, response);
        
        
        
        
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
