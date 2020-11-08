package business.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private List<Reservation> reservations;

    public boolean rent(Branch pickUp, DateRange dateRange) {
        List<Reservation> reservationFiltered = new ArrayList(reservations
            .stream()
            .filter(r -> r.getDateRange().getTo().isBefore(dateRange.getFrom()))
            .collect(Collectors.toList()));

        Collections.sort(reservationFiltered, new Comparator<Reservation>() {
            @Override
            public int compare(Reservation r1, Reservation r2) {
                return r2.getDateRange().getFrom().compareTo(r1.getDateRange().getTo());
            }
        });

        Reservation lastReservation = reservationFiltered.size() > 0
                ? reservationFiltered.get(0)
                : null;

        if (lastReservation != null &&
           !lastReservation.getDropOff().equals(pickUp)) {
            return false;
        }

        Reservation overlappingReservation = reservations
                .stream()
                .filter(reservation -> reservation.getDateRange().isOverlappingWith(dateRange))
                .findAny()
                .orElse(null);

        if (overlappingReservation != null) {
            return false;
        }

        return true;
    }
}
