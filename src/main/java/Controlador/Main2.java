package Controlador;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.bson.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ale_b
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        TDBController data = new TDBController("C:\\Users\\ale_b\\Desktop\\ISI\\Investigación\\JenaTDB");
        
        data.loadModel("C:\\Users\\ale_b\\Desktop\\ISI\\Investigación\\gpc.owl");
        
        Dataset dataset = data.getDataset();
       
        ModelController ont= new ModelController();
        ont.setModel(data.getModel());
        ont.setMap();
        String owl = ont.getUri("owl");
        String gr = ont.getUri("gr");
        String rdfs = ont.getUri("rdfs");
        String rdf = ont.getUri("rdf");
        String xsd = ont.getUri("xsd");
        String dcterms = ont.getUri("dcterms");
        String foaf = ont.getUri("foaf");
        String dc = ont.getUri("dc");
        String gpc =  ont.getUri("gpc");
        
        OntModel model= ont.getModel();
       
        dataset.begin(ReadWrite.WRITE);
        
        ObjectProperty g = model.createObjectProperty(gr+"productAndServiceProperties");
        g.addComment("Todas las propiedades referentes a productos y servicios", null);
        
        DatatypeProperty nombre_producto = model.getDatatypeProperty(gr+"name");
        nombre_producto.addComment("Nombre del producto o servicio",null);
        nombre_producto.addLabel("Nombre", null);
        ObjectProperty marca_producto = model.getObjectProperty(gr+"hasBrand");
        marca_producto.addComment("Marca asociada al producto o servicio",null);
        marca_producto.addLabel("Marca", null);
        DatatypeProperty modelo_producto = model.createDatatypeProperty(gr+"modelo");
        modelo_producto.addComment("Modelo del producto o servicio",null);
        modelo_producto.addLabel("Modelo", null);
        DatatypeProperty descripcion_producto = model.getDatatypeProperty(gr+"description");
        descripcion_producto.addComment("Breve descripción del producto o servicio",null);
        descripcion_producto.addLabel("Descripción", null);
        DatatypeProperty caracteristicas = model.createDatatypeProperty(gr+"caracteristicas");
        caracteristicas.addComment("Características del producto o servicio",null);
        caracteristicas.addLabel("Características", null);
        DatatypeProperty cat= model.getDatatypeProperty(gr+ "category");
        cat.addComment("Categoría/s del producto o servicio",null);
        cat.addLabel("Categorías", null);
        
        g.addSubProperty(nombre_producto);
        g.addSubProperty(marca_producto);
        g.addSubProperty(modelo_producto);
        g.addSubProperty(descripcion_producto);
        g.addSubProperty(caracteristicas);
        g.addSubProperty(cat);
        
        System.out.println(g.listSubProperties().toList().toString());
        
        
        try {
        FileWriter destino = new FileWriter("C:\\Users\\ale_b\\Desktop\\ISI\\gpc.owl");
        model.writeAll(destino, "RDF/XML-ABBREV");
        }
        catch(Exception e){
         e.printStackTrace();
        }
        System.out.println("Salida terminada");
        dataset.commit();
        dataset.end();
        
//        data.loadModel("C:\\Users\\ale_b\\Desktop\\ISI\\Investigación\\gpc.owl");
//        
//        ont.setModel(data.getModel());
//        model= ont.getModel();
//        
//        MongoClient mongo = new MongoClient("localhost",27017); 
//        
//        Runtime.getRuntime().exec("\"C:\\Program Files\\MongoDB\\Server\\3.4\\bin\\mongoimport\" --db ontologia --collection instancias --file C:\\Users\\ale_b\\Desktop\\salida1.json");
//
//        MongoDatabase database = mongo.getDatabase("ontologia");
//        MongoCollection<Document> collection = database.getCollection("instancias");
//        
//        FindIterable<Document> iterDoc = collection.find(); 
//        int i = 1; 
//
//        // Getting the iterator 
//        Iterator it = iterDoc.iterator(); 
//    
//       while (it.hasNext()) {  
//          System.out.println(it.next());  
//        i++; 
//        }
//        System.out.println(i);
//
//       FusekiController s = new FusekiController (3030, dataset, "/ont");    
//       s.up();
//
//        String queryString =
//        "PREFIX rdfs:"+rdfs+"\n"+
//        "PREFIX owl:"+owl+"\n"+
//        "PREFIX rdf:"+rdf+"\n"+
//        "SELECT DISTINCT ?nombre WHERE{\n"
//        + "?propiedad rdf:type owl:Class .\n"
//        + "?propiedad rdfs:subClassOf "+gr+";ProductOrService.\n"
//        + "?propiedad rdfs:label ?nombre.\n"
//                + "}";        
//
//        s.printQuery(queryString);
//        s.down();

        

        
    
    }
}
