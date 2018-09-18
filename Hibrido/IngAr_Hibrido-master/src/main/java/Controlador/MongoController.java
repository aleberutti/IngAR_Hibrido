
package Controlador;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoController {
    public int port;
    public MongoClient client;
    public MongoDatabase db;
    public MongoCollection coleccion;
    
    public MongoController (String database, String c) throws IOException{
        this.port = 27017;
        this.client = new MongoClient("localhost", port);
        db = client.getDatabase("ontologia");
        coleccion = db.getCollection("instancias");
    }
    
    public MongoCollection getCollection(){
        return this.coleccion;
    }
    
    public MongoDatabase getdatabase(){
        return this.db;
    }
    
    
    public void agregarDoc(Document d){
        this.coleccion.insertOne(d);
    }
    
    public long modificarDoc(Document doc_nuevo, Document viejo){
        Bson filter = Filters.eq("_id", doc_nuevo.get("_id"));
        return coleccion.replaceOne(filter, doc_nuevo).getModifiedCount();
    }
    
    public void eliminarDoc(Document doc){
        coleccion.deleteOne(doc);
    }
    
    public void imprimirDocs(){
        FindIterable<Document> iterDoc = this.coleccion.find(); 
        int i = 1; 
        
        Iterator it = iterDoc.iterator(); 
    
        while (it.hasNext()) {  
            System.out.println(it.next());  
            i++; 
        }
    }

    @SuppressWarnings("empty-statement")
    public List<Document> busqueda(String id, String nombre, String marca, String modelo, String tipo){
        
        String uri = "http://www.ebusiness-unibw.org/ontologies/pcs2owl/gpc/";
        Document doc = new Document();
        List<Document> prods = new ArrayList<>();

        if(id!=null){
            doc.append("_id", java.util.regex.Pattern.compile(uri+id));
        }
        if(nombre!=null){
            doc.append("nombre", java.util.regex.Pattern.compile(nombre));
        }
        if(marca!=null){
            doc.append("marca", java.util.regex.Pattern.compile(marca.toUpperCase()));
        }
        if(modelo!=null){
            doc.append("modelo", java.util.regex.Pattern.compile(modelo));
        }
        if(tipo!=null){
            doc.append("tipo", java.util.regex.Pattern.compile(tipo));
        }
       
        FindIterable <Document> it = coleccion.find(doc);
        it.forEach(new Block<Document>() {
            @Override
            public void apply(final Document t) {
               prods.add(t);
            }
        });
       
            
        return prods;
    }
    
    
    public boolean validarID(String id){
        Document doc = new Document();
        String uri = "http://www.ebusiness-unibw.org/ontologies/pcs2owl/gpc/";
        doc.append("_id", uri+id);
        FindIterable it = coleccion.find(doc);
        if(it.iterator().hasNext()){
            return false;
        }
        else{
            return true;
        } 
    }

  
}

