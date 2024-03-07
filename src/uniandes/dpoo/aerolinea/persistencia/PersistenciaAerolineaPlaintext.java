package uniandes.dpoo.aerolinea.persistencia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import uniandes.dpoo.aerolinea.exceptions.ClienteRepetidoException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Avion;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

/**
 * Esta clase no está implementada - y no debería implementarse como parte del taller.
 * 
 * Su objetivo es sólo ilustrar que podría haber varias implementaciones de la misma interfaz, y que durante la ejecución alguien podría decidir cuál de estas implementaciones
 * usar.
 */

public class PersistenciaAerolineaPlaintext implements IPersistenciaAerolinea
{
	private static final String NOMBRE_AVION = "nombreAvion";
    private static final String CAPACIDAD_AVION = "capacidadAvion";
    private static final String HORA_SALIDA = "horaSalida";
    private static final String HORA_LLEGADA = "horaLlegada";
    private static final String CODIGO_RUTA = "codigoRuta";
    private static final String NOMBRE_AEROPUERTO = "nombreAeropuerto";
    private static final String FECHA = "fecha";
    private static final String CODIGO_AEROPUERTO = "codigoAeropuerto";
    private static final String LATITUD = "latitud";
    private static final String LONGITUD = "longitud";
    
    @Override
    public void cargarAerolinea( String archivo, Aerolinea aerolinea ) {
    	
    	 String jsonCompleto = new String( Files.readAllBytes( new File( archivo ).toPath( ) ) );
         JSONObject raiz = new JSONObject( jsonCompleto );

         cargarAerolinea( aerolinea, raiz.getJSONArray( "aerolinea" ) );
         cargarVuelo ( aerolinea, raiz.getJSONArray( "vuelos" ) );
         salvarRuta( aerolinea, raiz.getJSONArray( "rutas" ) );
         cargarAeropuerto( aerolinea, raiz.getJSONArray( "aeropuertos" ) );
         
	}
    @Override
    public void salvarAerolinea( String archivo, Aerolinea aerolinea ) throws IOException
    {
        JSONObject jobject = new JSONObject( );

        
        salvarVuelo( aerolinea, jobject );
        salvarRuta( aerolinea, jobject );
        salvarAvion( aerolinea, jobject );
        salvarAerolinea( aerolinea, jobject );

        // Escribir la estructura JSON en un archivo
        PrintWriter pw = new PrintWriter( archivo );
        jobject.write( pw, 2, 0 );
        pw.close( );
    }

   
    public void cargarVuelo( Aerolinea aerolinea, JSONArray jVuelos ) 
    {
    	int numVuelos = jVuelos.length( );
        for( int i = 0; i < numVuelos; i++ )
        {
            JSONObject vuelo = jVuelos.getJSONObject( i );
            String fecha = vuelo.getString( FECHA );
            String codigo = vuelo.getString( CODIGO_RUTA );
            
            Ruta ruta = Vuelo.getRuta() ;
            Avion avion = Vuelo.getAvion();

              
            Vuelo nuevoVuelo = new Vuelo(fecha, ruta, avion );
            
            aerolinea.registrarVueloRealizado(fecha, codigo);
           
        }
	}
    private void salvarVuelo( Aerolinea aerolinea, JSONObject jobject )
    {
        JSONArray jVuelos = new JSONArray( );
        for( Vuelo vuelo : aerolinea.getVuelos( ) )
        {
            
                JSONObject jVuelo = new JSONObject( );
                jVuelo.put( FECHA, vuelo.getRuta().getCodigoRuta() );
                jVuelos.put( jVuelo );   
           
        }

        jobject.put( "vuelos", jVuelos );
    }
    
public void cargarRuta( Aerolinea aerolinea, JSONArray jRutas ) 
	{
	int numRutas = jRutas.length( );
    for( int i = 0; i < numRutas; i++ )
    {
        JSONObject ruta = jRutas.getJSONObject( i );
        String salida = ruta.getString( HORA_SALIDA );
        String llegada = ruta.getString( HORA_LLEGADA );
        String codRuta = ruta.getString( CODIGO_RUTA );
        Aeropuerto origen = Ruta.getOrigen() ;
        Aeropuerto destino = Ruta.getDestino() ;
        

          
        Ruta nuevaruta = new Ruta(salida, llegada, codRuta,  origen, destino);
        aerolinea.agregarRuta(nuevaruta);
	}
	}

private void salvarRuta(  Aerolinea aerolinea, JSONObject jobject)
{
    JSONArray jRutas = new JSONArray( );
    for( Ruta ruta : aerolinea.getRuta(CODIGO_RUTA) )
    {
        
            JSONObject jRuta = new JSONObject( );
            jRuta.put( CODIGO_RUTA , ruta  );
            jRutas.put( jRuta );   
       
    }

    jobject.put( "vuelos", jRutas );
}
    

    
    
    
    
    private void salvarAerolinea( Aerolinea aerolinea, JSONObject jobject )
    {
        JSONArray jTiquetes = new JSONArray( );
        for( Tiquete tiquete : aerolinea.getTiquetes( ) )
        {
            JSONObject jTiquete = new JSONObject( );
            jTiquete.put( CODIGO_TIQUETE, tiquete.getCodigo( ) );
            tiquete.getVuelo( );
			jTiquete.put( CODIGO_RUTA, Vuelo.getRuta( ).getCodigoRuta( ) );
            jTiquete.put( FECHA, tiquete.getVuelo( ).getFecha( ) );
            jTiquete.put( TARIFA, Tiquete.getTarifa( ) );
            jTiquete.put( USADO, tiquete.esUsado( ) );
            jTiquete.put( CLIENTE, tiquete.getCliente( ).getIdentificador( ) );

            jTiquetes.put( jTiquete );
        }
        jobject.put( "tiquetes", jTiquetes );
    }
    	
 }

