package cars;

import lejos.utility.Delay;

/**
 * Klasse welche von konkreten Fahrzeugen implementiert werden muss.
 */
public abstract class FahrzeugSteuerung {

    protected static final double GESCHWINDIGKEIT = 0.1;

    /**
     * Lässt das Fahrzeug für unbestimmte Zeit vorwärtsFahren.
     * Verwenden Sie <code>Delay.msDelay( 1000);"</code> um eine Sekunde nicht zu tun.
     * Halten Sie danach das fahrzug mit dem Aufruf von <code>stoppen()</code> an.
     */
    public abstract void vorwärtsFahren();

    /**
     * Lässt das Fahrzeug für unbestimmte Zeit rückwärts fahren.
     * Verwenden Sie <code>Delay.msDelay( 1000);"</code> um eine Sekunde nicht zu tun.
     * Halten Sie danach das fahrzug mit dem Aufruf von <code>stoppen()</code> an.
     */
    public abstract void rückwärtsFahren();

    /**
     * Bewegt das Fahrzeug um 90° nach links.
     */
    public abstract void linksAbbiegen();

    /**
     * Bewegt das Fahrzeug um 90° nach rechts.
     */
    public abstract void rechtsAbbiegen();

    /**
     * Hält das Fahrzeug nach dem vorwärts- oder Rückwärtsfahren wieder an.
     */
    public abstract void stoppen();

    /**
     * Gibt true zurück, wenn ein hindernis vorhanden ist, sonst false;
     * @return true wenn  hindernis vorhanden, sonst false
     */
    public boolean hindernisVorhanden() {
        return false;
        //Todo
    }

    /**
     * Umfährt ein Hindernis, indem es links um das Hindernis herum fährt.
     */
    public void umfahren() {
        stoppen();
        linksAbbiegen();
        rechtsAbbiegen();
        vorwärtsFahren();
        Delay.msDelay(500);
        rechtsAbbiegen();
        linksAbbiegen();
    }

    /**
     * @param geschwindigkeit in m/s
     */
    protected abstract void geschwindigkeitEinstellen(int geschwindigkeit);

    /**
     * Fährt das Fahrzeug für eine bestimmte Zeit vorwärts.
     *
     * @param zeit in millisekunden
     */
    public void vorwärtsFahren(int zeit) {
        this.vorwärtsFahren();
        Delay.msDelay(zeit);
        this.stoppen();
    }
    /**
     * Fährt das Fahrzeug für eine bestimmte Zeit rückwärts.
     *
     * @param zeit in millisekunden.
     */
    public void rückwärtsFahren(int zeit) {
        this.rückwärtsFahren();
        Delay.msDelay(2000);
        stoppen();
    }
}
