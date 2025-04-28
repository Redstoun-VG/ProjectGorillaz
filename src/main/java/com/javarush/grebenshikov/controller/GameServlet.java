package com.javarush.grebenshikov.controller;

import com.javarush.grebenshikov.service.GameLogic;
import com.javarush.grebenshikov.model.GameState;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    private GameLogic gameLogic = new GameLogic();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        GameState state = (GameState) session.getAttribute("gameState");

        if(state == null) {
            response.sendRedirect(request.getContextPath() + "/start");
            return;
        }

        String choice = request.getParameter("choice");
        if(choice != null) {
            gameLogic.processChoice(state, choice);
        }

        request.setAttribute("description", gameLogic.getSceneDescription(state.getCurrentScene()));

        if(state.getCurrentScene().equals("madness") ||
                state.getCurrentScene().equals("summoning") ||
                state.getCurrentScene().equals("safe")) {
            request.getRequestDispatcher("/WEB-INF/views/final.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(request, response);
        }
    }
}
