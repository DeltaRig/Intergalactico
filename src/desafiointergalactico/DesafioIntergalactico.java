/*
 * Programa para traduzir valores intergalacticos.
 * 
 * 
 * @author (Daniela Pereira Rigoli)
 * @version (17/07/2020)
 */
package desafiointergalactico;

import java.io.*;
import java.util.Scanner;

public class DesafioIntergalactico {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Tradutor traduz;
        traduz = new Tradutor();
        
        boolean verifica = false;
        
        
        do{ 
            verifica = false;
            System.out.println("Digite o caminho para o arquivo (com o nome do arquivo)"
                    + "\nEx.: C:/Users/(nome)/Documents/arquivo.txt");
        
            String path = scan.nextLine();
            
            try(BufferedReader reader = new BufferedReader(new FileReader(path));){
                // ler o arquivo e enviar para a tradução
                for (String linha = reader.readLine(); linha != null; linha = reader.readLine()){
                    if(linha.length() > 0){
                        traduz.setFrase(linha); //Traduz recebe a frase
                        traduz.trad();
                    }
                }
                reader.close();
                verifica = true;
            } catch (IOException e) {
                System.out.println("O arquivo não foi encontrado");
            }
        }while(verifica == false); // Para quando o arquivo for encontrado
        
        
    }
    
    
    
}
