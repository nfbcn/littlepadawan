    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import basicos.Professor;
import dao.Dao;
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
@WebFilter(filterName = "ControleAcessoProfessor", urlPatterns = {"/professor/*"})
public class ControleDeAcesso implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        HttpSession session = req.getSession();
        // Verificando se o login e a senha estão corretos.
        if (login != null && senha != null) {
            int siape = Integer.parseInt(login);
            //inicio
            Professor prof = (Professor) session.getAttribute("professor");
            if (prof == null) {
                fachadas.FachadaProfessor fachada = FachadaProfessor.getInstance();
                Professor tmp = null;
                tmp = fachada.autenticaProfessor(siape, senha);
                if (tmp != null) {

                    session.setAttribute("professor", tmp);
                    //redirecionar ele pra o indexProfessor.jsp                    
                } else {
                    //redirecionar pra pagina de login com a mensagem:
                    req.setAttribute("action", req.getRequestURI());
                    req.getRequestDispatcher("/login.jsp").forward(request, response);
                    //usuario não cadastrado.
                }
            } else {
                session.setAttribute("professor", prof);
                //redirecionar ele pra o indexProfessor.jsp
            }
            //fim
        }
//        if (login != null && login.equals("professor") && senha != null && senha.equals("123456")) {
//            session.setAttribute("professor", "logado");
//        }

        if (req.getRequestURI().indexOf("deslogar.jsp") != -1) {
            session.invalidate();
            req.getRequestDispatcher("/professor/deslogar.jsp").forward(request, response);
        } else {
            // Verificando se existe usuário na sessão (indicando que ele está logado)
            Professor user = (Professor) session.getAttribute("professor");
            if (user != null) {
                chain.doFilter(request, response);
            } else {
                req.setAttribute("action", req.getRequestURI());
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
