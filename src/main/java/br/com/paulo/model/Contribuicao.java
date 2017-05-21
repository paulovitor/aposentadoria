package br.com.paulo.model;

public class Contribuicao {

    public static final double TAXA_REAJUSTE_SALARIAL = 6.5;

    private Usuario usuario;
    private int anos;

    private double x;
    private double y;

    private double totalSalario;
    private double totalContribuicao;

    public Contribuicao() {

    }

    public Contribuicao(Usuario usuario, int anos, double x, double y) {
        this.usuario = usuario;
        this.anos = anos;
        this.x = x;
        this.y = y;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getAnos() {
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void simula() {
        totalSalario = calculaSalarioAnual();
        totalContribuicao = calculaContribuicaoAnual();

        for (int contador = 2; contador <= anos; contador++) {
            usuario.fazReajusteSalarial(TAXA_REAJUSTE_SALARIAL);

            totalSalario += calculaSalarioAnual();
            totalContribuicao += calculaContribuicaoAnual();
        }
    }

    public double getTotalSalario() {
        return totalSalario;
    }

    public double getTotalContribuicao() {
        return totalContribuicao;
    }

    private double calculaSalarioAnual() {
        return usuario.getSalario() * 12;
    }

    private double calculaContribuicaoAnual() {
        double x = (usuario.getSalario() * this.x) / 100;
        double y = ((usuario.getSalario() - 2500) * this.y) / 100;
        return x * 12 + y * 12;
    }
}
