package cars;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Fahrzeug1Blau extends FahrzeugSteuerung {
    private EV3LargeRegulatedMotor motorAntrieb = new EV3LargeRegulatedMotor(MotorPort.B);
    private EV3MediumRegulatedMotor motorLenkung = new EV3MediumRegulatedMotor(MotorPort.C);
    private double geschwindigkeit = GESCHWINDIGKEIT;

    public Fahrzeug1Blau(){
        motorAntrieb.setSpeed(100);
    }

    @Override
    public void vorwärtsFahren() {
        motorAntrieb.forward();
    }

    @Override
    public void rückwärtsFahren() {
        motorAntrieb.backward();
    }

    @Override
    public void linksAbbiegen() {
        motorLenkung.rotateTo(10);
        motorAntrieb.rotate(495);
        motorLenkung.rotateTo(0);
    }

    @Override
    public void rechtsAbbiegen() {
        motorLenkung.rotateTo(-10);
        motorAntrieb.rotate(495);
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
