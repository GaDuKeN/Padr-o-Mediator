public class AplicacaoMediator {
    public static void main(String[] args) {
        ChatMediator chat = new ChatMediatorImpl();

        Usuario usuario1 = new UsuarioImpl(chat, "Alice");
        Usuario usuario2 = new UsuarioImpl(chat, "Bob");
        Usuario usuario3 = new UsuarioImpl(chat, "Carlos");
        Usuario usuario4 = new UsuarioImpl(chat, "Diana");

        chat.adicionarUsuario(usuario1);
        chat.adicionarUsuario(usuario2);
        chat.adicionarUsuario(usuario3);
        chat.adicionarUsuario(usuario4);

        usuario1.enviarMensagem("Olá a todos!");
        usuario2.enviarMensagem("Oi Alice!");
    }
}
