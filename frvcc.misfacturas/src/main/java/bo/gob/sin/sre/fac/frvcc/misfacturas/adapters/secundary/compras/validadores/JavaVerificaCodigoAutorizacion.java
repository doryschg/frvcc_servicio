package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.EnumModalidadId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras.client.IValidarCufRestclient;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificadorNumeroAutoriacion;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.caut.security.jwt.model.JwtUserDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;

import static bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ParametrosPattern.COD_AUTORIZACION_PATTERN;
import static bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ParametrosPattern.CODIGO_AUTORIZACION_ESPECIAL_PATTERN;

@Service
@Transactional("contribuyentes-transaction_manager")
public class JavaVerificaCodigoAutorizacion implements VerificaCodigoAutorizacionRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    private IValidarCufRestclient restClientCuf;

    public JavaVerificaCodigoAutorizacion(@Qualifier("contribuyentes-session-factory")
                                                  SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public VerificadorNumeroAutoriacion verificaCodigoAutorizacion(Long pNitProveedor,
                                                                   Long pNumeroFactura,
                                                                   String pCodigoAutorizacion,
                                                                   String pNitCi,
                                                                   LocalDate pFechaFactura,
                                                                   String pCodigoControl,
                                                                   BigDecimal pImporteBaseCf) throws DomainError {
        if (pCodigoAutorizacion.matches(COD_AUTORIZACION_PATTERN) || pCodigoAutorizacion.matches(CODIGO_AUTORIZACION_ESPECIAL_PATTERN)) {
            return verficacionCodigoAutorizacion(pNitProveedor, pNumeroFactura, pCodigoAutorizacion, pNitCi, pFechaFactura, pCodigoControl, pImporteBaseCf); 
        }
        return verificadorCuf(pCodigoAutorizacion);
    }

    private VerificadorNumeroAutoriacion verificadorCuf(String pCodigoAutorizacion) {

        CufFactory cufFactory = new CufFactory();

        if(cufFactory.decode(pCodigoAutorizacion)){
            if(!(cufFactory.getTipoEmision() == 2 )){
                return new VerificadorNumeroAutoriacion(Arrays.asList(EnumFacFrvccMensajesShared.CUF_INVALIDO.getId()), Boolean.FALSE);
            }
            else{
                if(!restClientCuf.verificaCuf(pCodigoAutorizacion))
                    return new VerificadorNumeroAutoriacion(Arrays.asList(EnumFacFrvccMensajesShared.CUF_INVALIDO.getId()), Boolean.FALSE);
            }
        }

        if (cufFactory.decode(pCodigoAutorizacion)) {
            SectorCreditoFiscal sectorCreditoFiscal = sectorCreditoFiscalList.get(cufFactory.getTipoDocSector());

            return new VerificadorNumeroAutoriacion(
                    EnumModalidadId.FACTURA_COMPUTARIZADA_LINEA.value(),
                    sectorCreditoFiscal.creditoFiscal,
                    sectorCreditoFiscal.marcaEspecial,
                    Boolean.TRUE,
                    sectorCreditoFiscal.conDerecho(),
                    cufFactory.getTipoDocSector());
        }
        return new VerificadorNumeroAutoriacion(Arrays.asList(EnumFacFrvccMensajesShared.CUF_INVALIDO.getId()), Boolean.FALSE);
    }


    private VerificadorNumeroAutoriacion verficacionCodigoAutorizacion(Long pNitProveedor,
                                                                       Long pNumeroFactura,
                                                                       String pCodigoAutorizacion,
                                                                       String pNitCi,
                                                                       LocalDate pFechaFactura,
                                                                       String pCodigoControl,
                                                                       BigDecimal pImporteBaseCf) {
        Date sqlDate = Date.valueOf(pFechaFactura);
        StoredProcedureQuery vProcedimiento = sessionFactory.getCurrentSession().getSession().createStoredProcedureQuery("PSFE_UTILES.P_Es_Factura_Valida");
        vProcedimiento.registerStoredProcedureParameter("p_nitProveedor", Long.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter("p_Nro_Factura", Long.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter("p_Nro_Autorizacion", Long.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter("p_NitCi", Long.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter("p_FechaFactura", Date.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter("p_Cod_Control", String.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter("p_Importe", BigDecimal.class, ParameterMode.IN);
        vProcedimiento.registerStoredProcedureParameter("o_Valido", Integer.class, ParameterMode.OUT);
        vProcedimiento.registerStoredProcedureParameter("o_Modalidad", String.class, ParameterMode.OUT);
        vProcedimiento.registerStoredProcedureParameter("o_CreditoFiscal", BigDecimal.class, ParameterMode.OUT);
        vProcedimiento.registerStoredProcedureParameter("o_MarcaEspecial", String.class, ParameterMode.OUT);
        vProcedimiento.registerStoredProcedureParameter("o_ConDerecho", String.class, ParameterMode.OUT);
        vProcedimiento.registerStoredProcedureParameter("o_NoReIva", Integer.class, ParameterMode.OUT);
        vProcedimiento.registerStoredProcedureParameter("o_Cursor_Errores", ResultSet.class, ParameterMode.REF_CURSOR);
        vProcedimiento.setParameter("p_nitProveedor", pNitProveedor)
                .setParameter("p_Nro_Factura", pNumeroFactura)
                .setParameter("p_Nro_Autorizacion", Long.valueOf(pCodigoAutorizacion))
                .setParameter("p_NitCi", Long.valueOf(pNitCi))
                .setParameter("p_FechaFactura", sqlDate)
                .setParameter("p_Cod_Control", pCodigoControl != null ? pCodigoControl : "")
                .setParameter("p_Importe", pImporteBaseCf);
        vProcedimiento.execute();
        Integer valido = (Integer) vProcedimiento.getOutputParameterValue("o_Valido");
        if (valido.equals(0)) {
            List<Integer> listaErrores = new ArrayList<>();
            Object[] errores = vProcedimiento.getResultList().toArray();
            for (int i = 0; i < errores.length; i++) {
                listaErrores.add(Integer.valueOf(errores[0].toString()));
            }
            return new VerificadorNumeroAutoriacion(listaErrores, Boolean.FALSE);
        }
        String vModalidad = (String) vProcedimiento.getOutputParameterValue("o_Modalidad");
        BigDecimal vCreditoFiscal = (BigDecimal) vProcedimiento.getOutputParameterValue("o_CreditoFiscal");
        String vMarcaEspecial = (String) vProcedimiento.getOutputParameterValue("o_MarcaEspecial");
        String vConDerechoCf = (String) vProcedimiento.getOutputParameterValue("o_ConDerecho");
        Integer vTipoSector = vProcedimiento.getOutputParameterValue("o_NoReIva") == null ? null : (Integer)vProcedimiento.getOutputParameterValue("o_NoReIva");
        return new VerificadorNumeroAutoriacion(vModalidad, vCreditoFiscal, vMarcaEspecial, Boolean.TRUE, vConDerechoCf,vTipoSector);
    }

    HashMap<Integer, SectorCreditoFiscal> sectorCreditoFiscalList = new HashMap<>() {{
        put(1, new SectorCreditoFiscal("Facturade Compray Venta", "SI", new BigDecimal("13"), "SM"));
        put(2, new SectorCreditoFiscal("Recibo de Alquilerde Bienes Inmuebles", "SI", new BigDecimal("13"), "SM"));
        put(3, new SectorCreditoFiscal("Factura Comercialde Exportación", "NO", new BigDecimal("0"), "SM"));
        put(4, new SectorCreditoFiscal("Facturade Comercial de Exportación en Libre Consignación", "NO", new BigDecimal("0"), "SM"));
        put(5, new SectorCreditoFiscal("Factura de Ventaen ZonaFranca", "NO", new BigDecimal("0"), "SM"));
        put(6, new SectorCreditoFiscal("Facturade ServicioTurístico y Hospedaje", "NO", new BigDecimal("0"), "SM"));
        put(7, new SectorCreditoFiscal("Factura de Seguridad Alimentaria y Abastecimiento", "NO", new BigDecimal("0"), "SM"));
        put(8, new SectorCreditoFiscal("Factura TasaCero Venta de Libros y Transporte Internacional de Carga por Carretera", "NO", new BigDecimal("0"), "SM"));
        put(9, new SectorCreditoFiscal("Facturas de Compra y Venta de Moneda Extranjera", "NO", new BigDecimal("0"), "SM"));
        put(10, new SectorCreditoFiscal("Factura Dutty Free", "NO", new BigDecimal("0"), "SM"));
        put(11, new SectorCreditoFiscal("Factura Sectores Educativos", "SI", new BigDecimal("13"), "SM"));
        put(12, new SectorCreditoFiscal("Factura de Comercializaciónde Hidrocarburos", "SI", new BigDecimal("13"), "SM"));
        put(13, new SectorCreditoFiscal("Factura de Servicios Básicos", "SI", new BigDecimal("13"), "SM"));
        put(14, new SectorCreditoFiscal("Factura Productos Alcanzados por el ICE", "SI", new BigDecimal("13"), "SM"));
        put(15, new SectorCreditoFiscal("Factura de Entidades Financieras", "SI", new BigDecimal("13"), "SM"));
        put(16, new SectorCreditoFiscal("Factura de Hoteles", "SI", new BigDecimal("13"), "SM"));
        put(17, new SectorCreditoFiscal("Factura de Hospitales/Clínicas", "SI", new BigDecimal("13"), "SM"));
        put(18, new SectorCreditoFiscal("Factura de Juegos de Azar", "SI", new BigDecimal("13"), "SM"));
        put(19, new SectorCreditoFiscal("Facturade Hidrocarburos", "SI", new BigDecimal("13"), "SM"));
        put(20, new SectorCreditoFiscal("Factura Comercial de Exportación de Minerales", "NO", new BigDecimal("0"), "SM"));
        put(21, new SectorCreditoFiscal("Factura de Ventade Minerales", "SI", new BigDecimal("13"), "SM"));
        put(22, new SectorCreditoFiscal("Factura de Telecomunicaciones", "SI", new BigDecimal("13"), "SM"));
        put(23, new SectorCreditoFiscal("Factura Prevalorada", "SI", new BigDecimal("13"), "SM"));
        put(24, new SectorCreditoFiscal("NotadeCrédito-Débito", "NO", new BigDecimal("0"), "SM"));
        put(25, new SectorCreditoFiscal("Productos Nacionales", "SI", new BigDecimal("15.6"), "IPM"));
        put(26, new SectorCreditoFiscal("Productos Nacionales alcanzados por el ICE", "SI", new BigDecimal("15.6"), "IPM"));
        put(27, new SectorCreditoFiscal("SIETE-RG", "NO", new BigDecimal("5"), "7RG"));
    }};


    private class SectorCreditoFiscal {

        private String sector;
        private BigDecimal creditoFiscal;
        private String marcaEspecial;
        private String conDerecho;


        public String sector() {
            return sector;
        }

        public BigDecimal creditoFiscal() {
            return creditoFiscal;
        }

        public String marcaEspecial() {
            return marcaEspecial;
        }

        public String conDerecho() {
            return conDerecho;
        }

        public SectorCreditoFiscal(String sector, String conDerecho, BigDecimal creditoFiscal, String marcaEspecial) {
            this.sector = sector;
            this.creditoFiscal = creditoFiscal;
            this.marcaEspecial = marcaEspecial;
            this.conDerecho = conDerecho;
        }
    }

}

