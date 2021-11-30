package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static javafx.scene.paint.Color.*;

/**
 * Controller class communicates between the model and view
 *
 * <p>It calls the different methods in the board depending on how the user interacted
 * with the GUI.</p>
 *
 * <p>It's composed of all the display the users see and manipulates what the user can
 * click and not to click and also what changes in display when interacted with.</>
 */

public class Controller {

    //Main Menu Scene
    @FXML
    Button btnPlay;
    @FXML
    Button btnInstruct;
    @FXML
    Button btnExit;

    //Instruction Scene
    @FXML
    Button btnInstructOk;

    //Input Num Players Scene
    @FXML
    Label lblInputNumPlyrs;

    @FXML
    Button btnInputNumPlyrsInc;
    @FXML
    Button btnInputNumPlyrsDec;
    @FXML
    Button btnInputNumPlyrsOk;
    @FXML
    Button btnInputNumPlyrsBack;

    //Create Players Scene
    int ctr = 1; // Player number
    @FXML
    Label lblCreatePQuestion;
    @FXML
    Label lblCreatePPrompt;

    @FXML
    TextField tfCreatePName;

    @FXML
    Button btnCreatePBack;
    @FXML
    Button btnCreatePStart;
    @FXML
    Button btnCreatePCol;
    @FXML
    Button btnCreatePCar;

    //Board Scene

    //Board Scene - Start_Game
    @FXML
    Button btnBoardStartGame;

    //Board Scene - Player_Turn
    @FXML
    Label lblPlyrTurn;

    //Board Scene - Dice
    @FXML
    Button btnRollDice;
    @FXML
    Button btnEndTurn;

    //Board Scene - Dice_1
    @FXML
    Circle cFirstD1;
    @FXML
    Circle cFirstD2;
    @FXML
    Circle cFirstD3;
    @FXML
    Circle cFirstD4;
    @FXML
    Circle cFirstD5;

    //Board Scene - Dice_2
    @FXML
    Circle cSecD1;
    @FXML
    Circle cSecD2;
    @FXML
    Circle cSecD3;
    @FXML
    Circle cSecD4;
    @FXML
    Circle cSecD5;

    //Board Scene - Player Stats

    //Board Scene - Player_Stats_Player_1
    @FXML
    Circle cP1;
    @FXML
    Label lblP1Name;
    @FXML
    Label lblP1GenInfo;

    //Board Scene - Player_Stats_Player_1_Cards
    @FXML
    Label lblP1HouseTitle;
    @FXML
    Label lblP1HouseInfo;
    @FXML
    Label lblP1SalaryTitle;
    @FXML
    Label lblP1SalaryInfo;
    @FXML
    Label lblP1CareerTitle;
    @FXML
    Label lblP1CareerInfo;

    //Board Scene - Player_Stats_Player_1_Shapes
    @FXML
    Rectangle recP1Name;
    @FXML
    Rectangle recP1GenInfo;
    @FXML
    Rectangle recP1HouseInfo;
    @FXML
    Rectangle recP1SalaryInfo;
    @FXML
    Rectangle recP1CareerInfo;

    //Board Scene - Player_Stats_Player_2
    @FXML
    Circle cP2;
    @FXML
    Label lblP2Name;
    @FXML
    Label lblP2GenInfo;

    //Board Scene - Player_Stats_Player_2_Cards
    @FXML
    Label lblP2HouseTitle;
    @FXML
    Label lblP2HouseInfo;
    @FXML
    Label lblP2SalaryTitle;
    @FXML
    Label lblP2SalaryInfo;
    @FXML
    Label lblP2CareerTitle;
    @FXML
    Label lblP2CareerInfo;

    //Board Scene - Player_Stats_Player_2_Shapes
    @FXML
    Rectangle recP2Name;
    @FXML
    Rectangle recP2GenInfo;
    @FXML
    Rectangle recP2HouseInfo;
    @FXML
    Rectangle recP2SalaryInfo;
    @FXML
    Rectangle recP2CareerInfo;

    //Board Scene - Player_Stats_Player_3
    @FXML
    Circle cP3;
    @FXML
    Label lblP3Name;
    @FXML
    Label lblP3GenInfo;

    //Board Scene - Player_Stats_Player_3_Cards
    @FXML
    Label lblP3HouseTitle;
    @FXML
    Label lblP3HouseInfo;
    @FXML
    Label lblP3SalaryTitle;
    @FXML
    Label lblP3SalaryInfo;
    @FXML
    Label lblP3CareerTitle;
    @FXML
    Label lblP3CareerInfo;

    //Board Scene - Player_Stats_Player_3_Shapes
    @FXML
    Rectangle recP3Name;
    @FXML
    Rectangle recP3GenInfo;
    @FXML
    Rectangle recP3HouseInfo;
    @FXML
    Rectangle recP3SalaryInfo;
    @FXML
    Rectangle recP3CareerInfo;

    //Board Scene - Pop-up
    @FXML
    AnchorPane popUpAnchor;

    //Board Scene - Orange_Space
    ActionCard actionCardPicked;
    int ActionCardIndex = 0;
    @FXML
    AnchorPane orangeAnchor;
    @FXML
    Label lblActionCard;
    @FXML
    Label lblActionCardEvent;
    @FXML
    Label lblActionCardCashChange;
    @FXML
    Button btnActionCardPlayer1;
    @FXML
    Button btnActionCardPlayer2;
    @FXML
    Button btnActionCardPlayer3;
    @FXML
    Button btnActionCardOK;

    //Board Scene - Blue_Space
    BlueCard blueCardPicked;
    @FXML
    AnchorPane blueAnchor;
    @FXML Label lblBlueCard;
    @FXML Label lblBlueCardEvent;
    @FXML Label lblBlueDiceRoll;
    @FXML Button btnBlueRandPrice;
    @FXML Button btnBlueCardOK;

    //Board Scene - Magenta_Space

    //Board Scene - Magenta_Space_College_Career
    CareerCard[] career = new CareerCard[2];
    SalaryCard[] salary = new SalaryCard[2];

    @FXML AnchorPane colCarAnchor;
    @FXML Label lblColCareer1Info;
    @FXML Label lblColCareer2Info;
    @FXML Label lblColSalary1Info;
    @FXML Label lblColSalary2Info;
    @FXML Button btnCareer1;
    @FXML Button btnCareer2;
    @FXML Button btnSalary1;
    @FXML Button btnSalary2;

    //Board Scene - Magenta_Space_Job_Search
    @FXML AnchorPane jobSearchAnchor;
    @FXML Label lblJSCareer1Info;
    @FXML Label lblJSCareer2Info;
    @FXML Label lblJSSalary1Info;
    @FXML Label lblJSSalary2Info;
    @FXML Button btnCurrentCarSal;
    @FXML Button btnChangeCarSal;

    //Board Scene - Magenta_Space_Get_Married
    @FXML
    AnchorPane getMarriedAnchor;
    @FXML Label lblMarriedEvent;
    @FXML Button btnMarriedOK;

    //Board Scene - Magenta_Space_Get_Married_Dice
    @FXML Button btnMarriedRollDice;

    //Board Scene - Magenta_Space_Get_Married_Dice_1
    @FXML
    Circle cFirstMD1;
    @FXML
    Circle cFirstMD2;
    @FXML
    Circle cFirstMD3;
    @FXML
    Circle cFirstMD4;
    @FXML
    Circle cFirstMD5;

    //Board Scene - Magenta_Space_Get_Married_Dice_2
    @FXML
    Circle cSecMD1;
    @FXML
    Circle cSecMD2;
    @FXML
    Circle cSecMD3;
    @FXML
    Circle cSecMD4;
    @FXML
    Circle cSecMD5;

    //Board Scene - MagentaSpace_Which_Path_Pos_21_44
    @FXML
    AnchorPane whichPathAnchor;
    @FXML Button btnOtherPath;
    @FXML Button btnContinuePath;

    //Board Scene - MagentaSpace_Buy_A_House
    int buyHouseIndex = 1;
    @FXML
    AnchorPane buyAHouseAnchor;
    @FXML Label lblBuyHouseCtr;
    @FXML Button btnBuyHouseInc;
    @FXML Button btnBuyHouseDec;
    @FXML Button btnBuyHouseBuy;
    @FXML Button btnBuyHouseOK;

    //Board Scene - MagentaSpace_Have_Baby_Twins
    @FXML AnchorPane haveBabiesAnchor;
    @FXML Button btnHaveBabiesOK;
    @FXML Label lblHaveBabiesEvent;

    //Board Scene - MagentaSpace_Retirement
    @FXML AnchorPane retireAnchor;
    @FXML Label lblRetireTitle;
    @FXML Label lblRetireEvent;
    @FXML Label lblRetirePlyrChildren;
    @FXML Label lblRetirePlyrChildrenPrice;
    @FXML Label lblRetirePlyrLoan;
    @FXML Label lblRetirePlyrLoanPrice;
    @FXML Rectangle recRetireHouseBG;
    @FXML Label lblRetireHouseTitle;
    @FXML Label lblRetireHouseInfo;
    @FXML Label lblRetireHousePrice;
    @FXML Label lblRetireCurCash;
    @FXML Label lblRetireFinalCash;
    @FXML Button btnRetireOK;


    //Board Scene - Green_Space
    @FXML AnchorPane greenAnchor;
    @FXML Label lblGreenSpaceEvent;
    @FXML Button btnGreenSpaceOK;

    //Board Scene - Loans
    int getLoan = 0;
    int payLoan = 0;

    @FXML Button btnGetLoanInc;
    @FXML Button btnGetLoanDec;
    @FXML Button btnGetLoan;
    @FXML Label lblGetLoan;

    @FXML Button btnPayLoanInc;
    @FXML Button btnPayLoanDec;
    @FXML Button btnPayLoan;
    @FXML Label lblPayLoan;

    //Board Scene - End_Game
    @FXML Button btnEndGame;

    //Game Summary
    @FXML AnchorPane gameEndAnchor;
    @FXML Label lblGameEnd1stName;
    @FXML Label lblGameEnd1stCash;
    @FXML Label lblGameEnd2ndName;
    @FXML Label lblGameEnd2ndCash;

    //Game Summary - 3 players
    @FXML Label lblGameEnd3rdName;
    @FXML Label lblGameEnd3rdBG;
    @FXML Label lblGameEnd3rdCash;
    @FXML Rectangle rec3rdTrophy;
    @FXML Rectangle recGameEnd3rdBG;
    @FXML Arc arc3rdTrophy;
    @FXML Ellipse ell3rdTrophy;

    @FXML Button btnGameSummary;

    //Main Menu Scene

    /**
     * proceeds to the input number of player scene when clicked
     * @param event play button clicked
     * @throws IOException
     */
    @FXML
    public void playGameClicked(ActionEvent event) throws IOException {
        Stage stage = Main.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("InputNumPlayers.fxml"));
        Scene inputNumP = new Scene(root);

