package com.javarush.grebenshikov.service;


import com.javarush.grebenshikov.model.GameState;

public class GameLogic {

    public String processChoice(GameState state, String choice) {
        String currentScene = state.getCurrentScene();
        String nextScene = "start";

        switch(currentScene) {
            case "start":
                if("begin".equals(choice)) {
                    nextScene = "investigation";
                    state.setGamesPlayed(state.getGamesPlayed() + 1);
                }
                break;

            case "investigation":
                if("library".equals(choice)) {
                    nextScene = "library";
                } else if("cellar".equals(choice)) {
                    nextScene = "cellar";
                }
                break;

            case "library":
                if("read".equals(choice)) {
                    nextScene = "madness";
                    state.setMad(true);
                } else if("leave".equals(choice)) {
                    nextScene = "safe";
                }
                break;

            case "cellar":
                if("open".equals(choice)) {
                    nextScene = "summoning";
                    state.setMad(true);
                } else if("ignore".equals(choice)) {
                    nextScene = "safe";
                }
                break;

            default:
                nextScene = "start";
        }

        state.setCurrentScene(nextScene);
        return nextScene;
    }

    public String getSceneDescription(String scene) {
        switch(scene) {
            case "start":
                return "Добро пожаловать в мир Лавкрафта! Введите ваше имя и начните игру.";

            case "investigation":
                return "Вы - исследователь тайн, приехавший в старинный город Аркхэм. "
                        + "В старом особняке Уилтширов пропали люди. "
                        + "Куда вы направитесь сначала: в библиотеку или в подвал?";

            case "library":
                return "В библиотеке вы находите древний фолиант с непонятными символами. "
                        + "Прочитать его или уйти?";

            case "cellar":
                return "В подвале вы находите запертый сундук с странными узорами. "
                        + "Открыть его или проигнорировать?";

            case "madness":
                return "Вы прочитали запретные знания и теперь видите истинную природу реальности. "
                        + "Ваш разум не выдержал - вы сошли с ума!";

            case "summoning":
                return "Открыв сундук, вы случайно совершили древний ритуал. "
                        + "Из тьмы явилось Нечто, что нельзя описать словами. "
                        + "Ваш разум не выдержал этого зрелища!";

            case "safe":
                return "Вы проявили благоразумие и покинули проклятое место. "
                        + "Хотя тайна осталась нераскрытой, вы сохранили свой рассудок. "
                        + "Возможно, это к лучшему...";

            default:
                return "Сцена не найдена";
        }
    }
}