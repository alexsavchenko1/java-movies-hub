package ru.practicum.moviehub.store;

import ru.practicum.moviehub.model.Movie;
import ru.practicum.moviehub.model.MovieCreateRequest;

import java.util.*;

public class MoviesStore {

    private final Map<Integer, Movie> movies = new HashMap(); // final как гарантия, что ссылка не перезапишется
    private int nextID = 1;
    // реализовать методы хранилища!!!

        // Получение всех фильмов
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies.values());
    }

        // Получить фильм по ID
    public Optional<Movie> getMovieByID(int ID) {
        return Optional.ofNullable(movies.get(ID));
    }

        // Добавить новый фильм и присвоить ему ID
    public void addMovie(MovieCreateRequest movieCreateRequest) {
        Movie newMovie = new Movie(
                nextID++,
                movieCreateRequest.title(),
                movieCreateRequest.year()
        );
        movies.put(newMovie.id(), newMovie);
        // !пока ничего не возвращаю, потом перепишу под обстоятельства
    }

        // Удалить фильм по ID
    public void delMovieByID(int ID) {
        movies.remove(ID);
        // !пока ничего не возвращаю, потом перепишу под обстоятельства
    }

        // !Для тестов мб реализовать полное стирание базы
}