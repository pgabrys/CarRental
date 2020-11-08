package business.logic;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateRangeTests {

    @Test
    public void Cannot_create_date_range_with_end_date_lower_than_start_date() {
        LocalDate from = LocalDate.of(2020,1,31);
        LocalDate to = LocalDate.of(2020, 1,30);

        assertThrows(IllegalArgumentException.class, () -> new DateRange(from, to));
    }

    @Test
    public void Date_range_is_created_when_proper_dates_are_passed() {
        LocalDate from = LocalDate.of(2020, 05, 20);
        LocalDate to = LocalDate.of(2020, 05, 30);
        DateRange dateRange = new DateRange(from, to);

        assertEquals(from, dateRange.getFrom());
        assertEquals(to, dateRange.getTo());
    }

    // TODO: overlapping and not overlapping tests
}
