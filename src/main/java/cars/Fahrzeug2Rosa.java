package cars;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class Fahrzeug2Rosa extends FahrzeugSteuerung {
    final int SPEED = 400;
    private EV3LargeRegulatedMotor motorAntriebLinks;
    private EV3LargeRegulatedMotor motorAntriebRechts;

    public Fahrzeug2Rosa()  {

        motorAntriebLinks = new EV3LargeRegulatedMotor(MotorPort.A);
        motorAntriebRechts = new EV3LargeRegulatedMotor(MotorPort.D);

    }

    private void setSpeed(int speed) {
        motorAntriebLinks.setSpeed(speed);
        motorAntriebRechts.setSpeed(speed);
    }

    @Override
    public void vorwärtsFahren(){
        motorAntriebRechts.forward();
        motorAntriebLinks.forward();
    }

    @Override
    public void rückwärtsFahren()  {
        motorAntriebRechts.backward();
        motorAntriebLinks.backward();
    }

    @Override
    public void linksAbbiegen(){
        motorAntriebRechts.rotate(420);
    }

    @Override
    public void rechtsAbbiegen(){
        motorAntriebLinks.rotate(420);
    }

    @Override
    public void stoppen()  {
        motorAntriebRechts.stop(true);
        motorAntriebLinks.stop(true);
    }

    @Override
    protected void geschwindigkeitEinstellen(int geschwindigkeit) {
        motorAntriebRechts.setSpeed(geschwindigkeit);
        motorAntriebLinks.setSpeed(geschwindigkeit);
    }

    public void close() throws Exception {
        this.motorAntriebLinks.close();
        this.motorAntriebRechts.close();
    }
}

