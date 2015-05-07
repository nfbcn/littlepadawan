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
import basicos.Questoes;

/**
 *
 * @author nikolas
 */
public class DistribuirServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String inserir = request.getParameter("inserir.x");
        String alterar = request.getParameter("alterar.x");
        String remover = request.getParameter("remover.x");
        if (inserir != null) {
            request.getRequestDispatcher("/professor/inserir.jsp").forward(request, response);
        } else {
            String id = request.getParameter("id");
            int codigo = Integer.parseInt(id);
            FachadaQuestoes fachada = FachadaQuestoes.getInstance();
            if (alterar != null) {
                Questoes q = fachada.procurarPorCodigo(codigo);
                request.setAttribute("q", q);
                request.getRequestDispatcher("/professor/alterar.jsp").forward(request, response);
            } else if (remover != null) {
                Questoes q = fachada.procurarPorCodigo(codigo);
                fachada.remover(q);
                request.getRequestDispatcher("AtualizarServlet").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

    }
}
