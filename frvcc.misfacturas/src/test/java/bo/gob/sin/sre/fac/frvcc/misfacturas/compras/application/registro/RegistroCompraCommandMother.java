package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.application.registro;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro.RegistroCompraCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;

public final class RegistroCompraCommandMother {
    public static RegistroCompraCommand registro(
            CompraId id, CompraFechaFactura fechaFactura,
            CompraNitProveedor nitProveedor, CompraRazonSocialProveedor razonSocialProveedor,
            CompraNumeroFactura numeroFactura, CompraCodigoAutorizacion codigoAutorizacion,
            CompraImporteTotalCompra importeTotalCompra, CompraCodigoControl codigoControl,
            CompraUsuarioRegistro usuarioRegistro,
            CompraNombreCliente nombreCliente ,
            CompraTipoDocumentoCliente tipoDocumentoCliente,
            CompraNumeroDocumentoCliente numeroDocumentoCliente,
            CompraComplementoDocumentoCliente complementoDocumentoCliente,
            CompraOrigenId origenId
    ) {
        return  null;
    }

    public static RegistroCompraCommand random(){
        return registro(CompraIdMother.random(),CompraFechaFacturaMother.random(),
                CompraNitProveedorMother.random(), CompraRazonSocialProveedorMother.random(),
                CompraNumeroFacturaMother.random(), CompraCodigoAutorizacionMother.random(),
                CompraImporteTotalCompraMother.random(), CompraCodigoControlMother.random(),
                CompraUsuarioRegistroMother.random(),
                CompraNombreClienteMother.random(),CompraTipoDocumentoClienteMother.random(),
                CompraNumeroDocumentoClienteMother.random(),CompraComplementoDocumentoClienteMother.random(),
                CompraOrigenIdMother.random());
    }
}
