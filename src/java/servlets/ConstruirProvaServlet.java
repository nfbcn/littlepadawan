package servlets;

import basicos.Questoes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nikolas
 */
public class ConstruirProvaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

        //cria uma referencia para prova
        List<Questoes> provaOrdenada;
        
        //pega o objeto provaOrdenada e da  um cast para ArrayList
        provaOrdenada = (ArrayList) request.getAttribute("provaOrdenada");
        
        int tamanhoProva = provaOrdenada.size();
        
        //Mistura as questoes
        Collections.shuffle(provaOrdenada);
        
        //Mistura as alternativas
        for (Questoes questoes : provaOrdenada) {
            questoes.misturarAlternativas();
        }
        
        //seta o gabarito como atributo da sessão
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute("gabarito", provaOrdenada);
            session.setAttribute("tamanhoProvaGabarito", tamanhoProva);
        }
        
        request.setAttribute("tamanhoProva", tamanhoProva);
        request.setAttribute("prova", provaOrdenada);
        request.getRequestDispatcher("aluno/prova.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
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
