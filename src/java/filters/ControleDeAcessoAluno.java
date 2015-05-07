    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import basicos.Aluno;
import dao.Dao;
import fachadas.FachadaAluno;
import fachadas.FachadaProfessor;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Barbara
 */
@WebFilter(filterName = "ControleAcessoAluno", urlPatterns = {"/aluno/*"})
public class ControleDeAcessoAluno implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        HttpSession session = req.getSession();
        // Verificando se o login e a senha estão corretos.
        if (login != null && senha != null) {
           // int siape = Integer.parseInt(login);
            //inicio
            Aluno prof = (Aluno) session.getAttribute("aluno");
            if (prof == null) {
                fachadas.FachadaAluno fachada = FachadaAluno.getInstance();
                Aluno tmp = null;
                tmp = fachada.autenticaAluno(login, senha);
                if (tmp != null) {

                    session.setAttribute("aluno", tmp);
                    //redirecionar ele pra o indexProfessor.jsp                    
                } else {
                    //redirecionar pra pagina de login com a mensagem:
                    req.setAttribute("action2", req.getRequestURI());
                    req.getRequestDispatcher("/login.jsp").forward(request, response);
                    //usuario não cadastrado.
                }
            } else {
                session.setAttribute("aluno", prof);
                //redirecionar ele pra o indexProfessor.jsp
            }
            //fim
        }
      

        if (req.getRequestURI().indexOf("deslogar.jsp") != -1) {
            session.invalidate();
            req.getRequestDispatcher("/aluno/deslogar.jsp").forward(request, response);
        } else {
            // Verificando se existe usuário na sessão (indicando que ele está logado)
            Aluno user = (Aluno) session.getAttribute("aluno");
            if (user != null) {
                chain.doFilter(request, response);
            } else {
                req.setAttribute("action2", req.getRequestURI());
                req.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
