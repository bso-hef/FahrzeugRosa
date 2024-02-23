package cars;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Fahrzeug3Grün extends FahrzeugSteuerung {

    private double geschwindigkeit = GESCHWINDIGKEIT;
    private EV3LargeRegulatedMotor motorAntrieb;
    private EV3MediumRegulatedMotor motorLenkung;

    public Fahrzeug3Grün() {
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
        motorLenkung.rotateTo(100);
        motorAntrieb.rotate(-1200);
        motorLenkung.rotateTo(0);
    }

    @Override
    public void rechtsAbbiegen() {
        motorLenkung.rotateTo(-100);
        motorAntrieb.rotate(-1200);
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

    public void close() {
        this.motorAntrieb.close();
        this.motorLenkung.close();
    }
}
