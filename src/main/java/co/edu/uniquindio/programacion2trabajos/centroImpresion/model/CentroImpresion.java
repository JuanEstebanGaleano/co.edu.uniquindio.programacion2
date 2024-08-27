package co.edu.uniquindio.programacion2trabajos.centroImpresion.model;

import co.edu.uniquindio.programacion2trabajos.centroImpresion.model.services.ITipoImpresora;

public class CentroImpresion {
    private String codigo;
    private ITipoImpresora tipoImpresora ;

public CentroImpresion(ITipoImpresora ITipoImpresora){
    this.tipoImpresora=ITipoImpresora;
}
public void imprimirDocumento(){

}
}
