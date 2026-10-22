import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class reader {
    
    public void ler(String caminho){
    try{

        Scanner sc = new Scanner(new File("rel.txt"));//aqui abre o arquivo
        String number = sc.nextLine();//aqui vai ler o numero de relações.
        System.out.println(number);
        int num = Integer.parseInt(number);

        for (int i=0; i <num; i++ ){
            System.out.println(sc.nextLine());
        }

        sc.close();

        
    }catch(Exception e){
          System.out.println("Erro: " + e.getMessage());
    }
}
}
