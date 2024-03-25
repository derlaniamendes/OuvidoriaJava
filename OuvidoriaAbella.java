package projetoOuvidoria;


import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ouvidoria {
    // ArrayList para armazenar as manifestações
    private ArrayList<Manifestacao> manifestacoes;

    // Construtor da classe
    public Ouvidoria() {
        manifestacoes = new ArrayList<>();
    }

    // Método para listar todas as manifestações
    public void listarManifestacoes() {
        if (manifestacoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há manifestações cadastradas.");
        } else {
            StringBuilder lista = new StringBuilder();
            for (Manifestacao manifestacao : manifestacoes) {
                lista.append(manifestacao.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }

    // Método para adicionar uma nova manifestação
    public void adicionarManifestacao() {
        String descricao = JOptionPane.showInputDialog("Digite a descrição da manifestação:");
        String autor = JOptionPane.showInputDialog("Digite o nome do autor da manifestação:");
        Manifestacao novaManifestacao = new Manifestacao(descricao, autor);
        manifestacoes.add(novaManifestacao);
        JOptionPane.showMessageDialog(null, "Manifestação adicionada com sucesso.");
    }

    // Método para pesquisar uma manifestação por código
    public void pesquisarManifestacaoPorCodigo() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da manifestação:"));
        boolean encontrada = false;
        for (Manifestacao manifestacao : manifestacoes) {
            if (manifestacao.getCodigo() == codigo) {
                JOptionPane.showMessageDialog(null, manifestacao.toString());
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "Manifestação não encontrada.");
        }
    }

    // Método para remover uma manifestação pelo código
    public void removerManifestacaoPorCodigo() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da manifestação a ser removida:"));
        boolean removida = false;
        for (int i = 0; i < manifestacoes.size(); i++) {
            if (manifestacoes.get(i).getCodigo() == codigo) {
                manifestacoes.remove(i);
                JOptionPane.showMessageDialog(null, "Manifestação removida com sucesso.");
                removida = true;
                break;
            }
        }
        if (!removida) {
            JOptionPane.showMessageDialog(null, "Manifestação não encontrada.");
        }
    }

    // Método principal para executar o programa
    public static void main(String[] args) {
        Ouvidoria ouvidoria = new Ouvidoria();
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n"
                    + "1 - Listar manifestações\n"
                    + "2 - Adicionar manifestação\n"
                    + "3 - Pesquisar manifestação por código\n"
                    + "4 - Remover manifestação por código\n"
                    + "5 - Sair do sistema"));
            switch (opcao) {
                case 1:
                    ouvidoria.listarManifestacoes();
                    break;
                case 2:
                    ouvidoria.adicionarManifestacao();
                    break;
                case 3:
                    ouvidoria.pesquisarManifestacaoPorCodigo();
                    break;
                case 4:
                    ouvidoria.removerManifestacaoPorCodigo();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opcao != 5);
    }
}

// Classe Manifestação para representar cada manifestação
class Manifestacao {
    private static int proximoCodigo = 1;
    private int codigo;
    private String descricao;
    private String autor;

    // Construtor da classe
    public Manifestacao(String descricao, String autor) {
        this.codigo = proximoCodigo++;
        this.descricao = descricao;
        this.autor = autor;
    }

    // Métodos para obter informações da manifestação
    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\nDescrição: " + descricao + "\nAutor: " + autor;
    }
}

