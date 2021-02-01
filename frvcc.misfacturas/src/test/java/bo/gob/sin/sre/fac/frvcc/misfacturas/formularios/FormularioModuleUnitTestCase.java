package bo.gob.sin.sre.fac.frvcc.misfacturas.formularios;



import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import  bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import  bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import  bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import  bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.test.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class FormularioModuleUnitTestCase extends UnitTestCase {
    protected FormularioRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(FormularioRepository.class);
    }

    public void shouldHaveSaved(Formulario formulario) {
        verify(repository,atLeastOnce()).save(formulario);
    }

    public void shouldSearch(Formulario formulario) {
        Mockito.when(repository.search(formulario.id())).thenReturn(Optional.of(formulario));
    }

    public void shouldMatching(Formulario formulario) {
        Filter filter =  Filter.create("periodo","=",formulario.mesPeriodo().value().toString());
        List<Filter> filters = new ArrayList<>();
        filters.add(filter);
        Criteria criteria = new Criteria(
                new Filters(filters),
                Order.none(),
                Optional.empty(),
                Optional.empty()
        );

        List<Formulario> formularios = new ArrayList<>(
                Arrays.asList(formulario)
        );
        Mockito.when(repository.BuscarPorCriteria(criteria).getContent()).thenReturn(formularios);

    }
}
