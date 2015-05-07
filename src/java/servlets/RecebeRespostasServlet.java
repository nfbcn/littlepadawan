/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import basicos.Questoes;
import basicos.Aluno;
import basicos.Resultado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fachadas.FachadaResultado;

/**
 *
 * @author nikolas
 */
public class RecebeRespostasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);


//        
//        String questao = request.getParameter("q1");
//        String questao2 = request.getParameter("q2");
//      
        int tamanhoProva = (Integer)(request.getSession(false).getAttribute("tamanhoProvaGabarito"));
       
        // int tamanhoProva = 0;
        //String [] respostas = new String[tamanhoProva];
        ArrayList<Questoes> gabarito = (ArrayList<Questoes>) (request.getSession(false).getAttribute("gabarito"));
        ArrayList<String> respostas = new ArrayList<String>();
        ArrayList<String> comparativo = new ArrayList<String>();
       // ArrayList<Questoes> erradas = new ArrayList<Questoes>();
        FachadaResultado fachada = FachadaResultado.getInstance();
        
        Aluno aluno = (Aluno) request.getSession().getAttribute("aluno");
        int idAluno = aluno.getId_aluno();
        String nomeAluno = aluno.getNome();
        
     //   Resultado result;
        float denominador = 0;
        float numerador = 0;
        float nota = 0;
        float percentual = 0;
        int contadorDeQuestaoCertas = 0;
        //adicionando as respostas do aluno em um array temporário
        for (int i = 1; i <= tamanhoProva; i++) {


            String aux = "q" + i;
            String Parametro = request.getParameter(aux);
            respostas.add(Parametro);
        }
        //fazendo as comparações
        for (int i = 0; i < tamanhoProva; i++) {

            String gabaritoRochedo = gabarito.get(i).getAlternativaCorreta();


            
            denominador = denominador + gabarito.get(i).getPeso();

            if (gabaritoRochedo.equals(respostas.get(i))) {
                comparativo.add("Acertou");
                //conta quantas questões o aluno acertou
                contadorDeQuestaoCertas++;
                numerador = numerador + gabarito.get(i).getPeso();
            } else {
                comparativo.add("Errou");
                     
                //pegando a questao errada
               // gabarito.get(i).getId();
                
            }
        }
        //nota do aluno
         
        nota = (numerador / denominador)*10;
        //percentual de acertos no simulado
       percentual = (contadorDeQuestaoCertas*100)/tamanhoProva;   

       fachada.inserir(idAluno, nomeAluno, nota, percentual, contadorDeQuestaoCertas);



        request.setAttribute("comparativo", comparativo);
        request.setAttribute("nota", nota);


        request.getRequestDispatcher("aluno/resultadoProva.jsp").forward(request, response);
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
