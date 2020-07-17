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
        for(int i = 0; i < afirm.length; i++){
            try{
                Integer.parseInt(afirm[i]); 
                tipoR = false;
            } catch(NumberFormatException e){
            }
        }
        
        if(tipoR == false){
            System.out.println("tem que passar para romano");
        } else {
            System.out.println("está em romano");
        }
        
        
    }
    
    public static String intToRoman(int decimal){
        String roman = "";
        if ( decimal > 0 && decimal < 4000 ) {
            // M
            
            
            
            
        } else {
            return "Não faço a minima ideia";
        }
        return roman;
    }
            
        
}



    
    

