package ia.nimoy;

/**
 * The RelogioInterno class represents an internal clock that keeps track of the
 * number of seconds and days elapsed.
 */
public class RelogioInterno implements Comparable<RelogioInterno> {
    private enum Estado {
        RODANDO,
        PARADO
    }

    private Estado estado;
    /**
     * The number of seconds elapsed.
     */
    private int segundos;

    /**
     * The number of days elapsed.
     */
    private int dias;

    /**
     * Constructs a new instance of the RelogioInterno class.
     * This constructor initializes the internal clock.
     */
    public RelogioInterno() {

        this.reset();
    }

    /**
     * Constructs a new RelogioInterno object with the specified number of seconds.
     * The clock is reset to zero before setting the specified number of seconds.
     *
     * @param segundos the number of seconds to set the clock to
     */
    public RelogioInterno(int segundos) {
        this.reset();
        this.segundos = segundos;
    }

    /**
     * Constructs a new RelogioInterno object with the specified number of seconds
     * and days.
     * The clock is reset to its initial state.
     *
     * @param segundos the number of seconds elapsed
     * @param dias     the number of days elapsed
     */
    public RelogioInterno(int segundos, int dias) {
        this.reset();
        this.segundos = segundos;
        this.dias = dias;
    }

    /**
     * Resets the internal clock by setting the seconds and days to zero.
     */
    public void reset() {
        this.estado = Estado.PARADO;
        this.segundos = 0;
        this.dias = 0;
    }

    /**
     * Updates the internal clock by incrementing the seconds. If the seconds reach the end of the day (24 hours),
     * the days are incremented and the seconds are reset to zero.
     *
     * @return The updated value of the seconds.
     */
    public int update() {
        if (this.estado == Estado.RODANDO) {
            this.segundos++;
            if (this.segundos >= 60 * 60 * 24) {
                this.dias++;
                this.segundos = 0;
            }
            return this.segundos;
        }
        return this.segundos;
    }

    public void start() {
        if(this.estado == Estado.PARADO) {
            this.estado = Estado.RODANDO;
        }
    }

    public void stop() {
        if(this.estado == Estado.RODANDO) {
            this.estado = Estado.PARADO;
        }
    }

    public boolean isRunning() {
        return this.estado == Estado.RODANDO;
    }

    /**
     * Returns the number of days.
     *
     * @return the number of days
     */
    public int getDias() {
        return this.dias;
    }

    /**
     * Returns the value of the seconds.
     *
     * @return the value of the seconds
     */
    public int getSegundos() {
        return this.segundos;
    }

    /**
     * Sets the value of seconds for the internal clock.
     *
     * @param segundos the value of seconds to set
     */
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + segundos;
        result = prime * result + dias;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RelogioInterno other = (RelogioInterno) obj;
        if (segundos != other.segundos)
            return false;
        if (dias != other.dias)
            return false;
        return true;
    }

    /**
     * Compares this object with the specified object for order.
     * Returns a negative value if this object is less than the specified object,
     * a positive value if this object is greater than the specified object,
     * or zero if they are equal.
     *
     * @param other the object to be compared
     * @return a negative value, zero, or a positive value as this object is less
     *         than, equal to, or greater than the specified object
     */
    @Override
    public int compareTo(RelogioInterno other) {
        // Add your implementation here
        // Compare the current object with the 'other' object and return a negative
        // value if the current object is less than 'other',
        // a positive value if the current object is greater than 'other', or zero if
        // they are equal.
        // For example:
        if (this.dias < other.dias) {
            return -1;
        } else if (this.dias > other.dias) {
            return 1;
        } else {
            return Integer.compare(this.segundos, other.segundos);
        }
    }

    /**
     * Returns a string representation of the RelogioInterno object.
     *
     * @return a string representation of the RelogioInterno object
     */
    @Override
    public String toString() {
        return "RelogioInterno [segundos=" + segundos + ", dias=" + dias + "]";
    }

}
