import java.sql.*;
import java.util.LinkedHashMap;

public class Pessoa{
    private final String url, user, password;
    private Connection conexao;
    public Pessoa(){
        this.url = "jdbc:mysql://localhost:3306/GrupoCard";
        this.user = "root";
        this.password = "@D414n45376491";
        this.conexao = null;
    }
    private void conectar(){
        try{
            this.conexao = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void cadastroPessoa(String nome, String email, String senha){
        try{
            conectar();
            String comando = "INSERT INTO Pessoa(nome, email, senha) VALUES(?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(comando);
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setString(3, senha);
            int linhasAfetadas = statement.executeUpdate();
            statement.close();
            conexao.close();
            System.out.println("Linhas afetadas: " + linhasAfetadas);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public LinkedHashMap consultarDados(String email){
        LinkedHashMap<String, String> dados = new LinkedHashMap<String, String>();
        try{
            conectar();
            String comandoSql = "SELECT * FROM Pessoa WHERE email = ?";
            PreparedStatement statement = conexao.prepareStatement(comandoSql);
            statement.setString(1, email);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()){
                dados.put("nome", resultado.getString("nome"));
                dados.put("email", resultado.getString("email"));
                dados.put("senha", resultado.getString("senha"));
            }
            resultado.close();
            statement.close();
            conexao.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return dados;
    }
}
