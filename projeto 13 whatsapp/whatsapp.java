
class Mensagem{
    String mensagem;
    String nome;
    Mensagem(String nome, String mensagem){
        this.nome = nome;
        this.mensagem = mensagem;
    }
    public String toString(){
        String to = "[" + this.mensagem + ": " + this.nome + "]";
        return to;
    }
}
//CRIAR GRUPO
class Notificacao{
    int notificacoes;
    String grupo;
    Notificacao(String grupo){
        this.grupo = grupo;
        this.notificacoes = 0;
    }
    void addNotificacao(){
        notificacoes += 1;
    }
    void cleanNotificacoes(){
        notificacoes = 0;
    }
    public String toString(){
        String aux = grupo + " ";
        aux += "(" + notificacoes + ")";
        return aux;
    }
}
//FAZER INTERAÇÃO
//MAPA