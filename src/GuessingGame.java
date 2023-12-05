import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGame extends JFrame {
    private Random random;
    private int numberToGuess;
    private int tries;
    private JLabel titleLabel;
    private JLabel instructionLabel;
    private JTextField inputField;
    private JButton guessButton;

    public GuessingGame() {
        //initializing variables
        random = new Random();
        numberToGuess = random.nextInt(100);
        tries = 0;

        //setting up the windows
        setTitle("Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        //creating the title label
        titleLabel = new JLabel("Welcome! Try to guess the number between 0 and 100.");
        titleLabel.setHorizontalAlignment(titleLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel);

        //creating the instruction label
        instructionLabel = new JLabel("Enter your guess:");
        instructionLabel.setHorizontalAlignment(instructionLabel.CENTER);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(instructionLabel);

        //creating the input field
        inputField = new JTextField();
        inputField.setHorizontalAlignment(inputField.CENTER);
        inputField.setFont(new Font("Arial", Font.BOLD, 40));
        add(inputField);

        //creating the guesing button
        guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());
        guessButton.setFont(new Font("Arial", Font.PLAIN, 30));
        add(guessButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 600);
        setVisible(true);
    }


    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int guess = Integer.parseInt(inputField.getText());
                evaluateGuess(guess);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    //evaluating if the guess is the correct answer or not
    private void evaluateGuess(int guess) {
        tries++;
        if (guess == numberToGuess) {
            JOptionPane.showMessageDialog(null, "Congratulations! You've guessed the number in " + tries + " tries.");
            resetGame();
            getContentPane().setBackground(Color.GREEN);
        } else if (guess < numberToGuess) {
            JOptionPane.showMessageDialog(null, "My number is bigger. Try again!");
            getContentPane().setBackground(Color.red);
        } else {
            JOptionPane.showMessageDialog(null, "My number is smaller. Try again!");
            getContentPane().setBackground(Color.red);

        }
    }

    private void resetGame() {
        numberToGuess = random.nextInt(100);
        tries = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuessingGame::new);
    }




}
