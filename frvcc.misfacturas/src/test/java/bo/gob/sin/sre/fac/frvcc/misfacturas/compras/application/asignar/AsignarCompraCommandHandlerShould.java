package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.application.asignar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.asignar.AsignarCompraCommandImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.asignar.AsignarCompraCommandHandlerImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.CompraModuleUnitTestCase;

import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain.*;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.asignar.CompraAsignadorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class AsignarCompraCommandHandlerShould extends CompraModuleUnitTestCase {
    private AsignarCompraCommandHandlerImpl handler;
    @BeforeEach
     protected void setUp(){
      /*  super.setUp();*/
        //handler = new AsignarCompraCommandHandler(new CompraAsignador(repository, eventBus, queryBus));
    }
    @Test
    void asignar_y_validar_compra()  {
        AsignarCompraCommandImpl command = AsignarBeneficiarioFacturaCommandMother.random();
        Compra compra = CompraMother.withId(command.id());
        CompraPeriodoUso periodoUso = CompraPeriodoUsoMother.random();
        CompraGestionUso gestionUso = CompraGestionUsoMother.random();
        CompraNombreFormularioUso nombreArchivoUso = CompraNombreArchivoUsoMother.random();
        String pTipoFormulario="";

        compra.asignarAFormulario(new CompraFormularioId(command.formularioId()),
                periodoUso,
                nombreArchivoUso,
                new CompraUsuarioUltimaModificacion(command.usuarioUltimaModificacion()),
                gestionUso, pTipoFormulario);
  /*      shouldSearch(compra);
        handler.handle(command);
        shouldHaveSaved(compra);*/
    }
}
