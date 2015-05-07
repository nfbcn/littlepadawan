/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basicos;

/**
 *
 * @author Barbara
 */
public class Aluno {
    public int id_aluno;
    public String nome;
    private String matricula;
    private String senha;

    public Aluno(String string, int aInt) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Aluno(String nome, String matricula, String senha) {
        this.nome=nome;
        this.matricula=matricula;
        this.senha=senha;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }
}
