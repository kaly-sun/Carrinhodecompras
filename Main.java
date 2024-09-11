public class Main {
    public static void main(String[] args) {
        Produto item1 = new Produto("Placa de vídeo", 1200.00);
        Produto item2 = new Produto("CPU", 600.00);
        Produto item3 = new Produto("RAM", 300.00);
        Produto item4 = new Produto("Monitor", 1000.00);

        Carrinho carrinho = new Carrinho();

        carrinho.addProduto(item1, 1);
        carrinho.addProduto(item2,1);
        carrinho.addProduto(item3, 4);
        carrinho.addProduto(item4,2);

        carrinho.showCar();

        carrinho.attQuant(item4, 3);
        carrinho.showCar();

        carrinho.deletarProduto(item4);
        carrinho.showCar();
    }
}