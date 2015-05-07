/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basicos;

/**
 *
 * @author Barbara
 */
public class Professor {

    private int siape;
    private int id_professor;
    private String senha;
    public String nome;
    public String disciplina;

    public Professor() {
    }

    public Professor(String nome, String disciplina, int siape) {
       this.nome = nome;
       this.disciplina = disciplina;
       this.siape = siape;
    }

    public Professor(String nome, String disciplina, int siape, String senha) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.siape = siape;
        this.senha = senha;
    }

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
