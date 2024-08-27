package co.edu.uniquindio.programacion2trabajos.centroImpresion.model;

import co.edu.uniquindio.programacion2trabajos.centroImpresion.model.services.ITipoImpresora;

public class ImpresoraLaser implements ITipoImpresora {
    @Override
    public void imprimirDocumento(String valor){
    System.out.println("Imprimir ");
    }
}
