/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import fachadas.FachadaQuestoes;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import basicos.Questoes;

/**
 *
 * @author nikolas
 */
public class AlterarQuestaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String disciplina = request.getParameter("disciplina");
        String assunto = request.getParameter("assunto");
        //int tipo = Integer.parseInt(request.getParameter("tipo"));
        float peso = Float.parseFloat(request.getParameter("peso"));
        String enunciado = request.getParameter("enunciado");
        String alternativaCorreta = request.getParameter("alternativaCorreta");
        String alternativa1 = request.getParameter("alternativa1");
        String alternativa2 = request.getParameter("alternativa2");
        String alternativa3 = request.getParameter("alternativa3");
        String alternativa4 = request.getParameter("alternativa4");
        String codigo = request.getParameter("id");
        System.out.println("Disci" + disciplina +"Assunto"+ assunto + "Peso "+peso + "Enunciado "+enunciado + "alternativo Cor"+alternativaCorreta + alternativa1 + alternativa2 + alternativa3+ alternativa4 + "Cod "+codigo);
        int codigo1 = Integer.parseInt(codigo);
        
        FachadaQuestoes fachada = FachadaQuestoes.getInstance();
        
        Questoes q = new Questoes();
        
//        q = fachada.procurarPorCodigo(codigo1);
        q.setId(codigo1);
        q.setDisciplina(disciplina);
        q.setAssunto(assunto);
       // q.setTipo(tipo);
        q.setPeso(peso);
        q.setEnunciado(enunciado);
        q.setAlternativaCorreta(alternativaCorreta);
        q.setAlternativa1(alternativa1);
        q.setAlternativa2(alternativa2);
        q.setAlternativa3(alternativa3);
        q.setAlternativa4(alternativa4);
        
        fachada.alterar(q);
        request.getRequestDispatcher("AtualizarServlet").forward(request, response);
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
