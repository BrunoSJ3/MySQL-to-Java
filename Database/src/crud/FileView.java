import java.util.Scanner;
import java.sql.Date;

public class FileView

{
    public static void main(String[] args)

    {
        MySQL_Connection db = new MySQL_Connection();

        try {
            if (!db.getConnection())

            {
                System.out.println("Erro ao conectar ao banco de dados!");
                return;
            }
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        FilmDAO filmDAO = new FilmDAO(db);

        FilmController filmController = new FilmController(filmDAO);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar um novo filme");
            System.out.println("2 - Listar todos os filmes");
            System.out.println("3 - Editar um filme");
            System.out.println("4 - Excluir um filme");
            System.out.println("0 - Sair");

            System.out.println("Digite sua opção");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
            case 0 -> {
                System.out.println("Programa finalizado.");
                db.closeConnection();
                sc.close();
                System.exit(0);
            }
            case 1 ->

            {
                System.out.println("Digite o código do filme");
                String codigo = sc.nextLine();
                System.out.println("Digite o título do filme");
                String titulo = sc.nextLine();
                System.out.println("Digite o gênero do filme");
                String genero = sc.nextLine();
                System.out.println("Digite a produtora do filme");
                String produtora = sc.nextLine();
                System.out.println("Digite a data de compra do filme (formato dd/MM/yyyy)");
                Date dataCompra = Date.valueOf(sc.nextLine());
                FilmeModel filme = new FilmeModel(codigo, titulo, genero, produtora, dataCompra);
                filmController.createFilm(filme);
            }
            case 2 ->

            {
                filmController.readFilm();
            }
            case 3 ->

            {
                System.out.println("Digite o código do filme que deseja editar");
                String codigo = sc.nextLine();
                System.out.println("Digite o novo título do filme");
                String titulo = sc.nextLine();
                System.out.println("Digite o novo gênero do filme");
                String genero = sc.nextLine();
                System.out.println("Digite a nova produtora do filme");
                String produtora = sc.nextLine();
                System.out.println("Digite a nova data de compra do filme (formato dd/MM/yyyy)");
                Date dataCompra = Date.valueOf(sc.nextLine());
                // FilmeModel filme = new FilmeModel(codigo, titulo, genero, produtora,
                // dataCompra);
                // filmController.updateFilm(filme);

            }

            case 4 ->

            {
                System.out.println("Digite o código do filme que deseja deletar");
                String codigo = sc.nextLine();
                filmController.deleteFilm(codigo);
            }

            default -> System.out.println("Opção inválida! Tente novamente.");

            }

        }
    }
}
