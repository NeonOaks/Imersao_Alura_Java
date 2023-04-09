import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {

     public List<Conteudo> extratorConteudos(String json) {

           //  extrair so os dados importantes (titulo, poster, classficação, rank e votos)
           var parser = new JsonParser();
           List<Map<String, String>> listDeAtributos = parser.parse(json);
           // System.out.println(listaDeFilmes.size());
           // System.out.println(listaDeFilmes.get(1));

          List<Conteudo>  conteudos = new ArrayList<>();
            
          // popular a lista de conteudos
            for (Map<String, String> atributos : listDeAtributos) {
                String titulo = atributos.get("title");
                String urlImagem = atributos.get("image");
                // .replaceAll("(@+)(.*).jpg$", "$1.jpg");; pegar imagem maior no link da appi do imbdb
                
                var conteudo = new Conteudo(titulo, urlImagem);

                conteudos.add(conteudo);
                
            }
          

            return conteudos;
     }

    
}
