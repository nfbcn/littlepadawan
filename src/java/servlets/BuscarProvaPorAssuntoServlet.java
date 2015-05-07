/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import fachadas.FachadaQuestoes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nikolas
 */
public class BuscarProvaPorAssuntoServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //    processRequest(request, response);
        String assuntoEscolhido = request.getParameter("assuntoEscolhido");
        
        FachadaQuestoes fachada = FachadaQuestoes.getInstance();
        
        request.setAttribute("provaOrdenada", fachada.listarQuestoesPorAssunto(assuntoEscolhido));
        request.getRequestDispatcher("ConstruirProvaServlet").forward(request, response);
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
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
