package biblioteca.biblioteca.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import biblioteca.biblioteca.Dto.AutorResponseDto;
import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.LivroRepository;

public class LivroCrudPadraoService implements LivroCrudService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LivroRepository livroRepository;

    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto LivroPostPutDto) {
        Livro livro = modelMapper.map(LivroPostPutDto, Livro.class);
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public List<LivroResponseDto> buscarTodosLivros() {
        return livroRepository
                .findAll()
                .stream()
                .map(livro -> modelMapper.map(livro, LivroResponseDto.class))
                .toList();
    }

    @Override
    public LivroResponseDto buscarLivroPorISBN(String isbn) {
        return livroRepository
                .findBy(Livro.class, isbn)
                .stream()
                .map(livro -> modelMapper.map(livro, LivroResponseDto.class))
                .toList();
    }

    @Override
    public LivroResponseDto buscarLivroPorTitulo(String titulo) {
        return livroRepository
                .findBy(Livro.class, titulo)
                .stream()
                .map(livro -> modelMapper.map(livro, LivroResponseDto.class))
                .toList();
    }

    @Override
    public LivroResponseDto atualizarLivro(Long id, LivroPostPutDto LivroPostPutDto) {
        Livro livro = modelMapper.map(LivroPostPutDto, Livro.class);
        livro.setIsbn(LivroPostPutDto.getIsbn());
        livro.setTitulo(LivroPostPutDto.getTitulo());
        livro.setAutor(LivroPostPutDto.getAutor());
        livro.setAno(LivroPostPutDto.getAno());
        livro.setEdicao(LivroPostPutDto.getEdicao());

        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public void removerLivro(Long id) {
        livroRepository.delete(modelMapper.map(livroRepository.findById(id), Livro.class));
    }

    
}
