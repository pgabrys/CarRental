package business.logic;

public class Reservation {
    private Branch dropOff;
    private DateRange dateRange;

    public Reservation(Branch dropOff, DateRange dateRange) {
        if (dropOff == null) {
            throw new IllegalArgumentException("'DropOff' cannot be null");
        }

        if (dateRange == null) {
            throw new IllegalArgumentException("'Date range' cannot be null");
        }

        this.dropOff = dropOff;
        this.dateRange = dateRange;

    }

    public Branch getDropOff() {
        return dropOff;
    }

    public DateRange getDateRange() {
        return dateRange;
    }
}
