import java.util.Scanner;
import java.util.HashMap;
class Main{
    public static void main(String[] wxyz){
        Banco banco = new Banco();
        Scanner input = new Scanner(System.in);
        int id_cadastro = 0;
        while (1==1){
            System.out.println("-----------------------------------");
            System.out.println("[1] - Cadastrar Pessoa \n[0] - Sair");
            System.out.print("Escolha: ");
            int escolha = input.nextInt();

            if (escolha == 1){
                HashMap<String, String> dados = new HashMap<String, String>();

                System.out.print("Nome: ");
                String nome = input.next();
                dados.put("nome", nome);
                input.nextLine();

                System.out.print("Email: ");
                String email = input.next();
                dados.put("email", email);
                input.nextLine();

                System.out.print("Senha: ");
                String senha = input.next();
                dados.put("senha", senha);
                input.nextLine();

                banco.cadastroPessoa(nome, email, senha);
            }

            else if (escolha == 0){
                break;
            }
        }
    }
}