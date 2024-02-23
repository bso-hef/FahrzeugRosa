package cars;

import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Fahrzeug2Rosa extends FahrzeugSteuerung {
    final int SPEED = 400;
    private RMIRegulatedMotor motorAntriebLinks;
    private RMIRegulatedMotor motorAntriebRechts;

    public Fahrzeug2Rosa() throws MalformedURLException, NotBoundException, RemoteException {
        RemoteEV3 ev3 = new RemoteEV3("10.49.134.220");
        ev3.getTextLCD().clear();
        ev3.getTextLCD().drawString("Achtung fahre Fahrzeug", 1, 1);
        motorAntriebLinks = ev3.createRegulatedMotor("A", 'L');
        motorAntriebRechts = ev3.createRegulatedMotor("D", 'M');
        setSpeed(SPEED);
    }

    private void setSpeed(int speed) {
        try {
            motorAntriebLinks.setSpeed(speed);
            motorAntriebRechts.setSpeed(speed);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void vorwärtsFahren(){
        try {
            motorAntriebRechts.forward();
            motorAntriebLinks.forward();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rückwärtsFahren()  {
        try {
            motorAntriebRechts.backward();
            motorAntriebLinks.backward();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void linksAbbiegen(){
        try {
            motorAntriebRechts.rotate(420);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rechtsAbbiegen(){
        try {
            motorAntriebLinks.rotate(420);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stoppen()  {
        try {
            motorAntriebRechts.stop(true);
            motorAntriebLinks.stop(true);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void geschwindigkeitEinstellen(int geschwindigkeit) {
        try {
            motorAntriebRechts.setSpeed(geschwindigkeit);
            motorAntriebLinks.setSpeed(geschwindigkeit);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws Exception {
        this.motorAntriebLinks.close();
        this.motorAntriebRechts.close();
    }
}

