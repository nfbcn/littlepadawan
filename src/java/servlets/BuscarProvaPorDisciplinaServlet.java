/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import basicos.Questoes;
import fachadas.FachadaQuestoes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nikolas
 */
public class BuscarProvaPorDisciplinaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        String disciplinaEscolhida = request.getParameter("disciplinaEscolhida");
        
        
        FachadaQuestoes  fachada  = FachadaQuestoes.getInstance();
        
        
        
        request.setAttribute("provaOrdenada", fachada.listarQuestoesPorDisciplina(disciplinaEscolhida));
        request.getRequestDispatcher("ConstruirProvaServlet").forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //   processRequest(request, response);
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
