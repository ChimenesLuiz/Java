import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;
class Main{
    public static void main(String[] wxyz){
        Pessoa objeto = new Pessoa();
        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, String> dados = new LinkedHashMap<>();
        while (1==1){
            System.out.println("-----------------------------------");
            System.out.println("[1] - Cadastrar Pessoa \n[2] - Consultar Cadastro \n[0] - Sair");
            System.out.print("Escolha: ");
            int escolha = input.nextInt();

            if (escolha == 1){
                System.out.print("Nome: ");
                dados.put("nome", input.next());
                input.nextLine();

                System.out.print("Email: ");
                dados.put("email", input.next());
                input.nextLine();

                System.out.print("Senha: ");
                dados.put("senha", input.next());
                input.nextLine();

                objeto.cadastroPessoa(dados.get("nome"), dados.get("email"), dados.get("senha"));
                dados.clear();
            }

            else if (escolha == 2){
                System.out.print("Digite seu email: ");
                String email = input.next();
                input.nextLine();
                dados = objeto.consultarDados(email);
                System.out.println("-----------------------------------");
                for (Map.Entry<String, String> entry : dados.entrySet()){
                    String chave = entry.getKey();
                    String valor = entry.getValue();
                    System.out.println(chave + ": " + valor);
                }
                dados.clear();
            }
            else if (escolha == 0){
                break;
            }

        }//while
    }//main
}//clas