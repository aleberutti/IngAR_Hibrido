package Controlador;





import Modelo.Clase;
import java.util.ArrayList;
import java.util.Map;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.util.FileManager;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.util.iterator.Filter;

public class ModelController {
    public OntModelSpec spec;
    public OntModel model;
    public String path;
    public Map<String, String> mapUris;
    public ObjectProperty propiedades;
    public String gr;
    public String gpc;
    
    public ModelController(String dir, OntModelSpec sp){
        this.path= dir;
        this.spec=sp;
        this.model= ModelFactory.createOntologyModel(spec);

    }
    public ModelController(){
        
    }
    
    public void cargarOnt(){
        model.read(FileManager.get().open(this.path),"");
        //Obtenemos las uris de la ontología cargada
        this.mapUris = this.model.getNsPrefixMap();
        this.gr = this.mapUris.get("gr");
        this.gpc = this.mapUris.get("gpc");
        this.propiedades = this.model.getObjectProperty(gr+"productAndServiceProperties");
    }
    


    public OntModelSpec getSpec() {
        return spec;
    }

    public OntModel getModel() {
        return model;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getMapUris() {
        return mapUris;
    }
    public String getUri(String id){
        return mapUris.get(id);
    }
    public void setModel(OntModel m){
        this.model=m;
        this.mapUris = this.model.getNsPrefixMap();
        this.gr = this.mapUris.get("gr");
        this.gpc = this.mapUris.get("gpc");
        this.propiedades = this.model.getObjectProperty(gr+"productAndServiceProperties");
    }
    public void setMap(){
        this.mapUris = this.model.getNsPrefixMap();
    }
    
    public void createDatatypeProperty(String uri, String comment){
        DatatypeProperty p= this.model.createDatatypeProperty(gr+uri);
        p.addLabel(uri, null);
        if(!comment.isEmpty()) p.addComment(comment, null);
        this.propiedades.addSubProperty(p);
    }
    public void createObjectProperty(String uri, String comment){
        ObjectProperty o =this.model.createObjectProperty(gr+uri);
        o.addLabel(uri, null);
        if(!comment.isEmpty()) o.addComment(comment, null);
        this.propiedades.addSubProperty(o);
    }
    
    public DatatypeProperty getDatatypeProperty(String uri){
        return this.model.getDatatypeProperty(gr+uri);
    }
    public ObjectProperty getObjectProperty(String uri){
        return this.model.getObjectProperty(gr+uri);
    }

    public void removeClass(OntClass c){
        c.remove();
    }
    
    public ExtendedIterator<? extends OntProperty> getProperties(){
        return this.propiedades.listSubProperties();
    }
    
    public Clase createClass(String uri){
        return new Clase(this.model.createClass(gpc+uri));
    }
    
    public OntClass getOntClass(String uri){
        return this.model.getOntClass(uri);
    }
    public ArrayList <Clase> getHierarchyRootClasses(){
        
        ExtendedIterator<OntClass> it = this.model.listHierarchyRootClasses().filterKeep( new Filter<OntClass>() {
            @Override
            public boolean accept(OntClass o) {
                return o.isURIResource() && o.getURI().contains("gpc");
            }
        });
        ArrayList <Clase> raices = new ArrayList<>();
        while ( it.hasNext() ) {
            Clase c = new Clase (it.next());
            raices.add(c);
        }
        
        return raices;
    }
    
}
