package br.com.paulo.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class ContribuicaoTest {

    private Usuario usuario;

    @Before
    public void setUp() throws Exception {
        usuario = new Usuario("João Pinheiro da Silva", 5000.0);
    }

    @Test
    public void deveFazerSimulacaoDeDoisAnosComUmPorcentoParaXETresPorcentoParaY() {
        Contribuicao contribuicao = new Contribuicao(usuario, 2, 1.0, 3.0);

        contribuicao.simula();

        assertThat(123900.0, closeTo(contribuicao.getTotalSalario(), 0.03));
        assertThat(3156.0, closeTo(contribuicao.getTotalContribuicao(), 0.03));
    }
}
