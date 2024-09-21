import java.sql.SQLException;
import java.util.List;

//O feedback que o programa irá dar ao usuário será aqui... 
//se: a funcionalidade for sucedida, não sucedida e der erro no banco de dados.

public class FilmController

{
    private final FilmDAO filmDAO;

    public FilmController(FilmDAO filmDAO)

    {
        this.filmDAO = filmDAO;
    }

    public void createFilm(FilmeModel filme) {

        try {
            if (filmDAO.create(filme)) {
                System.out.println("Filme criado com sucesso!");
            } else {
                System.out.println("Erro ao criar o filme!");
            }
        } catch (SQLException e) {
            System.out.println("Erro na base de dados: " + e.getMessage());
        }
    }

    public void readFilm() {
        try {
            List<FilmeModel> filmes = filmDAO.read();
            if (filmes.isEmpty()) {
                System.out.println("Nenhum filme cadastrado!");
            } else {
                System.out.println("Listagem de filmes:");
                for (FilmeModel arrTemp : filmes) {
                    System.out.println("arrTemp");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na base de dados:" + e.getMessage());
        }
    }

    public void updateFilm() {
    }

    public void deleteFilm(String codigo) {
        try {
            if (filmDAO.delete(codigo)) {
                System.out.println("Filme deletado com sucesos");
            } else {
                System.out.println("Erro ao deletar o filme!");
            }
        } catch (SQLException e) {
            System.out.println("Erro da base de dados:" + e.getMessage());
        }
    }
}
