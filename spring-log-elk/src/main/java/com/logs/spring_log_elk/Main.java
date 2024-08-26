package com.logs.spring_log_elk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;  
import java.util.Scanner;

@RestController
@Slf4j
public class Main {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());
    private static final Auth auth = new Auth();  
    private static final Scanner scanner = new Scanner(System.in);

    @GetMapping("/test-log")
    public static void main(String[] args) {
        log.info("Método main iniciado");
        setupLogging();
        logger.info("Sistema de Login Iniciado");

        log.info("Loop principal iniciado");
        while (true) {
            log.debug("Exibindo opções de menu");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Cadastrar-se");
            System.out.print("Escolha uma opção: ");
            String choice = scanner.nextLine();
            log.debug("Opção selecionada: {}", choice);

            if (choice.equals("1")) {
                log.info("Opção de login selecionada");
                login();
            } else if (choice.equals("2")) {
                log.info("Opção de cadastro selecionada");
                createLogin();
            } else {
                log.warn("Opção inválida selecionada: {}", choice);
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void setupLogging() {
        log.info("Configuração de logging iniciada");
        // Configure o logger conforme necessário
        log.info("Configuração de logging concluída");
    }

    private static void login() {
        log.info("Processo de login iniciado");
        System.out.print("Digite seu nome de usuário: ");
        String username = scanner.nextLine();
        log.debug("Nome de usuário informado: {}", username);
        System.out.print("Digite sua senha: ");
        String password = scanner.nextLine();

        if (auth.authenticate(username, password)) {
            log.info("Login bem-sucedido para o usuário: {}", username);
            System.out.println("Login bem-sucedido!");
            menuOptions(username);
        } else {
            log.warn("Falha no login para o usuário: {}", username);
            System.out.println("Falha no login. Verifique suas credenciais.");
        }
    }

    private static void menuOptions(String username) {
        log.info("Exibindo opções de menu para o usuário: {}", username);
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Meus Dados");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            String choice = scanner.nextLine();
            log.debug("Opção de menu selecionada pelo usuário {}: {}", username, choice);

            if (choice.equals("1")) {
                log.info("Exibindo dados do usuário: {}", username);
                displayUserData(username);
            } else if (choice.equals("2")) {
                log.info("Usuário {} optou por sair", username);
                System.out.println("Saindo...");
                break;
            } else {
                log.warn("Opção inválida selecionada pelo usuário {}: {}", username, choice);
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void displayUserData(String username) {
        log.info("Buscando dados do usuário: {}", username);
        Map<String, String> userData = auth.getUsers().get(username);

        if (userData == null) {
            log.error("Usuário não encontrado: {}", username);
            System.out.println("Usuário não encontrado.");
            return;
        }

        log.info("Dados do usuário {} encontrados com sucesso", username);
        System.out.println("\nDados do Usuário:");
        System.out.println("Nome Completo: " + userData.get("full_name"));
        System.out.println("Idade: " + userData.get("age"));
        System.out.println("Nome de Usuário: " + userData.get("username"));
        System.out.println("Senha: " + userData.get("password") + " (não pode ser alterada)");

        System.out.println("\nDeseja Atualizar os dados?");
        System.out.println("1 - Atualizar Nome Completo");
        System.out.println("2 - Atualizar Idade");
        System.out.println("3 - Atualizar Nome de Usuário");
        System.out.println("4 - Voltar");
        System.out.print("Escolha uma opção: ");
        String choice = scanner.nextLine();
        log.debug("Opção de atualização selecionada para o usuário {}: {}", username, choice);

        switch (choice) {
            case "1":
                log.info("Atualizando nome completo do usuário: {}", username);
                System.out.print("Digite o novo nome completo: ");
                String newName = scanner.nextLine();
                userData.put("full_name", newName);
                log.info("Nome completo atualizado para o usuário: {}", username);
                System.out.println("Nome completo atualizado com sucesso!");
                break;
            case "2":
                log.info("Atualizando idade do usuário: {}", username);
                System.out.print("Digite a nova idade: ");
                String newAge = scanner.nextLine();
                userData.put("age", newAge);
                log.info("Idade atualizada para o usuário: {}", username);
                System.out.println("Idade atualizada com sucesso!");
                break;
            case "3":
                log.info("Atualizando nome de usuário para o usuário: {}", username);
                System.out.print("Digite o novo nome de usuário: ");
                String newUsername = scanner.nextLine();
                auth.getUsers().remove(username);
                userData.put("username", newUsername);
                auth.saveUser(userData);
                log.info("Nome de usuário atualizado para: {}", newUsername);
                System.out.println("Nome de usuário atualizado com sucesso!");
                break;
            case "4":
                log.info("Usuário {} escolheu voltar ao menu principal", username);
                return;
            default:
                log.warn("Opção inválida selecionada pelo usuário {}: {}", username, choice);
                System.out.println("Opção inválida. Retornando ao menu principal.");
                break;
        }
    }

    private static void createLogin() {
        log.info("Processo de criação de login iniciado");
        System.out.println("Cadastro de Usuário");

        System.out.print("Nome Completo: ");
        String fullName = scanner.nextLine();
        log.debug("Nome completo informado: {}", fullName);
        System.out.print("Idade: ");
        String age = scanner.nextLine();
        log.debug("Idade informada: {}", age);
        System.out.print("Nome de Usuário: ");
        String username = scanner.nextLine();
        log.debug("Nome de usuário informado: {}", username);

        String password;
        while (true) {
            System.out.print("Senha: ");
            password = scanner.nextLine();
            log.debug("Senha informada");
            if (password.length() < 6) {
                log.warn("Senha muito curta para o nome de usuário: {}", username);
                System.out.println("A senha deve ter pelo menos 6 caracteres.");
            } else {
                System.out.print("Confirme a Senha: ");
                String confirmPassword = scanner.nextLine();
                log.debug("Confirmação de senha informada");
                if (!password.equals(confirmPassword)) {
                    log.warn("As senhas não coincidem para o nome de usuário: {}", username);
                    System.out.println("As senhas não coincidem. Tente novamente.");
                } else {
                    break;
                }
            }
        }

        Map<String, String> userData = new HashMap<>();  
        userData.put("full_name", fullName);
        userData.put("age", age);
        userData.put("username", username);
        userData.put("password", password);

        auth.saveUser(userData);
        log.info("Usuário cadastrado com sucesso: {}", username);
        System.out.println("Usuário cadastrado com sucesso!");
    }
}
