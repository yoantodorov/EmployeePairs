package sirma.academy.employeepairs.model;

import java.time.LocalDate;

public class TimeInterval {
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public TimeInterval(LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return dateFrom +" - " + dateTo;
    }


}
