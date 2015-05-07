package fachadas;

/**
 *
 * @author Barbara
 */
import basicos.Resultado;
import repositorios.RepositorioResultadoBD;
import repositorios.RepositorioResultado;
import java.util.ArrayList;

public class FachadaResultado {
    private static FachadaResultado fachada;
    private RepositorioResultadoBD repositorio;
    
    static{
        fachada = new FachadaResultado();
    }
    
    public static FachadaResultado getInstance(){
        return fachada;
    }
    
    private FachadaResultado(){
        repositorio = new RepositorioResultadoBD();
    }
    
    public void inserir(int id_aluno, String nome_aluno, float nota, float percentual, int acertos){
     repositorio.inserir(id_aluno, nome_aluno, nota, percentual, acertos);
    }
    public ArrayList<Resultado> visualizarResultado(){
    return repositorio.visualizarResultado();
    }
    
}