package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion;

public enum EnumCodigoError {

    C_AMBIENTE_INVALIDO                                                            (1),
    C_CODIGO_DE_SISTEMA_INVALIDO                                                  ( 2),
    C_CUIS_INVALIDO                                                               ( 3),
    C_CUFD_INVALIDO                                                               ( 4),
    C_DOCUMENTO_FISCAL_INVALIDO                                                   ( 5),
    C_TIPO_EMISION_INVALIDO                                                       ( 6),
    C_MODALIDAD_INVALIDA                                                          ( 7),
    C_SUCURSAL_INVALIDA                                                           ( 8),
    C_NIT_INVALIDO                                                                ( 9),
    C_ARCHIVO_INVALIDO                                                            ( 10),
    C_FIRMA_INCORRRECTA                                                           ( 11),
    C_FIRMA_NO_CORRESPONDE_AL_CONTRIBUYENTE                                       ( 12),
    C_CODIGO_DE_RECEPCION_INVALIDO                                                ( 13),
    C_NUMERO_DOCUMENTO_DUPLICADO                                                  ( 14),
    C_NUMERO_DOCUMENTO_INEXISTENTE                                                ( 15),
    C_NOMBRE_DE_CAJERO_CON_CARACTERES_INVALIDOS                                   ( 16),
    C_FECHA_EMISION_MAYOR_A_DEFINIDO_EN_NORMATIVA                                 ( 17),
    C_FECHA_EMISION_MENOR_A_DEFINIDO_EN_NORMATIVA                                 ( 18),
    C_FECHA_EMISION_INVALIDA                                                      ( 18),
    C_TIPO_DOCUMENTO_IDENTIDAD_INVALIDO                                           ( 19),
    C_CODIGO_UNICO_DE_FACTURA_CUF_INVALIDO                                        ( 20),
    C_XML_INVALIDO                                                                ( 21),
    C_EL_PERIODO_FACTURADO_ES_REQUERIDO_PARA_ESTE_TIPO_DE_FACTURA                 ( 22),
    C_EL_CAMPO_ESTUDIANTE_ES_REQUERIDO_PARA_ESTE_TIPO_DE_FACTURA                  ( 23),
    C_EL_TIPO_CAMBIO_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                         ( 24),
    C_INCOTERM_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                               ( 25),
    C_PUERTO_DESTINO_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                         ( 26),
    C_TIPO_MONEDA_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                            ( 27),
    C_TIPO_DE__MONEDA_INVALIDO                                                    ( 28),
    C_ERROR_CODIGO_MONEDA                                                         ( 28),
    C_PRECIO_VALOR_BRUTO_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                     ( 29),
    C_GASTOS_TRANSPORTE_FRONTERA_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA             ( 30),
    C_GASTOS_SEGURO_FRONTERA_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                 ( 31),
    C_TOTAL_FOB_FRONTERA_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                     ( 32),
    C_MONTO_TRANSPORTE_INTERNACIONAL_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA         ( 33),
    C_MONTO_SEGURO_INTERNACIONAL_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA             ( 34),
    C_OTROS_MONTOS_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                           ( 35),
    C_TOTAL_MONEDA_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                           ( 36),
    C_TOTAL_PUERTO_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                           ( 37),
    C_OPERADOR_TURISMO_RECEPTIVO_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA             ( 38),
    C_REMITENTE_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                              ( 39),
    C_CONSIGNATARIO_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                          ( 40),
    C_PLACA_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                                  ( 41),
    C_CODIGO_PAIS_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                            ( 42),
    C_CODIGO_DE_PAIS_INVALIDO                                                     ( 43),
    C_MONTO_LEY_317_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                          ( 44),
    C_MONTO_TOTAL_SUJETO_A_IVA_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA               ( 45),
    C_MONTO_TOTAL_SUJETO_A_IPJ_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA               ( 46),
    C_MONTO_TOTAL_IJ_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                         ( 47),
    C_MONTO_POR_DIFERENCIA_DE_TIPO_DE_CAMBIO_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA ( 48),
    C_MONTO_ICE_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                              ( 49),
    C_MONTO_IDH_ES_REQUERIDO_EN_ESTE_TIPO_DE_FACTURA                              ( 50),
    C_CODIGO_DE_PRODUCTO_INVALIDO                                                 ( 51),
    C_PRODUCTO_NO_COINCIDE_CON_LA_ACTIVIDAD                                       ( 52),
    C_ACTIVIDAD_INVALIDA                                                          ( 53),
    C_MONTO_TOTAL_NO_COINCIDE_CON_LA_SUMATORIA_DE_LOS_SUBTOTALES_Y_DESCUENTOS     ( 54),
    C_CALCULO_DEL_SUBTOTAL_INCORRECTO                                             ( 55),
    C_MONTO_LEY_317_INCORRECTO                                                    ( 56),
    C_MONTO_TOTAL_SUJETO_A_IVA_INCORRECTO                                         ( 57),
    C_MONTO_TOTAL_SUJETO_IPJ_INCORRECTO                                           ( 58),
    C_MONTO_TOTAL_IJ_INCORRECTO                                                   ( 59),
    C_MONTO_ICE_INCORRECTO                                                        ( 60),
    C_MONTO_IDH_INCORRECTO                                                        ( 61),
    C_MOTIVO_DE_ANULACION_INVALIDO                                                ( 62),
    C_ERROR_DE_EJECUCION_DEL_SERVICIO                                             ( 63),
    C_SERVICIO_DE_VERIFICACION_DE_RECEPCION_INCORRECTO                            ( 64),
    C_ERROR_DE_DATOS                                                              ( 65),
    C_COMUNICACION_EXITOSA                                                        ( 66),
    C_ERROR_RECUPERACION_DATOS_BASICOS_POR_NIT                                    ( 67),
    C_ERROR_VALIDACION_DATOS_EMISOR                                               ( 68),
    C_ERROR_REGISTRO_RECEPCION_NOTA_FISCAL                                        ( 69),
    C_ERROR_REGISTRO_RECEPCION_NOTA_FISCAL_PAQUETE                                ( 70),
    C_ERROR_REGISTRO_RECEPCION_DOCUMENTO_FISCAL                                   ( 71),
    C_FIRMA_FECHA_INVALIDA                                                        ( 72),
    C_FIRMA_REVOCADA                                                              ( 73),
    C_FIRMA_CERTIFICADO_INVALIDO                                                  ( 74),
    C_NIT_NO_ASOCIADO_MODALIDAD                                                   ( 75),
    C_NIT_TIENE_MARCAS_CONTROL                                                    ( 76),
    C_NIT_INACTIVO                                                                ( 77),
    C_CUIS_NO_VIGENTE                                                             ( 78),
    C_CUIS_NO_CORRESPONDE_SUCURSAL_PUNTO_VENTA                                    ( 79),
    C_CODIGO_DOCUMENTO_SECTOR_INVALIDO                                            ( 80),
    C_CODIGO_SECTOR_NO_CORRESPONDE_AL_SERVICIO                                    ( 81),
    C_PUNTO_VENTA_INVALIDO                                                        ( 82),
    C_ANULACION_FUERA_PLAZO                                                       ( 83),
    C_ARCHIVO_NO_CORRESPONDE_HUELLA                                               ( 84),
    C_FECHA_ENVIO_INVALIDO                                                        ( 85),
    C_FACTURA_INEXISTENTE                                                         ( 86),
    C_FACTURA_ANULADA                                                             ( 87),
    C_SOAP_PARAMETROS_FORMATO_XSD_INCORRECTO                                      ( 88),
    C_FACTURA_FORMATO_XSD_INCORRECTO                                              ( 89),
    C_ERROR_EJECUCION_SERVICIO_VALIDACION_DETALLE_DOCUMENTO_FISCAL                ( 91),
    C_ERROR_METODO_PAGO                                                           ( 96),
    C_FACTURA_NO_CONSIGNADA                                                       ( 94),
    C_NUMERO_DOCUMENTO_INVALIDO                                                   ( 98),
    C_NIT_EMISOR_INVALIDO                                                         ( 99),
    C_ERROR_NUMERO_TARJETA                                                        ( 100),
    C_ERROR_MONTO_TOTAL_MONEDA                                                    ( 101),
    C_ERROR_CODIGO_PRODUCTO                                                       ( 102),
    C_CI_INVALIDO                                                                 ( 124),
    C_CUFD_FUERA_TOLERANCIA                                                       ( 123),
    C_ERROR_UNIDAD_MEDIDA                                                         ( 125),
    C_RECEPCION_PENDIENTE                                                         ( 901),
    C_RECEPCION_RECHAZADA                                                         ( 902),
    C_RECEPCION_PROCESADA                                                         ( 903),
    C_RECEPCION_OBSERVADA                                                         ( 904),
    C_ANULACION_CONFIRMADA                                                        ( 905),
    C_ANULACION_RECHAZADA                                                         ( 906),
    C_ANULACION_PENDIENTE_CONFIRMACION                                            ( 907),
    C_RECEPCION_VALIDADA                                                          ( 908),
    C_ANULACION_EXISTENTE                                                         ( 909),
    C_ANULACION_PROCESADO_POR_PIN                                                 ( 910),
    C_HASH_INVALIDO                                                               ( 911),
    C_GESTION_INCORRECTA                                                          ( 912),
    C_FECHA_INGRESO_HOSPEDAJE_INCORRECTO                                          ( 913),
    C_DOCUMENTO_MEDICO_INCORRECTO                                                 ( 914),
    C_NIT_SALON_INCORRECTO                                                        ( 915),
    C_FECHA_EVENTO_INCORRECTO                                                     ( 916),
    C_MONTO_TOTAL_PUERTO_INCORRECTO                                               ( 917),
    C_MONTO_TOTAL_FOB_FRONTERA_INCORRECTO                                         ( 918),
    C_CODIGO_NANDINA_INCORRECTO                                                   ( 919),
    C_MONTO_TOTAL_DEVUELTO_INCORRECTO                                             ( 920),
    C_MONTO_EFECTIVO_CREDITO_DEBITO_INCORRECTO                                    ( 921),
    C_MONTO_ORIGINAL_INCORRECTO                                                   ( 922),
    C_MONTO_IEHD_INCORRECTO                                                       ( 923),
    C_INGRESO_DIFERENCIA_CAMBIO_INCORRECTO                                        ( 924),
    //TODO: Los siguientes codigos se debe crear en base de datos
    C_CODIGO_CAED_INVALIDO                                                        ( 1005),
    C_CODIGO_CAED_CAEP_NO_VINCULADO                                               ( 1013),
    C_COMPLEMENTO_NO_NULO                                                         ( 2000),
    C_DATOS_NO_COINCIDEN_CON_LA_ANULACION                                         ( 2001),
    C_MARCA_ICE_0_CON_ALICUOTAS                                                   ( 2030),
    C_MARCA_ICE_SIN_ALICUOTAS                                                     ( 2031),
    C_MARCA_ALICUOTA_ESPECIFICA_SIN_LITROS                                        ( 2032),
    C_CODIGO_PAIS_ORIGEN_INCORRECTO                                               ( 2033),
    C_CODIGO_PAIS_DESTINO_INCORRECTO                                              ( 2034);

    private int codigo;

    EnumCodigoError(int codigo){
        this.codigo =codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}
