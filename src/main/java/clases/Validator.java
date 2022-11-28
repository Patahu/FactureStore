/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author fell
 */
public class Validator {
    
    
    private final String numericos="1234567890.";
    private final String letras="abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    
    public Validator() {
    }
    public boolean validarNumerico(String entrada){
        for(char numerico :entrada.toCharArray()) {
            boolean correcto=false;
            for(char letraEntrada :numericos.toCharArray()) {
                if(letraEntrada==numerico){
                    correcto=true;
                    break;
                }
            } 
            if(!correcto){
                return correcto;
            }

        } 
        return true;
    }
    public boolean validarLetra(String entrada){
        
        for(char letra :entrada.toCharArray() ) {
            boolean correcto=false;
            for(char letraEntrada :letras.toCharArray() ){
                if(letraEntrada==letra){
                    correcto=true;
                    break;
                }
            } 
            if(!correcto){
                return correcto;
                
            }

        } 
        return true;
    }
    
}
