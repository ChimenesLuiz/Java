import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.HashMap;

public class Banco{
    private final String url, user, password;
    Connection conexao;
    public Banco(){
        this.url = "jdbc:mysql://localhost:3306/GrupoCard";
        this.user = "root";
        this.password = "@D414n45376491";
        this.conexao = null;
    }
    public void conectar(){
        try{
            this.conexao = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public HashMap getAll(){
        String id = "";
        HashMap<String, String> dados = new HashMap<String, String>();
        try{
            conectar();
            Statement statement = conexao.createStatement();

            String comando = "SELECT * FROM Pessoa";
            ResultSet result = statement.executeQuery(comando);

            while (result.next()){
                int idInt = result.getInt("id_pessoa");
                id = String.valueOf(idInt);
                dados.put("id", id);
                dados.put("nome", result.getString("nome"));
                dados.put("email", result.getString("email"));
                dados.put("senha", result.getString("senha"));
            }
            result.close();
            statement.close();
            conexao.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return dados;
    }
}