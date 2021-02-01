package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring;



import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoListaDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.str.cmsj.mapl.dto.StrMensajeAplicacionDto;
import bo.gob.sin.str.cmsj.mapl.ports.MensajeAplicacionPort;
import bo.gob.sin.str.enumeradores.entorno.EnumSubsistema;
import bo.gob.sin.str.parametricas.enumeradores.IMensajeAplicacion;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.NestedServletException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class ApiExceptionMiddleware implements Filter {
    private RequestMappingHandlerMapping mapping;
    private MensajeAplicacionPort mensajeAplicacionPort;


    public ApiExceptionMiddleware(RequestMappingHandlerMapping mapping, MensajeAplicacionPort mensajeAplicacionPort) {
        this.mapping = mapping;
        this.mensajeAplicacionPort = mensajeAplicacionPort;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        HttpServletResponse httpResponse = ((HttpServletResponse) response);

        try {
            Object possibleController = (
                    (HandlerMethod) Objects.requireNonNull(
                            mapping.getHandler(httpRequest)).getHandler()
            ).getBean();

            try {
                chain.doFilter(request, response);
            } catch (NestedServletException exception) {
                if (possibleController instanceof ApiController) {
                    exception.printStackTrace();
                    handleCustomError(response, httpResponse, (ApiController) possibleController, exception);
                }
            }
        } catch (Exception e) {

            httpResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void handleCustomError(
            ServletResponse response,
            HttpServletResponse httpResponse,
            ApiController possibleController,
            NestedServletException exception
    ) throws IOException {
        HashMap<Class<? extends DomainError>, HttpStatus> errorMapping = possibleController
                .errorMapping();
        Throwable error = (
                exception.getCause() instanceof CommandHandlerExecutionError ||
                        exception.getCause() instanceof QueryHandlerExecutionError
        )
                ? exception.getCause().getCause() : exception.getCause();


        int statusCode = statusFor(errorMapping, error);
        String errorMessage = error.getMessage();

        httpResponse.reset();
        httpResponse.setHeader("Content-Type", "application/json");
        httpResponse.setStatus(statusCode);
        String errorJson = new Gson().toJson(errorCodeFor(error));
        PrintWriter writer = response.getWriter();
        writer.print(errorJson);
        writer.close();
    }

    private Object errorCodeFor(Throwable error) {
        if (!(error instanceof DomainError)) {
            return null;
        }
        DomainError domainError = (DomainError) error;
        if (domainError.getHashMapErrorCodigo() != null) {
            return getResultadoGenericoDto(domainError.getId(), domainError.getHashMapErrorCodigo());
        }

        if (domainError.getListaErrores() != null) {
            ResultadoGenericoListaDto<ResultadoGenericoDto> vResultadoGenericoListaDto = new ResultadoGenericoListaDto();
            vResultadoGenericoListaDto.setResultadoLista(domainError.getListaErrores().entrySet().stream().map(x -> getResultadoGenericoDto(x.getKey(), x.getValue())).collect(Collectors.toList()));
            vResultadoGenericoListaDto.setOk(false);
            return vResultadoGenericoListaDto;
        }
        return null;
    }

    private List<String> buscarCodigo(Integer codigo, HashMap<String, List<Integer>> validaciones) {
        List<String> reusltado = validaciones.entrySet().stream().filter(x -> x.getValue().stream().filter(y -> y.equals(codigo)).findFirst().isPresent()).map(x -> x.getKey()).collect(Collectors.toList());
        return reusltado;
    }

    private int statusFor(HashMap<Class<? extends DomainError>, HttpStatus> errorMapping, Throwable error) {
        return errorMapping.getOrDefault(error.getClass(), HttpStatus.OK).value();
    }
    private ResultadoGenericoDto getResultadoGenericoDto(String idModel, ValidationResponse pValidationResponse) {

        List<Integer> codigosError = pValidationResponse.errors().values().stream().distinct().flatMap(x -> x.stream()).collect(Collectors.toList());
        ResultadoGenericoDto resultadoGenericoDto = new ResultadoGenericoDto(idModel);
        codigosError.forEach(codError -> {
                    List<String> parametros = buscarCodigo(codError, pValidationResponse.errors());
                    StrMensajeAplicacionDto mensaje = mensajeAplicacionPort.getMensaje(EnumSubsistema.RECAUDACIONES,
                            new IMensajeAplicacion(){
                                @Override
                                public int getId() {
                                    return codError;
                                }
                            }
                          );
                    parametros.forEach(x -> mensaje.set(x));
                    resultadoGenericoDto.addMensaje(mensaje);
                }
        );
        return resultadoGenericoDto;
    }
}