        stage.setScene(inputNumP);
        stage.show();
    }

    /**
     * proceeds to instructions scene when clicked
     * @param event instructions button clicked
     * @throws IOException
     */
    @FXML
    public void instructClicked(ActionEvent event) throws IOException {
        Stage stage = Main.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("Instructions.fxml"));
        Scene mainMenu = new Scene(root);

        stage.setScene(mainMenu);
        stage.show();
    }

    /**
     * proceeds to main menu when clicked
     * @param event back to main menu clicked
     * @throws IOException
     */
    @FXML
    public void backToMainMenuClicked(ActionEvent event) throws IOException {
        Stage stage = Main.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainMenu = new Scene(root);

        stage.setScene(mainMenu);
        stage.show();
    }

    /**
     * exits the program and model when clicked
     * @param e exit button clicked
     */
    @FXML
    public void exit(ActionEvent e) {
        Stage stage = Main.getStage();
        stage.close();
    }

    //Input Num Players Scene

    /**
     * increases the number of player when clicked
     * @param event increase button clicked
     */
    @FXML
    public void inputNumPlayerIncClicked(ActionEvent event) {
        int numPlayer = Main.getBoard().getNumPlayer();
        btnInputNumPlyrsInc.setDisable(true);
        btnInputNumPlyrsDec.setDisable(false);

        Main.getBoard().setNumPlayer(numPlayer + 1);
        lblInputNumPlyrs.setText("" + Main.getBoard().getNumPlayer());
    }

    /**
     * decreases the number of player when clicked
     * @param event decrease button clicked
     */
    @FXML
    public void inputNumPlayerDecClicked(ActionEvent event) {
        int numPlayer = Main.getBoard().getNumPlayer();
        btnInputNumPlyrsDec.setDisable(true);
        btnInputNumPlyrsInc.setDisable(false);

        Main.getBoard().setNumPlayer(numPlayer - 1);
        lblInputNumPlyrs.setText("" + Main.getBoard().getNumPlayer());
    }

    /**
     * proceeds to creation of players scene
     * @throws Exception
     */
    @FXML
    public void inputNumPlayerOkClicked() throws Exception {
        Stage stage = Main.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("CreatePlayers.fxml"));
        Scene createP = new Scene(root);
        stage.setScene(createP);
        stage.show();
    }

    //Create Players

    /**
     * creates player and initializes them into college path
     * @throws Exception
     */
    @FXML
    public void createPColClicked() throws Exception {
        int lifepath = 0;
        String name = tfCreatePName.getCharacters().toString();

        if (!Main.getBoard().isNameChosen(name) && !Main.getBoard().isNameShortOrNull(name)) {
            lifepath = 2;

            Main.getBoard().getPlayerArr().add(new Player(name, ctr, lifepath));
            ctr++;
            displayCreatePlayerPrompt(false);
            updateCreatePlayerQstn(ctr);
        } else displayCreatePlayerPrompt(true);
        tfCreatePName.setText("");
        updateCreatePView();
    }

    /**
     * creates player and initializes them into career path
     * @throws Exception
     */
    @FXML
    public void createPCarClicked() throws Exception {
        int lifepath = 0;
        String name = tfCreatePName.getCharacters().toString();

        if (!Main.getBoard().isNameChosen(name) && !Main.getBoard().isNameShortOrNull(name)) {
            lifepath = 1;

            Main.getBoard().getPlayerArr().add(new Player(name, ctr, lifepath));
            Player player = Main.getBoard().getPlayerArr().get(ctr - 1);
            assignCarToPlayerNoDeg(player);
            ctr++;
            displayCreatePlayerPrompt(false);
            updateCreatePlayerQstn(ctr);
        } else displayCreatePlayerPrompt(true);
        tfCreatePName.setText("");
        updateCreatePView();
    }

    /**
     * assigns a career with no degree required to a player
     * @param p player to be assigned with career
     */
    public void assignCarToPlayerNoDeg(Player p) {
        for (int i = 0; i < Main.getBoard().getCareerCardDeck().getCareerCards().size(); i++) {
            CareerCard careerCard = Main.getBoard().getCareerCardDeck().pickFromCareerDeck();
            if (careerCard.getDegree() == false && careerCard.getPick() == false) {
                SalaryCard salaryCard = Main.getBoard().getSalaryCardDeck().pickFromSalaryDeck();

                careerCard.setPick(true);
                salaryCard.setPick(true);

                p.setCareerCard(careerCard);
                p.setSalaryCard(salaryCard);

                i = Main.getBoard().getCareerCardDeck().getCareerCards().size();
            }
        }
    }

    /**
     * displays if creation of player is successful
     * @param bSuccess dictates if creation of player was successful
     */
    public void displayCreatePlayerPrompt(boolean bSuccess) {
        if (bSuccess == true) {
            lblCreatePPrompt.setText("Invalid name! Please try again.");
            lblCreatePPrompt.setTextFill(RED);
        } else {
            lblCreatePPrompt.setText("Player created successfully!");
            lblCreatePPrompt.setTextFill(GREEN);
        }
    }

    /**
     * displays which player will input their name for creation
     * @param numPlayer player number of player that will input name
     */
    public void updateCreatePlayerQstn(int numPlayer) {
        lblCreatePQuestion.setText("What is your name Player " + numPlayer + "?");
        lblCreatePQuestion.setFont(new Font("Franklin Gothic Demi", 33));
    }

    /**
     * updates the label dictating user to start the game
     */
    public void updateCreatePlayerQstn() {
        lblCreatePQuestion.setText("Press START to play!");
        lblCreatePQuestion.setFont(new Font("Franklin Gothic Demi", 33));
    }

    /**
     * updates the buttons allowed to be clicked
     */
    public void updateCreatePView() {
        btnCreatePCar.setDisable(false);
        btnCreatePCol.setDisable(false);
        tfCreatePName.setDisable(false);
        btnCreatePStart.setDisable(true);

        if (ctr > Main.getBoard().getNumPlayer()) {
            btnCreatePCar.setDisable(true);
            btnCreatePCol.setDisable(true);
            tfCreatePName.setDisable(true);
            btnCreatePStart.setDisable(false);
            updateCreatePlayerQstn();
        }
    }

    /**
     * loads the board
     * @throws Exception
     */
    public void createPStartClicked() throws Exception {
        Stage stage = Main.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("Board.fxml"));
        Scene board = new Scene(root);
        stage.setScene(board);
        stage.show();
    }

    /**
     * initializes the labels and display
     * @param ctr player to input name for creation
     */
    public void initCreatePlayerScene(int ctr) {
        updateCreatePlayerQstn(ctr);
        tfCreatePName.setText("");
        lblCreatePPrompt.setText("Name should be at least 4 characters long.");
        lblCreatePPrompt.setTextFill(BLACK);
    }

    /**
     * initializes the labels and display
     */
    public void initCreatePlayerScene() {
        ctr = 1;
        initCreatePlayerScene(ctr);
        Main.getBoard().getPlayerArr().clear();
    }

    /**
     * updates the display when back button clicked
     * @throws Exception
     */
    public void createPBackClicked() throws Exception {
        Stage stage = Main.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("InputNumPlayers.fxml"));
        Scene board = new Scene(root);

        stage.setScene(board);
        stage.show();

        initCreatePlayerScene();
    }

    //Board Scene

    //Board Scene - Start Game

    //initializes the board

    /**
     * updates the attributes of players in a section on the board and officially
     * starts the game
     * @param a start game button clicked
     */
    @FXML
    public void boardStartGameClicked(ActionEvent a) {
        Player Player1 = Main.getBoard().getPlayerArr().get(0);
        lblPlyrTurn.setText(Player1.getName() + "'s TURN!");
        lblPlyrTurn.setStyle("-fx-text-fill: #ff8e8e;");
        btnBoardStartGame.setVisible(false);
        btnBoardStartGame.setDisable(true);

        btnGetLoanInc.setDisable(false);
        btnPayLoanInc.setDisable(false);

        int numPlayer = Main.getBoard().getNumPlayer();

        //Board Scene - Player_Stats_Player_1
        lblP1Name.setText(Player1.getName());
        lblP1GenInfo.setText("CASH:" + Player1.getCash()
                + "\nLOAN:" + Player1.getLoan() +
                "\nDEGREE:" + Player1.hasDegree() +
                "\nCHILDREN:" + Player1.getChildren() +
                "\nSPOUSE:" + Player1.isMarried() +
                "\nRETIRED:" + Player1.isRetired());
        if (Player1.getLifePath() == 1) {
            lblP1SalaryInfo.setText("SALARY\n" + Player1.getSalaryCard().getSalary() +
                    "\nTAX DUE\n" + Player1.getSalaryCard().getTaxDue() +
                    "\nPAY RAISE VALUE\n" + Player1.getSalaryCard().getPayRaiseValue());
            lblP1CareerInfo.setText("CAREER\n" + Player1.getCareerCard().getCareer() +
                    "\nMAX PAY RAISE\n" + Player1.getCareerCard().getFINALMAXRAISE());
        }

        //Board Scene - Player_Stats_Player_2
        Player Player2 = Main.getBoard().getPlayerArr().get(1);
        lblP2Name.setText(Player2.getName());
        lblP2GenInfo.setText("CASH:" + Player2.getCash()
                + "\nLOAN:" + Player2.getLoan() +
                "\nDEGREE:" + Player2.hasDegree() +
                "\nCHILDREN:" + Player2.getChildren() +
                "\nSPOUSE:" + Player2.isMarried() +
                "\nRETIRED:" + Player2.isRetired());

        if (Player2.getLifePath() == 1) {
            lblP2SalaryInfo.setText("SALARY\n" + Player2.getSalaryCard().getSalary() +
                    "\nTAX DUE\n" + Player2.getSalaryCard().getTaxDue() +
                    "\nPAY RAISE VALUE\n" + Player2.getSalaryCard().getPayRaiseValue());
            lblP2CareerInfo.setText("CAREER\n" + Player2.getCareerCard().getCareer() +
                    "\nMAX PAY RAISE\n" + Player2.getCareerCard().getFINALMAXRAISE());
        }

        if (numPlayer == 2) {
            //Board Scene - Player_Stats_Player_3
            cP3.setVisible(false);
            lblP3Name.setVisible(false);
            lblP3GenInfo.setVisible(false);

            //Board Scene - Player_Stats_Player_3_Cards
            lblP3HouseTitle.setVisible(false);
            lblP3HouseInfo.setVisible(false);

            lblP3SalaryTitle.setVisible(false);
            lblP3SalaryInfo.setVisible(false);

            lblP3CareerTitle.setVisible(false);
            lblP3CareerInfo.setVisible(false);

            //Board Scene - Player_Stats_Player_3_Shapes
            recP3Name.setVisible(false);
            recP3GenInfo.setVisible(false);
            recP3HouseInfo.setVisible(false);
            recP3SalaryInfo.setVisible(false);
            recP3CareerInfo.setVisible(false);
        } else {
            //Board Scene - Player_Stats_Player_3
            Player Player3 = Main.getBoard().getPlayerArr().get(2);
            lblP3Name.setText(Player3.getName());
            lblP3GenInfo.setText("CASH:" + Player3.getCash()
                    + "\nLOAN:" + Player3.getLoan() +
                    "\nDEGREE:" + Player3.hasDegree() +
                    "\nCHILDREN:" + Player3.getChildren() +
                    "\nSPOUSE:" + Player3.isMarried() +
                    "\nRETIRED:" + Player3.isRetired());

            //Board Scene - Player_Stats_Player_3_Cards

            if (Player3.getLifePath() == 1) {
                lblP3SalaryInfo.setText("SALARY\n" + Player3.getSalaryCard().getSalary() +
                        "\nTAX DUE\n" + Player3.getSalaryCard().getTaxDue() +
                        "\nPAY RAISE VALUE\n" + Player3.getSalaryCard().getPayRaiseValue());
                lblP3CareerInfo.setText("CAREER\n" + Player3.getCareerCard().getCareer() +
                        "\nMAX PAY RAISE\n" + Player3.getCareerCard().getFINALMAXRAISE());
            }
        }
    }

    //Board Scene - Dice

    /**
     * generates a random number from 1-10 when roll dice button is clicked
     * @param a roll dice button is clicked
     */
    @FXML
    public void rollDice(ActionEvent a) {
        int index = Main.getBoard().indexOfCurPlayerTurn();
        int dice = Main.getBoard().rollDice();

        updateDiceView(dice);
        System.out.println(Main.getBoard().getPlayerArr().get(index).getName() + " rolled " + dice + "!");

        if (index == 0) {
            movePlayer(cP1, dice, index);
        } else if (index == 1) {
            movePlayer(cP2, dice, index);
        } else if (index == 2) {
            movePlayer(cP3, dice, index);
        }

        displayEndTurn(index);
    }

    /**
     * updates the label above the roll dice stating the name of the player for
     * current turn
     * @param index index of the player currently in turn
     */
    public void updateLblBtnPlyrTurnView(int index) {
        Player Player1 = Main.getBoard().getPlayerArr().get(0);
        Player Player2 = Main.getBoard().getPlayerArr().get(1);

        if (index == 0) {
            lblPlyrTurn.setText(Player1.getName() + "'s TURN!");
            lblPlyrTurn.setStyle("-fx-text-fill: #ff8e8e;");
            btnRollDice.setStyle("-fx-background-color: #ff8e8e; -fx-text-fill: #800000");
        } else if (index == 1) {
            lblPlyrTurn.setText(Player2.getName() + "'s TURN!");
            lblPlyrTurn.setStyle("-fx-text-fill: #fff873;");
            btnRollDice.setStyle("-fx-background-color: #fff873; -fx-text-fill: #788000");
        } else if (index == 2) {
            Player Player3 = Main.getBoard().getPlayerArr().get(2);
            lblPlyrTurn.setText(Player3.getName() + "'s TURN!");
            lblPlyrTurn.setStyle("-fx-text-fill: #7dffa0;");
            btnRollDice.setStyle("-fx-background-color: #7dffa0; -fx-text-fill: #008002");
        }
    }

    /**
     * updates the dice to show the random number generated
     * @param dice random number generated
     */
    public void updateDiceView(int dice) {
        cFirstD1.setVisible(false);
        cFirstD2.setVisible(false);
        cFirstD3.setVisible(false);
        cFirstD4.setVisible(false);
        cFirstD5.setVisible(false);

        cSecD1.setVisible(false);
        cSecD2.setVisible(false);
        cSecD3.setVisible(false);
        cSecD4.setVisible(false);
        cSecD5.setVisible(false);
        if (dice == 1) {
            cFirstD3.setVisible(true);
        } else if (dice == 2) {
            cFirstD1.setVisible(true);
            cFirstD2.setVisible(true);
        } else if (dice == 3) {
            cFirstD1.setVisible(true);
            cFirstD2.setVisible(true);
            cFirstD3.setVisible(true);
        } else if (dice == 4) {
            cFirstD1.setVisible(true);
            cFirstD2.setVisible(true);
            cFirstD4.setVisible(true);
            cFirstD5.setVisible(true);
        } else if (dice == 5) {
            cFirstD1.setVisible(true);
            cFirstD2.setVisible(true);
            cFirstD3.setVisible(true);
            cFirstD4.setVisible(true);
            cFirstD5.setVisible(true);
        } else if (dice == 6) {
            cFirstD1.setVisible(true);
            cFirstD2.setVisible(true);
            cFirstD3.setVisible(true);
            cFirstD4.setVisible(true);
            cFirstD5.setVisible(true);

            cSecD3.setVisible(true);
        } else if (dice == 7) {
            cFirstD1.setVisible(true);
            cFirstD2.setVisible(true);
            cFirstD3.setVisible(true);
            cFirstD4.setVisible(true);
            cFirstD5.setVisible(true);

            cSecD1.setVisible(true);
            cSecD2.setVisible(true);
        } else if (dice == 8) {
            cFirstD1.setVisible(true);
            cFirstD2.setVisible(true);
            cFirstD3.setVisible(true);
            cFirstD4.setVisible(true);
            cFirstD5.setVisible(true);

            cSecD1.setVisible(true);
            cSecD2.setVisible(true);
            cSecD3.setVisible(true);
        } else if (dice == 9) {
            cFirstD1.setVisible(true);
            cFirstD2.setVisible(true);
            cFirstD3.setVisible(true);
            cFirstD4.setVisible(true);
            cFirstD5.setVisible(true);

            cSecD1.setVisible(true);
            cSecD2.setVisible(true);
            cSecD4.setVisible(true);
            cSecD5.setVisible(true);
        } else if (dice == 10) {
            cFirstD1.setVisible(true);
            cFirstD2.setVisible(true);
            cFirstD3.setVisible(true);
            cFirstD4.setVisible(true);
            cFirstD5.setVisible(true);

            cSecD1.setVisible(true);
            cSecD2.setVisible(true);
            cSecD3.setVisible(true);
            cSecD4.setVisible(true);
            cSecD5.setVisible(true);
        }
    }

    /**
     * display the end turn button to allow player in turn to end turn
     * @param index
     */
    public void displayEndTurn(int index)
    {
        btnRollDice.setDisable(true);
        btnRollDice.setVisible(false);

        btnEndTurn.setVisible(true);

        if (index == 0) {
            btnEndTurn.setStyle("-fx-background-color: #ff8e8e; -fx-text-fill: #800000");
        } else if (index == 1) {
            btnEndTurn.setStyle("-fx-background-color: #fff873; -fx-text-fill: #788000");
        } else if (index == 2) {
            btnEndTurn.setStyle("-fx-background-color: #7dffa0; -fx-text-fill: #008002");
        }
    }

    /**
     * proceeds to player next in turn when end turn button clicked by current player in turn
     * @param a end turn button clicked
     */
    @FXML
    public void endTurnClicked(ActionEvent a)
    {
        int index = Main.getBoard().indexOfCurPlayerTurn();

        btnEndTurn.setVisible(false);
        btnEndTurn.setDisable(true);

        btnRollDice.setDisable(false);
        btnRollDice.setVisible(true);

        btnGetLoanInc.setDisable(false);
        btnGetLoanDec.setDisable(true);
        btnGetLoan.setDisable(true);

        btnPayLoanInc.setDisable(false);
        btnPayLoanDec.setDisable(true);
        btnPayLoan.setDisable(true);

        lblGetLoan.setText("0");
        lblPayLoan.setText("0");
        payLoan = getLoan = 0;

        int curPos = Main.getBoard().getPlayerArr().get(index).getCurPos();

        if (Main.getBoard().isAllRetired() == Main.getBoard().getNumPlayer())
        {
            lblPlyrTurn.setVisible(false);
            btnEndTurn.setVisible(false);
            btnEndTurn.setDisable(true);

            btnRollDice.setVisible(false);
            btnRollDice.setDisable(true);

            btnGetLoanInc.setDisable(true);
            btnGetLoanDec.setDisable(true);
            btnGetLoan.setDisable(true);

            btnPayLoanInc.setDisable(true);
            btnPayLoanDec.setDisable(true);
            btnPayLoan.setDisable(true);

            btnEndGame.setVisible(true);
            btnEndGame.setDisable(false);
        }
        else {
            if (!(curPos == 21 || curPos == 44))
            {
                Main.getBoard().nextPlayerTurn();
            }
            index = Main.getBoard().indexOfCurPlayerTurn();
            updateLblBtnPlyrTurnView(index);
        }
    }

    /**
     * updates the position of the peg of the player displaying their current position on the board
     * @param cPlayer shape to be moved to current position
     * @param move number of moves to advance
     * @param index index of player to be moved
     */
    public void movePlayer (Circle cPlayer, int move, int index)
    {
        Player curPlayer = Main.getBoard().getPlayerArr().get(index);
        int curPos = curPlayer.getCurPos();
        int lifepath = curPlayer.getLifePath();

        Main.getBoard().updateCurPos(move, curPlayer);
        int updatedPos = Main.getBoard().getPlayerArr().get(index).getCurPos();

        System.out.println("CurPos:" + curPos + " to UpdatedPos: " + updatedPos);

        //move circle
        for (int i = curPos; i < updatedPos; i++)
        {
            //move right
            if ((i == 0 && lifepath == 1) || i == 1 || i == 2 || i == 3 ||
                    (i >= 9 && i <= 12) || (i == 44 && lifepath == 1) ||
                    (i >= 47 && i <= 59) || i == 63 || i == 64 || i == 66)
            {
                cPlayer.setLayoutX(cPlayer.getLayoutX() + 63);
            }
            //move left
            else if ((i >= 15 && i <= 20)|| (i >= 25 && i <= 29) ||
                    (i == 21 && lifepath == 1) || i == 34 || i == 35)
            {
                cPlayer.setLayoutX(cPlayer.getLayoutX() - 63);
            }
            //move up
            else if ((i >= 30 && i <= 33) || (i >= 21 && i <= 25) ||
                    (i == 21 && lifepath == 2) || i == 65 || i == 67)
            {
                cPlayer.setLayoutY(cPlayer.getLayoutY() - 49);
            }
            //move down
            else if ((i == 0 && lifepath == 2) || (i >= 4 && i <= 8) || i == 13 || i == 14 ||
                    (i == 44 && lifepath == 2) || (i >= 36 && i <= 46) || (i >= 60 && i <= 62))
            {
                cPlayer.setLayoutY(cPlayer.getLayoutY() + 49);
            }

            if ((i == 0 && lifepath == 2) || (i == 6 && lifepath == 1) ||
                    (i == 21 && lifepath == 1) || (i == 27 && lifepath == 2))
                i=i+6;
            else if ((i == 44 && lifepath == 1) || (i == 53 && lifepath == 2))
                i=i+9;
            System.out.println(i);
        }

        whichMethod();
        updatePlayerStatsView();
    }

    /**
     * determines which method to be executed when a player steps on
     * a space.
     */
    public void whichMethod ()
    {
        setAllPanesBtnDisableVisible();

        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);
        int curPosPlayer = players.get(curPlayerTurn).getCurPos();

        Space[] spaces = Main.getBoard().getSpaces();
        ActionDeck actionCardDeck = Main.getBoard().getActionCardDeck();
        BlueDeck blueCardDeck = Main.getBoard().getBlueCardDeck();
        SalaryDeck salaryCardDeck = Main.getBoard().getSalaryCardDeck();
        CareerDeck careerCardDeck = Main.getBoard().getCareerCardDeck();

        //Pop-up Anchor
        popUpAnchor.setDisable(false);
        popUpAnchor.setVisible(true);

        //Disable End Turn
        btnEndTurn.setDisable(true);

        //Disable Loan Buttons
        btnGetLoanDec.setDisable(true);
        btnGetLoanInc.setDisable(true);
        btnGetLoan.setDisable(true);

        btnPayLoanDec.setDisable(true);
        btnPayLoanInc.setDisable(true);
        btnPayLoan.setDisable(true);

        //OrangeSpace
        if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("Draw an Action Card!"))
        {
            actionCardPicked = actionCardDeck.pickFromActionDeck();
            orangeAnchor.setVisible(true);
            orangeAnchor.setDisable(false);

            lblActionCard.setText("ACTION CARD\n" +
                    actionCardPicked.getDescription() +
                    "\n" +
                    "P" + actionCardPicked.getAmount());
            if(actionCardPicked.getKind() == 1)
            {
                lblActionCardEvent.setText("COLLECT FROM BANK");
                lblActionCardCashChange.setText("P" + curPlayer.getCash() + " + P" + actionCardPicked.getAmount());
                lblActionCardCashChange.setTextFill(LIGHTGREEN);
                btnActionCardOK.setDisable(false);
                actionCardPicked.collectFromBank(curPlayer);
            }

            //current player pays the bank
            else if(actionCardPicked.getKind() == 2)
            {
                lblActionCardEvent.setText("PAY THE BANK");
                lblActionCardCashChange.setText(curPlayer.getCash() + " - " + actionCardPicked.getAmount());
                lblActionCardCashChange.setTextFill(RED);
                btnActionCardOK.setDisable(false);
                actionCardPicked.payTheBank(curPlayer);
            }

            //choose a player whom you will pay
            else if(actionCardPicked.getKind() == 3)
            {
                lblActionCardEvent.setText("PAY THE PLAYER\n" + "CHOOSE A PLAYER");

                disableActionCardPlyrBtn(Main.getBoard().indexOfCurPlayerTurn());

                lblActionCardCashChange.setText("P" + curPlayer.getCash() + " - P" + actionCardPicked.getAmount());
                lblActionCardCashChange.setTextFill(RED);
            }

            //choose a player whom you will collect money from
            else if(actionCardPicked.getKind() == 4)
            {
                lblActionCardEvent.setText("COLLECT FROM PLAYER\n" + "CHOOSE A PLAYER");

                disableActionCardPlyrBtn(Main.getBoard().indexOfCurPlayerTurn());

                lblActionCardCashChange.setText("P" + curPlayer.getCash() + " + P" + actionCardPicked.getAmount());
                lblActionCardCashChange.setTextFill(GREEN);
            }

            //current player will pay all players.
            else if(actionCardPicked.getKind() == 5)
            {
                lblActionCardEvent.setText("PAY ALL PLAYERS");
                lblActionCardCashChange.setText("P" + curPlayer.getCash() + " - P" + actionCardPicked.getAmount()*(Main.getBoard().getNumPlayer()-1));
                lblActionCardCashChange.setTextFill(RED);
                btnActionCardOK.setDisable(false);
                actionCardPicked.payAll(curPlayer, players);
            }

            //current player will collect money from all players
            else if(actionCardPicked.getKind() == 6)
            {
                lblActionCardEvent.setText("COLLECT FROM ALL PLAYERS");
                lblActionCardCashChange.setText("P" + curPlayer.getCash() + " + P" + actionCardPicked.getAmount()*(Main.getBoard().getNumPlayer()-1));
                lblActionCardCashChange.setTextFill(LIGHTGREEN);
                btnActionCardOK.setDisable(false);
                actionCardPicked.collectAll(curPlayer, players);
            }
        }


        //GreenSpace
        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("Pay Day!"))
        {
            greenAnchor.setVisible(true);
            greenAnchor.setDisable(false);
            lblGreenSpaceEvent.setText("\nPAY DAY!\n" + "SALARY COLLECTED FROM THE BANK.\nP" +
                    curPlayer.getSalaryCard().getSalary());
            ((GreenSpace) spaces[curPosPlayer]).payDay(curPlayer);
            btnGreenSpaceOK.setDisable(false);
        }

        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("Pay Raise!"))
        {
            greenAnchor.setVisible(true);
            greenAnchor.setDisable(false);
            if (curPlayer.getSalaryCard().getPayRaiseCtr() < curPlayer.getCareerCard().getFINALMAXRAISE())
                lblGreenSpaceEvent.setText("\nPAY RAISE!\n" + "SALARY INCREASED BY P" +
                    ((GreenSpace) spaces[curPosPlayer]).getAmount() + "\nTAXDUE INCREASED BY P2000");
            else lblGreenSpaceEvent.setText("\nPAY RAISE!\n" + "PAY RAISE EXCEEDS MAX RAISE.\n " +
                    "SALARY COLLECTED FROM THE BANK.\nP" + curPlayer.getSalaryCard().getSalary());
            ((GreenSpace) spaces[curPosPlayer]).payRaise(curPlayer);
            btnGreenSpaceOK.setDisable(false);
        }
        //BlueSpace

        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("Draw a Blue Card!"))
        {
            blueCardPicked = blueCardDeck.pickFromBlueDeck();
            blueAnchor.setVisible(true);
            blueAnchor.setDisable(false);
            lblBlueCardEvent.setVisible(true);
            int indexOfCareer = ((BlueSpace) spaces[curPosPlayer]).indexOfCareer(players, blueCardPicked.getCareer());

            if (blueCardPicked.getDescription().equalsIgnoreCase("Lawsuit"))
            {
                lblBlueCard.setText("BLUE CARD\n" +
                        blueCardPicked.getDescription() +
                        "\n" +
                        "P" + blueCardPicked.getAmount());

                if (blueCardPicked.checkCareer(curPlayer).equalsIgnoreCase("Lawyer"))
                {
                    lblBlueCardEvent.setText("COLLECT FROM\n" + "BANK" + "\nP" + curPlayer.getCash()
                            + " + P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(LIGHTGREEN);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).collectFromBank(curPlayer, blueCardPicked.getAmount());
                }

                else if (indexOfCareer > 0)
                {
                    lblBlueCardEvent.setText("PAY\n" + players.get(indexOfCareer).getName() +
                            "\nP" + curPlayer.getCash() +  " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payPlayer
                            (curPlayer, players.get(indexOfCareer), blueCardPicked.getAmount());
                }

                else
                {
                    lblBlueCardEvent.setText("PAY\n" + "BANK" + "\nP" + curPlayer.getCash() +
                            " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payBank(curPlayer, blueCardPicked.getAmount());
                }
            }

            else if (blueCardPicked.getDescription().equalsIgnoreCase("Tip the Server") ||
                    blueCardPicked.getDescription().equalsIgnoreCase("Computer Repair"))
            {
                lblBlueCard.setText("BLUE CARD\n"
                                + blueCardPicked.getDescription());
                lblBlueCardEvent.setVisible(false);
                btnBlueRandPrice.setVisible(true);
                btnBlueRandPrice.setDisable(false);
            }

            else if (blueCardPicked.getDescription().equalsIgnoreCase("Salary Tax Due"))
            {
                blueCardPicked.setAmount(curPlayer.getSalaryCard().getTaxDue());

                lblBlueCard.setText("BLUE CARD\n" +
                        blueCardPicked.getDescription() +
                        "\n" +
                        "P" + blueCardPicked.getAmount());

                if (blueCardPicked.checkCareer(curPlayer).equalsIgnoreCase("Accountant"))
                {
                    lblBlueCardEvent.setText("COLLECT FROM\n" + "BANK" + "\nP" + curPlayer.getCash()
                            + " + P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(LIGHTGREEN);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).collectFromBank(curPlayer, blueCardPicked.getAmount());
                }

                else if (indexOfCareer > 0)
                {
                    lblBlueCardEvent.setText("PAY\n" + players.get(indexOfCareer).getName() +
                            "\nP" + curPlayer.getCash() +  " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payPlayer(curPlayer, players.get(indexOfCareer), blueCardPicked.getAmount());
                }

                else
                {
                    lblBlueCardEvent.setText("PAY\n" + "BANK" + "\nP" + curPlayer.getCash() +
                            " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payBank(curPlayer, blueCardPicked.getAmount());
                }
            }

            else if (blueCardPicked.getDescription().equalsIgnoreCase("Ski Accident"))
            {
                lblBlueCard.setText("BLUE CARD\n" +
                        blueCardPicked.getDescription() +
                        "\n" +
                        "P" + blueCardPicked.getAmount());

                if ((blueCardPicked.checkCareer(curPlayer).equalsIgnoreCase("Doctor")))
                {
                    lblBlueCardEvent.setText("COLLECT FROM\n" + "BANK" + "\nP" + curPlayer.getCash()
                            + " + P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(LIGHTGREEN);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).collectFromBank(curPlayer, blueCardPicked.getAmount());
                }

                else if (indexOfCareer > 0)
                {
                    lblBlueCardEvent.setText("PAY\n" + players.get(indexOfCareer).getName() +
                            "\nP" + curPlayer.getCash() +  " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payPlayer(curPlayer, players.get(indexOfCareer), blueCardPicked.getAmount());
                }

                else
                {
                    lblBlueCardEvent.setText("PAY\n" + "BANK" + "\nP" + curPlayer.getCash() +
                            " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payBank(curPlayer, blueCardPicked.getAmount());
                }
            }

            else if (blueCardPicked.getDescription().equalsIgnoreCase("World Cup"))
            {
                blueCardPicked.setAmount(players.size()*5000);

                lblBlueCard.setText("BLUE CARD\n" +
                        blueCardPicked.getDescription() +
                        "\n" +
                        "P" + blueCardPicked.getAmount());

                if (blueCardPicked.checkCareer(curPlayer).equalsIgnoreCase("Athlete"))
                {
                    lblBlueCardEvent.setText("COLLECT FROM\n" + "BANK" + "\nP" + curPlayer.getCash()
                            + " + P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(LIGHTGREEN);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).collectFromBank(curPlayer, blueCardPicked.getAmount());
                }

                else if (indexOfCareer > 0)
                {
                    lblBlueCardEvent.setText("PAY\n" + players.get(indexOfCareer).getName() +
                            "\nP" + curPlayer.getCash() +  " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payPlayer(curPlayer, players.get(indexOfCareer), blueCardPicked.getAmount());
                }

                else
                {
                    lblBlueCardEvent.setText("PAY\n" + "BANK" + "\nP" + curPlayer.getCash() +
                            " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payBank(curPlayer, blueCardPicked.getAmount());
                }
            }

            else if (blueCardPicked.getDescription().equalsIgnoreCase("F1 Race"))
            {
                blueCardPicked.setAmount(curPlayer.getSalaryCard().getSalary()/10);

                lblBlueCard.setText("BLUE CARD\n" +
                        blueCardPicked.getDescription() +
                        "\n" +
                        "P" + blueCardPicked.getAmount());

                if (blueCardPicked.checkCareer(curPlayer).equalsIgnoreCase("Racecar Driver"))
                {
                    lblBlueCardEvent.setText("COLLECT FROM\n" + "BANK" + "\nP" + curPlayer.getCash()
                            + " + P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(LIGHTGREEN);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).collectFromBank(curPlayer, blueCardPicked.getAmount());
                }

                else if (indexOfCareer > 0)
                {
                    lblBlueCardEvent.setText("PAY\n" + players.get(indexOfCareer).getName() +
                            "\nP" + curPlayer.getCash() +  " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payPlayer(curPlayer, players.get(indexOfCareer), blueCardPicked.getAmount());
                }

                else
                {
                    lblBlueCardEvent.setText("PAY\n" + "BANK" + "\nP" + curPlayer.getCash() +
                            " - P" + blueCardPicked.getAmount());
                    lblBlueCardEvent.setTextFill(RED);
                    btnBlueCardOK.setDisable(false);

                    ((BlueSpace) spaces[curPosPlayer]).payBank(curPlayer, blueCardPicked.getAmount());
                }
            }
        }

        //MagentaSpace
        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("College Career Choice!"))
        {
            do {
                career[0] = careerCardDeck.pickFromCareerDeck();
            } while (career[0].getPick() == true);

            do {
                career[1] = careerCardDeck.pickFromCareerDeck();
            } while (career[1].getPick() == true);

            do {
                salary[0] = salaryCardDeck.pickFromSalaryDeck();
            } while (salary[0].getPick() == true);

            do {
                salary[1] = salaryCardDeck.pickFromSalaryDeck();
            } while (salary[1].getPick() == true);

            colCarAnchor.setVisible(true);
            colCarAnchor.setDisable(false);

            if (career[0].getDegree())
                lblColCareer1Info.setText(career[0].getCareer() + "\n\n\n\n" + career[0].getFINALMAXRAISE() + "\n\n\n"
                    + "REQUIRED");
            else lblColCareer1Info.setText(career[0].getCareer() + "\n\n\n\n" + career[1].getFINALMAXRAISE() + "\n\n\n"
                    + "NOT REQUIRED");

            if (career[1].getDegree())
                lblColCareer2Info.setText(career[1].getCareer() + "\n\n\n\n" + career[0].getFINALMAXRAISE() + "\n\n\n"
                        + "REQUIRED");
            else lblColCareer2Info.setText(career[1].getCareer() + "\n\n\n\n" + career[1].getFINALMAXRAISE() + "\n\n\n"
                    + "NOT REQUIRED");

            //choose salary card
            lblColSalary1Info.setText(salary[0].getSalary() + "\n\n\n\n" + salary[0].getTaxDue());
            lblColSalary2Info.setText(salary[1].getSalary() + "\n\n\n\n" + salary[1].getTaxDue());
        }


        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("Job Search!"))
        {
            jobSearchAnchor.setVisible(true);
            jobSearchAnchor.setDisable(false);
            career[0] = curPlayer.getCareerCard();

            do{
                career[1] = careerCardDeck.pickFromCareerDeck();
            } while (career[1].getPick() == true || (curPlayer.getDegree() == false && career[1].getDegree() == true));

            salary[0] = curPlayer.getSalaryCard();

            do{
                salary[1] = salaryCardDeck.pickFromSalaryDeck();
            } while (salary[1].getPick() == true);

            if (career[0].getDegree())
                lblJSCareer1Info.setText(career[0].getCareer() + "\n\n\n\n" + career[0].getFINALMAXRAISE() + "\n\n\n"
                        + "REQUIRED");
            else lblJSCareer1Info.setText(career[0].getCareer() + "\n\n\n\n" + career[0].getFINALMAXRAISE() + "\n\n\n"
                    + "NOT REQUIRED");

            if (career[1].getDegree())
                lblJSCareer2Info.setText(career[1].getCareer() + "\n\n\n\n" + career[1].getFINALMAXRAISE() + "\n\n\n"
                    + "REQUIRED");
            else lblJSCareer2Info.setText(career[1].getCareer() + "\n\n\n\n" + career[1].getFINALMAXRAISE() + "\n\n\n"
                    + "NOT REQUIRED");

            //choose salary card
            lblJSSalary1Info.setText(salary[0].getSalary() + "\n\n\n\n" + salary[0].getTaxDue());
            lblJSSalary2Info.setText(salary[1].getSalary() + "\n\n\n\n" + salary[1].getTaxDue());
        }

        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("Buy a House!"))
        {
            btnGetLoanInc.setDisable(false);
            btnGetLoan.setDisable(false);

            HouseDeck houseDeck = Main.getBoard().getHouseCardDeck();
            buyAHouseAnchor.setVisible(true);
            buyAHouseAnchor.setDisable(false);
            if((houseDeck.getHouseCards().get(buyHouseIndex-1).getPrice() > curPlayer.getCash())
                || houseDeck.findHouse(houseDeck.getHouseCards().get(buyHouseIndex-1).getName()).getPick())
                btnBuyHouseBuy.setDisable(true);
        }


        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("Get Married!"))
        {
            if (!(curPlayer.isMarried()))
            {
                getMarriedAnchor.setVisible(true);
                getMarriedAnchor.setDisable(false);

                lblMarriedEvent.setVisible(false);
                lblMarriedEvent.setDisable(true);
            }
            else btnEndTurn.setDisable(false);
        }

        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("Have Baby or Have Twins?"))
        {
            haveBabiesAnchor.setVisible(true);
            haveBabiesAnchor.setDisable(false);
            if (curPlayer.isMarried())
            {
                int rand = ThreadLocalRandom.current().nextInt(0,2);

                if (rand == 0)
                {
                    lblHaveBabiesEvent.setText("CONGRATULATIONS ON YOUR NEW BABY!\n\nCOLLECT P5000 FROM EACH PLAYER FOR EACH BABY");
                }
                else lblHaveBabiesEvent.setText("CONGRATULATIONS IT'S TWINS!\n\nCOLLECT P5000 FROM EACH PLAYER FOR EACH BABY");

                ((MagentaSpace) spaces[curPosPlayer]).haveChildren(curPlayer, players, rand);
            }
        }

        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("Which Path?"))
        {
            whichPathAnchor.setVisible(true);
            whichPathAnchor.setDisable(false);

            if(curPosPlayer == 21)
            {
                btnOtherPath.setText("CAREER PATH");

            }

            else if (curPosPlayer == 44)
            {
                btnOtherPath.setText("START A FAMILY PATH");
            }
        }

        else if (spaces[curPosPlayer].getDescription().equalsIgnoreCase("You Are Retired!"))
        {
            int curCash = curPlayer.getCash();
            curPlayer.setRetire(true);

            retireAnchor.setVisible(true);
            retireAnchor.setDisable(false);

            lblRetireTitle.setText("CONGRATULATIONS " + curPlayer.getName() +  "!\n" +
                    "YOU ARE RETIRED!");

            if (Main.getBoard().isAllRetired() == 1)
            {
                lblRetireEvent.setText("YOU ARE 1ST TO RETIRE! COLLECT 100000 FROM THE BANK ");
                lblRetireEvent.setTextFill(GOLD);
            }
            else if (Main.getBoard().isAllRetired() == 2)
            {
                lblRetireEvent.setText("YOU ARE 2ND TO RETIRE! COLLECT 50000 FROM THE BANK ");
                lblRetireEvent.setTextFill(SILVER);
            }
            else if (Main.getBoard().isAllRetired() == 3)
            {
                lblRetireEvent.setText("YOU ARE 3RD TO RETIRE! COLLECT 20000 FROM THE BANK ");
                lblRetireEvent.setTextFill(BROWN);
            }

            lblRetirePlyrChildren.setText("CHILDREN: " + curPlayer.getChildren());
            lblRetirePlyrLoan.setText("LOAN: " + curPlayer.getLoan());

            if (curPlayer.hasChildren())
            {
                lblRetirePlyrChildrenPrice.setVisible(true);
                lblRetirePlyrChildrenPrice.setText(" + " + curPlayer.getChildren()*10000);
            }

            if (curPlayer.hasLoan())
            {
                lblRetirePlyrLoanPrice.setVisible(true);
                lblRetirePlyrLoanPrice.setText(" - " + (curPlayer.getLoan() + (curPlayer.getLoan()/20000)*5000));
            }


            if (curPlayer.getHouse() != null)
            {
                recRetireHouseBG.setVisible(true);
                lblRetireHouseTitle.setVisible(true);
                lblRetireHouseInfo.setVisible(true);
                lblRetireHousePrice.setVisible(true);

                lblRetireHouseInfo.setText(curPlayer.getHouse().getName() +  "\n" +
                        "\n" + "\n" + curPlayer.getHouse().getPrice());

                lblRetireHousePrice.setText("+" + curPlayer.getHouse().getPrice());
                ((RetirementSpace) spaces[curPosPlayer]).sellHouse(curPlayer);
            }

            ((RetirementSpace) spaces[curPosPlayer]).collectFromBank(curPlayer, players);

            ((RetirementSpace) spaces[curPosPlayer]).collectChildren(curPlayer);

            ((RetirementSpace) spaces[curPosPlayer]).repayBank(curPlayer);

            lblRetireCurCash.setText("CURRENT CASH: " + curCash);

            lblRetireFinalCash.setText("FINAL CASH: " + curPlayer.getCash());

            btnEndTurn.setDisable(false);

            updatePlayerStatsView();
        }
    }

    //Orange Space - Player_Buttons
    /**
     * does the action dictated on the description on the player 1 when button clicked
     * @param e player 1 button clicked
     */
    @FXML
    public void btnActionCardPlayer1Clicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        btnActionCardPlayer1.setDisable(true);
        btnActionCardPlayer2.setDisable(true);
        btnActionCardPlayer3.setDisable(true);
        btnActionCardOK.setDisable(false);

        ActionCardIndex = 0;

        if(actionCardPicked.getKind() == 3)
            actionCardPicked.payPlayer(curPlayer, players.get(ActionCardIndex));
        else if (actionCardPicked.getKind() == 4)
            actionCardPicked.collectFromPlayer(players.get(ActionCardIndex), curPlayer);
        updatePlayerStatsView();
    }

    /**
     * does the action dictated on the description on the player 2 when button clicked
     * @param e player 2 button clicked
     */
    @FXML
    public void btnActionCardPlayer2Clicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        btnActionCardPlayer1.setDisable(true);
        btnActionCardPlayer2.setDisable(true);
        btnActionCardPlayer3.setDisable(true);
        btnActionCardOK.setDisable(false);

        ActionCardIndex = 1;

        if(actionCardPicked.getKind() == 3)
            actionCardPicked.payPlayer(curPlayer, players.get(ActionCardIndex));
        else if (actionCardPicked.getKind() == 4)
            actionCardPicked.collectFromPlayer(players.get(ActionCardIndex), curPlayer);
        updatePlayerStatsView();
    }

    /**
     * does the action dictated on the description on the player 3 when button clicked
     * @param e player 3 button clicked
     */
    @FXML
    public void btnActionCardPlayer3Clicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        btnActionCardPlayer1.setDisable(true);
        btnActionCardPlayer2.setDisable(true);
        btnActionCardPlayer3.setDisable(true);
        btnActionCardOK.setDisable(false);

        ActionCardIndex = 2;

        if(actionCardPicked.getKind() == 3)
            actionCardPicked.payPlayer(curPlayer, players.get(ActionCardIndex));
        else if (actionCardPicked.getKind() == 4)
            actionCardPicked.collectFromPlayer(players.get(ActionCardIndex), curPlayer);
        updatePlayerStatsView();
    }

    //initialize Player Buttons on Action Card

    /**
     * disables the button of the current player to avoid selecting himself/herself
     * @param index index of the current player in turn
     */
    public void disableActionCardPlyrBtn(int index)
    {
        //disable 1st button
        if (index == 0)
        {
            btnActionCardPlayer1.setDisable(true);
            btnActionCardPlayer1.setVisible(true);

            btnActionCardPlayer2.setDisable(false);
            btnActionCardPlayer2.setVisible(true);

            if (Main.getBoard().getNumPlayer() == 3)
            {
                btnActionCardPlayer3.setDisable(false);
                btnActionCardPlayer3.setVisible(true);
            }
        }
        //disable 2nd player button
        else if (index == 1)
        {
            btnActionCardPlayer1.setDisable(false);
            btnActionCardPlayer1.setVisible(true);

            btnActionCardPlayer2.setDisable(true);
            btnActionCardPlayer2.setVisible(true);

            if (Main.getBoard().getNumPlayer() == 3)
            {
                btnActionCardPlayer3.setDisable(false);
                btnActionCardPlayer3.setVisible(true);
            }
        }
        //disable 3rd button
        else if (index == 2)
        {
            btnActionCardPlayer1.setDisable(false);
            btnActionCardPlayer1.setVisible(true);

            btnActionCardPlayer2.setDisable(false);
            btnActionCardPlayer2.setVisible(true);

            btnActionCardPlayer3.setDisable(true);
            btnActionCardPlayer3.setVisible(true);
        }
    }

    //Magenta Space - Buttons_CollegeCareerChoice
    /**
     * selects the career card above the button when clicked
     * @param e button 1 below career card clicked
     */
    @FXML
    public void btnCareer1Clicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        btnCareer1.setDisable(true);
        btnCareer2.setDisable(true);

        curPlayer.setCareerCard(career[0]);

        Main.getBoard().getCareerCardDeck().findCareer(career[0].getCareer()).setPick(true);

        if ((btnCareer1.isDisabled() && btnSalary1.isDisabled()) ||
                (btnCareer1.isDisabled() && btnSalary2.isDisabled()))
        {
            colCarAnchor.setDisable(true);
            colCarAnchor.setVisible(false);
            updatePlayerStatsView();

            btnEndTurn.setDisable(false);
            initLoanBtn();
        }
    }

    /**
     * selects the career card above the button when clicked
     * @param e button 2 below career card clicked
     */
    @FXML
    public void btnCareer2Clicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        btnCareer2.setDisable(true);
        btnCareer1.setDisable(true);
        curPlayer.setCareerCard(career[1]);
        Main.getBoard().getCareerCardDeck().findCareer(career[1].getCareer()).setPick(true);

        if ((btnCareer2.isDisabled() && btnSalary1.isDisabled()) ||
                (btnCareer2.isDisabled() && btnSalary2.isDisabled()))
        {
            colCarAnchor.setDisable(true);
            colCarAnchor.setVisible(false);
            updatePlayerStatsView();

            btnEndTurn.setDisable(false);
            initLoanBtn();
        }
    }

    /**
     * selects the salary card above the button when clicked
     * @param e button 1 below salary card clicked
     */
    @FXML
    public void btnSalary1Clicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        btnSalary1.setDisable(true);
        btnSalary2.setDisable(true);
        curPlayer.setSalaryCard(salary[0]);

        Main.getBoard().getSalaryCardDeck().findSalary(salary[0].getSalary()).setPick(true);

        if ((btnCareer1.isDisabled() && btnSalary1.isDisabled()) ||
                (btnCareer2.isDisabled() && btnSalary1.isDisabled()))
        {
            colCarAnchor.setDisable(true);
            colCarAnchor.setVisible(false);
            updatePlayerStatsView();

            btnEndTurn.setDisable(false);
            initLoanBtn();
        }
    }

    /**
     * selects the salary card above the button when clicked
     * @param e button 2 below salary card clicked
     */
    @FXML
    public void btnSalary2Clicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        btnSalary2.setDisable(true);
        btnSalary1.setDisable(true);
        curPlayer.setSalaryCard(salary[1]);
        Main.getBoard().getSalaryCardDeck().findSalary(salary[1].getSalary()).setPick(true);

        if ((btnCareer1.isDisabled() && btnSalary2.isDisabled()) ||
                (btnCareer2.isDisabled() && btnSalary2.isDisabled()))
        {
            colCarAnchor.setDisable(true);
            colCarAnchor.setVisible(false);
            updatePlayerStatsView();

            btnEndTurn.setDisable(false);
            initLoanBtn();
        }
    }

    //Magenta Space - Get_Married

    /**
     * generates random number from 1-10 when roll dice button clicked
     * @param e roll dice button clicked
     */
    public void rollMarried (ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = Main.getBoard().getPlayerArr().get(curPlayerTurn);
        int curPosPlayer = players.get(curPlayerTurn).getCurPos();

        Space space = (Main.getBoard().getSpaces())[curPosPlayer];
        int dice = Main.getBoard().rollDice();
        updateMarriedDiceView(dice);

        btnMarriedRollDice.setDisable(true);
        lblMarriedEvent.setVisible(true);
        lblMarriedEvent.setDisable(false);

        if (dice%2 == 1)
            lblMarriedEvent.setText("YOU ROLLED AN ODD NUMBER! YOU GET 5000 FROM EACH PLAYER!");
        else if (dice%2 == 0)
            lblMarriedEvent.setText("YOU ROLLED AN EVEN NUMBER! YOU GET 10000 FROM EACH PLAYER!");

        btnMarriedOK.setDisable(false);

        ((MagentaSpace) space).getMarried(curPlayer, players, dice);

        updatePlayerStatsView();
    }

    /**
     * updates the dice display to show the random number generated
     * @param dice random number generated
     */
    public void updateMarriedDiceView(int dice) {
        cFirstMD1.setVisible(false);
        cFirstMD2.setVisible(false);
        cFirstMD3.setVisible(false);
        cFirstMD4.setVisible(false);
        cFirstMD5.setVisible(false);

        cSecMD1.setVisible(false);
        cSecMD2.setVisible(false);
        cSecMD3.setVisible(false);
        cSecMD4.setVisible(false);
        cSecMD5.setVisible(false);
        if (dice == 1) {
            cFirstMD3.setVisible(true);
        } else if (dice == 2) {
            cFirstMD1.setVisible(true);
            cFirstMD2.setVisible(true);
        } else if (dice == 3) {
            cFirstMD1.setVisible(true);
            cFirstMD2.setVisible(true);
            cFirstMD3.setVisible(true);
        } else if (dice == 4) {
            cFirstMD1.setVisible(true);
            cFirstMD2.setVisible(true);
            cFirstMD4.setVisible(true);
            cFirstMD5.setVisible(true);
        } else if (dice == 5) {
            cFirstMD1.setVisible(true);
            cFirstMD2.setVisible(true);
            cFirstMD3.setVisible(true);
            cFirstMD4.setVisible(true);
            cFirstMD5.setVisible(true);
        } else if (dice == 6) {
            cFirstMD1.setVisible(true);
            cFirstMD2.setVisible(true);
            cFirstMD3.setVisible(true);
            cFirstMD4.setVisible(true);
            cFirstMD5.setVisible(true);

            cSecMD3.setVisible(true);
        } else if (dice == 7) {
            cFirstMD1.setVisible(true);
            cFirstMD2.setVisible(true);
            cFirstMD3.setVisible(true);
            cFirstMD4.setVisible(true);
            cFirstMD5.setVisible(true);

            cSecMD1.setVisible(true);
            cSecMD2.setVisible(true);
        } else if (dice == 8) {
            cFirstMD1.setVisible(true);
            cFirstMD2.setVisible(true);
            cFirstMD3.setVisible(true);
            cFirstMD4.setVisible(true);
            cFirstMD5.setVisible(true);

            cSecMD1.setVisible(true);
            cSecMD2.setVisible(true);
            cSecMD3.setVisible(true);
        } else if (dice == 9) {
            cFirstMD1.setVisible(true);
            cFirstMD2.setVisible(true);
            cFirstMD3.setVisible(true);
            cFirstMD4.setVisible(true);
            cFirstMD5.setVisible(true);

            cSecMD1.setVisible(true);
            cSecMD2.setVisible(true);
            cSecMD4.setVisible(true);
            cSecMD5.setVisible(true);
        } else if (dice == 10) {
            cFirstMD1.setVisible(true);
            cFirstMD2.setVisible(true);
            cFirstMD3.setVisible(true);
            cFirstMD4.setVisible(true);
            cFirstMD5.setVisible(true);

            cSecMD1.setVisible(true);
            cSecMD2.setVisible(true);
            cSecMD3.setVisible(true);
            cSecMD4.setVisible(true);
            cSecMD5.setVisible(true);
        }
    }

    //Magenta Space - Which_Path_Pos21_Pos44
    //Pos_21_44

    /**
     * updates the player's life path when button selected
     * @param e other path button clicked
     */
    public void btnOtherPathClicked(ActionEvent e)
    {
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = Main.getBoard().getPlayerArr().get(curPlayerTurn);

        curPlayer.setLifepath(1);

        whichPathAnchor.setVisible(false);
        whichPathAnchor.setDisable(true);

        btnEndTurn.setDisable(false);

        initLoanBtn();
    }

    /**
     * updates the player's life path when button selected
     * @param e continue button clicked
     */
    public void btnContinuePathClicked(ActionEvent e)
    {
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = Main.getBoard().getPlayerArr().get(curPlayerTurn);

        curPlayer.setLifepath(2);

        whichPathAnchor.setVisible(false);
        whichPathAnchor.setDisable(true);

        btnEndTurn.setDisable(false);

        initLoanBtn();
    }

    //Magenta Space - Buttons_JobSearch

    /**
     * keeps the current career card and salary card of player
     * @param e keep button clicked
     */
    @FXML
    public void btnCurrentCarSalClicked(ActionEvent e)
    {
        jobSearchAnchor.setDisable(true);
        jobSearchAnchor.setVisible(false);

        updatePlayerStatsView();

        btnEndTurn.setDisable(false);
        initLoanBtn();
    }

    /**
     * updates the career card and salary card to the newly picked cards of the player
     * @param e change button clicked
     */
    @FXML
    public void btnChangeCarSalClicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        curPlayer.setCareerCard(career[1]);
        curPlayer.setSalaryCard(salary[1]);

        Main.getBoard().getCareerCardDeck().findCareer(career[1].getCareer()).setPick(true);
        Main.getBoard().getSalaryCardDeck().findSalary(salary[1].getSalary()).setPick(true);

        jobSearchAnchor.setDisable(true);
        jobSearchAnchor.setVisible(false);

        updatePlayerStatsView();

        btnEndTurn.setDisable(false);
        initLoanBtn();
    }

    //Magenta Space - Buy_A_House
    /**
     * increases the index for the selection of house the player intends to buy
     * @param e increase button clicked
     */
    public void btnBuyAHouseIncClicked(ActionEvent e)
    {
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = Main.getBoard().getPlayerArr().get(curPlayerTurn);
        btnBuyHouseBuy.setDisable(false);
        btnBuyHouseDec.setDisable(false);
        buyHouseIndex++;
        HouseCard houseCard = Main.getBoard().getHouseCardDeck().getHouseCards().get(buyHouseIndex-1);
        lblBuyHouseCtr.setText("" + buyHouseIndex);

        if (buyHouseIndex == 10)
        {
            btnBuyHouseInc.setDisable(true);
        }
        if ((houseCard.getPrice() > curPlayer.getCash()) || (houseCard.getPick() == true))
            btnBuyHouseBuy.setDisable(true);
    }

    /**
     * decreases the index for the selection of house the player intends to buy
     * @param e decrease button clicked
     */
    public void btnBuyAHouseDecClicked(ActionEvent e)
    {
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = Main.getBoard().getPlayerArr().get(curPlayerTurn);
        btnBuyHouseBuy.setDisable(false);
        btnBuyHouseInc.setDisable(false);
        buyHouseIndex--;
        HouseCard houseCard = Main.getBoard().getHouseCardDeck().getHouseCards().get(buyHouseIndex-1);
        lblBuyHouseCtr.setText("" + buyHouseIndex);
        if (buyHouseIndex == 1)
        {
            btnBuyHouseDec.setDisable(true);
        }
        if ((houseCard.getPrice() > curPlayer.getCash()) || (houseCard.getPick() == true))
            btnBuyHouseBuy.setDisable(true);
    }

    /**
     * updates player house card according to the selected index from the
     * houses showed
     * @param e buy button clicked
     */
    public void btnBuyAHouseBuyClicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = Main.getBoard().getPlayerArr().get(curPlayerTurn);
        int curPosPlayer = players.get(curPlayerTurn).getCurPos();
        HouseCard houseCard = Main.getBoard().getHouseCardDeck().getHouseCards().get(buyHouseIndex-1);
        Space space = (Main.getBoard().getSpaces())[curPosPlayer];

        ((MagentaSpace) space).buyAHouse(curPlayer, houseCard);

        Main.getBoard().getHouseCardDeck().getHouseCards().get(buyHouseIndex-1).setPick(true);
        btnBuyHouseOK.setDisable(false);
        btnBuyHouseBuy.setDisable(true);
        btnBuyHouseInc.setDisable(true);
        btnBuyHouseDec.setDisable(true);
        buyHouseIndex = 1;
        lblBuyHouseCtr.setText("" + buyHouseIndex);
        updatePlayerStatsView();
    }

    //BLue Space - Roll_For_Price

    /**
     * generates a random number for the amount on the blue card
     * @param e roll for price button clicked
     */
    public void btnBlueRandPriceClicked(ActionEvent e)
    {
        Space[] spaces = Main.getBoard().getSpaces();
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);
        int curPosPlayer = players.get(curPlayerTurn).getCurPos();
        int indexOfCareer = ((BlueSpace) spaces[curPosPlayer]).indexOfCareer(players, blueCardPicked.getCareer());
        int dice = Main.getBoard().rollDice();

        btnBlueRandPrice.setDisable(true);
        btnBlueRandPrice.setVisible(false);
        lblBlueCardEvent.setVisible(true);
        lblBlueDiceRoll.setText("YOU ROLLED" + dice + "!");

        if (blueCardPicked.getDescription().equalsIgnoreCase("Tip the Server"))
        {
            blueCardPicked.setAmount(dice*1000);

            lblBlueCard.setText("BLUE CARD\n\n"
                    + blueCardPicked.getDescription() +
                    "\n\nP" + blueCardPicked.getAmount()/dice + " * " + dice);

            lblBlueCardEvent.setVisible(true);

            if ((blueCardPicked.checkCareer(curPlayer).equalsIgnoreCase("Server")))
            {
                lblBlueCardEvent.setText("COLLECT FROM\n" + "BANK" + "\nP" + curPlayer.getCash()
                        + " + P" + blueCardPicked.getAmount());
                lblBlueCardEvent.setTextFill(LIGHTGREEN);
                btnBlueCardOK.setDisable(false);

                ((BlueSpace) spaces[curPosPlayer]).collectFromBank(curPlayer, blueCardPicked.getAmount());
            }

            else if (indexOfCareer > 0)
            {
                lblBlueCardEvent.setText("PAY\n" + players.get(indexOfCareer).getName() +
                        "\nP" + curPlayer.getCash() +  " - P" + blueCardPicked.getAmount());
                lblBlueCardEvent.setTextFill(RED);
                btnBlueCardOK.setDisable(false);

                ((BlueSpace) spaces[curPosPlayer]).payPlayer(curPlayer, players.get(indexOfCareer), blueCardPicked.getAmount());
            }

            else
            {
                lblBlueCardEvent.setText("PAY\n" + "BANK" + "\nP" + curPlayer.getCash() +
                        " - P" + blueCardPicked.getAmount());
                lblBlueCardEvent.setTextFill(RED);
                btnBlueCardOK.setDisable(false);

                ((BlueSpace) spaces[curPosPlayer]).payBank(curPlayer, blueCardPicked.getAmount());
            }
        }
        else if (blueCardPicked.getDescription().equalsIgnoreCase("Computer Repair"))
        {
            if (dice%2 == 0)
                blueCardPicked.setAmount(5000);
            else if (dice%2 == 1)
                blueCardPicked.setAmount(10000);

            lblBlueCard.setText("BLUE CARD\n\n" + blueCardPicked.getDescription() +
                    "\n\nP" + blueCardPicked.getAmount());

            if (blueCardPicked.checkCareer(curPlayer).equalsIgnoreCase("Computer Consultant"))
            {
                lblBlueCardEvent.setText("COLLECT FROM\n" + "BANK" + "\nP" + curPlayer.getCash()
                        + " + P" + blueCardPicked.getAmount());
                lblBlueCardEvent.setTextFill(LIGHTGREEN);
                btnBlueCardOK.setDisable(false);

                ((BlueSpace) spaces[curPosPlayer]).collectFromBank(curPlayer, blueCardPicked.getAmount());
            }

            else if (indexOfCareer > 0)
            {
                lblBlueCardEvent.setText("PAY\n" + players.get(indexOfCareer).getName() +
                        "\nP" + curPlayer.getCash() +  " - P" + blueCardPicked.getAmount());
                lblBlueCardEvent.setTextFill(RED);
                btnBlueCardOK.setDisable(false);

                ((BlueSpace) spaces[curPosPlayer]).payPlayer(curPlayer, players.get(indexOfCareer), blueCardPicked.getAmount());
            }

            else
            {
                lblBlueCardEvent.setText("PAY\n" + "BANK" + "\nP" + curPlayer.getCash() +
                        " - P" + blueCardPicked.getAmount());
                lblBlueCardEvent.setTextFill(RED);
                btnBlueCardOK.setDisable(false);

                ((BlueSpace) spaces[curPosPlayer]).payBank(curPlayer, blueCardPicked.getAmount());
            }
        }
    }

    //Board Scene - Loans
    /**
     * increase the amount to be loaned by player
     * @param e increase button clicked
     */
    public void btnGetLoanIncClicked(ActionEvent e)
    {
        btnGetLoanDec.setDisable(false);
        btnGetLoan.setDisable(false);
        getLoan += 20000;
        lblGetLoan.setText("" + getLoan);
        if (getLoan == 500000)
            btnGetLoanInc.setDisable(true);
    }

    /**
     * decrease the amount to be loaned by player
     * @param e decrease button clicked
     */
    public void btnGetLoanDecClicked(ActionEvent e)
    {
        btnGetLoanInc.setDisable(false);
        getLoan -= 20000;
        lblGetLoan.setText("" + getLoan);
        if (getLoan == 0) {
            btnGetLoanDec.setDisable(true);
            btnGetLoan.setDisable(true);
        }
    }

    /**
     * updates the loan of the player on loan claimed
     * @param e get loan button clicked
     */
    public void btnGetLoanClicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        curPlayer.setLoan(curPlayer.getLoan() + getLoan);
        curPlayer.setCash(curPlayer.getCash() + getLoan);

        getLoan = 0;
        btnGetLoan.setDisable(true);
        btnGetLoanDec.setDisable(true);
        lblGetLoan.setText("0");

        updatePlayerStatsView();
    }

    /**
     * increase the amount of loan to be paid by player
     * @param e increase button clicked
     */
    public void btnPayLoanIncClicked(ActionEvent e)
    {
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = Main.getBoard().getPlayerArr().get(curPlayerTurn);

        btnPayLoan.setDisable(false);
        btnPayLoanDec.setDisable(false);
        payLoan += 20000;
        lblPayLoan.setText(payLoan + " + " + ((payLoan/20000)*5000));
        if (payLoan == 100000 || payLoan >= curPlayer.getLoan())
            btnPayLoanInc.setDisable(true);
    }

    /**
     * decrease the amount of loan to be paid by player
     * @param e decrease button clicked
     */
    public void btnPayLoanDecClicked(ActionEvent e)
    {
        btnPayLoanInc.setDisable(false);
        payLoan -= 20000;
        lblPayLoan.setText(payLoan  + " + " + ((payLoan/20000)*5000));
        if (payLoan == 0)
        {
            btnPayLoanDec.setDisable(true);
            btnPayLoan.setDisable(true);
            lblPayLoan.setText("0");
        }
    }

    /**
     * updates the current loan and cash of player
     * @param e pay loan button clicked
     */
    public void btnPayLoanClicked(ActionEvent e)
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        curPlayer.setLoan(curPlayer.getLoan() - payLoan);
        curPlayer.setCash(curPlayer.getCash() - (payLoan + (payLoan/20000)*5000));

        payLoan = 0;
        btnPayLoan.setDisable(true);
        btnPayLoanDec.setDisable(true);
        lblPayLoan.setText("0");

        updatePlayerStatsView();
    }

    //initialize all Panes and Buttons
    /**
     * disables visibility of all the panes
     */
    public void setAllPanesBtnDisableVisible ()
    {
        //Pop-up Anchor
        popUpAnchor.setVisible(false);
        popUpAnchor.setDisable(true);

        //Green Space Anchor
        greenAnchor.setVisible(false);
        greenAnchor.setDisable(true);

        //Orange Space Anchor
        orangeAnchor.setVisible(false);
        orangeAnchor.setDisable(true);

        //Buttons - Orange_Space
        btnActionCardOK.setDisable(true);

        btnActionCardPlayer1.setDisable(true);
        btnActionCardPlayer1.setVisible(false);

        btnActionCardPlayer2.setDisable(true);
        btnActionCardPlayer2.setVisible(false);

        //Blue Space Anchor
        blueAnchor.setVisible(false);
        blueAnchor.setDisable(true);

        //Buttons - Blue_Space
        btnBlueCardOK.setDisable(true);
        btnBlueRandPrice.setDisable(true);
        btnBlueRandPrice.setVisible(false);

        //Label - Blue Space
        lblBlueCardEvent.setVisible(false);
        lblBlueDiceRoll.setVisible(false);

        //Magenta Space Anchor

        //Magenta Space Anchor - College Career Choice
        colCarAnchor.setVisible(false);
        colCarAnchor.setDisable(true);

        //Buttons - Magenta_Space_College_Career
        btnCareer1.setDisable(false);
        btnCareer2.setDisable(false);
        btnSalary1.setDisable(false);
        btnSalary2.setDisable(false);

        //Magenta Space Anchor - Get Married
        getMarriedAnchor.setVisible(false);
        getMarriedAnchor.setDisable(true);

        //Buttons - Magenta_Space_Get_Married
        btnMarriedOK.setDisable(true);
        btnMarriedRollDice.setDisable(false);

        //Circles - Magenta_Space_Get_Married
        //Board Scene - Magenta_Space_Get_Married_Dice_1
        cFirstMD1.setVisible(false);
        cFirstMD2.setVisible(false);
        cFirstMD3.setVisible(false);
        cFirstMD4.setVisible(false);
        cFirstMD5.setVisible(false);

        //Board Scene - Magenta_Space_Get_Married_Dice_2
        cSecMD1.setVisible(false);
        cSecMD2.setVisible(false);
        cSecMD3.setVisible(false);
        cSecMD4.setVisible(false);
        cSecMD5.setVisible(false);

        //Magenta Space Anchor - Job Search
        jobSearchAnchor.setVisible(false);
        jobSearchAnchor.setDisable(true);

        //Buttons - Magenta_Space_Job_Search
        btnCurrentCarSal.setDisable(false);
        btnChangeCarSal.setDisable(false);

        //Magenta Space Anchor - Buy_A_House
        buyAHouseAnchor.setVisible(false);
        buyAHouseAnchor.setDisable(true);

        btnBuyHouseDec.setDisable(true);
        btnBuyHouseInc.setDisable(false);

        //Buttons - Magenta_Space_Buy_A_House
        btnBuyHouseBuy.setDisable(false);
        btnBuyHouseDec.setDisable(true);
        btnBuyHouseOK.setDisable(true);
        buyHouseIndex = 1;

        //Magenta Space Anchor - WhichPath_Pos_21_44
        whichPathAnchor.setVisible(false);
        whichPathAnchor.setDisable(true);

        //Magenta Space Anchor - Have_Babies
        haveBabiesAnchor.setVisible(false);
        haveBabiesAnchor.setDisable(true);

        //Magenta Space Anchor - Retirement
        retireAnchor.setVisible(false);
        retireAnchor.setDisable(true);

        lblRetirePlyrChildrenPrice.setVisible(false);
        lblRetirePlyrLoanPrice.setVisible(false);

        lblRetireHouseTitle.setVisible(false);
        lblRetireHouseInfo.setVisible(false);
        lblRetireHousePrice.setVisible(false);
        recRetireHouseBG.setVisible(false);


        if (Main.getBoard().getNumPlayer() == 3)
        {
            btnActionCardPlayer3.setDisable(true);
            btnActionCardPlayer3.setVisible(false);
        }
    }

    //update Player Stats
    /**
     * updates the stats of all the players
     */
    public void updatePlayerStatsView()
    {
        Player Player1 = Main.getBoard().getPlayerArr().get(0);
        int numPlayer = Main.getBoard().getNumPlayer();

        //Board Scene - Player_Stats_Player_1
        lblP1Name.setText(Player1.getName());
        lblP1GenInfo.setText("CASH:" + Player1.getCash()
                + "\nLOAN:" + Player1.getLoan() +
                "\nDEGREE:" + Player1.hasDegree() +
                "\nCHILDREN:" + Player1.getChildren() +
                "\nSPOUSE:" + Player1.isMarried() +
                "\nRETIRED:" + Player1.isRetired());

        if (Player1.hasCareer()) {
            lblP1SalaryInfo.setText("SALARY\n" + Player1.getSalaryCard().getSalary() +
                    "\nTAX DUE\n" + Player1.getSalaryCard().getTaxDue() +
                    "\nPAY RAISE VALUE\n" + Player1.getSalaryCard().getPayRaiseValue());
            lblP1CareerInfo.setText("CAREER\n" + Player1.getCareerCard().getCareer() +
                    "\nMAX PAY RAISE\n" + Player1.getCareerCard().getFINALMAXRAISE());
        }
        if (Player1.hasHouse())
        {
            lblP1HouseInfo.setText("HOUSE\n" + Player1.getHouse().getName()
                    + "\nPRICE\n" + Player1.getHouse().getPrice());
        }
        else lblP1HouseInfo.setText("HOUSE\n" + "N/A"
                + "\nPRICE\n" + "N/A");

        //Board Scene - Player_Stats_Player_2
        Player Player2 = Main.getBoard().getPlayerArr().get(1);
        lblP2Name.setText(Player2.getName());
        lblP2GenInfo.setText("CASH:" + Player2.getCash()
                + "\nLOAN:" + Player2.getLoan() +
                "\nDEGREE:" + Player2.hasDegree() +
                "\nCHILDREN:" + Player2.getChildren() +
                "\nSPOUSE:" + Player2.isMarried() +
                "\nRETIRED:" + Player2.isRetired());

        if (Player2.hasCareer())
        {
            lblP2SalaryInfo.setText("SALARY\n" + Player2.getSalaryCard().getSalary() +
                    "\nTAX DUE\n" + Player2.getSalaryCard().getTaxDue() +
                    "\nPAY RAISE VALUE\n" + Player2.getSalaryCard().getPayRaiseValue());
            lblP2CareerInfo.setText("CAREER\n" + Player2.getCareerCard().getCareer() +
                    "\nMAX PAY RAISE\n" + Player2.getCareerCard().getFINALMAXRAISE());
        }

        if (Player2.hasHouse())
        {
            lblP2HouseInfo.setText("HOUSE\n" + Player2.getHouse().getName()
                    + "\nPRICE\n" + Player2.getHouse().getPrice());
        }
        else lblP2HouseInfo.setText("HOUSE\n" + "N/A"
                + "\nPRICE\n" + "N/A");
        if (numPlayer == 3)
        {
            //Board Scene - Player_Stats_Player_3
            Player Player3 = Main.getBoard().getPlayerArr().get(2);
            lblP3Name.setText(Player3.getName());
            lblP3GenInfo.setText("CASH:" + Player3.getCash()
                    + "\nLOAN:" + Player3.getLoan() +
                    "\nDEGREE:" + Player3.hasDegree() +
                    "\nCHILDREN:" + Player3.getChildren() +
                    "\nSPOUSE:" + Player3.isMarried() +
                    "\nRETIRED:" + Player3.isRetired());

            //Board Scene - Player_Stats_Player_3_Cards
            if (Player3.hasCareer())
            {
                lblP3SalaryInfo.setText("SALARY\n" + Player3.getSalaryCard().getSalary() +
                        "\nTAX DUE\n" + Player3.getSalaryCard().getTaxDue() +
                        "\nPAY RAISE VALUE\n" + Player3.getSalaryCard().getPayRaiseValue());
                lblP3CareerInfo.setText("CAREER\n" + Player3.getCareerCard().getCareer() +
                        "\nMAX PAY RAISE\n" + Player3.getCareerCard().getFINALMAXRAISE());
            }

            if (Player3.hasHouse())
            {
                lblP3HouseInfo.setText("HOUSE\n" + Player3.getHouse().getName()
                        + "\nPRICE\n" + Player3.getHouse().getPrice());
            }
            else lblP3HouseInfo.setText("HOUSE\n" + "N/A"
                    + "\nPRICE\n" + "N/A");
        }
    }

    //When OK is pressed on the event

    /**
     * returns back to the board and exits current pop-up scene
     * @param e ok button clicked
     */
    @FXML
    public void btnCardOKClicked(ActionEvent e)
    {
        setAllPanesBtnDisableVisible();
        updatePlayerStatsView();

        btnEndTurn.setDisable(false);
        initLoanBtn();
    }

    //initialize loan buttons
    /**
     * initializes loan buttons
     */
    public void initLoanBtn ()
    {
        ArrayList<Player> players = Main.getBoard().getPlayerArr();
        int curPlayerTurn = Main.getBoard().getCurPlayerTurn();
        Player curPlayer = players.get(curPlayerTurn);

        btnGetLoanDec.setDisable(false);
        btnGetLoanInc.setDisable(false);
        btnGetLoan.setDisable(false);

        btnPayLoanDec.setDisable(false);
        btnPayLoanInc.setDisable(false);
        btnPayLoan.setDisable(false);

        if (getLoan == 0)
        {
            btnGetLoan.setDisable(true);
            btnGetLoanDec.setDisable(true);
        }
        if (getLoan == 500000)
            btnGetLoanInc.setDisable(true);

        if (payLoan == 0)
        {
            btnPayLoan.setDisable(true);
            btnPayLoanDec.setDisable(true);
        }
        if (payLoan == 100000 || payLoan >= curPlayer.getLoan())
            btnPayLoanInc.setDisable(true);
    }

    /**
     * officially ends the game when button is pressed
     * @param e end game button clicked
     */
    public void btnEndGameClicked(ActionEvent e)
    {
        popUpAnchor.setVisible(true);
        popUpAnchor.setDisable(false);

        gameEndAnchor.setVisible(true);
        gameEndAnchor.setDisable(false);
        ArrayList<Player> endGamePlayers = Main.getBoard().gameWinner();

        lblGameEnd1stName.setText(endGamePlayers.get(0).getName());
        lblGameEnd1stCash.setText("P" + endGamePlayers.get(0).getCash());

        lblGameEnd2ndName.setText(endGamePlayers.get(1).getName());
        lblGameEnd2ndCash.setText("P" + endGamePlayers.get(1).getCash());

        if (Main.getBoard().getNumPlayer() == 3)
        {
            lblGameEnd3rdName.setVisible(true);
            lblGameEnd3rdCash.setVisible(true);

            lblGameEnd3rdName.setText(endGamePlayers.get(2).getName());
            lblGameEnd3rdCash.setText("P" + endGamePlayers.get(2).getCash());

            lblGameEnd3rdBG.setVisible(true);
            rec3rdTrophy.setVisible(true);
            recGameEnd3rdBG.setVisible(true);
            arc3rdTrophy.setVisible(true);
            ell3rdTrophy.setVisible(true);
        }
    }

    /**
     * returns to main menu of the game
     * @param e back to main menu clicked
     * @throws Exception
     */
    public void btnGameSummaryClicked(ActionEvent e) throws Exception
    {
        gameEndAnchor.setVisible(false);
        gameEndAnchor.setDisable(true);

        lblGameEnd3rdName.setVisible(false);
        lblGameEnd3rdCash.setVisible(false);
        lblGameEnd3rdBG.setVisible(false);
        rec3rdTrophy.setVisible(false);
        recGameEnd3rdBG.setVisible(false);
        arc3rdTrophy.setVisible(false);
        ell3rdTrophy.setVisible(false);

        setAllPanesBtnDisableVisible();

        Main.getBoard().getPlayerArr().clear();
        ctr = 1;
        Main.getBoard().setNumPlayer(2);

        Stage stage = Main.getStage();
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene mainMenu = new Scene(root);

        stage.setScene(mainMenu);
        stage.show();
    }
}
