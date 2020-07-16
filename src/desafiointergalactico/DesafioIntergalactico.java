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
        
        String linha = "Quantos anos?";
        System.out.println(linha);
        traduz.setFrase(linha); //Traduz recebeu a frase
        traduz.setFrase(linha);
        traduz.trad();
        
        boolean verifica = false;
        boolean classific;
        String resposta = "";
        
        do{ 
            verifica = false;
            System.out.println("Digite o caminho para o arquivo (com seu nome)"
                    + "\nEx.: /caminho/arquivo.txt");
            String arquivo = scan.nextLine();
            
            try{
                // ler o arquivo e enviar para a tradução
                BufferedReader buffRead = new BufferedReader(new FileReader(arquivo));
                linha = "";
                while (true) {
                    if (linha != null) {
                        System.out.println(linha);
                        traduz.setFrase(linha); //Traduz recebeu a frase
                        
                        traduz.trad();
                        
                    } else
                        break;
                    linha = buffRead.readLine();
                }
                
                buffRead.close();
                verifica = true;
            } catch (IOException e) {
                System.out.println("O arquivo não foi encontrado");
            }
        }while(verifica == false); // Para quando o arquivo for encontrado
        
        
    }
    
    
    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
 
    public static void escritor(String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        String linha = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Escreva algo: ");
        linha = in.nextLine();
        buffWrite.append(linha + "\n");
        buffWrite.close();
    }
    
}
