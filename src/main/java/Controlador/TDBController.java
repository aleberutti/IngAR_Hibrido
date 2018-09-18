package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.ModelFactory;

/**
 *
 * @author ale_b
 */
public class TDBController {
    public String d_path;
    public Dataset data;
    public Model model;
    
    public TDBController (String datapath){
        this.d_path=datapath;
        this.data=TDBFactory.createDataset(d_path);
    }
    public Dataset getDataset(){
        return this.data;
    }
    public void loadModel( String m_path){
        this.data.begin(ReadWrite.WRITE);
        this.model= this.data.getDefaultModel();
        this.model.read(FileManager.get().open(m_path),"");
        this.data.commit();
        this.data.end();
    }
    public void updateData(Model m){
        this.data.begin(ReadWrite.WRITE);
        this.model.removeAll();
        this.model.add(m);
        this.data.commit();
        this.data.end();
    }
    
    public OntModel getModel(){
        this.data.begin(ReadWrite.WRITE);
        OntModel m =ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, this.model);
        this.data.commit();
        this.data.end();
        return m; 
    }
}
