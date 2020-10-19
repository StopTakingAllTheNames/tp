package seedu.address.model.student.admin;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents all administrative details of a Student in Reeve.
 * Consists of the lesson venue, time, monthly fees, last paid date and additional notes.
 * Guarantees: details are present and non-null, all fields are validated and immutable.
 */
public class Admin {

    private final ClassVenue classVenue;
    private final ClassTime classTime;
    private final Fee fee;
    private final PaymentDate paymentDate;
    private final List<AdditionalDetail> details = new ArrayList<>();

    /**
     * venue, time, fee, date and details are not null.
     */
    public Admin(ClassVenue venue, ClassTime time, Fee fee, PaymentDate date,
                 List<AdditionalDetail> details) {
        requireAllNonNull(venue, time, fee, date, details);
        this.classVenue = venue;
        this.classTime = time;
        this.fee = fee;
        this.paymentDate = date;
        this.details.addAll(details);
    }

    public ClassVenue getClassVenue() {
        return classVenue;
    }

    public ClassTime getClassTime() {
        return classTime;
    }

    public Fee getFee() {
        return fee;
    }

    public PaymentDate getPaymentDate() {
        return paymentDate;
    }

    public List<AdditionalDetail> getDetails() {
        return details;
    }

    /**
     * Get additional details of student formatted for GUI use.
     * @return formatted additional details.
     */
    public String getFormattedDetails() {
        String result = "";
        for (AdditionalDetail detail: details) {
            result = result + "- " + detail.toString() + "\n";
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classVenue, classTime, fee, paymentDate, details);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Admin)) {
            return false;
        }

        Admin other = (Admin) obj;
        return other.getClassVenue().equals(getClassVenue())
                && other.getClassTime().equals(getClassTime())
                && other.getFee().equals(getFee())
                && other.getPaymentDate().equals(getPaymentDate())
                && other.getDetails().equals(getDetails());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Class Venue: ")
                .append(classVenue)
                .append(" Lesson Times: ")
                .append(classTime)
                .append(" Fee: ")
                .append(fee)
                .append(" Last Paid: ")
                .append(paymentDate)
                .append(" Notes: ");
        details.forEach(builder::append);
        return builder.toString();
    }
}
