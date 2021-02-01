package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras;



import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface VerificaCodigoAutorizacionRepository {

    VerificadorNumeroAutoriacion  verificaCodigoAutorizacion(Long pNitProveedor,
                                    Long pNumeroFactura,
                                    String CodigoAutorizacion,
                                    String pNitCi,
                                    LocalDate pFechaFactura,
                                    String pCodigoControl,
                                    BigDecimal pImporteBaseCf) throws DomainError;
}
