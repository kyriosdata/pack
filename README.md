# pack
Compressão e Criptografia de Sequências de Bytes (CCSB)

[<img src="https://api.travis-ci.org/kyriosdata/pack.svg?branch=master">](https://travis-ci.org/kyriosdata/pack)
[![Dependency Status](https://www.versioneye.com/user/projects/58162079cd069a34c00a2d36/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/58162079cd069a34c00a2d36)
[![Coverage Status](https://coveralls.io/repos/github/kyriosdata/pack/badge.svg?branch=master)](https://coveralls.io/github/kyriosdata/pack?branch=master)
[![Javadocs](http://javadoc.io/badge/com.github.kyriosdata.pack/pack.svg)](http://javadoc.io/doc/com.github.kyriosdata.pack/pack)
[![Sonarqube](https://sonarqube.com/api/badges/gate?key=com.github.kyriosdata.pack%3Apack)](https://sonarqube.com/dashboard?id=com.github.kyriosdata.pack%3Apack)

<br />
<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/4.0/">Creative Commons Attribution 4.0 International License</a>. 
<br />Fábio Nogueira de Lucena - Fábrica de Software - Instituto de Informática (UFG).

Sequência de bytes cujo conteúdo deve ser de acesso restrito e comprimido são consideradas pelo presente projeto. O código não faz uso de bibliotecas de terceiros. 

## Como usar?

Acrescente a dependência para o projeto conforme abaixo:

<pre>
&lt;dependency&gt;
  &lt;groupId&gt;com.github.kyriosdata.pack&lt;/groupId&gt;
  &lt;artifactId&gt;pack&lt;/artifactId&gt;
  &lt;version&gt;1.0.0&lt;/version&gt;
&lt;/dependency&gt;
</pre>

### Links relevantes
- https://www.infoq.com/news/2016/07/apple-lzfse-lossless-opensource 
- Compressão usando lz4 (https://cyan4973.github.io/lz4/). Aparentemente ainda não há lzfse para Java.
