public class UsuarioImpl extends Usuario {

    public UsuarioImpl(ChatMediator mediator, String nome) {
        super(mediator, nome);
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println(this.nome + " enviou: " + mensagem);
        mediator.enviarMensagem(mensagem, this);
    }

    @Override
    public void receberMensagem(String mensagem) {
        System.out.println(this.nome + " recebeu: " + mensagem);
    }
}
