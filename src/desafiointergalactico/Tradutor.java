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
    protected String[] unidadesIntergalacticas;
    private double iron, gold, silver;
    private String frase;
    private String[] fraseV;
    private int posicao;    
    private int valor;
    
    public Tradutor(){
        unidadesIntergalacticas = new String[7]; //I, V, X, L, C, D, M
    }
    
    public String getFrase(){
        return frase;
    }
   
    public void setFrase(String frase){
        this.frase = frase;
    }
    
    
    public void trad(){
        System.out.println(frase);
        fraseV = frase.split(" ");
        boolean classifica = classific();
        if(classifica) { //afirmacao
            aprende();
            
        }
    }
   
    private boolean classific(){ //classifica se é afirmação ou pergunta
        String up = fraseV[fraseV.length -1];  //nenhuma frase chega aqui vazia (lenght == 0) | up = última palavra
        char uLetra = up.charAt(up.length() -1);
        return uLetra != '?'; //true corresponde a afirmação e false corresponde pergunta
    }
    
    private void aprende(){ //se for afirmaçao vem p cá
        boolean tipoR = true;
        posicao = 0;
        for(int i = 0; i < fraseV.length; i++){
            try{
                valor = Integer.parseInt(fraseV[i]); 
                tipoR = false;
                posicao = i; //já vai retornar em qual posição está o número inteiro
            } catch(NumberFormatException e){
                //verificar em qual posição está o número em romano
                if(ehRomano(fraseV[i])){
                    posicao = i;
                }
            }
        }
        System.out.println(posicao);
        // Considerando que o número galactico esteja sempre no inicio e separado por uma palavra (ex.: representa, vale)
        
        String[] gala = new String[posicao - 1];
        for(int i = 0; i < gala.length; i++){
            gala[i] = fraseV[i];
        }
       
        //Para descobrir os valores das unidades dos metais
        if(tipoR == false){
            credito(gala);
        }
     
        
    }
    
    private boolean ehRomano(String roman){
        //romanos: I, V, X, L, C, D, M
        if(roman.equals("I")){
            unidadesIntergalacticas[0] = fraseV[0];
            return true;
        } else if(roman.equals("V")){
            unidadesIntergalacticas[1] = fraseV[0];
            return true;
        } else if(roman.equals("X")){
            unidadesIntergalacticas[2] = fraseV[0];
            return true;
        } else if(roman.equals("L")){
            unidadesIntergalacticas[3] = fraseV[0];
            return true;
        } else if(roman.equals("C")){
            unidadesIntergalacticas[4] = fraseV[0];
            return true;
        } else if(roman.equals("D")){
            unidadesIntergalacticas[5] = fraseV[0];
            return true;
        } else if(roman.equals("M")){
            unidadesIntergalacticas[6] = fraseV[0];
            return true;
        }        
        return false;
    }
    
    private void credito(String[] gala){
        int numRomano;
        numRomano = traduzirNumeralRomano(gala);
        if(gala[gala.length - 1].equals("Gold") || gala[gala.length - 1].equals("Ouro")){
            gold = numRomano / valor;
        } else if(gala[gala.length - 1].equals("Silver") || gala[gala.length - 1].equals("Prata")){
            silver = numRomano / valor;
        } else if(gala[gala.length - 1].equals("Iron") || gala[gala.length - 1].equals("Ferro")){
            iron = numRomano / valor;
        }   
    }
    
   
    private int traduzirNumeralRomano(String[] gala) {
        int n = 0;
        int direita = 0;
        for (int i = gala.length - 1; i >= 0; i--) {
            int valor = (int) traduzirNumeralRomano(gala[i]);
            n += valor * Math.signum(valor + 0.5 - direita);
            direita = valor;
        }
        return n;
    }

    private double traduzirNumeralRomano(String valor) {
        int cont = 0;
        double result;
        double x = 0;
        double y = 0;
        for(int i = 0; i < unidadesIntergalacticas.length; i = i + 2){ //Então passa nos valores I, X, C e M
            if(unidadesIntergalacticas[i] != null){
                if(unidadesIntergalacticas[i].equals(valor)){
                    x = Math.pow(10 , cont);
                }
            }
            cont++;
        }
        cont = 0;
        for(int i = 1; i < unidadesIntergalacticas.length; i = i + 2){
            if(unidadesIntergalacticas[i] != null){
                if(unidadesIntergalacticas[i].equals(valor)){
                    y = 5 * Math.floor(Math.pow(10, cont));
                }
            }
            cont++;
        }
        
        result = Math.floor(x + y);
        return result;
    }            
        
}



    
    

