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
        Livro l1 = new Livro(null, "História da Arte", "E.H. Gombrich", "Uma jornada pela evolução artística", Tamanho.MEDIO, cat1);
        Livro l2 = new Livro(null, "O Poder da Arte", "Simon Schama", "Análise de obras-primas", Tamanho.GRANDE, cat1);
        // Categoria: Autoajuda
        Livro l3 = new Livro(null, "O Poder do Hábito", "Charles Duhigg", "Como transformar hábitos", Tamanho.PEQUENO, cat2);
        Livro l4 = new Livro(null, "Mindset", "Carol S. Dweck", "A nova psicologia do sucesso", Tamanho.MEDIO, cat2);
        // Categoria: Biografia
        Livro l5 = new Livro(null, "Steve Jobs", "Walter Isaacson", "A vida do fundador da Apple", Tamanho.GRANDE, cat3);
        Livro l6 = new Livro(null, "Einstein: Sua Vida, Seu Universo", "Walter Isaacson", "Biografia do gênio da física", Tamanho.GRANDE, cat3);
        // Categoria: Ciências
        Livro l7 = new Livro(null, "Cosmos", "Carl Sagan", "Uma viagem pelo universo", Tamanho.MEDIO, cat4);
        Livro l8 = new Livro(null, "Breves Respostas para Grandes Questões", "Stephen Hawking", "Reflexões sobre ciência", Tamanho.PEQUENO, cat4);
        // Categoria: Direito
        Livro l9 = new Livro(null, "Direito Constitucional", "Alexandre de Moraes", "Fundamentos do direito brasileiro", Tamanho.GRANDE, cat5);
        Livro l10 = new Livro(null, "Manual de Direito Penal", "Luiz Regis Prado", "Princípios e legislação penal", Tamanho.MEDIO, cat5);
        // Categoria: Economia
        Livro l11 = new Livro(null, "Freakonomics", "Steven D. Levitt", "Economia do cotidiano", Tamanho.PEQUENO, cat6);
        Livro l12 = new Livro(null, "O Capital no Século XXI", "Thomas Piketty", "Análise sobre desigualdade", Tamanho.GRANDE, cat6);
        // Categoria: Fantasia
        Livro l13 = new Livro(null, "O Senhor dos Anéis", "J.R.R. Tolkien", "A jornada do Um Anel", Tamanho.GRANDE, cat7);
        Livro l14 = new Livro(null, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "O início da saga do bruxo", Tamanho.MEDIO, cat7);
        // Categoria: Ficção Científica
        Livro l15 = new Livro(null, "Duna", "Frank Herbert", "Uma aventura espacial", Tamanho.GRANDE, cat8);
        Livro l16 = new Livro(null, "1984", "George Orwell", "Um clássico distópico", Tamanho.MEDIO, cat8);
        // Categoria: Gastronomia
        Livro l17 = new Livro(null, "Comida, Cozinha & Co.", "Ramsay Gordon", "Receitas e técnicas", Tamanho.MEDIO, cat9);
        Livro l18 = new Livro(null, "Cozinha Brasileira", "Ana Luiza Trajano", "Sabores do Brasil", Tamanho.PEQUENO, cat9);
        // Categoria: História
        Livro l19 = new Livro(null, "Sapiens", "Yuval Noah Harari", "Uma breve história da humanidade", Tamanho.MEDIO, cat10);
        Livro l20 = new Livro(null, "A Queda de Constantinopla", "Steven Runciman", "O fim do Império Bizantino", Tamanho.GRANDE, cat10);
        // Categoria: Infantil
        Livro l21 = new Livro(null, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Uma fábula sobre amizade", Tamanho.PEQUENO, cat11);
        Livro l22 = new Livro(null, "Alice no País das Maravilhas", "Lewis Carroll", "Aventuras de Alice", Tamanho.MEDIO, cat11);
        // Categoria: Informática
        Livro l23 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", Tamanho.GRANDE, cat12);
        Livro l24 = new Livro(null, "Código Limpo", "Robert C. Martin", "Boas práticas de programação", Tamanho.MEDIO, cat12);
        // Categoria: Mangá
        Livro l25 = new Livro(null, "Death Note", "Tsugumi Ohba", "Um jogo de inteligência e morte", Tamanho.PEQUENO, cat13);
        Livro l26 = new Livro(null, "Attack on Titan", "Hajime Isayama", "Humanos contra titãs", Tamanho.MEDIO, cat13);
        // Categoria: Música
        Livro l27 = new Livro(null, "A História do Rock", "Andrew Chester", "Evolução do gênero musical", Tamanho.MEDIO, cat14);
        Livro l28 = new Livro(null, "Mozart: O Gênio da Música", "Peter Gay", "Biografia do compositor", Tamanho.PEQUENO, cat14);
        // Categoria: Psicologia
        Livro l29 = new Livro(null, "O Homem e Seus Símbolos", "Carl Jung", "Análise do inconsciente", Tamanho.MEDIO, cat15);
        Livro l30 = new Livro(null, "Inteligência Emocional", "Daniel Goleman", "Como lidar com emoções", Tamanho.PEQUENO, cat15);
        // Categoria: Religião
        Livro l31 = new Livro(null, "O Alcorão", "Tradução de Mansour Challita", "Texto sagrado do Islã", Tamanho.GRANDE, cat16);
        Livro l32 = new Livro(null, "Bíblia Sagrada", "Vários autores", "Livro sagrado do Cristianismo", Tamanho.GRANDE, cat16);
        // Categoria: Romance
        Livro l33 = new Livro(null, "Orgulho e Preconceito", "Jane Austen", "Um clássico do romance", Tamanho.MEDIO, cat17);
        Livro l34 = new Livro(null, "A Culpa é das Estrelas", "John Green", "Uma história de amor e superação", Tamanho.PEQUENO, cat17);
        // Categoria: Suspense
        Livro l35 = new Livro(null, "O Silêncio dos Inocentes", "Thomas Harris", "Um thriller psicológico", Tamanho.MEDIO, cat18);
        Livro l36 = new Livro(null, "Garota Exemplar", "Gillian Flynn", "Mistério e reviravoltas", Tamanho.PEQUENO, cat18);
        // Categoria: Turismo
        Livro l37 = new Livro(null, "100 Lugares para Conhecer Antes de Morrer", "Patricia Schultz", "Destinos imperdíveis", Tamanho.MEDIO, cat19);
        Livro l38 = new Livro(null, "Europa de Mochila", "Alexandre Nobumoto", "Dicas para mochileiros", Tamanho.PEQUENO, cat19);
        // Categoria: Saúde
        Livro l39 = new Livro(null, "O Corpo Humano", "Bill Bryson", "Uma viagem pelo organismo", Tamanho.MEDIO, cat20);
        Livro l40 = new Livro(null, "Medicina Interna", "Harrison", "Referência em clínica médica", Tamanho.GRANDE, cat20);


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
