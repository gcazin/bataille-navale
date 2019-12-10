import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[]args) throws IOException {

        JFrame frame = new JFrame("Bataille Navale");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setPreferredSize(new Dimension(1100, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.add(new GameBoard());

        GameBoard gameBoard = new GameBoard();

        gameBoard.addBoat("A1", 4, true);
        gameBoard.addBoat("E4", 2, true);

        System.out.println(gameBoard.getBoatsPosition());

        for(Object boat : gameBoard.getBoatsPosition()) {
            System.out.println(boat.toString());
        }

        for(Object boat : gameBoard.getBoatsPosition()) {

        }
    }

}
