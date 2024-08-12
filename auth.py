import logging
users = {
    'weslly': '12345',
    'vitor': '54321'
}

def authenticate(username, password):
    logging.debug(f'Tentativa de login para usuário: {username}')
    
    if username not in users:
        logging.warning(f'Usuário não encontrado: {username}')
        return False

    if users[username] == password:
        logging.info(f'Login bem-sucedido para usuário: {username}')
        return True
    else:
        logging.warning(f'Senha incorreta para usuário: {username}')
        return False
