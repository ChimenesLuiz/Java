import java.sql.*;
import java.util.LinkedHashMap;

public class Pessoa{
    //declarando os atributos da classe
    private final String url, user, password;
    private Connection conexao;
    public Pessoa(){
        //preenchendo informacoes relativas ao BD (sao exemplos)
        this.url = "exemplo: jdbc:mysql://localhost:3306/GrupoCard";
        this.user = "";
        this.password = "";
        this.conexao = null;
    }
    private void conectar(){//funcao para conectar com o BD
        try{
            this.conexao = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void cadastroPessoa(String nome, String email, String senha){
        try{
            conectar(); //conectando com o BD
            String comando_sql = "INSERT INTO Pessoa(nome, email, senha) VALUES(?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(comando_sql); //preparando o comando SQL
            //substituindo as interrogacoes do "comando_sql" sendo (1 = indice e {nome} = valor)
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setString(3, senha);
            int linhasAfetadas = statement.executeUpdate(); // executando o comando sql
            //encerrando conexao
            statement.close();
            conexao.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public LinkedHashMap getDados(String email){
        LinkedHashMap<String, String> dados = new LinkedHashMap<String, String>(); //dicionario usado para coletar dados
        try{
            conectar();
            String comandoSql = "SELECT * FROM Pessoa WHERE email = ?";
            PreparedStatement statement = conexao.prepareStatement(comandoSql);
            statement.setString(1, email);
            ResultSet resultado = statement.executeQuery(); //armazenando o resultado do SELECT

            while (resultado.next()){ //percorrendo o resultado e atribuindo ao dicionario
                dados.put("nome", resultado.getString("nome"));
                dados.put("email", resultado.getString("email"));
                dados.put("senha", resultado.getString("senha"));
            }
            //encerrando conexao
            resultado.close();
            statement.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return dados; //retornando o dicionario
    }

    public void setNome(String nome, String email){
        try{
            conectar();
            String comando_sql = "UPDATE Pessoa SET nome = ? WHERE email = ?";
            PreparedStatement statement = conexao.prepareStatement(comando_sql);
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.executeUpdate();

            statement.close();
            conexao.close();
            System.out.println("-----------------------------------");
            System.out.println("Dados alterados com sucesso! ");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void setEmail(String email, String novo_email){
        try{
            conectar();
            String comando_sql = "UPDATE Pessoa SET email = ? where email = ?";
            PreparedStatement statement = conexao.prepareStatement(comando_sql);
            statement.setString(1, novo_email);
            statement.setString(2, email);
            statement.executeUpdate();

            conexao.close();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void setSenha(String senha, String email){
        try{
            conectar();
            String comando_sql = "UPDATE Pessoa SET senha = ? WHERE email = ?";
            PreparedStatement statement = conexao.prepareStatement(comando_sql);
            statement.setString(1, senha);
            statement.setString(2, email);
            statement.executeUpdate();
            conexao.close();
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}


