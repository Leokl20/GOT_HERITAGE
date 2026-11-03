import java.util.ArrayList;
import java.util.HashMap;

public class genealogica {
    private HashMap<String, Tree> pessoas;

    public genealogica(HashMap<String, Tree> pessoas) {
        this.pessoas = pessoas;
    }

    public boolean ehAncestral(String ancestral, String descendente) {
        Tree no = pessoas.get(descendente);
        if (no == null) {
            return false;
        }

        // Sobe pelos pais do descendente
        Tree aux = no.getparent();
        while (aux != null) {
            if (aux.getitem().equals(ancestral)) {
                return true;
            }
            aux = aux.getparent();
        }
        return false;
    }

    public boolean saoIrmaos(String pessoa1, String pessoa2) {
        Tree p1 = pessoas.get(pessoa1);
        Tree p2 = pessoas.get(pessoa2);

        // Validações de existência e mesma pessoa
        if (p1 == null || p2 == null || p1 == p2) {
            return false;
        }
        // Valida se têm pai (se forem raízes, não têm pai)
        if (p1.getparent() == null || p2.getparent() == null) {
            return false;
        }

        return p1.getparent() == p2.getparent();
    }

    public boolean saoPrimos(String pessoa1, String pessoa2) {
        Tree p1 = pessoas.get(pessoa1);
        Tree p2 = pessoas.get(pessoa2);

        // Validações de existência e mesma pessoa
        if (p1 == null || p2 == null || p1 == p2) {
            return false;
        }
        // Valida se têm pais e avós antes de acessar getparent().getparent()
        if (p1.getparent() == null || p2.getparent() == null) {
            return false;
        }
        if (p1.getparent().getparent() == null || p2.getparent().getparent() == null) {
            return false;
        }

        boolean mesmosAvos = (p1.getparent().getparent() == p2.getparent().getparent());
        boolean mesmosPais = (p1.getparent() == p2.getparent());

        return mesmosAvos && !mesmosPais;
    }

    public String ancestralComumMaisProximo(String pessoa1, String pessoa2) {
        Tree p1 = pessoas.get(pessoa1);
        Tree p2 = pessoas.get(pessoa2);

        if (p1 == null || p2 == null) {
            return "Pessoa não encontrada.";
        }
        if (pessoa1.equals(pessoa2)) {
            return "Mesma pessoa!";
        }

        ArrayList<String> lst = new ArrayList<>();
        Tree aux = p1;
        while (aux != null) {
            lst.add(aux.getitem());
            aux = aux.getparent();
        }

        aux = p2;
        while (aux != null) {
            if (lst.contains(aux.getitem())) {
                return aux.getitem();
            }
            aux = aux.getparent();
        }

        return "Nenhum ancestral em comum.";
    }
}