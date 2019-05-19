/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.util.ArrayList;

/**
 *
 * @author Tatiana Alarcon
 */
public class PrecargarDatos {
    
    public ArrayList<String> cargarOpciones(){
        ArrayList<String> palabras=new ArrayList<>();
       
        //ESTROFA 1
        palabras.add("TRY");
        palabras.add("CLOSE");
        palabras.add("TO");
        palabras.add("ME");//RESPUESTA
        //ME
        
        
        //ESTROFA 2
        palabras.add("SHOULD");
        palabras.add("HOLD");//RESPUESTA
        palabras.add("BEEN");
        palabras.add("SO");
        //HOLD
        
        //ESTROFA 3
        palabras.add("CLOSE");
        palabras.add("LIFE");
        palabras.add("CAN");
        palabras.add("ONCE");//RESPUESTA
        //ONCE
        
        //ESTROFA 4
        palabras.add("TIDE");//RESPUESTA
        palabras.add("SKY");
        palabras.add("BACK");
        palabras.add("STOP");
        //TIDE
        
        //ESTROFA 5
        palabras.add("THE");//RESPUESTA
        palabras.add("CLOSE");
        palabras.add("UPON");
        palabras.add("TIME");
        //THE
        
        //ESTROFA 6
        palabras.add("BACK");
        palabras.add("STOP");
        palabras.add("ME");
        palabras.add("OHOO");//RESPUESTA
        //OHOOO
        
        //ESTROFA 7
        palabras.add("CLOSE");
        palabras.add("TRY");
        palabras.add("WANDER");//RESPUESTA
        palabras.add("HOLD");
        //WANDER
        
        //ESTROFA 8
        palabras.add("LOOK");
        palabras.add("HOLD");//RESPUESTA
        palabras.add("EYES");
        palabras.add("ME");
        //HOLD
        
        //ESTROFA 9
        palabras.add("I");//RESPUESTA
        palabras.add("CAN");
        palabras.add("CLOSE");
        palabras.add("LONELY");
        //I
        
        //ESTROFA 10
        palabras.add("TELL");
        palabras.add("BACK");
        palabras.add("US");//RESPUESTA
        palabras.add("LOVE");
        //US
      
        return palabras;
    }
    
    public ArrayList<Integer> cargarRespuestas(){
        
        ArrayList<Integer> respuestas=new ArrayList<>();
        respuestas.add(3);
        respuestas.add(1);
        respuestas.add(3);
        
        respuestas.add(0);   
        respuestas.add(0);
        respuestas.add(3);
        
        respuestas.add(2);
        respuestas.add(1);
        respuestas.add(0);
        respuestas.add(2);
      
        return respuestas;
    }
    
}
