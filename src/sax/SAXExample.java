/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;

/**
 *
 * @author dani
 */
public class SAXExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        File f = new File("libreriaComplete.xml");
        //Instanciamos un objeto para instanciar el parseador y que podamos leer el documento
        SAXParserFactory saxParserFactoy = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactoy.newSAXParser();
        
        //Asignamos nuestro fichero y un interprete para el documento
        //Definiremos nuestro Handler
        ManageHandlerSAX handler = new ManageHandlerSAX();
        //Leera toda la información y la almacenará en el arrayList
        saxParser.parse(f, handler);
        
        ArrayList<Libreria> lib = handler.getLibreria();
        
        for(Libreria b: lib){
            System.out.println("Libro");
            System.out.println("Publicado en: " + b.getPublicado());
            System.out.println("Autor: " + b.getAutor());
            System.out.println("Titulo: " + b.getTitulo());
            System.out.println("++++++++++++++");
        }
    }
            
}
