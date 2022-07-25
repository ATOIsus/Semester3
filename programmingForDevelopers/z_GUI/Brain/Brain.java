package programmingForDevelopers.z_GUI.Brain;

public class Brain {

    private int firstNum;
    private int secondNum;

    public Brain(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;

    }


    public int add() {
        return firstNum + secondNum;
    }


    public int firstNumber() {
        return firstNum;
    }


    public int secondNumber() {
        return secondNum;
    }

}
