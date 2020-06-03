package dev.joshpope.Kennels.API.bookings;

public class TotalCount {
    private long currentCount;
    private long totalCount;

    public TotalCount(long currentCount, long totalCount) {
        this.currentCount = currentCount;
        this.totalCount = totalCount;
    }
}
