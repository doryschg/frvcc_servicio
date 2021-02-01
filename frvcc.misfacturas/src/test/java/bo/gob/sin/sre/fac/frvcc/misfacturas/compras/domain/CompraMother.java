package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain;



import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.RegistroCompraCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CompraMother {
    public static Compra create(CompraId id,
                                CompraFechaFactura fechaFactura,
                                CompraNitProveedor nitProveedor,
                                CompraNumeroFactura numeroFactura,
                                CompraCodigoAutorizacion codigoAutorizacion,
                                CompraImporteTotalCompra importeTotalCompra,
                                CompraCodigoControl codigoControl,

                                CompraUsuarioRegistro usuarioRegistro,
                                CompraTipoDocumentoCliente tipoDocumentoCliente,
                                CompraNumeroDocumentoCliente numeroDocumentoCliente,
                                CompraComplementoDocumentoCliente complementoDocumentoCliente
    ){CompraRecepcionId recepcionId = new CompraRecepcionId(null);
        CompraSecuencia secuencia=new CompraSecuencia(null);
        CompraIfcProveedorNb ifcProveedorNb=new CompraIfcProveedorNb(null);
        CompraNombreCliente nombreCliente=new CompraNombreCliente(null);
        CompraOrigenId origenId=new CompraOrigenId(null);
        CompraRazonSocialProveedor razonSocialProveedor = new CompraRazonSocialProveedor(null);
        CompraImporteNoSujetoCf importeNoSujetoCf=new CompraImporteNoSujetoCf(null);
        CompraTipoDocumentoId tipoDocumentoId = new CompraTipoDocumentoId(null);
        CompraNumeroDui numeroDui = new CompraNumeroDui(null);
        CompraSubtotal subtotal = new CompraSubtotal(null);
        CompraDescuento descuento = new CompraDescuento(null);
        CompraImporteBaseCf importeBaseCf = new CompraImporteBaseCf(null);
        CompraCreditoFiscal creditoFiscal = new CompraCreditoFiscal(null);
        CompraTipoSectorId tipoSectorId = new CompraTipoSectorId(null);
        CompraEstadoCompraId estadoCompraId = new CompraEstadoCompraId(EstadoCompraId.VIGENTE.value());
        CompraEstadoUsoId estadoUsoId = new CompraEstadoUsoId(EstadoUsoId.APROPIADO.value());
        CompraImpuestoUsoId impuestoUsoId = new CompraImpuestoUsoId(null);
        CompraPeriodoUso periodoUso = new CompraPeriodoUso(null);
        CompraNombreFormularioUso nombreArchivoUso = new CompraNombreFormularioUso(null);
        CompraFormularioId formularioId = new CompraFormularioId(null);
        CompraVentaId ventaId = new CompraVentaId(null);
        CompraFechaRegistro fechaRegistro = new CompraFechaRegistro(LocalDateTime.now());
        CompraUsuarioUltimaModificacion usuarioUltimaModificacion = new CompraUsuarioUltimaModificacion(null);
        CompraFechaUltimaModificacion fechaUltimaModificacion = new CompraFechaUltimaModificacion(null);
        CompraEstadoId estadoId = new CompraEstadoId("AC");
        CompraGestionUso gestionUso = new CompraGestionUso(null);
        CompraModalidadId modalidadId = new CompraModalidadId("MAN");
        CompraLibroId libroId = new CompraLibroId(null);
        return null;
    }
    public static Compra fromRequest(RegistroCompraCommand request){
        return null;
    }
    public static Compra random(){
        return create(
                CompraIdMother.random(),
                CompraFechaFacturaMother.random(),
                CompraNitProveedorMother.random(),
                CompraNumeroFacturaMother.random(),
                CompraCodigoAutorizacionMother.random(),
                CompraImporteTotalCompraMother.random(),
                CompraCodigoControlMother.random(),
                CompraUsuarioRegistroMother.random(),
                CompraTipoDocumentoClienteMother.random(),
                CompraNumeroDocumentoClienteMother.random(),
                CompraComplementoDocumentoClienteMother.random()
        );
    }

    public static Compra withId(String id) {
    return  create(
                    CompraIdMother.create(id),
                    CompraFechaFacturaMother.random(),
                    CompraNitProveedorMother.random(),
                    CompraNumeroFacturaMother.random(),
                    CompraCodigoAutorizacionMother.random(),
                    CompraImporteTotalCompraMother.random(),
                    CompraCodigoControlMother.random(),
                    CompraUsuarioRegistroMother.random(),
                    CompraTipoDocumentoClienteMother.random(),
                    CompraNumeroDocumentoClienteMother.random(),
                    CompraComplementoDocumentoClienteMother.random()
            );
    }

    public static Compra withFechaEmision(LocalDate fechaEmision) {
          return null;
    }

}
