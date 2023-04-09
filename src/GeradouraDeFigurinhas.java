import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradouraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // Leitura da imagem  (O Polimorfismo é um mecanismo por meio do qual selecionamos as funcionalidades utilizadas de forma dinâmica por um programa no decorrer de sua execução.)
        // BufferedImage imagemOrigem = ImageIO.read(new File("entrada/TopMovies_1.jpg"));
        // InputStream inputStream = new FileInputStream(new File("entrada/TopMovies_1.jpg"));
        // BufferedImage imagemOrigem = ImageIO.read(inputStream);
        // InputStream inputStream = new 
        // URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg")
        // .openStream();
        BufferedImage imagemOrigem = ImageIO.read(inputStream);

        // Criar nova imagem, com transparencia, tamanho novo
        int largura = imagemOrigem.getWidth();
        int altura = imagemOrigem.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original pra nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOrigem, 0,0, null );

         // Configurar a fonte e cor (Isso é setar a fonte)
         var fonte = new Font(Font.SANS_SERIF,Font.BOLD, 80);
        graphics.setFont(fonte);
        graphics.setColor(Color.ORANGE);

        //  Escrever uma frase na nova imagem
        graphics.drawString("Imersão", 50 ,novaAltura -120 );
        graphics.drawString("das", 50 ,novaAltura -50 );
        graphics.drawString("Galaxias", 230 ,novaAltura -20);
       
        // Escrever  a nova imagem  em  um arquivo
        // ImageIO.write(novaImagem, formatName: "png", new File("saida/figurinha.png"));
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }
    
}
