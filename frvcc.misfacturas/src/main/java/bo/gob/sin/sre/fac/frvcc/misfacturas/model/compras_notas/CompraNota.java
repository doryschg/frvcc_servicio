package bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraEstadoUsoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFechaUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EstadoUsoId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraDeclaradaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra_nota.CompraNotaAsociadaLibroDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra_nota.CompraNotaDesAsociadaLibroDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra_nota.CompraNotaRegistradaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.model.AggregateRoot;
import bo.gob.sin.str.constantes.estado.ConstEstado;

public final class CompraNota extends AggregateRoot {
    private final CompraNotaId id;
    private CompraNotaIfcProveedor ifcProveedor;
    private CompraNotaNitProveedor nitProveedor;
    private CompraNotaRazonSocialProveedor razonSocialProveedor;
    private CompraNotaNumeroNota numeroNota;
    private CompraNotaCodigoAutorizacion codigoAutorizacion;
    private CompraNotaFechaNota fechaNota;
    private CompraNotaImporteTotalNota importeTotalNota;
    private CompraNotaCreditoFiscalNota creditoFiscalNota;
    private CompraNotaCodigoControlNota codigoControlNota;
   
    private CompraNotaCompraId compraId;
    
    private CompraNotaEstadoNotaId estadoNotaId;
    private CompraNotaTipoDocumentoCliente tipoDocumentoCliente;
    private CompraNotaNumeroDocumentoCliente numeroDocumentoCliente;
    private CompraNotaComplementoDocumentoCliente complementoDocumentoCliente;
    private CompraNotaNombreCliente nombreCliente;
    private CompraNotaOrigenId origenId;
    private CompraNotaEstadoUsoId estadoUsoId;
    private CompraNotaImpuestoUsoId impuestoUsoId;
    private CompraNotaGestionUso gestionUso;
    private CompraNotaPeriodoUso periodoUso;
    private CompraNotaNombreFormularioUso nombreFormularioUso;
    private CompraNotaFormularioId formularioId;
    private CompraNotaLibroId libroId;
    private CompraNotaVentaNotaId ventaNotaId;
    private CompraNotaRecepcionId recepcionId;
    private CompraNotaSecuencia secuencia;
    private CompraNotaTipoObservacionId tipoObservacionId;
    private CompraNotaUsuarioRegistro usuarioRegistro;
    private CompraNotaFechaRegistro fechaRegistro;
    private CompraNotaUsuarioUltimaModificacion usuarioUltimaModificacion;
    private CompraNotaFechaUltimaModificacion fechaUltimaModificacion;
    private CompraNotaEstadoId estadoId;

    private CompraNota(Builder builder) {
        this.id = builder.id;
        this.ifcProveedor = builder.ifcProveedor;
        this.nitProveedor = builder.nitProveedor;
        this.razonSocialProveedor = builder.razonSocialProveedor;
        this.numeroNota = builder.numeroNota;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.fechaNota = builder.fechaNota;
        this.importeTotalNota = builder.importeTotalNota;
        this.creditoFiscalNota = builder.creditoFiscalNota;
        this.codigoControlNota = builder.codigoControlNota;
        this.compraId = builder.compraId;
        
        this.estadoNotaId = builder.estadoNotaId;
        this.tipoDocumentoCliente = builder.tipoDocumentoCliente;
        this.numeroDocumentoCliente = builder.numeroDocumentoCliente;
        this.complementoDocumentoCliente = builder.complementoDocumentoCliente;
        this.nombreCliente = builder.nombreCliente;
        this.origenId = builder.origenId;
        this.estadoUsoId = builder.estadoUsoId;
        this.impuestoUsoId = builder.impuestoUsoId;
        this.gestionUso = builder.gestionUso;
        this.periodoUso = builder.periodoUso;
        this.nombreFormularioUso = builder.nombreFormularioUso;
        this.formularioId = builder.formularioId;
        this.libroId = builder.libroId;
        this.ventaNotaId = builder.ventaNotaId;
        this.recepcionId = builder.recepcionId;
        this.secuencia = builder.secuencia;
        this.tipoObservacionId = builder.tipoObservacionId;
        this.usuarioRegistro = builder.usuarioRegistro;
        this.fechaRegistro = builder.fechaRegistro;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.fechaUltimaModificacion = builder.fechaUltimaModificacion;
        this.estadoId = builder.estadoId;  
    }

    public static Builder newCompraNota() {
        return new Builder();
    }

    public static Builder registro() {
        return new Builder();
    }
    
    public CompraNota() {
        this.id = null;
    }
   
