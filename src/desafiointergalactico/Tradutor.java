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
        setFrase(" ");
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
        System.out.println(fraseV[fraseV.length -1]);
        boolean classifica = classific(fraseV);
        System.out.println(classifica);
    }
   
    public boolean classific(String[] fraseV){ //classifica se é afirmação ou pergunta
        String up = fraseV[fraseV.length -1];  //nenhuma frase chega aqui vazia (lenght == 0) | up = última palavra
        System.out.println(up);
        char uLetra = up.charAt(up.length() -1);
        System.out.println(uLetra);
        return uLetra != '?'; //true corresponde a afirmação e false corresponde pergunta
    }
    
    public void aprende(String[] afirm){ //se for afirmaçao vem p cá
        String up = afirm[afirm.length -1]; //pega a última palavra
        
        boolean tipoR = true;
        try{
            Integer.parseInt(up); 
            tipoR = false;
        } catch(NumberFormatException e){
            tipoR = true;
        }
        
        if(tipoR == false){
            System.out.println("tem que passar para romano");
        } else {
            System.out.println("está em romano");
        }
        
        
    }
}

    
    

