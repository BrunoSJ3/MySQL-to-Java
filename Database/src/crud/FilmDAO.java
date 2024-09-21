
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO: Data Access Object
public class FilmDAO

{
    public Connection con;
    private final MySQL_Connection db;

    public FilmDAO(MySQL_Connection db)

    {
        this.db = db;
    }

    public boolean create(FilmeModel filme) throws SQLException // obrigatorio verificar se deu exception na assinatura
                                                                // do SQL

    {
        Connection con = db.con;

        if (con == null)

        {
            return false;
        }

        // são 5 pontos de ? por que são 5 linhas
        String cmdSQL = "INSERT INTO filmes(codigo,titulo,genero,produtora,dataCompra) VALUES(?,?,?,?,?,)";
        PreparedStatement ps = con.prepareStatement(cmdSQL);
        ps.setString(1, filme.getCodigo());// o ínice é das informações das linhas
        ps.setString(2, filme.getTitulo());
        ps.setString(3, filme.getGenero());
        ps.setString(4, filme.getProdutora());
        ps.setDate(5, filme.getDataCompra());

        int modifiedLines = ps.executeUpdate();
        ps.close();
        // con.close(); Não podemos fechar aqui porém deve ser fechado em algum momento
        System.out.println("Filme criado com sucesso!");
        return modifiedLines > 0;

    }

    public List<FilmeModel> read() throws SQLException {
        List filmeList = new ArrayList<>();
        Connection con = db.con;
        if (con == null)

        {
            return filmeList;
        }

        String cmdSQL = "SELECT * FROM filmes";
        PreparedStatement ps = con.prepareStatement(cmdSQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next())

        {
            FilmeModel filme = new FilmeModel(rs.getString("codigo"), rs.getString("titulo"), rs.getString("genero"),
                    rs.getString("produtora"), rs.getDate("dataCompra"));

            filmeList.add(filme);
        }
        rs.close();
        ps.close();
        // con.close();
        return filmeList;
    }

    public void update()

    {

    }

    public boolean delete(String codigo) throws SQLException

    {
        Connection con = db.con;
        if (con == null)

        {
            return false;
        }

        String cmdSQL = "DELETE FROM filmes WHERE codigo = ?";
        PreparedStatement ps = con.prepareStatement(cmdSQL);
        ps.setString(1, codigo);
        int modifiedLines = ps.executeUpdate();
        ps.close();
        // con.close();
        return modifiedLines > 0;
    }
}
