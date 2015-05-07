    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadas;

/**
 *
 * @author Barbara
 */
import basicos.Professor;
import repositorios.RepositorioProfessor;
import repositorios.RepositorioProfessorBD;

public class FachadaProfessor {

    private static FachadaProfessor fachada;
    private RepositorioProfessor repositorio;

    static {
        fachada = new FachadaProfessor();
    }

    public static FachadaProfessor getInstance() {
        return fachada;
    }

    private FachadaProfessor() {
        repositorio = new RepositorioProfessorBD();
    }

    public void inserir(Professor prof) {
        repositorio.inserir(prof);
    }

    public void remover(Professor prof) {
        repositorio.remover(prof);
    }

    public void alterar(Professor prof) {
        repositorio.alterar(prof);
    }

    public Professor procurarPorId(int id_prof) {
        return repositorio.procurarPorId(id_prof);
    }

    public Professor procurarPorSiape(int siape) {
        return repositorio.procurarPorSiape(siape);
    }

    public Professor autenticaProfessor(int siape, String senha) {
        return repositorio.autenticaProfessor(siape, senha);
    }
}
