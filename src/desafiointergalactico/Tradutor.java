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
    
    
    public Tradutor(){
        
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
                posicao = i;
            } catch(NumberFormatException e){
                //verificar em qual posição está o número em romano
                if(ehRomano((afirm[i])){
                    posicao = i;
                }
            }
        }
        
        String roman = "";
        
        if(tipoR == false){
            int decimal = Integer.parseInt(afirm[posicao]); 
            roman = intToRoman(decimal);
        } else {
            System.out.println("está em romano");
            
        }
        System.out.println("Em romano: " + roman);
        
    }
    
    public static boolean ehRomano(String roman){
        char letra;
        for(int i = 0; i < roman.length(); i++){
            letra = roman.charAt(i);
            if(letra != 'I' && letra != V && letra != X){ 
            
            }
        }
        return true;
    }
    
    public static String intToRoman(int decimal){ //erro para 40, 400
        String roman = "";
        if ( decimal > 0 && decimal < 4000 ) {
           
            for(int i = 0; i < decimal/1000; i++){
                roman = roman +"M";
            }
            decimal = decimal % 1000;
            
            for(int i = 0; i < decimal/500; i++){
                roman = roman + "D";
            }
            decimal = decimal % 500;
            
            for(int i = 0; i < decimal/100; i++){
                roman = roman + "C";
            }
            decimal = decimal % 100;
            
            for(int i = 0; i < decimal/50; i++){
                roman = roman + "L" ;
            }
            decimal = decimal % 50;
            
            for(int i = 0; i < decimal/10; i++){
                roman = roman + "X";
            }
            decimal = decimal % 10;
            
            for(int i = 0; i < decimal/5; i++){
                roman = roman + "V";
            }
            decimal = decimal % 5;
            
            for(int i = 0; i < decimal/1; i++){
                roman = roman + "I";
            }
            decimal = decimal % 1;
            
        } else {
            return "Não faço a minima ideia";
        }
        return roman;
    }
            
        
}



    
    

