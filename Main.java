import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        reader r = new reader();
        HashMap<String, Tree> pessoas = r.ler("rel.txt");
        System.out.println(pessoas.size());
        genealogica g= new genealogica( pessoas );

        System.out.println(g.ehAncestral("Rickard Stark", "Robb Stark"));  // esperado: true
         System.out.println(g.ehAncestral("Robb Stark", "Rickard Stark"));  // esperado: false
         System.out.println(g.ehAncestral("Zeca", "Robb Stark"));           // esperado: false
         System.out.println(g.ehAncestral("Rickard Stark", "Zeca")); 
         System.out.println(g.saoIrmaos("Arianne Martell", "Arianne Martell"));
         System.out.println(g.saoIrmaos ("Quentyn Martell", "Arianne Martell"));
           System.out.println(g.saoPrimos("Quentyn Martell", "Arianne Martell"));
            System.out.println(g.saoPrimos("Quentyn Martell", "Obara Sand"));
            System.out.println(g.ancestralComumMaisProximo("Rickon Stark", "Jon Snow"));
    }
}