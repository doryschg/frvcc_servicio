package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.application.find;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.find.FindCompraQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.find.FindCompraQueryHandler;
import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.CompraModuleUnitTestCase;


import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain.CompraMother;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.find.CompraBuscadorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





final class FindCompraQueryHandlerShould extends CompraModuleUnitTestCase {
    private FindCompraQueryHandler handler;

    @BeforeEach
    protected void setUp() {
/*        super.setUp();*/

       // handler = new FindCompraQueryHandler(new CompraFinder(repository), new );
    }



    @Test
    void search_an_existing_beneficiario_factura() {
        FindCompraQuery query = FindBeneficiarioFacturaQueryMother.random();

        Compra compra = CompraMother.withId(query.id());
 /*       CompraResponse response = BeneficiarioFacturaResponseMother.create(compra.id(),
                compra.codigoControl(),
                compra.fechaEmision(),
                compra.nit(),
                compra.numero(),
                compra.beneficiarioId(),
                compra.importe());

        shouldSearch(compra);*/

    //    assertEquals(response, handler.handle(query));
    }
}
