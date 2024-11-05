import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
    private List<Usuario> usuarios;

    public ChatMediatorImpl() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario usuario) {
        for (Usuario u : this.usuarios) {
            if (u != usuario) {
                u.receberMensagem(mensagem);
            }
        }
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}
