package ia.nimoy;

import java.util.List;

import org.apache.commons.math3.distribution.PoissonDistribution;

/**
 * Classe que representa um cliente no supermercado
 */

public class Customer {
    public enum Estado {
        EM_FILA,
        EM_CHECKOUT,
        ENTRANDO,
        SAINDO,
        COMPRANDO
    }

    private List<Item> items;
    private Estado estado;

    public Customer(List<Item> items) {
        this.items = items;
        this.estado = Estado.ENTRANDO; // O estado inicial é ENTRANDO
    }

    public List<Item> getItems() {
        return items;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    private int gerarPoisson(double lambda) {
        PoissonDistribution poisson = new PoissonDistribution(lambda);
        return poisson.sample();
    }

    public void entrar(RelogioInterno relogioInterno) {
        this.estado = Estado.ENTRANDO;
        System.out.println("O cliente está entrando...");
        // Gerar uma lista de compras aleatória que deverá conter um numero de itens que segue uma poisson com lambda = 10 itens
        // A lista de compras deverá conter ni minimo 1 item

        // todos os itens devem estar presentes na lista de itens do supermercado

        // Deverá registrar o tempo de entrada do cliente usando a classe RelogioInterno que foi passada como parametro
        // O tempo (RelogioInterno) de entrada para o estado COMPRANDO deve ser gerado segundo uma exponencial com lambda 20 segundos)

    }
}
