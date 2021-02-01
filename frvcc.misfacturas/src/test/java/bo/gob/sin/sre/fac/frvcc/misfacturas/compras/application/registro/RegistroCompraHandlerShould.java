package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.application.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.RegistroCompraCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.RegistroCompraCommandHandler;
import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.CompraModuleUnitTestCase;

import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain.CompraMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain.CompraRegistradaDomainEventMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.registro.CompraRegistradorServiceImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraRegistradaDomainEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RegistroCompraHandlerShould extends CompraModuleUnitTestCase {
    private RegistroCompraCommandHandler handler;
    @BeforeEach
     protected void setUp(){
       /* super.setUp();*/
       /* handler = new RegistroCompraCommandHandler(new CompraRegistrador(repository, eventBus,queryBus, validador));*/
    }
    @Test
    void  registrar_compra()  {
/*        RegistroCompraCommand command = RegistroCompraCommandMother.random();
        Compra compra                 = CompraMother.fromRequest(command);
        CompraRegistradaDomainEvent domainEvent = CompraRegistradaDomainEventMother.fromCompra(compra);
        handler.handle(command);
        shouldHaveSaved(compra);
       shouldHavePublished(domainEvent);*/

    }
}
