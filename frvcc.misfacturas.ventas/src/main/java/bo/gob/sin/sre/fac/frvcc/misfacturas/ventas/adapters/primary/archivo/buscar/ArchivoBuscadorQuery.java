package bo.gob.sin.sre.fac.frvcc.misfacturas.ventas.adapters.primary.archivo.buscar;



import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public class ArchivoBuscadorQuery implements Query {
    private final String id;
    public ArchivoBuscadorQuery(String id){
        this.id=id;
    }
    public String id(){
        return id;
    }
}
