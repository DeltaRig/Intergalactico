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
    private double valor;
    
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
        System.out.println("\n" + frase);
        fraseV = frase.split(" ");
        boolean classifica = classific();
        if(classifica) //afirmacao
            aprende(); // aqui ocorre todo processo para se aprender os valores galacticos
        else {
            responde();
        }
    }
   
    private boolean classific(){ //classifica se é afirmação ou pergunta
        String up = fraseV[fraseV.length -1];  //nenhuma frase chega aqui vazia (lenght == 0) | up = última palavra
        char uLetra = up.charAt(up.length() -1);
        if(uLetra != '?')
            return true;
        else {
            if(fraseV[fraseV.length -1].length() == 1) { //se tiver espaço antes do sinal de interrogação
                String[] novo = new String[fraseV.length -1];
                for(int i = 0; i < novo.length; i++){
                    novo[i] = fraseV[i];
                }
                fraseV = novo;
            } else { // caso a última palavra estejá junto com a interrogação. Ex.: "Silver?"
                fraseV[fraseV.length -1] = fraseV[fraseV.length -1].substring(0, (fraseV[fraseV.length -1].length() -1) ); //removendo a última letra (o "?")
            }
            return false;
        }
       //true corresponde a afirmação e false corresponde pergunta
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
        numRomano = traduzirNumeral(gala, 2);
        if(gala[gala.length - 1].equals("Gold") || gala[gala.length - 1].equals("Ouro")){
            gold = valor / numRomano;
        } else if(gala[gala.length - 1].equals("Silver") || gala[gala.length - 1].equals("Prata")){
            silver = valor / numRomano;
        } else if(gala[gala.length - 1].equals("Iron") || gala[gala.length - 1].equals("Ferro")){
            iron = valor / numRomano;
        }   
    }
    
   
    private int traduzirNumeral(String[] gala, int x) {
        int n = 0;
        int direita = 0;
        for (int i = gala.length - x; i >= 0; i--) {
            int valorG = (int) traduzirUnidade(gala[i]);
            n += valorG * Math.signum(valorG + 0.5 - direita);
            direita = valorG;
        }
        return n;
    }

    private double traduzirUnidade(String valorG) {
        int cont = 0;
        double result;
        double x = 0;
        double y = 0;
        for(int i = 0; i < unidadesIntergalacticas.length; i = i + 2){ //Então passa nos valores I, X, C e M
            if(unidadesIntergalacticas[i] != null){
                if(unidadesIntergalacticas[i].equals(valorG)){
                    x = Math.pow(10 , cont);
                }
            }
            cont++;
        }
        cont = 0;
        for(int i = 1; i < unidadesIntergalacticas.length; i = i + 2){
            if(unidadesIntergalacticas[i] != null){
                if(unidadesIntergalacticas[i].equals(valorG)){
                    y = 5 * Math.floor(Math.pow(10, cont));
                }
            }
            cont++;
        }
        result = Math.floor(x + y);
        return result;
    }            
    
    private void responde(){
        if(fraseV[1].equalsIgnoreCase("vale")){
            String[] gala = new String[fraseV.length - 2]; // retira "quanto vale"
            
            for(int i = 0; i < gala.length; i++){
                gala[i] = fraseV[i + 2];
            }
            
            int numGalactico = traduzirNumeral(gala, 1);
            
            if(numGalactico == 0)
                System.out.println("Nem ideia do que isso significa!");
            else {
                for(int i = 0; i < gala.length; i++){
                    System.out.print(gala[i] + " ");
                }
                
                System.out.print("vale " + numGalactico);
            }
        } else if(fraseV[1].equalsIgnoreCase("créditos")){
            String[] gala = new String[fraseV.length - 3]; // retira "quantos créditos são"
            
            for(int i = 0; i < gala.length; i++){
                gala[i] = fraseV[i + 3];
            }
            
            int numGalactico = traduzirNumeral(gala, 1);
            
            if(numGalactico == 0){
                System.out.println("Nem ideia do que isso significa!");
            } else {
                for(int i = 0; i < gala.length; i++){
                    System.out.print(gala[i] + " ");
                }
                
                if(gala[gala.length - 1].equals("Gold") || gala[gala.length - 1].equals("Ouro")){
                    
                    System.out.print("custa " + (numGalactico * gold) + " créditos");
                } else if(gala[gala.length - 1].equals("Silver") || gala[gala.length - 1].equals("Prata")){
                    System.out.print("custa " + (numGalactico * silver) + " créditos");
                } else if(gala[gala.length - 1].equals("Iron") || gala[gala.length - 1].equals("Ferro")){
                    System.out.print("custa " + (numGalactico * iron) + " créditos");
                }
            }
            
            
            
        } else//caso seja uma pergunta diferente do esperado
            System.out.println("Nem ideia do que isso significa!");
        
    }
}



    
    

