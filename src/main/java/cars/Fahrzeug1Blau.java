package cars;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Fahrzeug1Blau extends FahrzeugSteuerung {
    private EV3LargeRegulatedMotor motorAntrieb;
    private EV3MediumRegulatedMotor motorLenkung;
    private double geschwindigkeit = GESCHWINDIGKEIT;

    public Fahrzeug1Blau(){
        motorAntrieb = new EV3LargeRegulatedMotor(MotorPort.B);
        motorLenkung = new EV3MediumRegulatedMotor(MotorPort.C);
    }

    @Override
    public void vorwärtsFahren() {
        motorAntrieb.backward();
    }

    @Override
    public void rückwärtsFahren() {
        motorAntrieb.forward();
    }

    @Override
    public void linksAbbiegen() {
        motorLenkung.rotateTo(60);
        motorAntrieb.rotate(-700);
        motorLenkung.rotateTo(0);
    }

    @Override
    public void rechtsAbbiegen() {
        motorLenkung.rotateTo(-60);
        motorAntrieb.rotate(-700);
        motorLenkung.rotateTo(0);
    }

    @Override
    public void stoppen() {
        motorAntrieb.stop();
    }

    @Override
    protected void geschwindigkeitEinstellen(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public void close() throws Exception {
        this.motorAntrieb.close();
        this.motorLenkung.close();
    }
}
