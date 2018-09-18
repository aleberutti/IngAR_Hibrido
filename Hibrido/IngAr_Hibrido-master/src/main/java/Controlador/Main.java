/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Inicio;
import java.io.IOException;
import org.apache.jena.query.Dataset;

public class Main {
//    public MongoController mongocontroller;
//    public FusekiController fusekicontroller;
    
    public static void main(String[] args) throws IOException{
        //CAMBIAR PATHSSSSSSSSSSSSSSSS
        System.out.println("Comienza tdb");
        TDBController data = new TDBController("C:\\Users\\Azul\\Documents\\INGAR\\Proyecto IngAr\\JenaTDB");
        
        data.loadModel("C:\\Users\\Azul\\Documents\\INGAR\\Proyecto IngAr\\gpc.owl");
        Dataset dataset = data.getDataset();
        
        System.out.println("Comienza mongo");
        
        MongoController mongocontroller = new MongoController("ontologia", "instancias");
        System.out.println("Comienza fuseki");
        
        FusekiController fusekicontroller = new FusekiController(3030, dataset, "/ont");
        
        ModelController modelcontroller = new ModelController();
        modelcontroller.setModel(fusekicontroller.getModel());
        System.out.println("Comienza inicio");
        Inicio inicio = new Inicio(mongocontroller, fusekicontroller, data, modelcontroller);
        inicio.setVisible(true);
    }
}
