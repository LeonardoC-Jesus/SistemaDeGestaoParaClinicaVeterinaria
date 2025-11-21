package dao;

import banco.BancoConexao;
import model.Email;
import model.Endereco;
import model.ProprietarioAnimal;
import model.Telefone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioAnimalDAO {

    private String sql;
    private Connection conn;
    private PreparedStatement statement ;

    private PreparedStatement prepararSetenca(String sql) throws SQLException {
        this.conn = BancoConexao.getConexao();
        if (this.conn == null) {
            throw new RuntimeException("Conexão retornou nula!");
        }
        return this.conn.prepareStatement(sql);
    }


    public void inserirPropietario(ProprietarioAnimal p) {
        String sqlProprietario = "INSERT INTO proprietarios (nome, cpf) VALUES (?, ?)";
        String sqlEndereco = "INSERT INTO endereco (rua, bairro, cidade, numero_casa) VALUES (?, ?, ?, ?)";
        String sqlRelacao = "INSERT INTO proprietarios_endereco (id_proprietarios, id_endereco) VALUES (?, ?)";
        String sqlTelefone = "INSERT INTO telefone (ddi, ddd, prefixo, numero, id_proprietarios) VALUES (?, ?, ?, ?, ?)";
        String sqlEmail = "INSERT INTO email (email, id_proprietarios) VALUES (?, ?)";

        try {
            Connection conn = BancoConexao.getConexao();
            conn.setAutoCommit(false);

            // proprietario

            PreparedStatement pstmt = conn.prepareStatement(sqlProprietario, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, p.getNome());
            pstmt.setString(2, p.getCpf());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            long idProprietario = rs.getLong(1);

            // endereço

            PreparedStatement psEnd = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            psEnd.setString(1, p.getEndereco().getRua());
            psEnd.setString(2, p.getEndereco().getBairro());
            psEnd.setString(3, p.getEndereco().getCidade());
            psEnd.setInt(4, p.getEndereco().getNumero_casa());
            psEnd.executeUpdate();

            ResultSet rsEnd = psEnd.getGeneratedKeys();
            rsEnd.next();
            long idEndereco = rsEnd.getLong(1);

            // Relacionar

            PreparedStatement psRelacao = conn.prepareStatement(sqlRelacao);
            psRelacao.setLong(1, idProprietario);
            psRelacao.setLong(2, idEndereco);
            psRelacao.executeUpdate();

            // telefone

            PreparedStatement psTel = conn.prepareStatement(sqlTelefone);
            psTel.setInt(1, p.getTelefone().getDdi());
            psTel.setInt(2, p.getTelefone().getDdd());
            psTel.setInt(3, p.getTelefone().getPrefixo());
            psTel.setInt(4, p.getTelefone().getNumero());
            psTel.setLong(5, idProprietario);
            psTel.executeUpdate();

            // email

            PreparedStatement psEmail = conn.prepareStatement(sqlEmail);
            psEmail.setString(1, p.getEmail().getEnderecoEmail());
            psEmail.setLong(2, idProprietario);
            psEmail.executeUpdate();

            conn.commit();
            conn.close();

        } catch (Exception e) {
            System.out.println("Erro ao inserir Propietário");
            throw new RuntimeException(e);
        }
    }


    public List<ProprietarioAnimal> listaPropietario() {

        sql = "SELECT p.id, p.nome, p.cpf, t.ddi, t.ddd, t.prefixo, t.numero, e.email, ende.rua, " +
                " ende.bairro, ende.cidade, ende.numero_casa " +
                "FROM proprietarios p " +
                "INNER JOIN telefone t ON (p.id = t.id_proprietario)  " +
                "INNER JOIN email e ON (p.id = e.id_proprietario)  " +
                "INNER JOIN proprietarios_endereco pe ON pe.id_proprietarios = p.id" +
                "INNER JOIN endereco ende ON ende.id = pe.id_endereco;";
        List<ProprietarioAnimal> lista = new ArrayList<>();

        try{
            Connection conn = BancoConexao.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ProprietarioAnimal p = new ProprietarioAnimal(
                        rs.getLong("id"),
                        rs.getString("cpf"),
                        rs.getString("nome")
                );

                // Email
                Email email = new Email(
                        rs.getString("email")
                );

                // Telefone
                Telefone telefone = new Telefone(
                        rs.getInt("ddi"),
                        rs.getInt("ddd"),
                        rs.getInt("prefixo"),
                        rs.getInt("numero")
                );

                // Endereço
                Endereco endereco = new Endereco(
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getInt("numero_casa")
                );
                p.setEmail(email);
                p.setTelefone(telefone);
                p.setEndereco(endereco);

                lista.add(p);
            }

            conn.close();
            return lista;

        }catch (Exception e) {
            System.out.println("Erro ao listar proprietários");
            throw new RuntimeException(e);
        }
    }

    public void atualizarPropietario(ProprietarioAnimal p) throws SQLException {

        sql = "UPDATE proprietarios SET nome=? WHERE cpf=?";

        try {
            Connection conn = BancoConexao.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            statement = prepararSetenca(sql);
            statement.setString(1, p.getNome());
            statement.setInt(2, p.getTelefone().getDdi());
            statement.setInt(3, p.getTelefone().getDdd());
            statement.setInt(4, p.getTelefone().getPrefixo());
            statement.setInt(5, p.getTelefone().getNumero());
            statement.setString(6, p.getEmail().getEnderecoEmail());
            statement.setString(7, p.getCpf());
            statement.executeUpdate();
            System.out.println("Proprietário atualizado!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar proprietário");
            throw new RuntimeException(e);
        }
    }


    public void deletarPropietario(String cpf) throws SQLException {

        sql = "DELETE FROM propietarios WHERE cpf=?";

        try {
            Connection conn = BancoConexao.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sql);
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
