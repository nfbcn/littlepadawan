/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basicos;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author nikolas
 */
public class Questoes {
    
    private int id;
    private String disciplina;
    private String assunto;
    private int tipo;
    private float peso;
    private String enunciado;
    private String alternativaCorreta;
    private String alternativa1;
    private String alternativa2;
    private String alternativa3;
    private String alternativa4;
    private ArrayList<String> alternativas;
    
    public Questoes(){
        alternativas = new ArrayList<String>();
    }
    public Questoes(String disciplina, String assunto, int tipo, float peso, String enunciado, String alternativaCorreta, String alternativa1, String alternativa2, String alternativa3, String alternativa4){
    
        alternativas = new ArrayList<String>();
        this.disciplina = disciplina;
        this.assunto = assunto;
        this.tipo = tipo;
        this.peso = peso;
        this.enunciado = enunciado;
        this.alternativaCorreta = alternativaCorreta;
        this.alternativa1 = alternativa1;
        this.alternativa2 = alternativa2;
        this.alternativa3 = alternativa3;
        this.alternativa4 = alternativa4;
        alternativas.add(alternativaCorreta);
        alternativas.add(alternativa1);
        alternativas.add(alternativa2);
        alternativas.add(alternativa3);
        alternativas.add(alternativa4);
    }
    
    public void misturarAlternativas(){
        Collections.shuffle(alternativas);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public String getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public String getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public String getAlternativa4() {
        return alternativa4;
    }

    public void setAlternativa4(String alternativa4) {
        this.alternativa4 = alternativa4;
    }

    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(ArrayList<String> alternativas) {
        this.alternativas = alternativas;
    }
}
