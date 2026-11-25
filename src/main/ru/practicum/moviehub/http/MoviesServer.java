package ru.practicum.moviehub.http;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import ru.practicum.moviehub.store.MoviesStore;

import java.io.IOException;


public class MoviesServer {
    HttpServer httpServer;

    public MoviesServer(MoviesStore moviesStore, int PORT){
        try {
            httpServer = HttpServer.create();
            httpServer.bind(new InetSocketAddress(PORT), 0);

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при создании сервера:", e);
        }
    }

    public void start() {
        httpServer.start();
        System.out.println("Сервер успешно запущен");
    }

    public void stop() {
        httpServer.stop(0);
        System.out.println("Сервер успешно остановлен");
    }

}