    public CompraNotaId id() {
		return id;
	}

	public CompraNotaIfcProveedor ifcProveedor() {
		return ifcProveedor;
	}

	public CompraNotaNitProveedor nitProveedor() {
		return nitProveedor;
	}

	public CompraNotaRazonSocialProveedor razonSocialProveedor() {
		return razonSocialProveedor;
	}

	public CompraNotaNumeroNota numeroNota() {
		return numeroNota;
	}

	public CompraNotaCodigoAutorizacion codigoAutorizacion() {
		return codigoAutorizacion;
	}

	public CompraNotaFechaNota fechaNota() {
		return fechaNota;
	}

	public CompraNotaImporteTotalNota importeTotalNota() {
		return importeTotalNota;
	}

	public CompraNotaCreditoFiscalNota creditoFiscalNota() {
		return creditoFiscalNota;
	}

	public CompraNotaCodigoControlNota codigoControlNota() {
		return codigoControlNota;
	}

	public CompraNotaCompraId compraId() {
		return compraId;
	}

	public CompraNotaEstadoNotaId estadoNotaId() {
		return estadoNotaId;
	}

	public CompraNotaTipoDocumentoCliente tipoDocumentoCliente() {
		return tipoDocumentoCliente;
	}

	public CompraNotaNumeroDocumentoCliente numeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}

	public CompraNotaComplementoDocumentoCliente complementoDocumentoCliente() {
		return complementoDocumentoCliente;
	}

	public CompraNotaNombreCliente nombreCliente() {
		return nombreCliente;
	}

	public CompraNotaOrigenId origenId() {
		return origenId;
	}

	public CompraNotaEstadoUsoId estadoUsoId() {
		return estadoUsoId;
	}

	public CompraNotaImpuestoUsoId impuestoUsoId() {
		return impuestoUsoId;
	}

	public CompraNotaGestionUso gestionUso() {
		return gestionUso;
	}

	public CompraNotaPeriodoUso periodoUso() {
		return periodoUso;
	}

	public CompraNotaNombreFormularioUso nombreFormularioUso() {
		return nombreFormularioUso;
	}

	public CompraNotaFormularioId formularioId() {
		return formularioId;
	}

	public CompraNotaLibroId libroId() {
		return libroId;
	}

	public CompraNotaVentaNotaId ventaNotaId() {
		return ventaNotaId;
	}

	public CompraNotaRecepcionId recepcionId() {
		return recepcionId;
	}

	public CompraNotaSecuencia secuencia() {
		return secuencia;
	}

	public CompraNotaTipoObservacionId tipoObservacionId() {
		return tipoObservacionId;
	}

	public CompraNotaUsuarioRegistro usuarioRegistro() {
		return usuarioRegistro;
	}

	public CompraNotaFechaRegistro fechaRegistro() {
		return fechaRegistro;
	}

	public CompraNotaUsuarioUltimaModificacion usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public CompraNotaFechaUltimaModificacion fechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public CompraNotaEstadoId estadoId() {
		return estadoId;
	}

	// Registro Individual Compra Nota
    public static CompraNota registro(
    		CompraNotaId id,
    		CompraNotaIfcProveedor ifcProveedor,
    		CompraNotaNitProveedor nitProveedor,
    		CompraNotaRazonSocialProveedor razonSocialProveedor,
    		CompraNotaNumeroNota numeroNota,
    		CompraNotaCodigoAutorizacion codigoAutorizacion, 
    		CompraNotaFechaNota fechaNota,                   
    		CompraNotaImporteTotalNota importeTotalNota,
    		CompraNotaCodigoControlNota codigoControlNota,
    		CompraNotaCompraId compraId,
    		
    		CompraNotaTipoDocumentoCliente tipoDocumentoCliente,
    		CompraNotaNumeroDocumentoCliente numeroDocumentoCliente,
    		CompraNotaComplementoDocumentoCliente complementoDocumentoCliente,
    		CompraNotaNombreCliente nombreCliente,
    		CompraNotaOrigenId origenId,
            CompraNotaUsuarioRegistro usuarioRegistro                              
    ) {
    	CompraNotaCreditoFiscalNota creditoFiscalNota =  new CompraNotaCreditoFiscalNota(BigDecimal.ZERO);
    	CompraNotaEstadoNotaId estadoNotaId = new CompraNotaEstadoNotaId(EstadoCompraNotaId.VIGENTE.value());
        CompraNotaEstadoUsoId estadoUsoId = new CompraNotaEstadoUsoId(EstadoUsoId.REGISTRADO.value());
        CompraNotaImpuestoUsoId impuestoUsoId = new CompraNotaImpuestoUsoId(null);
        CompraNotaGestionUso gestionUso = new CompraNotaGestionUso(null);
        CompraNotaPeriodoUso periodoUso = new CompraNotaPeriodoUso(null);
        CompraNotaNombreFormularioUso nombreFormularioUso = new CompraNotaNombreFormularioUso(null);
        CompraNotaFormularioId formularioId = new CompraNotaFormularioId(null);
        CompraNotaLibroId libroId = new CompraNotaLibroId(null);
        CompraNotaVentaNotaId ventaNotaId = new CompraNotaVentaNotaId(null);
        CompraNotaRecepcionId recepcionId = new CompraNotaRecepcionId(null);
        CompraNotaSecuencia secuencia = new CompraNotaSecuencia(null);
        CompraNotaTipoObservacionId tipoObservacionId= new CompraNotaTipoObservacionId(null);
        CompraNotaFechaRegistro fechaRegistro = new CompraNotaFechaRegistro(LocalDateTime.now());
        CompraNotaUsuarioUltimaModificacion usuarioUltimaModificacion = new CompraNotaUsuarioUltimaModificacion(usuarioRegistro.value());
        CompraNotaFechaUltimaModificacion fechaUltimaModificacion = new CompraNotaFechaUltimaModificacion(LocalDateTime.now());
        CompraNotaEstadoId estadoId = new CompraNotaEstadoId(ConstEstado.ESTADO_ACTIVO);
    
        CompraNota compraNota = newCompraNota()
                .id(id)
                .ifcProveedor(ifcProveedor)
                .nitProveedor(nitProveedor)
                .razonSocialProveedor(razonSocialProveedor)
                .numeroNota(numeroNota)
                .codigoAutorizacion(codigoAutorizacion)
                .fechaNota(fechaNota)
                .importeTotalNota(importeTotalNota)
                .creditoFiscalNota(creditoFiscalNota)
                .codigoControlNota(codigoControlNota)
                .compraId(compraId)
                
                .estadoNotaId(estadoNotaId)
                .tipoDocumentoCliente(tipoDocumentoCliente)
                .numeroDocumentoCliente(numeroDocumentoCliente)
                .complementoDocumentoCliente(complementoDocumentoCliente)
                .nombreCliente(nombreCliente)
                .origenId(origenId)
                .estadoUsoId(estadoUsoId)
                .impuestoUsoId(impuestoUsoId)
                .gestionUso(gestionUso)
                .periodoUso(periodoUso)
                .nombreFormularioUso(nombreFormularioUso)
                .formularioId(formularioId)
                .libroId(libroId)
                .ventaNotaId(ventaNotaId)
                .recepcionId(recepcionId)
                .secuencia(secuencia)
                .tipoObservacionId(tipoObservacionId)
                .usuarioRegistro(usuarioRegistro)
                .fechaRegistro(fechaRegistro)
                .usuarioUltimaModificacion(usuarioUltimaModificacion)
                .fechaUltimaModificacion(fechaUltimaModificacion)
                .estadoId(estadoId).build();
        compraNota.record(CompraNotaRegistradaDomainEvent
                .CompraNotaRegistradaDomainEvent()
                .id(compraNota.id().value())
                .ifcProveedor(compraNota.ifcProveedor().value())
                .nitProveedor(compraNota.nitProveedor().value())
                .razonSocialProveedor(compraNota.razonSocialProveedor().value())
                .numeroNota(compraNota.numeroNota().value())
                .codigoAutorizacion(compraNota.codigoAutorizacion().value())
                .fechaNota(compraNota.fechaNota().value())
                .importeTotalNota(compraNota.importeTotalNota().value())
                .creditoFiscalNota(compraNota.creditoFiscalNota().value())
                .codigoControlNota(compraNota.codigoControlNota().value())
                .compraId(compraNota.compraId().value())
                
                .estadoNotaId(compraNota.estadoNotaId().value())
                .tipoDocumentoCliente(compraNota.tipoDocumentoCliente().value())
                .numeroDocumentoCliente(compraNota.numeroDocumentoCliente().value())
                .complementoDocumentoCliente(compraNota.complementoDocumentoCliente().value())
                .nombreCliente(compraNota.nombreCliente().value())
                .origenId(compraNota.origenId().value())
                .estadoUsoId(compraNota.estadoUsoId().value())
                .impuestoUsoId(compraNota.impuestoUsoId().value())
                .gestionUso(compraNota.gestionUso().value())
                .periodoUso(compraNota.periodoUso().value())
                .nombreFormularioUso(compraNota.nombreFormularioUso().value())
                .formularioId(compraNota.formularioId().value())
                .libroId(compraNota.libroId().value())
                .ventaNotaId(compraNota.ventaNotaId().value())
                .recepcionId(compraNota.recepcionId().value())
                .secuencia(compraNota.secuencia().value())
                .tipoObservacionId(compraNota.tipoObservacionId().value())
                .usuarioRegistro(compraNota.usuarioRegistro().value())
                .fechaRegistro(compraNota.fechaRegistro().value())
                .usuarioUltimaModificacion(compraNota.usuarioUltimaModificacion().value())
                .fechaUltimaModificacion(compraNota.fechaUltimaModificacion().value())
                .estadoId(compraNota.estadoId().value())
                .build());
        return compraNota;
    }

 
    public static CompraNota registro(Builder builder ) {
    	CompraNotaCreditoFiscalNota creditoFiscal = new CompraNotaCreditoFiscalNota(BigDecimal.ZERO);
        CompraNotaEstadoNotaId estadoNotaId = new CompraNotaEstadoNotaId(EstadoCompraNotaId.VIGENTE.value());
        CompraNotaEstadoUsoId estadoUsoId = new CompraNotaEstadoUsoId(EstadoUsoId.REGISTRADO.value());
        CompraNotaImpuestoUsoId impuestoUsoId = new CompraNotaImpuestoUsoId(null);
        CompraNotaGestionUso gestionUso = new CompraNotaGestionUso(null);
        CompraNotaPeriodoUso periodoUso = new CompraNotaPeriodoUso(null);
        CompraNotaNombreFormularioUso nombreFormularioUso = new CompraNotaNombreFormularioUso(null);
        CompraNotaFormularioId formularioId = new CompraNotaFormularioId(null);
        CompraNotaLibroId libroId = new CompraNotaLibroId(null);
        CompraNotaVentaNotaId ventaNotaId = new CompraNotaVentaNotaId(null);
        CompraNotaRecepcionId recepcionId = new CompraNotaRecepcionId(null);
        CompraNotaSecuencia secuencia = new CompraNotaSecuencia(null);
        CompraNotaTipoObservacionId tipoObservacionId = new CompraNotaTipoObservacionId(null);
        CompraNotaFechaRegistro fechaRegistro = new CompraNotaFechaRegistro(LocalDateTime.now());
        CompraNotaUsuarioUltimaModificacion usuarioUltimaModificacion = new CompraNotaUsuarioUltimaModificacion(builder.usuarioRegistro.value());
        CompraNotaFechaUltimaModificacion fechaUltimaModificacion = new CompraNotaFechaUltimaModificacion(LocalDateTime.now());
        CompraNotaEstadoId estadoId = new CompraNotaEstadoId(ConstEstado.ESTADO_ACTIVO);
        
       
        CompraNota compraNota = newCompraNota()
                .id(builder.id)
                .ifcProveedor(builder.ifcProveedor)
                .nitProveedor(builder.nitProveedor)
                .razonSocialProveedor(builder.razonSocialProveedor)
                .numeroNota(builder.numeroNota)
                .codigoAutorizacion(builder.codigoAutorizacion)
                .fechaNota(builder.fechaNota)
                .importeTotalNota(builder.importeTotalNota)
                .creditoFiscalNota(creditoFiscal)
                .codigoControlNota(builder.codigoControlNota)
                .compraId(builder.compraId)
                
                .estadoNotaId(estadoNotaId)
                .tipoDocumentoCliente(builder.tipoDocumentoCliente)
                .numeroDocumentoCliente(builder.numeroDocumentoCliente)
                .complementoDocumentoCliente(builder.complementoDocumentoCliente)
                .nombreCliente(builder.nombreCliente)
                .origenId(builder.origenId)
                .estadoUsoId(estadoUsoId)
                .impuestoUsoId(impuestoUsoId)
                .gestionUso(gestionUso)
                .periodoUso(periodoUso)
                .nombreFormularioUso(nombreFormularioUso)
                .formularioId(formularioId)
                .libroId(libroId)
                .ventaNotaId(ventaNotaId)
                .recepcionId(recepcionId)
                .secuencia(secuencia)
                .tipoObservacionId(tipoObservacionId)
                .usuarioRegistro(builder.usuarioRegistro)
                .fechaRegistro(fechaRegistro)
                .usuarioUltimaModificacion(usuarioUltimaModificacion)
                .fechaUltimaModificacion(fechaUltimaModificacion)
                .estadoId(estadoId).build();
        compraNota.record(CompraNotaRegistradaDomainEvent
                .CompraNotaRegistradaDomainEvent()
                .id(compraNota.id().value())
                .ifcProveedor(compraNota.ifcProveedor().value())
                .nitProveedor(compraNota.nitProveedor().value())
                .razonSocialProveedor(compraNota.razonSocialProveedor().value())
                .numeroNota(compraNota.numeroNota().value())
                .codigoAutorizacion(compraNota.codigoAutorizacion().value())
                .fechaNota(compraNota.fechaNota().value())
                .importeTotalNota(compraNota.importeTotalNota().value())
                .creditoFiscalNota(compraNota.creditoFiscalNota().value())
                .codigoControlNota(compraNota.codigoControlNota().value())
                .compraId(compraNota.compraId().value())
                
                .estadoNotaId(compraNota.estadoNotaId().value())
                .tipoDocumentoCliente(compraNota.tipoDocumentoCliente().value())
                .numeroDocumentoCliente(compraNota.numeroDocumentoCliente().value())
                .complementoDocumentoCliente(compraNota.complementoDocumentoCliente().value())
                .nombreCliente(compraNota.nombreCliente().value())
                .origenId(compraNota.origenId().value())
                .estadoUsoId(compraNota.estadoUsoId().value())
                .impuestoUsoId(compraNota.impuestoUsoId().value())
                .gestionUso(compraNota.gestionUso().value())
                .periodoUso(compraNota.periodoUso().value())
                .nombreFormularioUso(compraNota.nombreFormularioUso().value())
                .formularioId(compraNota.formularioId().value())
                .libroId(compraNota.libroId().value())
                .ventaNotaId(compraNota.ventaNotaId().value())
                .recepcionId(compraNota.recepcionId().value())
                .secuencia(compraNota.secuencia().value())
                .tipoObservacionId(compraNota.tipoObservacionId().value())
                .usuarioRegistro(compraNota.usuarioRegistro().value())
                .fechaRegistro(compraNota.fechaRegistro().value())
                .usuarioUltimaModificacion(compraNota.usuarioUltimaModificacion().value())
                .fechaUltimaModificacion(compraNota.fechaUltimaModificacion().value())
                .estadoId(compraNota.estadoId().value())
                .build());
        return compraNota;
    }

	public void modificar(
			CompraNotaNitProveedor pNitProveedor,
			CompraNotaIfcProveedor pIfcProveedorNb, 
			CompraNotaRazonSocialProveedor pRazonSocialProveedor,
			CompraNotaNumeroNota pNumeroNota, 
			CompraNotaCodigoAutorizacion pCodigoAutorizacion,
			CompraNotaFechaNota pFechaNota,
			CompraNotaImporteTotalNota pImporteTotalNota,
			CompraNotaCodigoControlNota pCodigoControlNota, 
			CompraNotaOrigenId pOrigenId,
			CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		this.nitProveedor = pNitProveedor;
		this.ifcProveedor = pIfcProveedorNb == null ? this.ifcProveedor : pIfcProveedorNb;
		this.razonSocialProveedor = pRazonSocialProveedor == null ? this.razonSocialProveedor : pRazonSocialProveedor;
		this.numeroNota = pNumeroNota;
		this.codigoAutorizacion = pCodigoAutorizacion;
		this.fechaNota= pFechaNota;
		this.importeTotalNota = pImporteTotalNota;
		this.codigoControlNota = pCodigoControlNota;
		this.origenId = pOrigenId;
		this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;

	}
	
		public void asociarALibro(CompraNotaLibroId pLibrooId,CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion 
			,CompraNotaPeriodoUso pPeriodoUso,CompraNotaGestionUso pGestionUso, CompraNotaNombreFormularioUso pNombreLibroUso) {
		if (this.estadoUsoId.value().equals(EstadoUsoId.REGISTRADO.value())) {
			this.libroId = pLibrooId;
			this.estadoUsoId = new CompraNotaEstadoUsoId(EstadoUsoId.ASOCIADO.value());
			this.periodoUso=pPeriodoUso;
			this.gestionUso=pGestionUso;
			this.nombreFormularioUso=pNombreLibroUso;
			this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
			this.fechaUltimaModificacion = new CompraNotaFechaUltimaModificacion(LocalDateTime.now());
			this.record(
					new CompraNotaAsociadaLibroDomainEvent(this.id.value(), this.libroId.value(),
							this.usuarioUltimaModificacion.value(), this.fechaUltimaModificacion.value(),
							this.importeTotalNota.value(), this.creditoFiscalNota.value()));

		
		}
	}
	
	
	public void desAsociarLibro(CompraNotaLibroId libroId,
			CompraNotaUsuarioUltimaModificacion usuarioUltimaModificacion){
		if (this.estadoUsoId.value().equals(EstadoUsoId.ASOCIADO.value())) {
			this.libroId = new CompraNotaLibroId(null);
			this.periodoUso = new CompraNotaPeriodoUso(null);
			this.gestionUso = new CompraNotaGestionUso(null);
			this.nombreFormularioUso = new CompraNotaNombreFormularioUso(null);
			this.estadoUsoId = new CompraNotaEstadoUsoId(EstadoUsoId.REGISTRADO.value());
			this.impuestoUsoId = new CompraNotaImpuestoUsoId(null);
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			this.fechaUltimaModificacion = new CompraNotaFechaUltimaModificacion(LocalDateTime.now());
			this.record(
					new CompraNotaDesAsociadaLibroDomainEvent(this.id.value(), libroId.value(),
							this.usuarioUltimaModificacion.value(), this.fechaUltimaModificacion.value(),
							this.importeTotalNota.value(),this.creditoFiscalNota.value()));
		}
	}
	
	public void eliminar(CompraNotaUsuarioUltimaModificacion usuarioUltimaModificacion) {
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.estadoId = new CompraNotaEstadoId(ConstEstado.ESTADO_ANULADO);
	}
	
	public void desdeclararNotaPorRectificacionLibro(CompraNotaLibroId pLibroId) {
		//if (this.estadoUsoId.value().equals(EstadoUsoId.DECLARADO.value())) {
			this.estadoUsoId = new CompraNotaEstadoUsoId(EstadoUsoId.ASOCIADO.value());
			this.libroId = new CompraNotaLibroId(pLibroId.value());
		//}
	}
	public void declararCompraNota(CompraNotaUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
		if (this.estadoUsoId.value().equals(EstadoUsoId.ASOCIADO.value())) {
			this.record(new CompraDeclaradaDomainEvent(this.id().value(),
					this.estadoUsoId().value(),
					this.usuarioUltimaModificacion().value(),
					this.fechaUltimaModificacion().value(),
					this.formularioId.value()));
			this.usuarioUltimaModificacion = pUsuarioUltimaModificacion;
			this.fechaUltimaModificacion = new CompraNotaFechaUltimaModificacion(LocalDateTime.now());
			this.estadoUsoId = new CompraNotaEstadoUsoId(EstadoUsoId.DECLARADO.value());
		}
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraNota compraNota = (CompraNota) o;
        return Objects.equals(id.value(), compraNota.id.value()) &&
                Objects.equals(ifcProveedor.value(), compraNota.ifcProveedor.value()) &&
                Objects.equals(nitProveedor.value(), compraNota.nitProveedor.value()) &&
                Objects.equals(razonSocialProveedor.value(), compraNota.razonSocialProveedor.value()) &&
                Objects.equals(numeroNota.value(), compraNota.numeroNota.value()) &&
                Objects.equals(codigoAutorizacion.value(), compraNota.codigoAutorizacion.value()) &&
                Objects.equals(fechaNota.value(), compraNota.fechaNota.value()) &&
                Objects.equals(importeTotalNota.value(), compraNota.importeTotalNota.value()) &&
                Objects.equals(creditoFiscalNota.value(), compraNota.creditoFiscalNota.value()) &&
                Objects.equals(codigoControlNota.value(), compraNota.codigoControlNota.value()) &&
                Objects.equals(compraId.value(), compraNota.compraId.value()) &&
                
                Objects.equals(estadoNotaId.value(), compraNota.estadoNotaId.value()) &&
                Objects.equals(tipoDocumentoCliente.value(), compraNota.tipoDocumentoCliente.value()) &&
                Objects.equals(numeroDocumentoCliente.value(), compraNota.numeroDocumentoCliente.value()) &&
                Objects.equals(complementoDocumentoCliente.value(), compraNota.complementoDocumentoCliente.value()) &&
                Objects.equals(nombreCliente.value(), compraNota.nombreCliente.value()) &&
                Objects.equals(origenId.value(), compraNota.origenId.value()) &&
                Objects.equals(estadoUsoId.value(), compraNota.estadoUsoId.value()) &&
                Objects.equals(impuestoUsoId.value(), compraNota.impuestoUsoId.value()) &&
                Objects.equals(gestionUso.value(), compraNota.gestionUso.value()) &&
                Objects.equals(periodoUso.value(), compraNota.periodoUso.value()) &&
                Objects.equals(nombreFormularioUso.value(), compraNota.nombreFormularioUso.value()) &&
                Objects.equals(formularioId.value(), compraNota.formularioId.value()) &&
                Objects.equals(libroId.value(), compraNota.libroId.value()) &&
                Objects.equals(ventaNotaId.value(), compraNota.ventaNotaId.value()) &&
                Objects.equals(recepcionId.value(), compraNota.recepcionId.value()) &&
                Objects.equals(secuencia.value(), compraNota.secuencia.value()) &&
                Objects.equals(tipoObservacionId.value(), compraNota.tipoObservacionId.value()) &&
                Objects.equals(usuarioRegistro.value(), compraNota.usuarioRegistro.value()) &&
                // Objects.equals(fechaRegistro.value(), compra.fechaRegistro.value())&&
                Objects.equals(usuarioUltimaModificacion.value(), compraNota.usuarioUltimaModificacion.value()) &&
                Objects.equals(fechaUltimaModificacion.value(), compraNota.fechaUltimaModificacion.value()) &&
                Objects.equals(estadoId.value(), compraNota.estadoId.value());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, 
        		ifcProveedor, 
        		nitProveedor, 
        		razonSocialProveedor, 
        		numeroNota,  
        		codigoAutorizacion,
        		fechaNota,
        		importeTotalNota,
        		creditoFiscalNota, 
        		codigoControlNota,
        		compraId,
        		estadoNotaId,
        		tipoDocumentoCliente, 
        		numeroDocumentoCliente, 
        		complementoDocumentoCliente, 
        		nombreCliente, 
        		origenId, 
        		estadoUsoId, 
        		impuestoUsoId, 
        		gestionUso,
        		periodoUso, 
        		nombreFormularioUso, 
        		formularioId, 
        		libroId,
        		ventaNotaId, 
        		recepcionId, 
        		secuencia,
        		tipoObservacionId,
        		usuarioRegistro,
        		fechaRegistro, 
        		usuarioUltimaModificacion, 
        		fechaUltimaModificacion, 
        		estadoId);
    }

    public static final class Builder {
        private CompraNotaId id;
        private CompraNotaIfcProveedor ifcProveedor;
        private CompraNotaNitProveedor nitProveedor;
        private CompraNotaRazonSocialProveedor razonSocialProveedor;
        private CompraNotaNumeroNota numeroNota;
        private CompraNotaCodigoAutorizacion codigoAutorizacion;
        private CompraNotaFechaNota fechaNota;
        private CompraNotaImporteTotalNota importeTotalNota;
        private CompraNotaCreditoFiscalNota creditoFiscalNota;
        private CompraNotaCodigoControlNota codigoControlNota;
        private CompraNotaCompraId compraId;
        private CompraNotaEstadoNotaId estadoNotaId;
        private CompraNotaTipoDocumentoCliente tipoDocumentoCliente;
        private CompraNotaNumeroDocumentoCliente numeroDocumentoCliente;
        private CompraNotaComplementoDocumentoCliente complementoDocumentoCliente;
        private CompraNotaNombreCliente nombreCliente;
        private CompraNotaOrigenId origenId;
        private CompraNotaEstadoUsoId estadoUsoId;
        private CompraNotaImpuestoUsoId impuestoUsoId;
        private CompraNotaGestionUso gestionUso;
        private CompraNotaPeriodoUso periodoUso;
        private CompraNotaNombreFormularioUso nombreFormularioUso;
        private CompraNotaFormularioId formularioId;
        private CompraNotaLibroId libroId;
        private CompraNotaVentaNotaId ventaNotaId;
        private CompraNotaRecepcionId recepcionId;
        private CompraNotaSecuencia secuencia;
        private CompraNotaTipoObservacionId tipoObservacionId;
        private CompraNotaUsuarioRegistro usuarioRegistro;
        private CompraNotaFechaRegistro fechaRegistro;
        private CompraNotaUsuarioUltimaModificacion usuarioUltimaModificacion;
        private CompraNotaFechaUltimaModificacion fechaUltimaModificacion;
        private CompraNotaEstadoId estadoId;


        private Builder() {
        }

        public CompraNota build() {
            return new CompraNota(this);
        }

        
		public Builder id(CompraNotaId id) {
			this.id = id;
			return this;
		}

		public Builder ifcProveedor(CompraNotaIfcProveedor ifcProveedor) {
			this.ifcProveedor = ifcProveedor;
			return this;
		}

		public Builder nitProveedor(CompraNotaNitProveedor nitProveedor) {
			this.nitProveedor = nitProveedor;
			return this;
		}

		public Builder razonSocialProveedor(CompraNotaRazonSocialProveedor razonSocialProveedor) {
			this.razonSocialProveedor = razonSocialProveedor;
			return this;
		}

		public Builder numeroNota(CompraNotaNumeroNota numeroNota) {
			this.numeroNota = numeroNota;
			return this;
		}

		public Builder codigoAutorizacion(CompraNotaCodigoAutorizacion codigoAutorizacion) {
			this.codigoAutorizacion = codigoAutorizacion;
			return this;
		}

		public Builder fechaNota(CompraNotaFechaNota fechaNota) {
			this.fechaNota = fechaNota;
			return this;
		}

		public Builder importeTotalNota(CompraNotaImporteTotalNota importeTotalNota) {
			this.importeTotalNota = importeTotalNota;
			return this;
		}

		public Builder creditoFiscalNota(CompraNotaCreditoFiscalNota creditoFiscalNota) {
			this.creditoFiscalNota = creditoFiscalNota;
			return this;
		}

		public Builder codigoControlNota(CompraNotaCodigoControlNota codigoControlNota) {
			this.codigoControlNota = codigoControlNota;
			return this;
		}

		
		public Builder compraId(CompraNotaCompraId compraId) {
			this.compraId = compraId;
			return this;
		}

		public Builder estadoNotaId(CompraNotaEstadoNotaId estadoNotaId) {
			this.estadoNotaId = estadoNotaId;
			return this;
		}

		public Builder tipoDocumentoCliente(CompraNotaTipoDocumentoCliente tipoDocumentoCliente) {
			this.tipoDocumentoCliente = tipoDocumentoCliente;
			return this;
		}

		public Builder numeroDocumentoCliente(CompraNotaNumeroDocumentoCliente numeroDocumentoCliente) {
			this.numeroDocumentoCliente = numeroDocumentoCliente;
			return this;
		}

		public Builder complementoDocumentoCliente(CompraNotaComplementoDocumentoCliente complementoDocumentoCliente) {
			this.complementoDocumentoCliente = complementoDocumentoCliente;
			return this;
		}

		public Builder nombreCliente(CompraNotaNombreCliente nombreCliente) {
			this.nombreCliente = nombreCliente;
			return this;
		}

		public Builder origenId(CompraNotaOrigenId origenId) {
			this.origenId = origenId;
			return this;
		}

		public Builder estadoUsoId(CompraNotaEstadoUsoId estadoUsoId) {
			this.estadoUsoId = estadoUsoId;
			return this;
		}

		public Builder impuestoUsoId(CompraNotaImpuestoUsoId impuestoUsoId) {
			this.impuestoUsoId = impuestoUsoId;
			return this;
		}

		public Builder gestionUso(CompraNotaGestionUso gestionUso) {
			this.gestionUso = gestionUso;
			return this;
		}

		public Builder periodoUso(CompraNotaPeriodoUso periodoUso) {
			this.periodoUso = periodoUso;
			return this;
		}

		public Builder nombreFormularioUso(CompraNotaNombreFormularioUso nombreFormularioUso) {
			this.nombreFormularioUso = nombreFormularioUso;
			return this;
		}

		public Builder formularioId(CompraNotaFormularioId formularioId) {
			this.formularioId = formularioId;
			return this;
		}

		public Builder libroId(CompraNotaLibroId libroId) {
			this.libroId = libroId;
			return this;
		}

		public Builder ventaNotaId(CompraNotaVentaNotaId ventaNotaId) {
			this.ventaNotaId = ventaNotaId;
			return this;
		}

		public Builder recepcionId(CompraNotaRecepcionId recepcionId) {
			this.recepcionId = recepcionId;
			return this;
		}

		public Builder secuencia(CompraNotaSecuencia secuencia) {
			this.secuencia = secuencia;
			return this;
		}

		public Builder tipoObservacionId(CompraNotaTipoObservacionId tipoObservacionId) {
			this.tipoObservacionId = tipoObservacionId;
			return this;
		}

		public Builder usuarioRegistro(CompraNotaUsuarioRegistro usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			return this;
		}

		public Builder fechaRegistro(CompraNotaFechaRegistro fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
			return this;
		}

		public Builder usuarioUltimaModificacion(CompraNotaUsuarioUltimaModificacion usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

		public Builder fechaUltimaModificacion(CompraNotaFechaUltimaModificacion fechaUltimaModificacion) {
			this.fechaUltimaModificacion = fechaUltimaModificacion;
			return this;
		}

		public Builder estadoId(CompraNotaEstadoId estadoId) {
			this.estadoId = estadoId;
			return this;
		}
    }
}
