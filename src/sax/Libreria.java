/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

/**
 *
 * @author dani
 */
class Libreria {
    private int publicado;
    private String titulo;
    private String autor;

    public Libreria() {
    }

    public int getPublicado() {
        return publicado;
    }

    public void setPublicado(int publicado) {
        this.publicado = publicado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libreria{" + "publicado=" + publicado + ", titulo=" + titulo + ", autor=" + autor + '}';
    }
    
    
}
