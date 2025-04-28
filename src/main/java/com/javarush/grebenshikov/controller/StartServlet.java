package com.javarush.grebenshikov.controller;

import com.javarush.grebenshikov.model.GameState;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("gameState") == null) {
            GameState state = new GameState();
            state.setCurrentScene("start");
            session.setAttribute("gameState", state);
        }

        request.getRequestDispatcher("/WEB-INF/views/start-page.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        GameState state = (GameState) session.getAttribute("gameState");

        String playerName = request.getParameter("playerName");
        if(playerName != null && !playerName.isEmpty()) {
            state.setPlayerName(playerName);
        }

        response.sendRedirect(request.getContextPath() + "/game?choice=begin");
    }
}