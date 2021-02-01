package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.application.search_by_criteria;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.search_by_criteria.SearchComprasByCriteriaQueryHandler;
import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.CompraModuleUnitTestCase;

import bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras.search_by_criteria.ComprasByCriteriaSearcherImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


final class SearchComprasByCriteriaQueryHandlerShould extends CompraModuleUnitTestCase {
    private SearchComprasByCriteriaQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        /*super.setUp();*/

       // handler = new SearchComprasByCriteriaQueryHandler(new ComprasByCriteriaSearcher(repository));
    }



    @Test
    void search_an_existing_from_fecha_emision_beneficiario_factura() {
/*        FindBeneficiarioFacturaFechaEmisionQuery query = FindBeneficiarioFacturaFechaEmisionQueryMother.random();

        BeneficiarioFactura         beneficiarioFactura   = BeneficiarioFacturaMother.withFechaEmision(query.fechaEmision());
        BeneficiarioFacturaResponse beneficiarioFacturaResponse = BeneficiarioFacturaResponseMother.create(beneficiarioFactura.id(),
                beneficiarioFactura.codigoControl(),
                beneficiarioFactura.fechaEmision(),
                beneficiarioFactura.nit(),
                beneficiarioFactura.numero(),
                beneficiarioFactura.beneficiarioId(),
                beneficiarioFactura.importe());

        List<BeneficiarioFactura> beneficiarioFacturas = new ArrayList<>(
                Arrays.asList(beneficiarioFactura)
        ) ;

        BeneficiarioFacturasResponse response = new BeneficiarioFacturasResponse(new ArrayList<>(
               Arrays.asList(beneficiarioFacturaResponse)));

        Filter filter =  Filter.create("codigoControl","=","hola");

        Criteria criteria = new Criteria(
                new Filters(
                        new ArrayList<>(
                                Arrays.asList(filter)
                        )
                ),
                Order.none(),
                Optional.empty(),
                Optional.empty()
        );

        shouldMatching(criteria, beneficiarioFacturas);

        BeneficiarioFacturasResponse responseMook = handler.handle(query);*/



    /*    assertEquals( response,responseMook );*/
    }
}
