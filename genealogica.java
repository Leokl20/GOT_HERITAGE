import java.util.HashMap;

public class genealogica {
    private HashMap<String, Tree> pessoas;

    public genealogica(HashMap<String, Tree> pessoas) {
    this.pessoas = pessoas;
    }

    public boolean ehAncestral(String ancestral, String descendente){
        Tree no = pessoas.get(descendente);
        if (no==null){//aqui serve pra ver se o descendente realmente existe.
            return false;
        }
        
        while (no.getparent()!=null){// pra ele procurar até a raiz
            
            if(no.getitem()!= ancestral){//se o nome do descendente não for igual ao do ascendente 
            no = no.getparent();//então o nó vai virar seu pai até o if falhar
            }
            return true;
        }
        return false;

    }
    public boolean saoIrmaos(String pessoa1, String pessoa2){
        return false;
    }
    public boolean saoPrimos(String pessoa1, String pessoa2){
         return false;
    }
    public String ancestralComumMaisProximo(String pessoa1, String pessoa2){
         return null;
    }
    
}
