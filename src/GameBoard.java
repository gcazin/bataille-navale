import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class GameBoard extends JPanel implements ActionListener {

    /**
     * Coups par joueur
     */
    private int coups = 1;

    /**
     * Liste des bateaux
     */
    private ArrayList boats = new ArrayList();

    /**
     * Cases sélectionnés par le joueur
     */
    private ArrayList<String> cases = new ArrayList<>();

    /**
     * Cases sélectionnées par l'IA
     */
    private ArrayList<String> casesIA = new ArrayList<>();

    /**
     * Constructeur à appelé pour
     * construire la grille de jeu
     */
    GameBoard() {
        init();
    }

    /**
     * Initialisation de la grille
     */
    private void init() {
        ImageIcon iconA = new ImageIcon("./img/water.jpg");
        GridLayout layout = new GridLayout(10, 10);
        setLayout(layout);
        for (int col = 1; col <= 10; col++) {
            for (char row = 'A'; row <= 'J'; row++) {
                JButton button = new JButton("" + row + col, iconA);
                button.setMargin(new Insets(0, 0, 0, 0));
                button.setPreferredSize(new Dimension(50, 50));
                button.addActionListener(this);
                add(button);
            }
        }
    }

    /**
     * Actions faite sur les boutons
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String selected_case = e.getActionCommand();
        JOptionPane.showMessageDialog(
                this,
                String.format("Vous avez choisi la case %s!", e.getActionCommand()),
                "You Pressed a Button", JOptionPane.INFORMATION_MESSAGE);
        ((JButton) e.getSource()).setEnabled(false);
        System.out.println(coups++);
        cases.add(selected_case);
        System.out.println(getCasesOccupes());
    }

    /**
     *
     *
     */
    public void addBoat(String start, int length, boolean horizontal) {
        Boat boat = new Boat();
        boat.setStart(start);
        boat.setLength(length);
        boat.setHorizontal(horizontal);

        List<? extends Serializable> boat_create = Arrays.asList(boat.getStart(), boat.getLength(), boat.isHorizontal());
        boats.add(boat_create);
    }

    /**
     * Retourne toutes les positions des bateaux
     *
     * @return ArrayList
     */
    ArrayList getBoatsPosition() {
        return boats;
    }

    /**
     * Retourne toutes les cases sélectionnés sur le plateau
     *
     * @return <ArrayList> cases
     */
    private ArrayList getCasesOccupes()
    {
        return cases;
    }

}
