import java.util.Map; // Interface que define um mapeamento de chave-valor.
import java.util.HashMap; // Implementação de Map que utiliza tabela de hash para armazenar as chaves e valores, permitindo acesso rápido.

public class Carrinho {
    private Map<Produto, Integer> itens;
    private double precoTotal;

    public Carrinho() {
        this.itens = new HashMap<>();
        this.precoTotal = 0.0;
    }

    public void addProduto(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return;
        }

        // Tá no carrinho?
        if (itens.containsKey(produto)) {
            // Se tiver atualiza
            itens.put(produto, itens.get(produto) + quantidade);
        } else {
            // adiciona o produto
            itens.put(produto, quantidade);
        }

        // Preço total
        precoTotal += produto.getPreco() * quantidade;
        System.out.println("Foram adicionados " + quantidade + " de " + produto.getNome() + " ao carrinho.");
    }

        // Deletador do carrinho
    public void deletarProduto(Produto produto) {
        if (itens.containsKey(produto)) {
            int quantidade = itens.get(produto);
            precoTotal -= produto.getPreco() * quantidade;
            itens.remove(produto);
            System.out.println("O(a) " + produto.getNome() + " foi removido do carrinho.");
        }
    }

    // Atualizador de quantidade
    public void attQuant(Produto produto, int quantNova) {
        if (itens.containsKey(produto)) {
            int quantAgora = itens.get(produto);

            // Novo preço total
            precoTotal -= produto.getPreco() * quantAgora; // Tira
            precoTotal += produto.getPreco() * quantNova; // Bota

            itens.put(produto, quantNova);
            System.out.println("A nova quantidade de " + produto.getNome() + " é de " + quantNova + " produtos.");
        } else {
            System.out.println("Não existe esse produto no carrinho!");
        }
    }

    // Visualizar o preço final do carrinho
    public double getPrecoTotal() {
        return precoTotal;
    }

    // Visualizar os produtos do carrinho
    public void showCar() {
        System.out.println("Os produtos do carrinho são:");
        for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            System.out.println("Quantidade de produtos: " + quantidade);
        }
        System.out.println("Preço total: R$" + precoTotal);
    }
}
