import static java.net.http.HttpRequest.newBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Conexão http
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_3fw06h3k";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);  // URI HIERARQUICA
        var client = HttpClient.newHttpClient();
        HttpRequest request = newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        // System.out.println(body);

        //  extrair so os dados importantes (titulo, poster, classficação, rank e votos)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // System.out.println(listaDeFilmes.size());
        // System.out.println(listaDeFilmes.get(1));
        
        // manipular os dados e exibir
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\033[1;32m\033[0;32m Rank# " + filme.get("rank"));
            System.out.println(filme.get("title"));
            System.out.println("\033[0;92m\033[4;34m\033[1;34m\033[0;34mPoster: " + filme.get("image"));            
            System.out.println("\u001b[37m\u001b[45m\033[1;34mClassficação:\u001b[m" + filme.get("imDbRating"));        
            System.out.println("\033[0;33mVotos: " + filme.get("imDbRatingCount"));
            
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            int numeroEstrelinhas = (int) classificacao;

            for (int n = 1; n <= numeroEstrelinhas; n++) {
                System.out.print("⭐");
                
            }
            System.out.println("\n");
            System.out.println("\033[0;37m __________________________________________________________________________________________");

        }


    }
}
