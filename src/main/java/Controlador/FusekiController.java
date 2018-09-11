package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.apache.jena.fuseki.embedded.FusekiServer;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetAccessor;
import org.apache.jena.query.DatasetAccessorFactory;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

/**
 *
 * @author ale_b
 */
public class FusekiController {
    public int port;
    public Dataset data;
    public String name;
    public FusekiServer server;
    public DatasetAccessor accessor;
     
    public FusekiController (int p, Dataset d, String name){
        this.port=p;
        this.data=d;
        this.name=name;
        this.server = FusekiServer.create().setPort(this.port).add(this.name, this.data).build();
        this.accessor = DatasetAccessorFactory.createHTTP("http://localhost:"+this.port+this.name+"/data");
        
    }
    
    public void up(){
        this.server.start();
    }
    public void down(){
        this.server.stop();
    }
    public void printQuery(String query){
        QueryExecution qExec = QueryExecutionFactory.sparqlService("http://localhost:"+this.port+this.name+"/query", query);
        ResultSet rs = qExec.execSelect() ;
        ResultSetFormatter.out(rs) ;
    }
    
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Dataset getData() {
        return data;
    }

    public void setData(Dataset data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FusekiServer getServer() {
        return server;
    }

    public void setServer(FusekiServer server) {
        this.server = server;
    }
    public OntModel getModel(){
        this.up();
        Model mo = accessor.getModel();
        
        System.out.println("Modelo obtenido");

        OntModel m=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, mo);
        this.down();
        return m;
    }

}
