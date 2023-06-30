import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;
class Main{
    public static void main(String[] wxyz){

        Pessoa objeto = new Pessoa(); //responsavel pela interacao com o BD
        Scanner input = new Scanner(System.in); //responsavel pelos inputs do usuario
        LinkedHashMap<String, String> dados = new LinkedHashMap<>();
        String novo_email = "";
        while (1==1){
            //menu principal;
            System.out.println("-----------------------------------");
            System.out.println("[1] - Cadastrar Pessoa \n[2] - Editar dados\n[0] - Sair");
            System.out.print("Escolha: ");
            int escolha = input.nextInt();

            if (escolha == 1){//logica para cadastro no BD
                System.out.print("Nome: ");
                dados.put("nome", input.next());
                input.nextLine();

                System.out.print("Email: ");
                dados.put("email", input.next());
                input.nextLine();

                System.out.print("Senha: ");
                dados.put("senha", input.next());
                input.nextLine();

                //chamando o metodo de cadastro
                objeto.cadastroPessoa(dados.get("nome"), dados.get("email"), dados.get("senha"));
                dados.clear(); //zerando o dicionario dados
            }

            else if (escolha == 2){ //logica para editar dados no BD
                //coletando email
                System.out.print("Digite seu email: ");
                String email = input.next();
                input.nextLine();
                //buscando no BD por email
                dados = objeto.getDados(email);
                System.out.println("-----------------------------------");
                int c = 0;
                //for usado para imprimir na tela
                for (Map.Entry<String, String> entry : dados.entrySet()){
                    String chave = entry.getKey();
                    String valor = entry.getValue();
                    System.out.println("[" + (c+1) + "]" + " - " + chave + ": " + valor);
                    c += 1;
                }
                System.out.print("Qual campo deseja editar: ");
                escolha = input.nextInt();
                //switch usado para chamar algum metodo e realizar alguma edicao.
                switch (escolha){
                    case 1:
                        System.out.print("Digite o novo nome: ");
                        String novo_nome = input.next();
                        objeto.setNome(novo_nome, dados.get("email"));
                        break;
                    case 2:
                        System.out.print("Digite o novo email: ");
                        novo_email = input.next();
                        objeto.setEmail(dados.get("email"), novo_email);
                        break;
                    case 3:
                        System.out.print("Digite a nova senha: ");
                        String nova_senha = input.next();
                        objeto.setSenha(nova_senha, novo_email);
                        break;
                }
                dados.clear(); //zerando dicionario dados
            }
            else if (escolha == 0){ //interrompe o loop while
                break;
            }
        }//while
    }//main
}//clas