import models.CartaoDeCredito;

public class Main {
    public static void main(String[] args) {
        CartaoDeCredito cartao = new CartaoDeCredito(10000);
        cartao.menu(cartao);
    }
}
