package br.com.paulo.model;

import org.junit.Before;
import org.junit.Test;

import static br.com.paulo.model.Contribuicao.TAXA_REAJUSTE_SALARIAL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class UsuarioTest {

    private Usuario usuario;

    @Before
    public void setUp() throws Exception {
        usuario = new Usuario("João Pinheiro da Silva", 5000.0);
    }

    @Test
    public void deveFazerReajusteSalarialDeUmAno() {
        usuario.fazReajusteSalarial(TAXA_REAJUSTE_SALARIAL);

        assertThat(5325.0, closeTo(usuario.getSalario(), 0.03));
    }

    @Test
    public void deveFazerReajusteSalarialDeTresAnos() {
        usuario.fazReajusteSalarial(TAXA_REAJUSTE_SALARIAL);
        usuario.fazReajusteSalarial(TAXA_REAJUSTE_SALARIAL);
        usuario.fazReajusteSalarial(TAXA_REAJUSTE_SALARIAL);

        assertThat(6039.74, closeTo(usuario.getSalario(), 0.03));
    }
}
