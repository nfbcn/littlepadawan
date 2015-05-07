/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

/**
 *
 * @author Barbara
 */
import basicos.Questoes;
import java.util.Collection;

public interface RepositorioQuestoes {
        public void inserir(Questoes q);
        public void remover(Questoes q);
        public void alterar(Questoes q);
        public Questoes procurarPorCodigo(int codigoQuestao);
        public Collection<Questoes> listarTodos();
        public Collection<String> listarTodasDisciplinas();
        public Collection<String> listarTodosAssuntos();
        public Collection<Questoes> listarQuestoesPorAssunto(String assuntoEscolhido);
        public Collection<Questoes> listarQuestoesPorDisciplina(String disciplinaEscolhida);
}
