/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

/**
 *
 * @author Barbara
 */

import basicos.Aluno;

public interface RepositorioAluno {
    
        public void inserir(Aluno aluno);
	public void remover(Aluno aluno);
	public void alterar(Aluno aluno);

    public Aluno procurarPorId(int id_aluno);
    public Aluno autenticaAluno(String matricula,String senha);
    
}
