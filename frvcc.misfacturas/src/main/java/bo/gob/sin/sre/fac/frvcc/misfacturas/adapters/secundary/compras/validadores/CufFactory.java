package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores;


import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * CufFactory permite generar CUFs basado en el CUFD del contribuyente.
 *
 * @author vigmar.carlo
 * @version 29/03/2020
 * @VERSION 13/07/2020 adicion de codigo de verificacion
 */

public class CufFactory {

    public static final String FORMATO_FECHA = "yyyyMMddHHmmssSSS";

    private DateTimeFormatter formatter;
    private Map<String, Object> parametros = new HashMap<>();

    public CufFactory() {
        formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
    }

    public void setNit(Long pNit) {
        parametros.put("nit", pNit);
    }

    public Long getNit() {
        return (Long) parametros.get("nit");
    }

    public void setSucursal(Integer pSucursal) {
        parametros.put("sucursal", pSucursal);
    }

    public Integer getSucursal() {
        return (Integer) parametros.get("sucursal");
    }

    public void setPuntoVenta(Integer pPuntoVenta) {
        parametros.put("puntoVenta", (pPuntoVenta == null) ? 0 : pPuntoVenta);
    }

    public Integer getPuntoVenta() {
        return (Integer) parametros.get("puntoVenta");
    }

    public void setTipoModalidad(Integer pTipoModalidad) {
        parametros.put("tipoModalidad", pTipoModalidad);
    }

    public Integer getTipoModalidad() {
        return (Integer) parametros.get("tipoModalidad");
    }

    public void setTipoEmision(Integer pTipoEmision) {
        parametros.put("tipoEmision", pTipoEmision);
    }

    public Integer getTipoEmision() {
        return (Integer) parametros.get("tipoEmision");
    }

    public void setTipoDocFiscal(Integer pTipoDocFiscal) {
        parametros.put("tipoDocFiscal", pTipoDocFiscal);
    }

    public Integer getTipoDocFiscal() {
        return (Integer) parametros.get("tipoDocFiscal");
    }

    public void setTipoDocSector(Integer pTipoDocSector) {
        parametros.put("tipoDocSector", pTipoDocSector);
    }

    public Integer getTipoDocSector() {
        return (Integer) parametros.get("tipoDocSector");
    }

    public void setCodigoVerificacion (String pCodigoVerificacion) { parametros.put("codigoVerificacion", pCodigoVerificacion);}

    public String getCodigoVerificacion() {
        return (String) parametros.get("codigoVerificacion");
    }

    private void setNumeroFactura(Integer pNumeroFactura){ parametros.put("numeroFactura", pNumeroFactura); }

    public Integer getNumeroFactura() { return (Integer) parametros.get("numeroFactura"); }

    private void setFechaEmision(Date pFechaEmision){ parametros.put("fechaEmision", pFechaEmision); }

    public Date getFechaEmision() { return (Date) parametros.get("fechaEmision"); }




    public Boolean decode(String pCuf){
        try {

            boolean cufValido = pCuf!=null && !pCuf.isEmpty();
            if(!cufValido) return false;

            StringBuilder cadena = new StringBuilder(pCuf);

            String vCodigoVerificacion = recuperar(cadena,15);
            setCodigoVerificacion(vCodigoVerificacion);

            cadena = new StringBuilder(decimal(cadena.toString()));
            recuperar(cadena,1); // recupera Dig Verificador

            String vPuntoVenta = recuperar(cadena,4);
            setPuntoVenta(Integer.valueOf(vPuntoVenta));

            String vNumeroFactura = recuperar(cadena,10);
            setNumeroFactura(Integer.valueOf(vNumeroFactura));

            String vTipoDocSector = recuperar(cadena,2);
            setTipoDocSector(Integer.valueOf(vTipoDocSector));

            String vTipoDocFiscal = recuperar(cadena,1);
            setTipoDocFiscal(Integer.valueOf(vTipoDocFiscal));

            String vTipoEmision = recuperar(cadena,1);
            setTipoEmision(Integer.valueOf(vTipoEmision));

            String vTipoModalidad = recuperar(cadena,1);
            setTipoModalidad(Integer.valueOf(vTipoModalidad));

            String vSucursal = recuperar(cadena,4);
            setSucursal(Integer.valueOf(vSucursal));

            String vFechaEmision = recuperar(cadena,17);
            setFechaEmision(new SimpleDateFormat(FORMATO_FECHA).parse(vFechaEmision));

            String vNit = cadena.toString();
            boolean vLongitudNitValida =  1 <= vNit.length() && vNit.length() <= 13;
            if(!vLongitudNitValida) return false;
            setNit(Long.valueOf(vNit));

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String recuperar(StringBuilder cadena, int numCaracteres){
        Integer length = cadena.length();
        String vCampo = cadena.substring(length - numCaracteres,length);
        cadena.delete(length - numCaracteres,length);
        return vCampo;
    }

    private String fechaFarmateda(Date dateToConvert) {
        LocalDateTime vDateTime = new Timestamp(dateToConvert.getTime()).toLocalDateTime();
        return vDateTime.format(formatter);
    }

    private String completar(String cadena, int longitud, char caracter) {
        return String.format("%1$" + longitud + "s", cadena).replace(' ', caracter);
    }

    private String digitoMod11(String dado, int numDig, int limMult, boolean x10) {
        int mult, soma, i, n, dig;
        if (!x10) numDig = 1;
        for (n = 1; n <= numDig; n++) {
            soma = 0;
            mult = 2;
            for (i = dado.length() - 1; i >= 0; i--) {
                soma += (mult * Integer.parseInt(dado.substring(i, i + 1)));
                if (++mult > limMult) mult = 2;
            }

            if (x10) {
                dig = ((soma * 10) % 11) % 10;
            } else {
                dig = soma % 11;
            }

            if (dig == 10) {
                dado += "1";
            }
            if (dig == 11) {
                dado += "0";
            }
            if (dig < 10) {
                dado += String.valueOf(dig);
            }
        }
        return dado.substring(dado.length() - numDig, dado.length());
    }

    private String hexadecimal(String cadenaConcatenada) {
        BigInteger vNumeroDecimal = new BigInteger(cadenaConcatenada, 10);
        String vCadenaHexadecimal = vNumeroDecimal.toString(16);
        return vCadenaHexadecimal.toUpperCase();
    }

    private String decimal(String pCadenaHexadecimal){
        return new BigInteger(pCadenaHexadecimal, 16).toString();
    }


    @Override
    public String toString() {
        return "CufFactory{" +
                "nit=" + getNit()+
                ", sucursal=" + getSucursal()+
                ", puntoVenta=" + getPuntoVenta()+
                ", tipoModalidad=" + getTipoModalidad()+
                ", tipoEmision=" + getTipoEmision()+
                ", tipoDocFiscal=" + getTipoDocFiscal()+
                ", tipoDocSector=" + getTipoDocSector()+
                ", codigoVerificacion=" + getCodigoVerificacion()+
                ", numeroFactura=" + getNumeroFactura()+
                ", fechaEmision=" + getFechaEmision()+
                '}';
    }
}
