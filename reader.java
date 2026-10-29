import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

public class reader {
    
    public HashMap<String, Tree> ler(String caminho){
    try{

        Scanner sc = new Scanner(new File(caminho));//aqui abre o arquivo
        String number = sc.nextLine();//aqui vai ler o numero de relações.
        int num = Integer.parseInt(number);

        HashMap<String, Tree> pessoas = new HashMap<>();

        for (int i=0; i <num; i++ ){
           String linha = sc.nextLine();
           String [] partes = linha.split("\""); //serve pra separar os pais dos filhos
            //"parte 1" "parte 3"
            String pai = partes[1];
            String filho = partes[3];

            if (!pessoas.containsKey(pai)) {// Se este pai ainda não existe, cria um tree pra ele.
            pessoas.put(pai, new Tree(pai));
            }
            if (!pessoas.containsKey(filho)) {// Se este filho ainda não existe, cria um tree pra ele.
            pessoas.put(filho, new Tree(filho));
            }

            Tree dad = pessoas.get(pai);//Crio nodo pai 
            Tree son = pessoas.get(filho);//o filho tbm
          
            if (son.getparent()==null){//Por causa do Jon que tem dois pais
              dad.addChild(son);//adiciono o nodo filho como child daquele pai
            }

        }
        sc.close();

        return pessoas;

        
        
    }catch(Exception e){
          System.out.println("Erro: " + e.getMessage());
          return null;
    }
}
}
