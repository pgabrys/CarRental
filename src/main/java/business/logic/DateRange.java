package business.logic;

import java.time.LocalDate;

public class DateRange {
    private LocalDate from;
    private LocalDate to;

    public DateRange(LocalDate from, LocalDate to) {
        if (to.isBefore(from)) {
            throw new IllegalArgumentException("'To' cannot be earlier than 'From'");
        }

        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public boolean isOverlappingWith (DateRange dateRange) {
        LocalDate from1 = from;
        LocalDate to1 = to;
        LocalDate from2 = dateRange.from;
        LocalDate to2 = dateRange.to;

        if ((from2.isAfter(from1) && from2.isBefore(to1)) || from2.isEqual(from1) || from2.isEqual(to1)) {
            return true;
        }

        if ((to2.isAfter(from1) && to2.isBefore(to1)) || to2.isEqual(from1) || to2.isEqual(to1)) {
            return true;
        }

        return false;
    }
}
