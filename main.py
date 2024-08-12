from log import setup_logging
import auth
import logging

def main():
    setup_logging()
    logging.info("Sistema de Login Iniciado")

    print("Bem-vindo!")
    
    username = input("Digite seu nome de usuário: ")
    password = input("Digite sua senha: ")

    if auth.authenticate(username, password):
        print("Login bem-sucedido!")
    else:
        print("Falha no login. Verifique suas credenciais.")

    logging.info("Sistema de login Encerrado")

if __name__ == "__main__":
    main()
