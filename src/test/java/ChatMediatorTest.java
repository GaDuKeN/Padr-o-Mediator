import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class ChatMediatorTest {

    private ChatMediator chat;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private ByteArrayOutputStream saidaCapturada;

    @Before
    public void setup() {
        chat = new ChatMediatorImpl();
        usuario1 = new UsuarioImpl(chat, "Alice");
        usuario2 = new UsuarioImpl(chat, "Bob");
        usuario3 = new UsuarioImpl(chat, "Carlos");

        chat.adicionarUsuario(usuario1);
        chat.adicionarUsuario(usuario2);
        chat.adicionarUsuario(usuario3);

        saidaCapturada = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saidaCapturada));
    }

    @Test
    public void testEnvioDeMensagem() {
        // Alice envia uma mensagem
        usuario1.enviarMensagem("Olá, pessoal!");

        String resultadoEsperado = "Alice enviou: Olá, pessoal!\n" +
                "Bob recebeu: Olá, pessoal!\n" +
                "Carlos recebeu: Olá, pessoal!\n";
        assertTrue(saidaCapturada.toString().contains(resultadoEsperado));
    }

    @Test
    public void testEnvioDeResposta() {
        // Bob responde com outra mensagem
        usuario2.enviarMensagem("Oi, Alice!");

        String resultadoEsperado = "Bob enviou: Oi, Alice!\n" +
                "Alice recebeu: Oi, Alice!\n" +
                "Carlos recebeu: Oi, Alice!\n";
        assertTrue(saidaCapturada.toString().contains(resultadoEsperado));
    }
}
