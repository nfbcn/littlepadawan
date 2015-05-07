/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;
import basicos.Resultado;
import java.util.ArrayList;

/**
 *
 * @author nikolas
 */
public interface RepositorioResultado {
    
    public void inserir(int id_aluno, String nome_aluno, float nota, float percentual, int acertos);
    public ArrayList<Resultado> visualizarResultado();
}
