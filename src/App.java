import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

                 // Conexão http
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_3fw06h3k";
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
               
        String url = "https://api.nasa.gov/planetary/apod?api_key=tpaEehAuXabi8iL8LOhHr1rnZaaOcbRNbFoGF2Wh&start_date=2022-06-12&end_date=2022-06-14";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        // var http = new ClienteHttp();
        String json = http.buscaDados(url);sfsdfsdfsdfsdfsdfs

       
        List<Conteudo> conteudos = extrator.extratorConteudos(json);
        
        // manipular os dados e exibir
        var geradoura = new GeradouraDeFigurinhas();
        
        // Map<String, String>[] listaDeConteudos;
        // for (Map<String,String> conteudo : listaDeConteudos) {}
           for (int i = 0; i < 10; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "Stikers/" + conteudo.getTitulo() + ".png";

            // String nomeArquivo = titulo + ".png";            
            geradoura.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
            

           }
            
                 
    }
}
