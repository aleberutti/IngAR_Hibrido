/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.util.iterator.Filter;

/**
 *
 * @author ale_b
 */
public class Clase {
   
    public OntClass clase;
    public ArrayList<Clase> hijos;
    public String comment;
    public String name;
    
   
    public Clase (OntClass c){
        this.clase=c;
        this.hijos= new ArrayList<>();
        this.comment=c.getComment(null);
        this.name= this.clase.getLabel(null);
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    public void setSubClasses(){

        ExtendedIterator<OntClass> it = this.clase.listSubClasses().filterKeep( new Filter<OntClass>() {
            @Override
            public boolean accept(OntClass o) {
                return o.isURIResource() && o.getURI().contains("gpc");
            }
           });

        while (it.hasNext()) {
                OntClass k = it.next();
                Clase c = new Clase (k);
                this.hijos.add(c);  
        }

    }
    public void addSubclass(Clase c){
        this.clase.addSubClass(c.getClase());
    }
    public void addLabel(String label){
        this.clase.addLabel(label, null);
    }
    public void addComment(String c){
        this.clase.addComment(c, null);
    }
    public String getUri(){
        return this.clase.getURI();
    }

    public OntClass getClase() {
        return clase;
    }

    public ArrayList<Clase> getHijos() {
        return hijos;
    }
    
    public String getComment(){
        return comment;
    }

    public Boolean isLeaf() {
        return this.hijos.isEmpty();
    }
}
