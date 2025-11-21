package dao;

import banco.BancoConexao;
import model.Endereco;
import model.PropretarioAnimal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioAnimalDAO {

    private String sql;
    private Connection conn;
    private PreparedStatement statement;

    private PreparedStatement prepararSetenca(String sql) {
        try{
            this.conn = BancoConexao.getConexao();
            assert conn != null;
            this.statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            return this.statement;
        }catch (Exception e) {
            System.out.println("Erro ao preparar sequencia SQL");
            throw new RuntimeException(e);
        }
    }


    public void inserirPropietario(PropretarioAnimal p) {
        String sql = "INSERT INTO propietarionome, cpf, telefone, email, rua, bairro, cidade, numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = prepararSetenca(sql);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getCpf());
            statement.setString(3, p.getTelefone());
            statement.setString(4, p.getEmail());
            statement.setString(5, p.getEndereco().getRua());
            statement.setString(6, p.getEndereco().getBairro());
            statement.setString(7, p.getEndereco().getCidade());
            statement.setInt(8, p.getEndereco().getNumero());
            statement.execute();
            System.out.println("Proprietário inserido!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir Propietário");
            throw new RuntimeException(e);
        }
    }


    public List<PropretarioAnimal> listaPropietario() {

        sql = "SELECT nome,cpf,t.ddi t.ddd, t.prefixo, t.numero, e.email, ende.rua, " +
                " ende.bairro, ende.cidade, ende.numero_casa " +
                "FROM FROM proprietarios p " +
                "INNER JOIN telefone t ON (p.id = t.id_proprietarios)  " +
                "INNER JOIN email e ON (p.id = e.id_proprietarios)  " +
                "INNER JOIN endereco ende ON (p.id = ende.id);";
        List<PropretarioAnimal> lista = new ArrayList<>();

        try{
            conn = BancoConexao.getConexao();
            assert conn != null;
            statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Endereco end = new Endereco(
                        rs.getString("rua"),
                        rs.getString("Bairro"),
                        rs.getString("cidade"),
                        rs.getInt("Numero")
                );

                PropretarioAnimal p = new PropretarioAnimal(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        end
                );

                lista.add(p);
            }

            return lista;

        }catch (Exception e) {
            System.out.println("Erro ao listar proprietários");
            throw new RuntimeException(e);
        }
    }

    public void atualizarPropietario(PropretarioAnimal p) {
        sql = "UPDATE proprietario SET nome=?, telefone=?, email=? WHERE cpf=?";

        try {
            statement = prepararSetenca(sql);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getTelefone());
            statement.setString(3, p.getEmail());
            statement.setString(4, p.getCpf());
            statement.executeUpdate();
            System.out.println("Proprietário atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar proprietário");
            throw new RuntimeException(e);
        }
    }


    public void deletarPropietario(String cpf) {
        sql = "DELETE FROM propietario WHERE cpf=?";

        try {
            statement = prepararSetenca(sql);
            statement.setString(1, cpf);
            statement.executeUpdate();
            System.out.println("Propietário deletado!");
        }catch (Exception e){
            System.out.println("Erro ao deletar propietário.");
            throw new RuntimeException(e);
        }
    }
}
