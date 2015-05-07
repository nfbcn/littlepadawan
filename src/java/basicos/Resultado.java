package basicos;

/**
 *
 * @author Barbara
 */
public class Resultado {

    int id_aluno;
    String nomeAluno;
    float nota;
    float percentual;
    int acerto;
    
    public Resultado(int id_aluno, String nomeAluno, float nota, float percentual, int acerto){
    
        this.id_aluno = id_aluno;
        this.nomeAluno = nomeAluno;
        this.nota = nota;
        this.percentual = percentual;
        this.acerto = acerto;
        
    }
    
    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getPercentual() {
        return percentual;
    }

    public void setPercentual(float percentual) {
        this.percentual = percentual;
    }

    public int getAcerto() {
        return acerto;
    }

    public void setAcerto(int acerto) {
        this.acerto = acerto;
    }
  
    
    
    
}