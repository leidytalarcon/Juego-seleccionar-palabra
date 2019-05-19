/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Tatiana Alarcon
 */
public class GestionarArchivo {

    public GestionarArchivo() {
        validarArchivoOpciones();
        validarArchivoRespuestas();
    }
    
    private String rutaOpciones="listaOpciones.txt";
    private String rutaRespuestas="listaRespuestas.txt";
    
    private void validarArchivoOpciones(){
     try {
            
            File file = new File(rutaOpciones);
           
            if (!file.exists()) {
                file.createNewFile();
                PrecargarDatos precarga=new PrecargarDatos();
                escribirOpciones(precarga.cargarOpciones());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    private void validarArchivoRespuestas(){
     try {
            
            File file = new File(rutaRespuestas);
           
            if (!file.exists()) {
                file.createNewFile();
                PrecargarDatos precarga=new PrecargarDatos();
                escribirRespuestas(precarga.cargarRespuestas());
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    


    public void escribirOpciones(ArrayList<String> palabras) {
        try {
            FileWriter Archivo = new FileWriter(rutaOpciones);
            PrintWriter pw = new PrintWriter(Archivo);
            for(String palabra:palabras){
                 pw.println(palabra);
            }
           
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> LeerOpciones() {

        File archivo = null;
        FileReader fr = null;
        ArrayList<String> palabras=new ArrayList<>();
        try {
            archivo = new File(rutaOpciones);
            String linea;
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                palabras.add(linea);
            }

        } catch (IOException e) {
            System.out.println(e);
            
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            return palabras;
        }
        
        
    }
    
    
     public void escribirRespuestas(ArrayList<Integer> respuestas) {
        try {
            FileWriter Archivo = new FileWriter(rutaRespuestas);
            PrintWriter pw = new PrintWriter(Archivo);
            for(Integer respuesta:respuestas){
                 pw.println(respuesta.toString());
                 System.out.print(respuesta);
            }
           
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> LeerRespuestas() {

        File archivo = null;
        FileReader fr = null;
        ArrayList<Integer> respuestas=new ArrayList<>();
        try {
            archivo = new File(rutaRespuestas);
            String linea;
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                respuestas.add(Integer.valueOf(linea));
                    
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return respuestas;
        }
        
        
    }




}
