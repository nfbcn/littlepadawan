/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import basicos.Questoes;
import fachadas.FachadaQuestoes;

/**
 *
 * @author nikolas
 */
public class InserirQuestaoServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String disciplina = request.getParameter("disciplina");
        String assunto = request.getParameter("assunto");
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        float peso = Float.parseFloat(request.getParameter("peso"));
        String enunciado = request.getParameter("enunciado");
        String alternativaCorreta = request.getParameter("alternativaCorreta");
        String alternativa1 = request.getParameter("alternativa1");
        String alternativa2 = request.getParameter("alternativa2");
        String alternativa3 = request.getParameter("alternativa3");
        
        String alternativa4 = request.getParameter("alternativa4");
        
        Questoes q = new Questoes(disciplina,assunto,tipo,peso,enunciado,alternativaCorreta,alternativa1,alternativa2,alternativa3,alternativa4);
        
        request.setAttribute("q", q);
        FachadaQuestoes f = FachadaQuestoes.getInstance();
        f.inserir(q);
        request.getRequestDispatcher("AtualizarServlet").forward(request, response);
        
        
        
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
