package br.edu.ifpr.pedidos;
@FunctionalInterface public interface ProcessadorPagamento { boolean autorizar(long totalCentavos); }
