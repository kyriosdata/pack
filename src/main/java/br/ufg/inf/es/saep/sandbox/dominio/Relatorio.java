/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.saep.sandbox.dominio;

import br.ufg.inf.es.saep.sandbox.dominio.excecoes.CampoExigidoNaoFornecido;

import java.util.ArrayList;
import java.util.List;

/**
 * Conjunto de relatos sobre os quais uma contagem é realizada.
 *
 * @see Relato
 * @see Contagem
 *
 */
public class Relatorio extends Entidade {

    /**
     * Ano base do relatório.
     */
    private int anoBase;

    /**
     * Relatos associados ao RADOC.
     * Um RADOC pode possuir zero ou mais
     * relatos.
     */
    private List<Relato> relatos;

    /**
     * Cria um relatório parecerById relatos.
     *
     * @param id O identificador único do RADOC.
     * @param anoBase O ano base do RADOC.
     * @param relatos Conjunto de relatos que fazem parte do RADOC.
     */
    public Relatorio(String id, int anoBase, List<Relato> relatos) {
        super(id);

        if (relatos == null) {
            throw new CampoExigidoNaoFornecido("relatos");
        }

        this.anoBase = anoBase;
        this.relatos = relatos;
    }

    /**
     * Identifica, dentre os relatos do RADOC, aqueles
     * de um dado tipo.
     *
     * @param tipo O tipo de relato.
     * @return Conjunto de relatos do tipo indicado.
     */
    public List<Relato> relatosPorTipo(String tipo) {

        List<Relato> procurados = new ArrayList<>();

        for(Relato relato : relatos) {
            if (relato.getClasse().equals(tipo)) {
                procurados.add(relato);
            }
        }

        return procurados;
    }

    /**
     * Recupera o ano base do RADOC.
     *
     * @return O ano base do RADOC.
     */
    public int getAnoBase() {
        return anoBase;
    }

    /**
     * Recupera os relatos que fazem parte do RADOC.
     *
     * @return O conjunto de relatos do RADOC.
     */
    public List<Relato> getRelatos() {
        return relatos;
    }
}
