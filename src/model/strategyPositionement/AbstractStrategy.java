package model.strategyPositionement;

import java.util.Random;

import model.FormContainer;

@SuppressWarnings("unused")

public abstract class AbstractStrategy implements IStrategy{
    protected int formNumber;
    protected Random random;
    protected FormContainer formContainer;
    protected int width, height;
    protected final int formWidth = 200;
    protected final int formHeight = 150;
    protected final int maxAttempts = 1000; // Limite le nombre d'essais pour placer une forme

    public AbstractStrategy(int formNumber, int w, int h){
        this.formNumber = formNumber;
        random = new Random();
        width = w;
        height = h;
    }
    public AbstractStrategy(int formNumbe,int w, int h, FormContainer formContainer){
        this(formNumbe, w, h);
        this.formContainer = formContainer;
    }
    public int getFormNumber() {
        return formNumber;
    }


    public void setFormNumber(int formNumber) {
        this.formNumber = formNumber;
    }

    public Random getRandom() {
        return random;
    }

    @Override
    public abstract void posForm();
}
