# pack
Compressão e Criptografia de Arquivos (CCA)

[<img src="https://api.travis-ci.org/kyriosdata/parser.svg?branch=master">](https://travis-ci.org/kyriosdata/parser)
[![Coverage Status](https://coveralls.io/repos/github/kyriosdata/parser/badge.svg?branch=master)](https://coveralls.io/github/kyriosdata/parser?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1eb0eb949dd14f2bb8b31c56a988350f)](https://www.codacy.com/app/kyriosdata/parser?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=kyriosdata/parser&amp;utm_campaign=Badge_Grade)
[![Javadocs](http://javadoc.io/badge/com.github.kyriosdata.parser/parser.svg)](http://javadoc.io/doc/com.github.kyriosdata.parser/parser)
[![Sonarqube](https://img.shields.io/badge/quality-verifique-lightgrey.svg)](https://sonarqube.com/dashboard?id=com.github.kyriosdata.parser%3Aparser)

<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a><br />
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/4.0/">Creative Commons Attribution 4.0 International License</a>. Faça a atribuição de autoria à "Fábrica de Software - Instituto de Informática (UFG)".

Alguns cenários fazem uso de sequências de bytes, muitas vezes armazenadas em arquivos, cujo conteúdo deve ser de acesso restrito. Adicionalmente, além do aspecto de segurança, a compressão deve ser considerada como instrumento empregado para reduzir o eventual consumo de "rede" durante transferência desse conteúdo. O presente projeto implementa uma proposta tanto para compressão quanto para oferecer algum nível de segurança (sigilo) de dados.
