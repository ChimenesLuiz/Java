public class Pessoa{
    private String nome, email, senha;
    public Pessoa(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public String[] getInfo(){
        String[] dados = {this.nome, this.email, this.senha};
        return dados;
    }
}