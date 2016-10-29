package br.ufg.inf.es.saep.sandbox.dominio;

import br.ufg.inf.es.saep.sandbox.dominio.excecoes.AvaliaveisIncompativeis;
import br.ufg.inf.es.saep.sandbox.dominio.excecoes.CampoExigidoNaoFornecido;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ObservacaoTest {

    @Test
    public void montaRecuperaCorretamenteUmaNota() {
        Avaliavel o = new Pontuacao("o", new Valor("o"));
        Avaliavel s = new Pontuacao("s", new Valor("o"));

        assertNotEquals(o, s);

        Observacao n = new Observacao(o, s, "simples erro");
        assertEquals(o, n.getItemOriginal());
        assertEquals(s, n.getItemNovo());
        assertEquals("simples erro", n.getJustificativa());
    }

    @Test
    public void origemSignificaInsercao() {
        Avaliavel o = new Pontuacao("o", new Valor("o"));
        assertTrue(new Observacao(null, o, "simples erro").isInsercao());
    }

    @Test
    public void destinoPodeSerNull() {
        Avaliavel o = new Pontuacao("o", new Valor("o"));
        new Observacao(o, null, "motivo");
    }

    @Test
    public void justificativaNullGeraExcecao() {
        Avaliavel o = new Pontuacao("o", new Valor("o"));
        assertThrows(CampoExigidoNaoFornecido.class, () -> new Observacao(o, o, null));
    }

    @Test
    public void tentativaDeCriarNotaComAvaliaveisDeTiposDistintos() {
        Avaliavel o = new Pontuacao("o", new Valor("o"));
        HashMap<String, Valor> valores = new HashMap<>(1);
        valores.put("v", new Valor("v"));

        Avaliavel d = new Relato("d", valores);

        assertThrows(AvaliaveisIncompativeis.class, () -> new Observacao(o, d, "tentativa deve falhar"));
    }
}

