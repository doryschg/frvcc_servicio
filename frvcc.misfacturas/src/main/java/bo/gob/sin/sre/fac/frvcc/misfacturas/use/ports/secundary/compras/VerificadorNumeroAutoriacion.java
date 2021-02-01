package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras;

import java.math.BigDecimal;
import java.util.List;

public final class VerificadorNumeroAutoriacion {

    private String modalidad;
    private BigDecimal creditoFiscal;
    private String marcaEspecial;
    private Integer tipoSector;

    private String conDerechoCf;
    private Boolean isValid;
    private List<Integer> erorres;

    public VerificadorNumeroAutoriacion(
            String pModalidad,
            BigDecimal pCreditoFiscal,
            String pMarcaEspecial, Boolean isValid,
            String pConDerechoCf,
            Integer pTipoSector) {

        this.modalidad = pModalidad.strip().toUpperCase();
        this.creditoFiscal = pCreditoFiscal;
        this.marcaEspecial = pMarcaEspecial.strip().toUpperCase();
        this.isValid = isValid;
        this.conDerechoCf=pConDerechoCf.strip().toUpperCase();
        this.tipoSector = pTipoSector;
    }

    public VerificadorNumeroAutoriacion(List<Integer> erorres, Boolean isValid) {
        this.erorres = erorres;
        this.isValid = isValid;
    }

    public Integer getTipoSector() {
        return tipoSector;
    }

    public String getConDerechoCf() {
        return conDerechoCf;
    }

    public Boolean isValid() {
        return isValid;
    }


    public String getModalidad() {
        return modalidad;
    }

    public BigDecimal getCreditoFiscal() {
        return creditoFiscal;
    }

    public String getMarcaEspecial() {
        return marcaEspecial;
    }

    public List<Integer> getErorres() {
        return erorres;
    }
}
