/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadas;
import repositorios.RepositorioQuestoes;
import repositorios.RepositorioQuestoesBD;
import basicos.Questoes;
import java.util.Collection;

/**
 *
 * @author nikolas
 */
public class FachadaQuestoes {
    
    public static FachadaQuestoes fachada;
    private RepositorioQuestoes repositorio;
    
    static{
        fachada = new FachadaQuestoes();
    }
    
    private FachadaQuestoes(){
        repositorio = new RepositorioQuestoesBD();
    }
    public static FachadaQuestoes getInstance(){
        return fachada;
    }
    public void inserir(Questoes q){
        repositorio.inserir(q);
    }
    public void remover(Questoes q){
        repositorio.remover(q);
    }
    public void alterar(Questoes q){
        repositorio.alterar(q);
    }
    public Questoes procurarPorCodigo(int codigoQuestao){
       return repositorio.procurarPorCodigo(codigoQuestao);
    }
    public Collection<Questoes> listarTodos(){
        return repositorio.listarTodos();
    }
    public Collection<String> listarTodasDisciplinas(){
        return repositorio.listarTodasDisciplinas();
    }
    public Collection<String> listarTodosAssuntos(){
        return repositorio.listarTodosAssuntos();
    }
    public Collection<Questoes> listarQuestoesPorDisciplina(String disciplinaEscolhida){
        return repositorio.listarQuestoesPorDisciplina(disciplinaEscolhida);
    }
    public Collection<Questoes> listarQuestoesPorAssunto(String assuntoEscolhido){
        return repositorio.listarQuestoesPorAssunto(assuntoEscolhido);
    }
}
