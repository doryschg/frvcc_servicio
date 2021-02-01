package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared;

public interface ICompraContribuyenteCache {
     Long getIfcContribuyenteCache(Long nit);
    String getRazonSocialContribuyenteCache(Long nit);
    Boolean isPresent(Long nit);
}
