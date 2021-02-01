package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.RespuestaConciliacionDto;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.SolicitudConciliacionDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;

import java.math.BigDecimal;

public interface IRecepionFormulario {
    ResultadoGenericoDto<RespuestaConciliacionDto> recepcionFormulario(String formulario,
                                                                       Long codigoPersona,
                                                                       Integer periodo,
                                                                       Integer anio,
                                                                       BigDecimal montoDeterminacionPago,
                                                                       Integer cantidadFacturas,
                                                                       BigDecimal montoTotalFacturas);
}
