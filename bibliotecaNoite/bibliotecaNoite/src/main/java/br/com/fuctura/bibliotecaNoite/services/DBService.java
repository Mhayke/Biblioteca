package br.com.fuctura.bibliotecaNoite.services;

import br.com.fuctura.bibliotecaNoite.enuns.Tamanho;
import br.com.fuctura.bibliotecaNoite.models.Categoria;
import br.com.fuctura.bibliotecaNoite.models.Livro;
import br.com.fuctura.bibliotecaNoite.repositories.CategoriaRepository;
import br.com.fuctura.bibliotecaNoite.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaDB() {

        Categoria cat1 = new Categoria(null, "Arte", "Livros sobre arte e cultura");
        Categoria cat2 = new Categoria(null, "Autoajuda", "Livros de desenvolvimento pessoal");
        Categoria cat3 = new Categoria(null, "Biografia", "Livros de biografias");
        Categoria cat4 = new Categoria(null, "Ciências", "Livros sobre ciências naturais");
        Categoria cat5 = new Categoria(null, "Direito", "Livros sobre legislação e direito");
        Categoria cat6 = new Categoria(null, "Economia", "Livros sobre economia e finanças");
        Categoria cat7 = new Categoria(null, "Fantasia", "Livros de fantasia e mundos imaginários");
        Categoria cat8 = new Categoria(null, "Ficção científica", "Livros de ficção científica");
        Categoria cat9 = new Categoria(null, "Gastronomia", "Livros sobre culinária e gastronomia");
        Categoria cat10 = new Categoria(null, "História", "Livros sobre eventos históricos");
        Categoria cat11 = new Categoria(null, "Infantil", "Livros para crianças");
        Categoria cat12 = new Categoria(null, "Informática", "Livros de tecnologia e programação");
        Categoria cat13 = new Categoria(null, "Mangá", "Livros de mangá japoneses");
        Categoria cat14 = new Categoria(null, "Música", "Livros sobre teoria musical");
        Categoria cat15 = new Categoria(null, "Psicologia", "Livros sobre comportamento humano");
        Categoria cat16 = new Categoria(null, "Religião", "Livros sobre espiritualidade e religiões");
        Categoria cat17 = new Categoria(null, "Romance", "Livros de romance");
        Categoria cat18 = new Categoria(null, "Terror", "Livros de terror");
        Categoria cat19 = new Categoria(null, "Turismo", "Livros de viagens e guias turísticos");
        Categoria cat20 = new Categoria(null, "Saúde", "Livros sobre medicina");

// Categoria: Arte
        Livro l1 = new Livro(null, Tamanho.MEDIO, cat1, "Uma jornada pela evolução artística", "E.H. Gombrich", "História da Arte");
        Livro l2 = new Livro(null, Tamanho.GRANDE, cat1, "Análise de obras-primas", "Simon Schama", "O Poder da Arte");
// Categoria: Autoajuda
        Livro l3 = new Livro(null, Tamanho.PEQUENO, cat2, "Como transformar hábitos", "Charles Duhigg", "O Poder do Hábito");
        Livro l4 = new Livro(null, Tamanho.MEDIO, cat2, "A nova psicologia do sucesso", "Carol S. Dweck", "Mindset");
// Categoria: Biografia
        Livro l5 = new Livro(null, Tamanho.GRANDE, cat3, "A vida do fundador da Apple", "Walter Isaacson", "Steve Jobs");
        Livro l6 = new Livro(null, Tamanho.GRANDE, cat3, "Biografia do gênio da física", "Walter Isaacson", "Einstein: Sua Vida, Seu Universo");
// Categoria: Ciências
        Livro l7 = new Livro(null, Tamanho.MEDIO, cat4, "Uma viagem pelo universo", "Carl Sagan", "Cosmos");
        Livro l8 = new Livro(null, Tamanho.PEQUENO, cat4, "Reflexões sobre ciência", "Stephen Hawking", "Breves Respostas para Grandes Questões");
// Categoria: Direito
        Livro l9 = new Livro(null, Tamanho.GRANDE, cat5, "Fundamentos do direito brasileiro", "Alexandre de Moraes", "Direito Constitucional");
        Livro l10 = new Livro(null, Tamanho.MEDIO, cat5, "Princípios e legislação penal", "Luiz Regis Prado", "Manual de Direito Penal");
// Categoria: Economia
        Livro l11 = new Livro(null, Tamanho.PEQUENO, cat6, "Economia do cotidiano", "Steven D. Levitt", "Freakonomics");
        Livro l12 = new Livro(null, Tamanho.GRANDE, cat6, "Análise sobre desigualdade", "Thomas Piketty", "O Capital no Século XXI");
// Categoria: Fantasia
        Livro l13 = new Livro(null, Tamanho.GRANDE, cat7, "A jornada do Um Anel", "J.R.R. Tolkien", "O Senhor dos Anéis");
        Livro l14 = new Livro(null, Tamanho.MEDIO, cat7, "O início da saga do bruxo", "J.K. Rowling", "Harry Potter e a Pedra Filosofal");
// Categoria: Ficção Científica
        Livro l15 = new Livro(null, Tamanho.GRANDE, cat8, "Uma aventura espacial", "Frank Herbert", "Duna");
        Livro l16 = new Livro(null, Tamanho.MEDIO, cat8, "Um clássico distópico", "George Orwell", "1984");
// Categoria: Gastronomia
        Livro l17 = new Livro(null, Tamanho.MEDIO, cat9, "Receitas e técnicas", "Ramsay Gordon", "Comida, Cozinha & Co.");
        Livro l18 = new Livro(null, Tamanho.PEQUENO, cat9, "Sabores do Brasil", "Ana Luiza Trajano", "Cozinha Brasileira");
// Categoria: História
        Livro l19 = new Livro(null, Tamanho.MEDIO, cat10, "Uma breve história da humanidade", "Yuval Noah Harari", "Sapiens");
        Livro l20 = new Livro(null, Tamanho.GRANDE, cat10, "O fim do Império Bizantino", "Steven Runciman", "A Queda de Constantinopla");
// Categoria: Infantil
        Livro l21 = new Livro(null, Tamanho.PEQUENO, cat11, "Uma fábula sobre amizade", "Antoine de Saint-Exupéry", "O Pequeno Príncipe");
        Livro l22 = new Livro(null, Tamanho.MEDIO, cat11, "Aventuras de Alice", "Lewis Carroll", "Alice no País das Maravilhas");
// Categoria: Informática
        Livro l23 = new Livro(null, Tamanho.GRANDE, cat12, "Lorem ipsum", "Louis V. Gerstner", "Engenharia de Software");
        Livro l24 = new Livro(null, Tamanho.MEDIO, cat12, "Boas práticas de programação", "Robert C. Martin", "Código Limpo");
// Categoria: Mangá
        Livro l25 = new Livro(null, Tamanho.PEQUENO, cat13, "Um jogo de inteligência e morte", "Tsugumi Ohba", "Death Note");
        Livro l26 = new Livro(null, Tamanho.MEDIO, cat13, "Humanos contra titãs", "Hajime Isayama", "Attack on Titan");
// Categoria: Música
        Livro l27 = new Livro(null, Tamanho.MEDIO, cat14, "Evolução do gênero musical", "Andrew Chester", "A História do Rock");
        Livro l28 = new Livro(null, Tamanho.PEQUENO, cat14, "Biografia do compositor", "Peter Gay", "Mozart: O Gênio da Música");
// Categoria: Psicologia
        Livro l29 = new Livro(null, Tamanho.MEDIO, cat15, "Análise do inconsciente", "Carl Jung", "O Homem e Seus Símbolos");
        Livro l30 = new Livro(null, Tamanho.PEQUENO, cat15, "Como lidar com emoções", "Daniel Goleman", "Inteligência Emocional");
// Categoria: Religião
        Livro l31 = new Livro(null, Tamanho.GRANDE, cat16, "Texto sagrado do Islã", "Tradução de Mansour Challita", "O Alcorão");
        Livro l32 = new Livro(null, Tamanho.GRANDE, cat16, "Livro sagrado do Cristianismo", "Vários autores", "Bíblia Sagrada");
// Categoria: Romance
        Livro l33 = new Livro(null, Tamanho.MEDIO, cat17, "Um clássico do romance", "Jane Austen", "Orgulho e Preconceito");
        Livro l34 = new Livro(null, Tamanho.PEQUENO, cat17, "Uma história de amor e superação", "John Green", "A Culpa é das Estrelas");
// Categoria: Suspense
        Livro l35 = new Livro(null, Tamanho.MEDIO, cat18, "Um thriller psicológico", "Thomas Harris", "O Silêncio dos Inocentes");
        Livro l36 = new Livro(null, Tamanho.PEQUENO, cat18, "Mistério e reviravoltas", "Gillian Flynn", "Garota Exemplar");
// Categoria: Turismo
        Livro l37 = new Livro(null, Tamanho.MEDIO, cat19, "Destinos imperdíveis", "Patricia Schultz", "100 Lugares para Conhecer Antes de Morrer");
        Livro l38 = new Livro(null, Tamanho.PEQUENO, cat19, "Dicas para mochileiros", "Alexandre Nobumoto", "Europa de Mochila");
// Categoria: Saúde
        Livro l39 = new Livro(null, Tamanho.MEDIO, cat20, "Uma viagem pelo organismo", "Bill Bryson", "O Corpo Humano");
        Livro l40 = new Livro(null, Tamanho.GRANDE, cat20, "Referência em clínica médica", "Harrison", "Medicina Interna");


        // Associando livros às categorias
        cat1.getLivros().addAll(Arrays.asList(l1, l2));
        cat2.getLivros().addAll(Arrays.asList(l3, l4));
        cat3.getLivros().addAll(Arrays.asList(l5, l6));
        cat4.getLivros().addAll(Arrays.asList(l7, l8));
        cat5.getLivros().addAll(Arrays.asList(l9, l10));
        cat6.getLivros().addAll(Arrays.asList(l11, l12));
        cat7.getLivros().addAll(Arrays.asList(l13, l14));
        cat8.getLivros().addAll(Arrays.asList(l15, l16));
        cat9.getLivros().addAll(Arrays.asList(l17, l18));
        cat10.getLivros().addAll(Arrays.asList(l19, l20));
        cat11.getLivros().addAll(Arrays.asList(l21, l22));
        cat12.getLivros().addAll(Arrays.asList(l23, l24));
        cat13.getLivros().addAll(Arrays.asList(l25, l26));
        cat14.getLivros().addAll(Arrays.asList(l27, l28));
        cat15.getLivros().addAll(Arrays.asList(l29, l30));
        cat16.getLivros().addAll(Arrays.asList(l31, l32));
        cat17.getLivros().addAll(Arrays.asList(l33, l34));
        cat18.getLivros().addAll(Arrays.asList(l35, l36));
        cat19.getLivros().addAll(Arrays.asList(l37, l38));
        cat20.getLivros().addAll(Arrays.asList(l39, l40));

        // Salvando categorias e livros no repositório
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10,
                cat11, cat12, cat13, cat14, cat15, cat16, cat17, cat18, cat19, cat20));

        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10,
                l11, l12, l13, l14, l15, l16, l17, l18, l19, l20,
                l21, l22, l23, l24, l25, l26, l27, l28, l29, l30,
                l31, l32, l33, l34, l35, l36, l37, l38, l39, l40));
    }

}
