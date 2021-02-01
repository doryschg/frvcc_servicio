package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.usuario;

public class DatosPersona {
    private Long seqUsuario;
    private String nombreUsuario;
    private String nroDocumento;
    private String tipoDocumento;
    private Integer lugarExpedicionId;
    private String lugarExpedicionDescripcion;

    public DatosPersona(Long seqUsuario, String nombreUsuario, String nroDocumento, String tipoDocumento, Integer lugarExpedicionId, String lugarExpedicionDescripcion) {
        this.seqUsuario = seqUsuario;
        this.nombreUsuario = nombreUsuario;
        this.nroDocumento = nroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.lugarExpedicionId = lugarExpedicionId;
        this.lugarExpedicionDescripcion = lugarExpedicionDescripcion;
    }
    public DatosPersona()
    {

    }
    public Long getSeqUsuario() {
        return seqUsuario;
    }

    public void setSeqUsuario(Long seqUsuario) {
        this.seqUsuario = seqUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getLugarExpedicionId() {
        return lugarExpedicionId;
    }

    public void setLugarExpedicionId(Integer lugarExpedicionId) {
        this.lugarExpedicionId = lugarExpedicionId;
    }

    public String getLugarExpedicionDescripcion() {
        return lugarExpedicionDescripcion;
    }

    public void setLugarExpedicionDescripcion(String lugarExpedicionDescripcion) {
        this.lugarExpedicionDescripcion = lugarExpedicionDescripcion;
    }
}
