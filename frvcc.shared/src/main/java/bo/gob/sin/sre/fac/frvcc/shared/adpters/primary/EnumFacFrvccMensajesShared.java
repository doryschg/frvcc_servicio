package bo.gob.sin.sre.fac.frvcc.shared.adpters.primary;

import bo.gob.sin.str.parametricas.enumeradores.IMensajeAplicacion;

public enum EnumFacFrvccMensajesShared implements IMensajeAplicacion {

	REGISTRO_CORRECTO_FACTURAS_COMPRAS(2129),
	ERROR_REGISTRO_FACTURAS_COMPRAS(4259),
	RECUPERACION_BUSQUEDA_EXITOSO(4000),
	NIT_FORMATO_NOVALIDO(3076),
	NIT_NO_EXISTE(4005),
	UUID_FORMATO_NO_VALIDO(3090),
	CAMPO_REQUERIDO(3082),
	NOMBRE_EMPLEADOR_NOT_NULL(4287),
	CADENA_NO_VALIDA(4002),
	CAMPO_VACIO(3082),
	CODIGO_AUTORIZACION_NO_VALIDO(4280),
	NUMERO_FACTURA_NO_VALIDO(3094),
	COMPRA_YA_EXISTE(3080),
	ERROR_REGISTRO_FORMULARIO(4263),
	ORIGEN_COMPRA_INVALIDO(3117),
	COMPRA_NO_EXISTE(3081),
	FORMULARIO_NO_EXISTE(3118),
	ERROR_ASOCIACION_COMPRAS(4265),
	ERROR_DESASOCIACION_COMPRAS(4266),
	ERROR_EDICION(4269),
	ERROR_MODIFICACION_FECHA_PRESENTACION(4268),
	ERROR_CANCELAR_DECLARACION(4270),
	ERROR_RECTIFICACION_FORMULARIO(4271),
	ERROR_REZACHO_FORMULARIO(4274),
	ERROR_CONSOLIDAR_FORMULARIO(4273),
	ERROR_ELIMINACION(4262),
	ERROR_DECLARAR_FORMULARIO(4276),
	ERROR_HABILITAR_RECTIFICACION_FORMULARIO(4275),
	ERROR_NUMERO_AUTORIZACION_INEXISTENTE(3101),
	ERROR_REGISTRO_LIBRO(4278),
	COMPRA_NOTA_NO_EXISTE(3119),
	LIBRO_EXISTE_PERIODO(4279),
	FORMULARIO_EXISTE_PERIODO(3114),
	FORMULARIO_FECHA_PRESENTACION(4286),
	IMPORTE_NO_VALIDO(3099),
	ERROR_HABILITAR_RECTIFICACION_LIBRO(4275),
	ERROR_ASOCIACION_MAYOR_ORIGINAL_IPN(4289),
	ERROR_ASOCIACION_MAYOR_ORIGINAL_7RG(4288),
	ERROR_ASOCIACION_MAYOR_ORIGINAL_OTROS(4290),
	ASOCIACION_COMPRAS_CORRECTO(2132),
	REGISTRO_CORRECTO_FORMULARIO(2131),
	DESASOCIACION_COMPRAS_CORRECTO(2133),
	ELIMINACION_CORRECTO(2130),
	EDITADO_CORRECTO(2136),
	RESULTADO_BUSQUEDA_VACIA(3113),
	FORMULARIO_DECLARACION_CANCELADO_CORRECTO(2137),
	FORMULARIO_CONSOLIDADO_CORRECTO(2139),
	CAMBIO_FECHA_PRESENTACION_CORRECTO(2135),
	FORMULARIO_RECHAZADO_CORRECTO(2140),
	FORMULARIO_RECTIFICADO_CORRECTO(2138),
	FORMULARIO_DECLARADO_CORRECTO(2141),
	FORMULARIO_HABILITACION_RECTIFICACION_CORRECTO(2142),
	REPORTE_GENERADO_CORRECTO(2143),
	ERROR_GENERAR_REPORTE(4277),
	REGISTRO_LIBRO_CORRECTO(2144),
	LIBRO_HABILITACION_RECTIFICACION_CORRECTO(2142),
	CUF_INVALIDO(3083),
	ERROR_REGISTRO_CONSOLIDACION(4291),
	REGISTRO_CORRECTO_CONSOLIDACION(2145),
	REGISTRO_CORRECTO_SUCURSAL_USUARIO(2146),
	ERROR_REGISTRO_SUCURSAL_USUARIO(4292),
	ERROR_CONSOLIDACION_EXISTENTE(4293),
	ERROR_CONCILICION_EXISTENTE(4300),
	ERROR_CONSOLIDACION_REALIZADA(3120),
	EXITO_INHABILITACION_SUCURSAL_USUARIO(2147),
	ERROR_FORMULARIOS_PENDIENTES_REVISION(3121),
	ERROR_DIRECCION_EMPLEADOR(4294);


	private final int id;

	EnumFacFrvccMensajesShared(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
