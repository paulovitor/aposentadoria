package br.com.paulo.model;

public class Usuario {

    private String nome;
    private double salario;

    public Usuario() {

    }

    public Usuario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void fazReajusteSalarial(double percentual) {
        salario = salario + (salario * percentual) / 100;
    }
}
