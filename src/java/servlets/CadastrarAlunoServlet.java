/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import basicos.Aluno;
import fachadas.FachadaAluno;
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
public class CadastrarAlunoServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nomeAluno");
        String matricula = request.getParameter("matricula");
        String senha  = request.getParameter("senhaAluno");
        
        Aluno a = new Aluno(nome,matricula,senha);
        
        request.setAttribute("a", a);
        FachadaAluno f = FachadaAluno.getInstance();
        f.inserir(a);
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
