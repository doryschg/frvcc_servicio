package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.contribuyente_newton;


import java.util.Arrays;
import java.util.HashMap;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.contribuyentes.IVerificaContribuyenteNewton;

@Service
public class contribuyente_newton  implements IVerificaContribuyenteNewton {
	private static final Logger LOG= LoggerFactory.getLogger(contribuyente_newton.class);
    private final IVerificaContribuyenteNewton verificaContribuyente;
   

        public contribuyente_newton(IVerificaContribuyenteNewton verificaContribuyente) {
            this.verificaContribuyente = verificaContribuyente;
        }

       

    
    private ValidationResponse crearValidacionException(){
        return  new ValidationResponse(new HashMap<>() {{
            put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_DECLARAR_FORMULARIO.getId()));
        }});
    }

	@Override
	public String esContribuyenteNewton(Long pNit) {
		 return  verificaContribuyente.esContribuyenteNewton(pNit);
	}

}





