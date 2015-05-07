/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadas;

/**
 *
 * @author Barbara
 */
import basicos.Aluno;
import repositorios.RepositorioAluno;
import repositorios.RepositorioAlunoBD;


public class FachadaAluno {
    private static FachadaAluno fachada;
    private RepositorioAluno repositorio;
    
    static{
        fachada = new FachadaAluno();
    }
    
    public static FachadaAluno getInstance(){
        return fachada;
    }
    
    private FachadaAluno(){
        repositorio = new RepositorioAlunoBD();
    }
    
    public void inserir(Aluno aluno) {
        repositorio.inserir(aluno);
    }

    public void remover(Aluno aluno) {
        repositorio.remover(aluno);
    }

    public void alterar(Aluno aluno) {
        repositorio.alterar(aluno);
    }

    public Aluno procurarPorId(int id_aluno) {
        return repositorio.procurarPorId(id_aluno);
    }

    public Aluno autenticaAluno(String matricula, String senha) {
        return repositorio.autenticaAluno(matricula,senha);
    }
    
}
