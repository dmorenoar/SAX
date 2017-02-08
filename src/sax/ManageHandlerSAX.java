/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import sax.Libreria;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author dani
 */

//Clase que nos permite controlar los callbacks
public class ManageHandlerSAX extends DefaultHandler{
    
    //Creamos una lista de libreria
    private ArrayList<Libreria> libreria = new ArrayList();
    //Creamos un objeto para leyer del xml y generar la libreria
    private Libreria lib;

    //Generamos el arraylist de versiones
  
    
    
    //Creamos un buffer para los elementos texto
    //String vs StringBuilder = uno es inmutable y el otro mutable
    //Cada vez que modificamos un String se crea un objeto nuevo, con el otro no.
    //String cuando sabemos que no va a cambiar mucho la información de dentro
    //Cómo sabemos que la información va a cambiar muy continuadamente
    //preferimos tener threads, y tratarlo con este
    private StringBuilder buffer = new StringBuilder();
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //Cuando encontremos carácteres los cargamos la información en el buffer
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            /*case "libros":
            break;
            case "libro":

            break;*/
            case "titulo":
            //Cómo sabemos el orden de lectura, sabemos que despues del characters tenemos
            //el texto dentro del buffer
                lib.setTitulo(buffer.toString());
            break;
            case "autor":
            //Cómo sabemos el orden de lectura, sabemos que despues del characters tenemos
            //el texto dentro del buffer
                lib.setAutor(buffer.toString());
            break;   
        }
        
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //qName nos indica el elemento de la etiqueta(apertura)
        switch(qName){
           /* case "libros":
                break;*/
            case "libro":
                lib = new Libreria();
                //Añadimos el obejto a la lista
                libreria.add(lib);
                //Indicamos que queremos assignar el valor del atributo
                lib.setPublicado(Integer.parseInt(attributes.getValue("publicado_en")));
            break;
            case "titulo":
                buffer.delete(0, buffer.length());
            break;
            case "autor":
                buffer.delete(0, buffer.length());
            break;   
            /*
            default:
                buffer.delete(0, buffer.length());
            */
        }
        
        
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Ya he recorrido todo el documento..");
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Empezando a recorrer el documento..");
    }
    
    
      public ArrayList<Libreria> getLibreria() {
        return libreria;
    }
}
