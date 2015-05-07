/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fachadas.FachadaQuestoes;

/**
 *
 * @author nikolas
 */
public class SelecionarTipoQuestoesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        int tipoSelecao = Integer.parseInt(request.getParameter("tipoSelecao"));
        FachadaQuestoes fachada = FachadaQuestoes.getInstance();
        
        
        if(tipoSelecao == 1){
        
            request.setAttribute("colecao", fachada.listarTodasDisciplinas());
            request.getRequestDispatcher("aluno/disciplinasDisponiveis.jsp").forward(request, response);
            
            
        }else{
            request.setAttribute("colecao", fachada.listarTodosAssuntos());
            request.getRequestDispatcher("aluno/assuntosDisponiveis.jsp").forward(request, response);
            
        
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
