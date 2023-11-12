package fr.metro.game;

import fr.metro.characters.Player;

public class Game {

    private final Player player;
    private final Board board;

    public Game(Player player, Board board) {
        this.player = player;
        this.board = board;
    }
}
