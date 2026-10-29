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

    public boolean saoIrmaos(String pessoa1, String pessoa2){//foi facil. pega o pai de cada pessoa e ve se é o mesmo. Tambem checa se não é a mesma pessoa
        Tree p1 = pessoas.get(pessoa1);
        Tree p2 = pessoas.get(pessoa2);

        if (p1.getparent()!=p2.getparent()) return false;
        else if(p1==p2)return false;
        else return true;
        
    }
    public boolean saoPrimos(String pessoa1, String pessoa2){
         Tree p1 = pessoas.get(pessoa1);
        Tree p2 = pessoas.get(pessoa2);

        if (p1.getparent().getparent()!=p2.getparent().getparent()) return false;//avós são diferentes? false
        else if (p1.getparent()==p2.getparent()){//pai igual? false
            System.out.println("São irmãos!");
            return false;
        } 
        else if(p1==p2){
             System.out.println("Mesma pessoa.");
            return false;
        }
        else return true;
    }
    public String ancestralComumMaisProximo(String pessoa1, String pessoa2){
        Tree p1 = pessoas.get(pessoa1);
        Tree p2 = pessoas.get(pessoa2);

        for(p1 : p2)
         return null;
    }
    
}
