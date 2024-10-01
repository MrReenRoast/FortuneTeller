import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    ArrayList<String> fortunes;
    JTextArea fortuneArea;
    int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        super("Fortune Teller");

        initializeFortunes();

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JLabel titleLabel = createTitleLabel();
        topPanel.add(titleLabel);

        JPanel middlePanel = new JPanel();
        fortuneArea = createFortuneTextArea();
        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        middlePanel.setLayout(new BorderLayout());
        middlePanel.add(scrollPane);

        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        readFortuneButton.addActionListener(e -> displayRandomFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }

    private JLabel createTitleLabel() {
        ImageIcon fortuneIcon = new ImageIcon("src/FortuneTeller.jpg");
        JLabel titleLabel = new JLabel("Fortune Teller", fortuneIcon, JLabel.CENTER);
        titleLabel.setFont(new Font("Sans-Serif", Font.BOLD, 48));
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        return titleLabel;
    }

    private JTextArea createFortuneTextArea() {
        JTextArea fortuneArea = new JTextArea();
        fortuneArea.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        fortuneArea.setEditable(false);
        return fortuneArea;
    }

    private void initializeFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You won't meet anyone important today.");
        fortunes.add("A disappointing time is ahead of you.");
        fortunes.add("An opportunity will soon be presented to you. Can't tell if it's good or bad.");
        fortunes.add("The early bird gets the worm, but nobody wants to be up early anymore.");
        fortunes.add("You will be hungry again in one hour.");
        fortunes.add("Fortune favors the bold—and also those who bring snacks.");
        fortunes.add("Screw it. Go gambling, why not?");
        fortunes.add("Your smile will bring sunshine to someone’s day.");
        fortunes.add("You will conquer obstacles, but whether they were worth it, I cannot tell.");
        fortunes.add("Your shoes will get scuffed today.");
        fortunes.add("A secret admirer will soon reveal themselves. They might also be a secret stalker.");
        fortunes.add("You will soon receive unexpected news. Can't tell if it's good or bad.");
    }

    private void displayRandomFortune() {
        Random random = new Random();
        int randomIndex;

        do {
            randomIndex = random.nextInt(fortunes.size());
        } while (randomIndex == lastFortuneIndex);

        String newFortune = fortunes.get(randomIndex);
        lastFortuneIndex = randomIndex;

        fortuneArea.append(newFortune + "\n");
    }
}