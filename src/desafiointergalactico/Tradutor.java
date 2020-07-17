/*
 * Programa para traduzir valores intergalacticos.
 * Essa classe irá receber as linhas do arquivo e criar algo similar a um dicionario
 * e responder as perguntas recebidas.
 * 
 * Métodos:
 *      classific: Recebe a linha e retorna se ela é uma afirmação ou uma pergunta
 * 
 * @author (Daniela Pereira Rigoli)
 * @version (17/07/2020)
 */
package desafiointergalactico;

public final class Tradutor {
    private String I, V, X, L, C, D, M;
    private String frase;
    private int cont; //conta o número de afirmação que estamos para não ocorrer sobreposição
    private String[][] galacti;
    private double[] humano; //tradução para números da linguagem humana
    
    
    public Tradutor(){
        galacti = new String[0][0];
    }
    
    public String getFrase(){
        return frase;
    }
   
    public void setFrase(String frase){
        this.frase = frase;
    }
    
    
    public void trad(){
        System.out.println(frase);
        String[] fraseV = frase.split(" ");
        boolean classifica = classific(fraseV);
        System.out.println(classifica);
        if(classifica == true) { //afirmacao
            aprende(fraseV);
            
        }
    }
   
    public boolean classific(String[] fraseV){ //classifica se é afirmação ou pergunta
        String up = fraseV[fraseV.length -1];  //nenhuma frase chega aqui vazia (lenght == 0) | up = última palavra
        char uLetra = up.charAt(up.length() -1);
        return uLetra != '?'; //true corresponde a afirmação e false corresponde pergunta
    }
    
    public void aprende(String[] afirm){ //se for afirmaçao vem p cá
        boolean tipoR = true;
        int posicao = 0;
        for(int i = 0; i < afirm.length; i++){
            try{
                Integer.parseInt(afirm[i]); 
                tipoR = false;
                posicao = i; //já vai retornar em qual posição está o número inteiro
            } catch(NumberFormatException e){
                //verificar em qual posição está o número em romano
                if(ehRomano(afirm[i])){
                    posicao = i;
                }
            }
        }
        System.out.println(posicao);
        // Considerando que o número galactico esteja sempre no inicio e separado por uma palavra (ex.: representa, vale)
        String[] gala = new String[posicao - 1];
        
        for(int i = 0; i < gala.length; i++){
            gala[i] = afirm[i]; //gala é uma variavel que vai sumir, então vou colocar ela em uma matriz para pegar todas as respostas
        }
        // Armazenas número galctico
        atualizaMatriz(gala);
        
        //PARA ARMAZENAR O NÚMERO EM ROMANO
        String roman = "";
        
        if(tipoR == false){
            int decimal = Integer.parseInt(afirm[posicao]); 
        } else {
            System.out.println("Está em romano");
        }
        System.out.println("Em romano: " + roman);
        
        
        //Terminado de analisar a afirmatica
        cont++;
    }
    
    public static boolean ehRomano(String roman){
        char letra;
        for(int i = 0; i < roman.length(); i++){
            letra = roman.charAt(i);
            if(letra != 'I' && letra != 'V' && letra != 'X'){ 
                if(letra != 'L' && letra != 'C' && letra != 'M'){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void atualizaMatriz(String[] novaLinha){
        String[][] nova;
        if(galacti[0].length > novaLinha.length){
            nova = new String [galacti.length][galacti[0].length];
        } else {
            nova = new String [galacti.length][novaLinha.length];
        }
        
        for(int i = 0; i < galacti.length; i++){
            for(int j = 0; j < galacti[0].length; j++){
                nova[i][j] = galacti[i][j];
            }
        }
        for(int j = 0; j < novaLinha.length; j++){
                nova[cont][j] = novaLinha[j];
        }        
        
        galacti = nova;
        
        for(int i = 0; i < galacti.length; i++){
            for(int j = 0; j < galacti[0].length; j++){
                System.out.print(galacti[i][j] + " ");
            }
            System.out.println();
        }
    }
    
            
        
}



    
    

