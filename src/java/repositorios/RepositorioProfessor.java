/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

/**
 *
 * @author Barbara
 */
import basicos.Professor;

public interface RepositorioProfessor {

    public void inserir(Professor prof);

    public void remover(Professor prof);

    public void alterar(Professor prof);

    public Professor procurarPorId(int id_prof);

    public Professor procurarPorSiape(int siape);
    
    public Professor autenticaProfessor(int siape,String senha);
}
