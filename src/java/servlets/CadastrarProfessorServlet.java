/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import basicos.Professor;
import fachadas.FachadaProfessor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Barbara
 */
public class CadastrarProfessorServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nomeProf");
        String disciplina = request.getParameter("disciplina");
        int siape = Integer.parseInt(request.getParameter("siape"));
        String senha  = request.getParameter("senhaProf");
        
        Professor p = new Professor(nome,disciplina,siape,senha);
        
        request.setAttribute("p", p);
        FachadaProfessor f = FachadaProfessor.getInstance();
        f.inserir(p);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
        
        
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
